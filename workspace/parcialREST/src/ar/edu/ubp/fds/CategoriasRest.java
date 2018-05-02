package ar.edu.ubp.fds;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ar.edu.ubp.fds.Categoria;


@Path("/parcial")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class CategoriasRest {
	
	@POST
	@Path("/agregar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response agregar(@FormParam("cod_categoria") String codCategoria, 
			                  @FormParam("desc_categoria") String descCategoria) throws Exception {
		Connection conn;
        CallableStatement st;
        ResultSet result;
        
        try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        conn = DriverManager.getConnection("jdbc:sqlserver://bilbo;databaseName=pdc", "fdeschant", "37011374");            
	        conn.setAutoCommit(true);
	
	        try {
	        	LinkedList<Categoria> categorias;
	        	
	        	st = conn.prepareCall("{CALL dbo.ins_categoria(?,?)}");
            	st.setString(1, codCategoria);
            	st.setString(2, descCategoria);
	            st.executeQuery();
			
	            result     = st.getResultSet();
	            
	            
	            return Response.status(Response.Status.OK).entity("asdasdasd").build();	  
	            
			}
			catch (SQLException ex) {
    			throw new Exception(ex);
			}
	        finally {
	        	conn.close();
	        }
        }
        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			throw new Exception(ex);
		}
	}

	@GET
	@Path("/eliminar/{cod_categoria}")
	public Response getVideosSinAgrupar(@FormParam("cod_categoria") String codCategoria){
        try {
        	Connection conn;
            PreparedStatement st;
            ResultSet result;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://bilbo;databaseName=pdc", "fdeschant", "37011374");
            conn.setAutoCommit(true);

            try {
            	
            	st = conn.prepareStatement("delete from dbo.categorias_programas_academicos where cod_categoria = ?");
                st.setString(1, codCategoria);
            	st.executeQuery();
            	
                return  Response.status(Response.Status.OK).entity("asdasdasd").build();	
            }
    		catch(SQLException ex) {
				return  Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();	
    		}
    		finally {
    			conn.close();
    		}
        }
        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			return  Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
	}
}
