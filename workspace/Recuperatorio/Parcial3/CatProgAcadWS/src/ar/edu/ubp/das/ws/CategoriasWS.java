package ar.edu.ubp.das.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.jws.WebService;

import ar.edu.ubp.das.bean.CategoriaBean;

@WebService(targetNamespace = "http://ws.das.ubp.edu.ar/", endpointInterface = "ar.edu.ubp.das.ws.ICategorias", portName = "CategoriasWSPort", serviceName = "CategoriasWSService")
public class CategoriasWS implements ICategorias{

	public LinkedList<CategoriaBean> getCategorias() throws Exception {
        Connection conn;
        Statement st;
        ResultSet result;
        
        try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        conn = DriverManager.getConnection("jdbc:sqlserver://bilbo;databaseName=pdc", "mbarotto", "37225846");            
	        conn.setAutoCommit(true);
	
	        try {
	        	LinkedList<CategoriaBean> categorias;
	        	
	            st = conn.createStatement();
	            st.execute("select distinct cod_categoria, desc_categoria from dbo.categorias_programas_academicos");
			
	            result     = st.getResultSet();
	            categorias = new LinkedList<CategoriaBean>();
	            while(result.next()) {
	            	CategoriaBean bean = new CategoriaBean();
	            	              bean.setCodCategoria(result.getString("cod_categoria"));
	            	              bean.setDescCategoria(result.getString("desc_categoria"));
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
