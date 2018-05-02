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
 * Servlet implementation class GuardarServlet
 */
@WebServlet("/guardar.jsp")
public class GuardarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		try {
            Connection conn;
            PreparedStatement st;
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");            
            conn.setAutoCommit(false);
            
            try {
                if(request.getParameter("operacion").equals("A")){
                    st = conn.prepareStatement("update dbo.tipos_documentos set tipo_documento=?, mascara=?, numerico=?, tipo_persona=? where cod_tipo_documento=?");
                    st.setString(1, request.getParameter("tipo_documento").toUpperCase());
                    st.setString(2, request.getParameter("mascara"));
                    st.setString(3, request.getParameter("numerico") == null ? "N" : request.getParameter("numerico"));
                    st.setString(4, request.getParameter("tipo_persona"));                    
                    st.setString(5, request.getParameter("cod_tipo_documento"));                    
                }
                else {
                    st = conn.prepareStatement("insert into dbo.tipos_documentos(cod_tipo_documento, tipo_documento, mascara, numerico, tipo_persona) values(?, ?, ?, ?, ?)");
                    st.setString(1, request.getParameter("cod_tipo_documento"));
                    st.setString(2, request.getParameter("tipo_documento"));
                    st.setString(3, request.getParameter("mascara"));
                    st.setString(4, request.getParameter("numerico") == null ? "N" : request.getParameter("numerico"));
                    st.setString(5, request.getParameter("tipo_persona"));
                }    
                st.execute();
                conn.commit();
                st.close();
                
                response.sendRedirect("./index.jsp");
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
