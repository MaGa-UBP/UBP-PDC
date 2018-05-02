package ar.edu.ubp.pdc.tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class TemasTagHandler extends SimpleTagSupport {
	private String nombre;
	private String codigo;
	
	@Override
	public void doTag() throws JspException, IOException
	{
		super.doTag();
		
		String nom = (this.nombre == null ? "" : this.nombre);
		
		Connection conn;
		PreparedStatement stmt;
		ResultSet result;
		
		JspWriter out = this.getJspContext().getOut();
			if (this.codigo != null && this.codigo != "")
			{
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
					conn.setAutoCommit(true);
					
					stmt = conn.prepareStatement("select tema, cod_tipo_servicio, nro_tema from dbo.temas_servicios (nolock) where cod_tipo_servicio = ? order by tema");
					stmt.setString(1, codigo);
					result = stmt.executeQuery();
					
					out.println("<select name="+nom+">");
					out.println("<option value=\"\" disabled selected>Seleccione un tema</option>");
					while(result.next())
						out.println("<option value="+result.getInt("nro_tema")+">"+result.getString("tema")+"</option>");
					
					stmt.close();
					conn.close();
					out.println("</select>");
				}
				catch (java.sql.SQLException | java.lang.InstantiationException | java.lang.IllegalAccessException | java.lang.ClassNotFoundException e) {
					out.println(e.getMessage());
				}
			}
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
