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
 * Servlet implementation class InsertarPreferencias
 */
@WebServlet("/insertarPreferencias.jsp")
public class InsertarPreferencias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarPreferencias() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=ISO-8859-1");
		HttpSession session = request.getSession(true);
		try {
            Connection conn;
            PreparedStatement st;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");     
            //conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "33814003"); 
            conn.setAutoCommit(false);
            
            try {

                    st = conn.prepareStatement("insert into dbo.preferencias_usuarios (id_sesion, cod_tipo, nro_preferencia) values (?, ?, ?)");
                    st.setString(1, session.getId());
                    st.setString(2, request.getParameter("codPref"));
                    st.setString(3, request.getParameter("nroPref"));                
                    
	                st.execute();
	                conn.commit();
	                st.close();
                
                //response.sendRedirect("./index.jsp");
            } 
            catch (SQLException ex) {
                conn.rollback();
                this.printMessage(ex.getMessage(), request, response);
            } 
            finally {
                conn.setAutoCommit(true);
                conn.close();
            }
        } 
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
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
