package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.pdc.beans.CarreraBean;

/**
 * Servlet implementation class CarrerasServlet
 */
@WebServlet("/index.jsp")
public class CarrerasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarrerasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-8859-1");
        try {        	
        	Connection conn;
            Statement st;
            ResultSet result;
            
            LinkedList<CarreraBean> carreras = new LinkedList<CarreraBean>();
            
            CarreraBean carrera;
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
            conn.setAutoCommit(true);
            
            st = conn.createStatement();
            st.executeQuery("select nro_carrera = -1, " +
                                   "carrera     = 'Todas las carreras', " +
                                   "nro_orden   = 1 " +
                             "union " +
                            "select nro_carrera = nro_carrera, " +
                                   "carrera     = nom_carrera + ' (' + convert(varchar(5), plan_carrera) + ') ' + " +
                                                 "case modalidad_carrera " +
				                                      "when 'PR' " +
					                                  "then 'Pres.' " +
					                                  "when 'D' " +
					                                  "then 'Dist.' " +
					                                  "else 'Semi-Pres.' "+
			                                     "end, " +
                                   "nro_orden   = 2 " +
                              "from dbo.carreras (nolock) " +
                             "order by nro_orden, " +
                                      "carrera");
            
            result = st.getResultSet();
            while(result.next()) {
            	carrera = new CarreraBean();
            	carrera.setNroCarrera(result.getShort("nro_carrera"));
            	carrera.setCarrera(result.getString("carrera"));
            	carreras.add(carrera);
            }
            result.close();
            st.close();
            conn.close();

            request.setAttribute("carreras", carreras);
            
            this.gotoPage("/carreras.jsp", request, response);
        } 
        catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException ex) {
        	this.printMessage(ex.getMessage(), request, response);
        }
	}

    private void printMessage(String message, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("error", message);
    	this.gotoPage("/error.jsp", request, response);
    }

    private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
                          dispatcher.forward(request, response);
    }

}
