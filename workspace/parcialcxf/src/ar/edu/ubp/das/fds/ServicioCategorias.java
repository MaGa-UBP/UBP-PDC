package ar.edu.ubp.das.fds;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;





@WebService(targetNamespace = "http://fds.das.ubp.edu.ar/", endpointInterface = "ar.edu.ubp.das.fds.ServicioCategoriasWS", portName = "ServicioCategoriasPort", serviceName = "ServicioCategoriasService")
public class ServicioCategorias implements ServicioCategoriasWS {
	
	
	
	public LinkedList <Categoria> getCategorias() throws Exception{
		Connection conn;
        CallableStatement st;
        ResultSet result;
        
        try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=das", "fdeschant", "37011374");            
	        conn.setAutoCommit(true);
	
	        try {
	        	LinkedList<Categoria> categorias;
	        	
	            st = conn.prepareCall("select cod_categoria, desc_categoria from dbo.categorias_programas_academicos}");
	            st.executeQuery();
			
	            result     = st.getResultSet();
	            categorias = new LinkedList<Categoria>();
	            while(result.next()) {
	            	Categoria bean = new Categoria();
	            	              bean.setCod_categoria(result.getString("cod_categoria"));
	            	              bean.setDesc_categoria(result.getString("desc_categoria"));
	            	categorias.add(bean);              
	            }
	            
	            return categorias;	            
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
}
