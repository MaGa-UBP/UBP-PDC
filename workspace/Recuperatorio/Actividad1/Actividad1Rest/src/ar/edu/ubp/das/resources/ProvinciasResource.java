package ar.edu.ubp.das.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ar.edu.ubp.das.bean.ProvinciaBean;

@Path("/provincias")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ProvinciasResource 
{
	@GET
	public String getMessage() {
		return "Hola mundo!";
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/getProvincias")
	public Response getProvincias(@FormParam("cod_pais") String codPais) throws Exception
	{
		Connection conn;
        PreparedStatement st;
        ResultSet result;
        
        String res = "";
        
        try
        {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "cin");
            conn.setAutoCommit(true);
            
            try
            {
    			LinkedList<ProvinciaBean> provincias;
	            
    			st = conn.prepareStatement("select cod_pais, cod_provincia, provincia from dbo.provincias (nolock) where cod_pais = ? order by provincia");
	            st.setString(1, codPais);
	            st.executeQuery();
	            
	            result = st.getResultSet();
	            provincias = new LinkedList<ProvinciaBean>();
	            while(result.next()) {
	            	ProvinciaBean provincia = new ProvinciaBean();
	            	provincia.setCodProvincia(result.getString("cod_provincia"));
	            	provincia.setNomProvincia(result.getString("provincia"));
	            	provincias.add(provincia);
	            }
	            
	            return Response.status(200).entity(provincias).build();
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
