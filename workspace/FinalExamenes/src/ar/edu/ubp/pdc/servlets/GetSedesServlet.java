package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.pdc.beans.SedesBean;

/**
 * Servlet implementation class GetSedesServlet
 */
@WebServlet("/GetSedes.jsp")
public class GetSedesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSedesServlet() {
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
		ResultSet result;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(true);
			LinkedList<SedesBean> sedes = new LinkedList<SedesBean>();
			SedesBean s;
			
				stmt = conn.prepareCall("{CALL dbo.get_sedes}");
				result = stmt.executeQuery();
				result = stmt.getResultSet();
				while(result.next()) {
					s = new SedesBean();
					s.setNomSede(result.getString("nom_sede"));
					s.setNroSede(result.getInt("nro_sede"));
					sedes.add(s);
				}
				
				stmt.close();
				conn.close();
				
				request.setAttribute("sedes", sedes);
				//request.setAttribute("sedes2", sedes);
				if(request.getParameter("ult")!=null&&request.getParameter("ult").equals("si")){
					this.gotoPage("/tablaUltimasSedes.jsp", request, response);	
				}
				else this.gotoPage("/tablaSedes.jsp", request, response);

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