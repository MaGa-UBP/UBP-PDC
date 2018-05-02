package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.pdc.beans.AlumnoBean;
import ar.edu.ubp.pdc.beans.CarreraBean;

/**
 * Servlet implementation class AlumnosServlet
 */
@WebServlet("/alumnos.jsp")
public class AlumnosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-8859-1");
        try {        	
        	Connection conn;
            PreparedStatement pst;
            ResultSet result;
            
            LinkedList<CarreraBean> aluCarreras = new LinkedList<CarreraBean>();
            LinkedList<AlumnoBean>  alumnos;
            
            CarreraBean carrera;
            AlumnoBean alumno;
            
            short nroCarrera, nroCarreraSel = request.getParameter("nro_carrera") == null ? -1 : Short.parseShort(request.getParameter("nro_carrera"));
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
            conn.setAutoCommit(true);
            		            
        	pst = conn.prepareStatement("select nro_leg_alumno = m.nro_leg_alumno, " +
                                               "nom_alumno     = upper(a.apellido + ', ' + a.nombre), " +
                                               "documento      = a.cod_tipo_documento + '-' + a.nro_documento, " +
                                               "nro_carrera    = m.nro_carrera, " +
                                               "carrera        = c.nom_carrera + ' (' + convert(varchar(5), c.plan_carrera) + ') ' + " +
                                                                "case c.modalidad_carrera " +
				                                                     "when 'PR' " +
					                                                 "then 'Pres.' " +
					                                                 "when 'D' " +
					                                                 "then 'Dist.' " +
					                                                 "else 'Semi-Pres.' " +
			                                                    "end " +
                                          "from dbo.matriculas m (nolock) " +
                                               "join dbo.carreras c (nolock) " +
                                                 "on m.nro_carrera    = c.nro_carrera " +
                                               "join dbo.alumnos a (nolock) " +
                                                 "on m.nro_leg_alumno = a.nro_leg_alumno " +
                                         "where (?  = -1 " +
                                            "or  m.nro_carrera = ?) " + 
                                         "order by carrera, " +
                                                  "a.apellido, " +
	                                              "a.nombre", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pst.setShort(1, nroCarreraSel);
            pst.setShort(2, nroCarreraSel);
            result = pst.executeQuery();

            result.last();
            if(result.getRow() > 0) {
            	result.beforeFirst();
            	result.next();
                while(result.getRow() > 0) {
                	carrera = new CarreraBean();
	            	carrera.setNroCarrera(result.getShort("nro_carrera"));
	            	carrera.setCarrera(result.getString("carrera"));
                	
	            	alumnos  = new LinkedList<AlumnoBean>();
	            	
                	nroCarrera = result.getShort("nro_carrera");
                	while(result.getRow() > 0 && nroCarrera == result.getShort("nro_carrera")) {
                		alumno = new AlumnoBean();
                		alumno.setNroLegAlumno(result.getInt("nro_leg_alumno"));
                		alumno.setNomAlumno(result.getString("nom_alumno"));
                		alumno.setDocumento(result.getString("documento"));
                		alumnos.add(alumno);
                		
	    	            result.next();
                    }		                        
                    carrera.setAlumnos(alumnos);
                    aluCarreras.add(carrera);
                }
            }    
            result.close();
            pst.close();

            conn.close();

            request.setAttribute("aluCarreras", aluCarreras);
            
            this.gotoPage("/listado.jsp", request, response);
        } 
        catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException ex) {
        	this.printMessage(ex.getMessage(), request, response);
        }
	}

    private void printMessage(String message, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setStatus(400);
        request.setAttribute("error", message);
    	this.gotoPage("/error.jsp", request, response);
    }

    private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
                          dispatcher.forward(request, response);
    }

}
