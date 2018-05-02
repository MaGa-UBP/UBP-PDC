package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuardarSugerenciaServlet
 */
@WebServlet("/GuardarSugerencia.jsp")
public class GuardarSugerenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarSugerenciaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		CallableStatement stmt;
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(false);
			
			try
			{
				stmt = conn.prepareCall("{CALL dbo.ins_sugerencia(?, ?, ?, ?)}");
				
				stmt.setString(1, request.getParameter("servicio"));
				stmt.setInt(2, Integer.parseInt(request.getParameter("tema")));
				stmt.setString(3, request.getParameter("email") == null ? "" : request.getParameter("email"));
				stmt.setString(4, request.getParameter("sugerencias"));
				
				stmt.executeUpdate();
				conn.commit();
				stmt.close();
			}
			catch (SQLException e) {
				conn.rollback();
				this.printError(e.getMessage(), request, response);
			}
			finally
			{
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			this.printError(e.getMessage(), request, response);
		}
		
		Cookie cookie = null;
		if(request.getParameter("email") != null && request.getParameter("email") != ""){
			cookie = new Cookie("mail",request.getParameter("email"));
		}
		if(request.getParameter("identifica")!=null&&request.getParameter("identifica").equals("No")){
			cookie = new Cookie("mail", "");
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
	}
	
	private void printError(String error, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setStatus(400);
		request.setAttribute("error", error);
		this.gotoPage("/error.jsp", request, response);
	}

	private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
		                  dispatcher.forward(request, response);
	}
}