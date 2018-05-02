package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
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
import javax.servlet.http.HttpSession;

import ar.edu.ubp.pdc.beans.PreferenciaBean;

/**
 * Servlet implementation class BusquedaPreferencias
 */
@WebServlet("/busquedaPreferencias.jsp")
public class BusquedaPreferencias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaPreferencias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=ISO-8859-1");
		
		HttpSession session = request.getSession(true);
		
		try {
					
					Connection conn;
		            CallableStatement st;
		            PreparedStatement pst;
		            String idSesion = session.getId();
		            String codTipo =  request.getParameter("tipo");
		
		            //Statement st;
		            ResultSet result;
		            LinkedList<PreferenciaBean> preferencias = new LinkedList<PreferenciaBean>();
		            LinkedList<PreferenciaBean> misPreferencias = new LinkedList<PreferenciaBean>();
		            PreferenciaBean preferencia;
		            
		            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
		            //conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "33814003"); 
		            conn.setAutoCommit(true);
		            
		            st = conn.prepareCall("{CALL dbo.get_lista_preferencias_posibles(?, ?)}");
		            st.setString(1, idSesion);
		            st.setString(2, codTipo);
		
		            //st.execute();
		
		            result = st.executeQuery();
		            
		            while (result.next()){
		            	preferencia = new PreferenciaBean();
		            	preferencia.setDescPreferencia(result.getString("desc_preferencia"));
		            	preferencia.setCodTipo(result.getString("cod_tipo"));
		            	preferencia.setNroPreferencia(result.getString("nro_preferencia"));
		            	preferencias.add(preferencia);
		            }
		            result.close();
		            st.close();
		            
		            //----------------------------------
		            
		            String SQL = " select "
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
		        	pst = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        	//pst = conn.prepareStatement(consulta);
		        	pst.setString(1, idSesion);
		            pst.setString(2, codTipo);
		            
		            
		            result = pst.executeQuery();
		            
		            while (result.next()){
		            	preferencia = new PreferenciaBean();
		            	preferencia.setDescPreferencia(result.getString("desc_preferencia"));
		            	preferencia.setCodTipo(result.getString("cod_tipo"));
		            	preferencia.setNroPreferencia(result.getString("nro_preferencia"));
		            	misPreferencias.add(preferencia);
		            }
		            result.close();
		            pst.close();
		            conn.close();
		            request.setAttribute("preferencias", preferencias);
		            request.setAttribute("misPreferencias", misPreferencias);
		            this.gotoPage("/lista.jsp", request, response);
            
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
