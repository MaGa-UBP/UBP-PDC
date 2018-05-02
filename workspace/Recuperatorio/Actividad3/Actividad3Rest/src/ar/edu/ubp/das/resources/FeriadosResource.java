package ar.edu.ubp.das.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ar.edu.ubp.das.beans.A�oFeriadoBean;
import ar.edu.ubp.das.beans.FeriadoBean;

@Path("/feriados")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class FeriadosResource 
{
	@GET
	public String getMessage() {
		return "Hola mundo!";
	}
	
	@GET
	@Path("/getA�osFeriados")
	public Response getA�osFeriados()
	{
		Connection conn;
        PreparedStatement st;
        ResultSet result;
        
        try
        {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "cin");
            conn.setAutoCommit(true);
            
            try
            {
    			st = conn.prepareStatement("dbo.get_a�os_feriados");
	            st.executeQuery();
	            
	            LinkedList<A�oFeriadoBean> res = new LinkedList<A�oFeriadoBean>();
	            
	            result = st.getResultSet();
	            while(result.next()) {
	            	A�oFeriadoBean temp = new A�oFeriadoBean();
	            	temp.setA�o(result.getString("a�o"));
	            	temp.setActual(result.getString("actual"));
	            	res.add(temp);
	            }
	            
	            return Response.status(200).entity(res).build();
            }           
            catch (SQLException ex) {
            	return Response.status(Response.Status.BAD_REQUEST).entity("se rompio la parte de la consulta").build();
			}
	        finally {
	        	conn.close();
	        }
        } 
        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
        	return Response.status(Response.Status.BAD_REQUEST).entity("se rompio la parte de la conexion").build();
		}
	}
	
	@POST
	@Path("/getFeriados/{a�o}")
	public Response getFeriados(@PathParam("a�o") int a�o)
	{
		Connection conn;
        PreparedStatement st;
        ResultSet result;
        
        try
        {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "cin");
            conn.setAutoCommit(true);
            
            try
            {
    			st = conn.prepareStatement("execute dbo.get_feriados_por_a�o @a�o=?");
    			st.setInt(1, a�o);
	            st.executeQuery();
	            
	            LinkedList<FeriadoBean> res = new LinkedList<FeriadoBean>();
	            
	            result = st.getResultSet();
	            while(result.next()) {
	            	FeriadoBean temp = new FeriadoBean();
	            	temp.setFeriado(result.getString("feriado"));
	            	temp.setDescripcion(result.getString("desc_feriado"));
	            	res.add(temp);
	            }
	            
	            return Response.status(200).entity(res).build();
            }           
            catch (SQLException ex) {
            	return Response.status(Response.Status.BAD_REQUEST).entity("se rompio la parte de la consulta").build();
			}
	        finally {
	        	conn.close();
	        }
        } 
        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
        	return Response.status(Response.Status.BAD_REQUEST).entity("se rompio la parte de la conexion").build();
		}
	}
}
