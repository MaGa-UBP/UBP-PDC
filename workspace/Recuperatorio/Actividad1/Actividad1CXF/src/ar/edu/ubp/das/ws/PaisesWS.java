package ar.edu.ubp.das.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ar.edu.ubp.das.bean.PaisBean;

@WebService(targetNamespace = "http://ws.das.ubp.edu.ar/", portName = "PaisesWSPort", serviceName = "PaisesWSService")
public class PaisesWS 
{
	@WebMethod(operationName = "test", action = "urn:Test")
	public String test()
	{
		return "Service running...";
	}
	
	@WebMethod(operationName = "getPaises", action = "urn:GetPaises")
	public LinkedList<PaisBean> getPaises() throws Exception
	{
		Connection conn;
        Statement st;
        ResultSet result;
        
        try
        {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "cin");
            conn.setAutoCommit(true);
            
            try
            {
    			LinkedList<PaisBean> paises;
	            
	            st = conn.createStatement();
	            st.executeQuery("select cod_pais, pais from dbo.paises (nolock) order by pais");
	            
	            result = st.getResultSet();
	            paises = new LinkedList<PaisBean>();
	            while(result.next()) {
	            	PaisBean pais = new PaisBean();
	            	pais.setCodPais(result.getString("cod_pais"));
	            	pais.setNomPais(result.getString("pais"));
	            	paises.add(pais);
	            }  
	            
	            return paises;
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
