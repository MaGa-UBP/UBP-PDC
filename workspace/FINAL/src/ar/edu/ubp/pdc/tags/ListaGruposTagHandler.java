package ar.edu.ubp.pdc.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import ar.edu.ubp.pdc.beans.GrupoBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class ListaGruposTagHandler extends SimpleTagSupport {
	
	private String name;
	private String grupo;

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		JspWriter out = this.getJspContext().getOut();
		
		String nameLista = this.name;
		String group = (this.grupo == null ? "" : this.grupo);
		
		
  		try{
  			Connection conn;
  			PreparedStatement pst;
  			ResultSet result;
  			LinkedList<GrupoBean> grupos = new LinkedList<GrupoBean>();
  			GrupoBean grupo;
  			
  			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //conn = DriverManager.getConnection("jdbc:sqlserver://bilbo;databaseName=pdc", "scenzano", "33814003");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801"); 
            conn.setAutoCommit(true);
            
            String consulta = "select nro_grupo_atencion, "
            				+ "nom_grupo_atencion "
            				+ "from dbo.grupos_atencion (nolock)"
            				+ "order by nom_grupo_atencion";
            
            
            pst = conn.prepareStatement(consulta);
            
            result = pst.executeQuery();
            
            while (result.next()){
            	grupo = new GrupoBean();
            	grupo.setNroGrupo(result.getString("nro_grupo_atencion"));
            	grupo.setNomGrupo(result.getString("nom_grupo_atencion"));
            	grupos.add(grupo);
            }
            result.close();
            pst.close();
            conn.close();
            
           
    		out.println("<select name=\""+ nameLista +"\" id=\"listaGrupos\"  >");
    		if(group.equals("")){
    			out.println("<option selected value=\"\" ></option>");
    		}
    		for(GrupoBean g : grupos){
    			out.println("<option value=\""+ g.getNroGrupo() + "\"" + (group.equals(g.getNroGrupo()) && !group.equals("") ? "selected" : "")  + ">" + g.getNomGrupo() + "</option>");
    		}
    		out.println("</select>");
      		
            
  		}
  		catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException ex) {
  			out.println(ex.getMessage());
        }

	}
	
	public void setName(String nLista) {
		this.name = nLista;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
}
