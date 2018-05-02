package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.LinkedList;

import ar.edu.ubp.pdc.beans.PreferenciasBean;
/**
 * Servlet implementation class BuscarServlet
 */
@WebServlet("/BuscarServlet.jsp")
public class BuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarServlet() {
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
            java.sql.CallableStatement cst;
            ResultSet result;
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
            conn.setAutoCommit(true);
            
            cst = conn.prepareCall("{CALL dbo.get_lista_preferencias_posibles(?,?)}");
            
            String idSesion = session.getId();
            String codTipo = request.getParameter("lista");
                      
            cst.setString(1, idSesion);
            cst.setString(2, codTipo);
            cst.execute();
           
            result = cst.getResultSet();
           
            
            PreferenciasBean preferencia;
            LinkedList <PreferenciasBean> preferenciasPosiblesList = new LinkedList <PreferenciasBean> ();            
            while(result.next()) {
        		
            	preferencia = new PreferenciasBean();
        		preferencia.setDescPreferencia(result.getString("desc_preferencia"));
        		preferencia.setCodTipo(result.getString("cod_tipo"));
        		preferencia.setNroPreferencia(result.getString("nro_preferencia"));        		
        		preferenciasPosiblesList.add(preferencia);
	            
            }		  
            
            request.setAttribute("preferenciasPosiblesList", preferenciasPosiblesList);
            
            cst.close();
            
            
            String consulta = " select "
            		+ "					p.desc_preferencia, "
            		+ "        			pu.cod_tipo, "
            		+ "        			pu.nro_preferencia "
            		+ "   		from "
            		+ "					dbo.preferencias_usuarios pu (nolock) "
            		+ "        			join dbo.preferencias p (nolock) "
            		+ "          			on pu.cod_tipo        = p.cod_tipo "
            		+ "         			and pu.nro_preferencia = p.nro_preferencia "
            		+ "  		where "
            		+ "					pu.id_sesion = ? "
            		+ "    				and pu.cod_tipo  = ? ";
            
        	pst = conn.prepareStatement(consulta);
  
        	pst.setString(1, idSesion);
            pst.setString(2, codTipo);
          
        	result = pst.executeQuery();
        	
            PreferenciasBean preferenciaRegistrada;
            LinkedList <PreferenciasBean> preferenciasRegistradaList = new LinkedList <PreferenciasBean> ();            
            while(result.next()) {
        		
            	preferenciaRegistrada = new PreferenciasBean();
            	preferenciaRegistrada.setDescPreferencia(result.getString("desc_preferencia"));
            	preferenciaRegistrada.setCodTipo(result.getString("cod_tipo"));
            	preferenciaRegistrada.setNroPreferencia(result.getString("nro_preferencia"));        		
            	preferenciasRegistradaList.add(preferenciaRegistrada);
	            
            }		  
            
            request.setAttribute("preferenciasRegistradaList", preferenciasRegistradaList);
            pst.close();
            
        	
            result.close();
            conn.close();
            
           
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