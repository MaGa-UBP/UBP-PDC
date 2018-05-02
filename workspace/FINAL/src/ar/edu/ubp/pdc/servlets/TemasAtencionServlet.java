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
import javax.servlet.http.HttpSession;

import ar.edu.ubp.pdc.beans.TemaBean;








/**
 * Servlet implementation class TemasAtencionServlet
 */
@WebServlet("/index.jsp")
public class TemasAtencionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TemasAtencionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
        try {        	
        	Connection conn;
        	CallableStatement st;
            ResultSet result;
            
            HttpSession session = request.getSession(true);
            
            LinkedList<TemaBean> temas = new LinkedList<TemaBean>();
            TemaBean tema;
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //conn = DriverManager.getConnection("jdbc:sqlserver://bilbo;databaseName=pdc", "scenzano", "33814003");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801"); 
            conn.setAutoCommit(true);
            
            st = conn.prepareCall("{CALL dbo.get_temas_atencion}");
            
            result = st.executeQuery();
            
            /*
            //metodo deprecado por eso el tachado
            if(session.getValueNames().length >= 0 ){
            	for(int i = 0; i < session.getValueNames().length; i++){
            		tema = new TemaBean();
            		tema.setNroGrupoAtencion((String)session.getAttribute("inputDescTema-"+ i));
                	tema.setDescTema((String)session.getAttribute("listGroup-"+ i));
                	tema.setVigente((String)session.getAttribute("checked-"+ i));
                	temas.add(tema);
            	}
            }
            else{*/
            	while (result.next()){
                	tema = new TemaBean();
                	tema.setNroTema(result.getString("nro_tema"));
                	tema.setNroGrupoAtencion(result.getString("nro_grupo_atencion"));
                	tema.setDescTema(result.getString("desc_tema"));
                	tema.setVigente(result.getString("vigente"));
                	temas.add(tema);
                }
            //}
            
            result.close();
            st.close();
            
            request.setAttribute("temas", temas);
            this.gotoPage("/temasGrupos.jsp", request, response);
            
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
