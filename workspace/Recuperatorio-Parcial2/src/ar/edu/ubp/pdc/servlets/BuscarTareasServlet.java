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

import ar.edu.ubp.pdc.beans.TareasBean;

/**
 * Servlet implementation class BuscarTareasServlet
 */
@WebServlet("/BuscarTareas.jsp")
public class BuscarTareasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarTareasServlet() {
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
		LinkedList<TareasBean> tareas = new LinkedList<TareasBean>();
		TareasBean ta;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(true);
			
			stmt = conn.prepareCall("{CALL dbo.get_tareas_proceso(?)}");
			if(request.getParameter("proceso")!=null){
				stmt.setInt(1, Integer.parseInt(request.getParameter("proceso")));
			}
			//result = stmt.executeQuery();
			stmt.executeQuery();
			result = stmt.getResultSet();
			while(result.next()) {
				ta = new TareasBean();
				ta.setDescTarea(result.getString("desc_tarea"));
				ta.setNroTarea(result.getInt("nro_tarea"));
				ta.setSeleccionada(result.getString("seleccionada"));
				tareas.add(ta);
			}
			
			stmt.close();
			conn.close();
			
			request.setAttribute("tareas", tareas);
			this.gotoPage("/TablaTareas.jsp", request, response);
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

		/*Connection conn;
		CallableStatement stmt;
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(false);
			ResultSet result;

			LinkedList<TareasBean> tareas = new LinkedList<TareasBean>();
			TareasBean ta;
			
			try
			{
				stmt = conn.prepareCall("{CALL dbo.get_tareas_proceso(?)}");
				
				if(request.getParameter("proceso")!=null){
					stmt.setInt(1, Integer.parseInt(request.getParameter("proceso")));
				}
				
				//stmt.executeUpdate();
				stmt.executeQuery();
				result = stmt.getResultSet();
				while(result.next()) {
					ta = new TareasBean();
					ta.setDescTarea(result.getString("desc_tarea"));
					ta.setNroTarea(result.getInt("nro_tarea"));
					ta.setSeleccionada(result.getString("seleccionada"));
					tareas.add(ta);
				}
				conn.commit();
				stmt.close();
				request.setAttribute("tareas", tareas);
				this.gotoPage("/TablaTareas.jsp", request, response);
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
	

}*/
