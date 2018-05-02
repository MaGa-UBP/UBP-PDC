package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

import ar.edu.ubp.pdc.beans.GruposBean;


@WebServlet("/BuscarGrupos.jsp")
public class BuscarGruposServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarGruposServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        try {
        	Connection conn;
            PreparedStatement st;
            ResultSet result;
            
            String areaSel = (request.getParameter("area") == null ? "" : request.getParameter("area"));
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");            
            conn.setAutoCommit(true);

        	try {
        		LinkedList<GruposBean> grupos = new LinkedList<GruposBean>();
        		GruposBean g;
	
	            st = conn.prepareStatement("select cod_area,"+
						"nro_grupo,"+
						"nom_grupo,"+
						"vigente"+
						"from dbo.grupos_contactos"+
						"where cod_area = ?"+
						"end", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	

                st.setString(1, areaSel);
	
	            result = st.executeQuery();
	        	result.next();
				while(result.next()) {

					g = new GruposBean();
					g.setCod_area((result.getString("cod_area") == null ? "" : result.getString("cod_area") ));
					g.setNom_grupo((result.getString("nom_grupo") == null ? "" : result.getString("nom_grupo") ));
					g.setNro_grupo(0);
					g.setVigente((result.getString("vigente") == null ? "" : result.getString("vigente") ));

					grupos.add(g);
				}
	            st.close();
 
	            request.setAttribute("grupos", grupos);
	            this.gotoPage("/TablaGrupos.jsp", request, response);
	            
	            out.println(grupos.get(1));
        	}
    		catch(SQLException ex) {
                out.println(ex.getMessage());
    		}
    		finally {
    			conn.close();
    		}
        }
        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
        	response.setStatus(400);
        	out.println(ex.getMessage());
        	this.printError(ex.getMessage(), request, response);
        }
        finally {
        	out.close();	
        }*/
		response.setContentType("text/html;charset=iso-8859-1");
		Connection conn;
		PreparedStatement stmt;//para con parametros, para procedimiento almacenado se usa otro
		ResultSet result;

		LinkedList<GruposBean> grupos = new LinkedList<GruposBean>();
		GruposBean g;
		
		
		String areaSel = (request.getParameter("area") == null ? "" : request.getParameter("area"));

		if(request.getParameter("area") != null){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(true);
			
			//remplazar arrobas con signos de pregunta
			stmt = conn.prepareStatement("select * from dbo.grupos_contactos where cod_area = ? ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			
			stmt.setString(1, areaSel);
			 result = stmt.executeQuery();
	        	//result.next();
			result = stmt.getResultSet();
			while(result.next()) {
				g = new GruposBean();
				g.setCod_area((result.getString("cod_area") == null ? "" : result.getString("cod_area") ));
				g.setNom_grupo((result.getString("nom_grupo") == null ? "" : result.getString("nom_grupo") ));
				g.setNro_grupo(result.getInt("nro_grupo"));
				g.setVigente((result.getString("vigente") == null ? "" : result.getString("vigente") ));

				grupos.add(g);
			}
			
			stmt.close();
			conn.close();
			
			request.setAttribute("grupos", grupos);
			this.gotoPage("/TablaGrupos.jsp", request, response);
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			this.printError(e.getMessage(), request, response);
		}
		}
		
	}
	private void printError(String error, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("error", error);
		this.gotoPage("/error.jsp", request, response);
	}

	private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
		                  dispatcher.forward(request, response);
	}
}
