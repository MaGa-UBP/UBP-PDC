package ar.edu.ubp.pdc.tag;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CritBusqVideosTagHandler extends SimpleTagSupport {

	private String onClick;
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();

		JspWriter out = this.getJspContext().getOut();
				  out.println("<fieldset>");	
				
        try {
        	Connection conn;
            CallableStatement st;
            ResultSet result;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");            
            conn.setAutoCommit(true);

            try {
                st = conn.prepareCall("{CALL dbo.get_categorias_videos}");
                st.execute();

                out.println("<input type=\"text\" name=\"string_busqueda\" value=\"\" maxlength=\"255\" size=\"100\" /><br/><br/>");
                out.println("<input type=\"radio\" id=\"c0\" name=\"nro_categoria\" checked value=\"\"/><label for=\"c0\" checked>Todos</label>&nbsp;&nbsp;");
                
                result = st.getResultSet();
                while(result.next()) {
                	out.println("<input type=\"radio\" id=\"c" + result.getShort("nro_categoria") + "\" name=\"nro_categoria\" value=\"" + result.getShort("nro_categoria") + "\"/><label for=\"c" + result.getShort("nro_categoria") + "\">" + result.getString("nom_categoria") + "</label>&nbsp;&nbsp;");
                }
                result.close();
                
                out.println("<br/><br/><input type=\"button\" value=\"Buscar\" onclick=\"" + this.onClick + "\"/>");
    		}
    		catch(SQLException ex) {
                out.println(ex.getMessage());
    		}
    		finally {
    			conn.close();
    		}
        }
        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            out.println(ex.getMessage());
        }
        finally {
			out.println("</fieldset>");	
        }
	}
	
	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}
	
}
