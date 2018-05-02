package ar.edu.ubp.pdc.tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ListaTemasTagHandler extends SimpleTagSupport {
	
	String nombre;
	String codigo;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		JspWriter out = this.getJspContext().getOut();
		
		try {
			String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String dbConnString = "jdbc:sqlserver://BILBO;databaseName=pdc"; 
			String dbUser = "iroccalada";
			String dbPassword = "37575567";
			Class.forName(dbDriver).newInstance();
			Connection con = DriverManager.getConnection(dbConnString, dbUser, dbPassword);
			
			String statement = "select tema, cod_tipo_servicio, nro_tema " +
							   "from dbo.temas_servicios (nolock) " +
							   "where cod_tipo_servicio = ? " +
							   "order by tema;";
			
			System.out.println("Statement: " + statement);
			
			PreparedStatement stmtConsulta = con.prepareStatement(statement);
			stmtConsulta.setString(1, codigo);
			ResultSet rs = stmtConsulta.executeQuery();
			out.println("<label for=\""+nombre+"\">Temas</label> <br/>");
			out.println( "<select name=\"" + nombre + "\" id=\"listaTemas\">" );
			while( rs.next() ){
				out.println( "<option value=\""+ rs.getString("nro_tema") +"\">"+ rs.getString("tema") +"</option>" );
			}
			out.println( "</select>" );
			
			stmtConsulta.close();
			con.close();
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
		}
		
		
	}
}
