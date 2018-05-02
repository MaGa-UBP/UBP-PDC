package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuardarNotaServlet
 */
@WebServlet("/GuardarNota.jsp")
public class GuardarNotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarNotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn;
		CallableStatement stmt;
		int cantNotas=1;
		HttpSession session = request.getSession(true);
		String sessionid = session.getId();
		 //Integer[] ius = null;
		if (request.getParameterMap().size()>0&&request.getParameterValues("idsession")!=null){
		 if(sessionid.equals(request.getParameter("idsession")))
		 session.setAttribute("cantNotas", cantNotas++);
		 else{cantNotas=0;}
		 }

		//String [] preferenciaRegistrada = request.getParameter("preferenciaRegistrada").split("-");
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(false);
			
			try
			{
				stmt = conn.prepareCall("{CALL dbo.ins_nota(?)}");
				
				stmt.setString(1, request.getParameter("nota").equals("") ? "" : request.getParameter("nota"));
				
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
		this.gotoPage("/index.jsp", request, response);
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