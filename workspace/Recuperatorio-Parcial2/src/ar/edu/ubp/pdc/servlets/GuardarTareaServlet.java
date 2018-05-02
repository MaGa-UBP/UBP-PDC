package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuardarTareaServlet
 */
@WebServlet("/GuardarTarea.jsp")
public class GuardarTareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarTareaServlet() {
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
			/*ArrayList<String> seleccionadas = new ArrayList<String>();
			//las seleccionadas
			//horrible
			if(request.getParameterMap().size() != 0) {
				
				for(int i = 0; i<=request.getParameterMap().size(); i++) {
					String parametro[]= request.getParameterValues(""+i+"");
					if(Integer.parseInt(parametro[0])==i){seleccionadas.add(i);}
				}
					
			}*/
			String seleccionad[] = request.getParameterValues("tarea");
			try {
				for(int i = 0; i<seleccionad.length; i++){
					stmt = conn.prepareStatement("insert into dbo.tareas_procesos(nro_proceso, nro_tarea)values(?, ?)");
					
					
					stmt.setInt(1, Integer.parseInt(request.getParameter("proceso")));
					stmt.setInt(2, Integer.parseInt(seleccionad[i]));
					//stmt.setInt(2, 7);
					stmt.executeUpdate();
					//stmt.execute();
					stmt.close();
				}
				conn.commit();
				
				
				conn.close();
				
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
