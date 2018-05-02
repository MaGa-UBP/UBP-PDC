package ar.edu.ubp.pdc.tags;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CarrerasTagHandler extends SimpleTagSupport {
	private String nombre;
	private String funcion;
	
	private String todas;
	private String obligatoria;
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();

		JspWriter out = this.getJspContext().getOut();
	
		Connection conn;
		Statement stmt;
		ResultSet result;
		
	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(true);
			
			stmt = conn.createStatement();
			stmt.executeQuery("select nro_carrera, nom_carrera from dbo.carreras (nolock) order by nom_carrera");
			
			out.println("<select name=\""+nombre+"\" style=\"width:500px\">");
			if(obligatoria.equals("si")){
				out.println("<option value=\"-1\"> " + "Debe seleccionar una carrera" + "</option>");
			}
			
			result = stmt.getResultSet();
			while(result.next()) {
				out.println("<option value=\""+result.getInt("nro_carrera")+"\" onchanche=\""+funcion+"\" > " + result.getString("nom_carrera") + "</option>");
			}
			out.println("</select>");
			
			stmt.close();
			conn.close();
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | IllegalArgumentException e) {
			out.println(e.getMessage());
		}
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	
	public void setTodas(String todas) {
		this.todas = todas;
	}

	public void setObligatoria(String obligatoria) {
		this.obligatoria = obligatoria;
	}

}
