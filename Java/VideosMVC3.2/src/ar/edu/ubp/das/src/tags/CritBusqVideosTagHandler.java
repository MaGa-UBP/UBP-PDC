package ar.edu.ubp.das.src.tags;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.db.Dao;
import ar.edu.ubp.das.mvc.db.DaoFactory;

public class CritBusqVideosTagHandler extends SimpleTagSupport {

	private String onClick;
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();

		JspWriter out = this.getJspContext().getOut();
				  out.println("<fieldset>");	
				
        try {
        	String lang = String.valueOf(this.getJspContext().getAttribute("lang", PageContext.SESSION_SCOPE));
        	
            Locale.setDefault(new Locale(lang));
            ResourceBundle bundle = ResourceBundle.getBundle("ar.edu.ubp.das.src.videos.properties.etiquetas");

            List<DynaActionForm> categorias;
            DynaActionForm form = new DynaActionForm();
                           form.setItem("lang", lang);
                           
            Dao dao = DaoFactory.getDao("Categorias", "tags");
            
            out.println("<input type=\"text\" name=\"string_busqueda\" value=\"\" maxlength=\"255\" size=\"100\" /><br/><br/>");
            out.println("<input type=\"radio\" id=\"c0\" name=\"nro_categoria\" checked value=\"\"/><label for=\"c0\" checked>" + bundle.getString("todos") + "</label>&nbsp;&nbsp;");

            categorias = dao.select(form);
            for(DynaActionForm categoria : categorias) {
            	out.println("<input type=\"radio\" id=\"c" + categoria.getItem("nro_categoria") + "\" name=\"nro_categoria\" value=\"" + categoria.getItem("nro_categoria") + "\"/><label for=\"c" + categoria.getItem("nro_categoria") + "\">" + categoria.getItem("nom_categoria") + "</label>&nbsp;&nbsp;");
            }
            
            out.println("<br/><br/><input type=\"button\" value=\"" + bundle.getString("buscar") + "\" onclick=\"" + this.onClick + "\"/>");
    	}
		catch(SQLException ex) {
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
