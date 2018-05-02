package ar.edu.ubp.das.resources;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/progacad")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ProgAcadResource {
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response insProgAcad(@FormParam("cod_categoria") String cod_categoria,
			@FormParam("desc_categoria") String desc_categoria) {
		Connection conn;
        CallableStatement st;
        try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        conn = DriverManager.getConnection("jdbc:sqlserver://bilbo;databaseName=pdc", "mbarotto", "37225846");            
	        conn.setAutoCommit(false);
	
	        try {
	            st = conn.prepareCall("{CALL dbo.ins_categoria(?, ?)}");
	            st.setString(1, cod_categoria);
	            st.setString(2, desc_categoria);
	            st.execute();
	            conn.commit();
	            return Response.status(Response.Status.OK).build();
			}
			catch (SQLException ex) {
				conn.rollback();
    			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
			}
	        finally {
	        	conn.setAutoCommit(true);
	        	conn.close();
	        }
        }
        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
		}

	}

	@DELETE
	public Response delProgAcad(@QueryParam("cod_categoria") String cod_categoria) {
		Connection conn;
        PreparedStatement st;
        try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        conn = DriverManager.getConnection("jdbc:sqlserver://bilbo;databaseName=pdc", "mbarotto", "37225846");            
	        conn.setAutoCommit(false);
	
	        try {
	            st = conn.prepareCall("delete from dbo.categorias_programas_academicos where cod_categoria = ?");
	            st.setString(1, cod_categoria);
	            st.execute();
	            conn.commit();
	            return Response.status(Response.Status.OK).build();
			}
			catch (SQLException ex) {
				conn.rollback();
    			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
			}
	        finally {
	        	conn.setAutoCommit(true);
	        	conn.close();
	        }
        }
        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
		}

	}

	
}

