package ar.edu.ubp.pdc.tags;

import java.io.IOException;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AreasTagHandler extends SimpleTagSupport {
	private String name;
	private String presentacion;
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();

		JspWriter out = this.getJspContext().getOut();
		
		try {
			SchemaFactory          schema   = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");	        
	        DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
	                               factory.setValidating(false);
	                               factory.setNamespaceAware(true);
	                               factory.setSchema(schema.newSchema(new Source[] {new StreamSource(((PageContext)this.getJspContext()).getServletContext().getResourceAsStream("/WEB-INF/xml/areas.xsd"))}));
	        DocumentBuilder        builder  = factory.newDocumentBuilder();        
			
	        XPath                  xPath    =  XPathFactory.newInstance().newXPath();
			Document               document = builder.parse(((PageContext)this.getJspContext()).getServletContext().getResourceAsStream("/WEB-INF/xml/areas.xml"));
		
			String codigo,nombre;
			
			if(!(presentacion.equals("radio") || presentacion.equals("lista"))) {
				throw new IllegalArgumentException("El parámetro presentacion acepta 'radio' o 'lista'");
			}

					
			NodeList tipos = NodeList.class.cast(xPath.compile("/areas/area").evaluate(document, XPathConstants.NODESET));
			if(presentacion.equals("radio")){
				for (int i = 0, len = tipos.getLength(); i < len; i++) {
					codigo = String.valueOf(xPath.compile("codigo").evaluate(tipos.item(i), XPathConstants.STRING));
					nombre = String.valueOf(xPath.compile("nombre").evaluate(tipos.item(i), XPathConstants.STRING));
					out.println("<input type=\"radio\" name=\"" + name + "\" value=\"" + codigo + "\">" + nombre +"<br/>");	
				}						
			}
			else{
		    	out.println("<select name=\""+name+"\">");
		    	out.println("<option value=\"\" disabled selected>Seleccione un area</option>");
				for (int i = 0, len = tipos.getLength(); i < len; i++) {
					codigo = String.valueOf(xPath.compile("codigo").evaluate(tipos.item(i), XPathConstants.STRING));
					nombre = String.valueOf(xPath.compile("nombre").evaluate(tipos.item(i), XPathConstants.STRING));
					out.println("<option value=\""+codigo+"\">"+nombre+"</option>");
				}
			}
		}
		catch(SAXException | ParserConfigurationException | XPathExpressionException | IllegalArgumentException ex) {
			out.println(ex.getMessage());	
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

}
