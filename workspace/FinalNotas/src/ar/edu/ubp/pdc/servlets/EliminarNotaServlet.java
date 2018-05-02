package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EliminarNotaServlet
 */
@WebServlet("/EliminarNota.jsp")
public class EliminarNotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarNotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		PreparedStatement stmt;		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(true);
			
			try {
				stmt = conn.prepareCall("delete from dbo.notas where año_nota = ?  and nro_nota = ?");
				
				stmt.setString(1, request.getParameter("anoNota"));
				stmt.setString(2, request.getParameter("nroNota"));
				stmt.execute();
				conn.commit();
				stmt.close();
			}
			catch(SQLException e) {
				conn.rollback();
				this.printError(e.getMessage(), request, response);
			}
			finally {
				//conn.setAutoCommit(true);
				conn.close();
			}
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			this.printError(e.getMessage(), request, response);
		}
	}

	
	private void printError(String error, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(400);
		request.setAttribute("error", error);
		this.gotoPage("/error.jsp", request, response);
	}

	private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
		                  dispatcher.forward(request, response);
	}

}
