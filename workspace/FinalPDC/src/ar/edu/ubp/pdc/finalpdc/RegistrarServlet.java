package ar.edu.ubp.pdc.finalpdc;

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
 * Servlet implementation class RegistrarServlet
 */
@WebServlet("/RegistrarServlet")
public class RegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
try {     
			
        	Connection conn;
            PreparedStatement pst;
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://bilbo;databaseName=pdc", "fdeschant", "37011374");
            conn.setAutoCommit(false);
            
           
     
            
            String consulta = " insert into dbo.reclamos(nro_chasis, dominio, km, apellido, nombre, email, telefono, contactar, reclamo) ";
            
        	pst = conn.prepareStatement(consulta);
  
        	pst.setString(1,  request.getParameter("nrochasis"));
        	pst.setString(2,  request.getParameter("patente"));
        	pst.setInt(3,  Integer.parseInt(request.getParameter("kilometros")));
        	pst.setString(4,  request.getParameter("apellido"));
        	pst.setString(5,  request.getParameter("nombre"));
        	pst.setString(6,  request.getParameter("mail"));
        	pst.setString(7,  request.getParameter("telefono"));
        	pst.setString(8,  request.getParameter("contactar"));
        	pst.setString(9,  request.getParameter("reclamo"));
        	pst.executeUpdate();
        	conn.commit();
        	
            pst.close();
            conn.setAutoCommit(true);
        	conn.close();
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
