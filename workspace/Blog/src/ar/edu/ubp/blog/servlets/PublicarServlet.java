package ar.edu.ubp.blog.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class PublicarServlet
 */
@WebServlet("/insertarComentario.jsp")
public class PublicarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		try {
			
			/*
			String r;
			r = ( request.getParameter("recordar") == null ? "" : request.getParameter("autor"));
			if (!r.equals("")){
				Cookie cookie = new Cookie("autorComentarioBlog", request.getParameter("autor")+";"+request.getParameter("emailAutor"));
				response.addCookie(cookie);
			}*/
			
            Connection conn;
            CallableStatement st;
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");            
            conn.setAutoCommit(false);
            
            try {        
                st = conn.prepareCall("{CALL dbo.ins_mensaje_tema_blog(?, ?, ?, ?)}");
                
                st.setInt("nro_tema", Integer.parseInt(request.getParameter("tema_elegido")));
                st.setString(2, request.getParameter("autor"));
                st.setString(3, request.getParameter("emailAutor"));
                st.setString(4, request.getParameter("textoMensaje"));

                st.execute();
                conn.commit();
                st.close();
                
                
                request.setAttribute("tema_elegido", request.getParameter("tema_elegido"));
                
                //response.sendRedirect("./index.jsp");
                this.gotoPage("/index.jsp", request, response);
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
	        request.setAttribute("error", message);
	        request.setAttribute("volver", "S");
	    	this.gotoPage("/error.jsp", request, response);
	    }

	    private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
	                          dispatcher.forward(request, response);
	}

}
