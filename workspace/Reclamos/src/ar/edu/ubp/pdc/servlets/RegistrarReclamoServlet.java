package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
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
 * Servlet implementation class RegistrarReclamoServlet
 */
@WebServlet("/RegistrarReclamo.jsp")
public class RegistrarReclamoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarReclamoServlet() {
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
			conn.setAutoCommit(false);
			
			try {
				//if(request.getParameter("operacion").equals("I")) {
					stmt = conn.prepareStatement("insert into dbo.reclamos(nro_chasis, dominio, km, apellido, nombre, email, telefono, contactar, reclamo) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
					stmt.setString(1, request.getParameter("chasis"));
					stmt.setString(2, request.getParameter("patente"));
					stmt.setInt(3, Integer.parseInt(request.getParameter("km")));
					stmt.setString(4, request.getParameter("apellido"));
					stmt.setString(5, request.getParameter("nombre"));
					stmt.setString(6, request.getParameter("email"));
					stmt.setString(7, request.getParameter("telefono"));
					stmt.setString(8, request.getParameter("contacto") == null ? "N" : "S");
					stmt.setString(9, request.getParameter("reclamo"));

				stmt.executeUpdate();
				//stmt.execute();
				conn.commit();
				
				stmt.close();
				//conn.close();
			}
			catch(SQLException e) {
				conn.rollback();
				this.printError(e.getMessage(), request, response);
			}
			finally {
				conn.setAutoCommit(true);
				conn.close();
			}
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			this.printError(e.getMessage(), request, response);
		}
		this.gotoPage("/reclamoRegistrado.jsp", request, response);
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
