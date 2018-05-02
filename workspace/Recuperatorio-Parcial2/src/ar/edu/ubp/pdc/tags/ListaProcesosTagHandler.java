package ar.edu.ubp.pdc.tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ListaProcesosTagHandler extends SimpleTagSupport {
	private String nombre;
	private String funcion;
	
	@Override
	public void doTag() throws JspException, IOException
	{
		super.doTag();
		
		
		
		Connection conn;
		PreparedStatement stmt;//en este caso usar statement solo
		ResultSet result;
		
		JspWriter out = this.getJspContext().getOut();
			//if (this.codigo != null && this.codigo != "")
			//{
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
					conn.setAutoCommit(true);
					
					stmt = conn.prepareStatement("select desc_proceso, nro_proceso from dbo.procesos (nolock) order by desc_proceso", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					
					result = stmt.executeQuery();
					result = stmt.getResultSet();
					out.println("<select name=\""+nombre+"\" onchange=\""+funcion+"\">");
					out.println("<option value=\"-1\">Debeseleccionar un proceso</option>");
					while(result.next())
						out.println("<option value="+result.getInt("nro_proceso")+">"+result.getString("desc_proceso")+"</option>");
						
					stmt.close();
					conn.close();
					out.println("</select>");
				}
				catch (java.sql.SQLException | java.lang.InstantiationException | java.lang.IllegalAccessException | java.lang.ClassNotFoundException e) {
					out.println(e.getMessage());
				}
			//}
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
}
