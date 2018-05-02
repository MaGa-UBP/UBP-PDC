package ar.edu.ubp.pdc.tags;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PropietariosTagHandler extends SimpleTagSupport {

	private String nombre;
	private String tipoPropietario;
	private int codArea;
	private int nroLegPersonal;
	private String habilitado;
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();

		JspWriter out = this.getJspContext().getOut();
	
		Connection conn;
		CallableStatement stmt;		
		ResultSet result;
		
		try {
			if(!(tipoPropietario.equals("A") || tipoPropietario.equals("P"))) {
				throw new IllegalArgumentException("El parámetro tipoPropietario acepta A o P");
			}

			if(!(habilitado.equals("S") || habilitado.equals("N"))) {
				throw new IllegalArgumentException("El parámetro habilitado acepta S o N");
			}
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(true);
			
			stmt = conn.prepareCall("{CALL dbo.get_lista_propietarios(?,?,?)}");
			stmt.setString(1, tipoPropietario);
			if(Integer.valueOf(nroLegPersonal) == null || nroLegPersonal == 0) {
				stmt.setNull(2, Types.INTEGER);
			}
			else {
				stmt.setInt(2, nroLegPersonal);
			}
			if(Integer.valueOf(codArea) == null || codArea == 0) {
				stmt.setNull(3, Types.INTEGER);
			}
			else {
				stmt.setInt(3, codArea);
			}
			
			result = stmt.executeQuery();

			/* O...
			 * stmt.execute();
			 * result = stmt.getResultSet();
			 */
			
			out.println("<select name=\"" + nombre + "\" " + (habilitado.equals("S") ? "" : "disabled") + ">");
			while(result.next()) {
				out.println("<option value=\"" + result.getInt("nro_area") + ";" + result.getInt("nro_leg_personal") + "\" " + 
			                (result.getString("seleccionado").equals("S") ? "selected" : "") + ">" + result.getString("nombre") + "</option>");
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
	
	public void setTipoPropietario(String tipoPropietario) {
		this.tipoPropietario = tipoPropietario;
	}
	
	public void setCodArea(int codArea) {
		this.codArea = codArea;
	}

	public void setNroLegPersonal(int nroLegPersonal) {
		this.nroLegPersonal = nroLegPersonal;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}
	
}
