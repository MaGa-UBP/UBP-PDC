package ar.edu.ubp.das.fds.cxf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://cxf.fds.das.ubp.edu.ar/", portName = "ListaObrasSocialesCXFPort", serviceName = "ListaObrasSocialesCXFService")
public class ListaObrasSocialesCXF {

	@WebMethod(operationName = "getObrasSociales", action = "urn:GetObrasSociales")
	public String[] getObrasSociales() throws Exception {
		String[] returnSet;
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
            	st = conn.prepareStatement("select *  from obras_sociales (nolock) order by cod_obra_social");
            	st.executeQuery();
            	LinkedList<String> queryReturnSet = new LinkedList<String>();
            	
            	result = st.getResultSet();
            	while(result.next()){
            		queryReturnSet.add(new String(result.getString(1)));
            	}
            	returnSet = new String[queryReturnSet.size()];
            	for(int i = 0; i< queryReturnSet.size();i++)
            	{
            		returnSet[i] = queryReturnSet.get(i);
            	}
            	return returnSet;
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
