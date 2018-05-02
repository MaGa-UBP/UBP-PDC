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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrarServlet
 */
@WebServlet("/RegistrarServlet.jsp")
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		try {     
			
        	Connection conn;
            PreparedStatement pst;
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
            conn.setAutoCommit(false);
            
            String idSesion = session.getId();
            String [] preferenciaRegistrada = request.getParameter("preferenciaRegistrada").split("-");

            System.out.println(preferenciaRegistrada[0]);
            System.out.println(preferenciaRegistrada[1]);
            
            String consulta = " insert into dbo.preferencias_usuarios (id_sesion, cod_tipo, nro_preferencia) "
            				 + " values (?, ?, ?) ";
            
        	pst = conn.prepareStatement(consulta);
  
        	pst.setString(1, idSesion);        	
            pst.setString(2, preferenciaRegistrada[0]);
            pst.setInt(3, Integer.parseInt(preferenciaRegistrada[1]));
            
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