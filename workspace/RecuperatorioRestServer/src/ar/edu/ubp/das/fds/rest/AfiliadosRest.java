package ar.edu.ubp.das.fds.rest;

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

import ar.edu.ubp.das.fds.rest.AfiliadoBean;


@Path("/afiliados")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class AfiliadosRest {

	@GET
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/getAfiliados/{obra_social}")
	public Response getAfiliados(@PathParam("obra_social") String obra_social) throws Exception
	{
		Connection conn;
        PreparedStatement st;
        ResultSet result;
        
        try
        {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://bilbo;databaseName=pdc", "fdeschant", "37011374");
            conn.setAutoCommit(true);
            try
            {
    			LinkedList<AfiliadoBean> afiliados;
	            
    			st = conn.prepareStatement("select apellido, nombre, cod_tipo_documento, nro_documento, baja, nro_afiliado from dbo.afiliados (nolock) where cod_obra_social = ?");
	            st.setString(1, obra_social);
	            st.executeQuery();
	            
	            result = st.getResultSet();
	            afiliados = new LinkedList<AfiliadoBean>();
	            while(result.next()) {
	            	AfiliadoBean afiliado = new AfiliadoBean();
	            	afiliado.setApellido(result.getString("apellido"));
	            	afiliado.setNombre(result.getString("nombre"));
	            	afiliado.setBaja(result.getString("baja"));
	            	afiliado.setCod_tipo_documento(result.getString("cod_tipo_documento"));
	            	afiliado.setNro_afiliado(result.getInt("nro_afiliado"));
	            	afiliado.setNro_documento(result.getString("nro_documento"));
	            	afiliados.add(afiliado);
	            }
	            
	            return Response.status(200).entity(afiliados).build();
            }           
            catch (SQLException ex) {
            	return Response.status(Response.Status.BAD_REQUEST).entity(ex).build();
			}
	        finally {
	        	conn.close();
	        }
           
        } 
        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
        	return Response.status(Response.Status.BAD_REQUEST).entity(ex).build();
		}
	}
}
