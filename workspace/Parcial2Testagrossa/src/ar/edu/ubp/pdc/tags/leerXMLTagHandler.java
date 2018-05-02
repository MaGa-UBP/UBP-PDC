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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class leerXMLTagHandler extends SimpleTagSupport {

	private String nombre;
	private String funcion;
	
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		String nom = (this.nombre   == null ? "tipo_preferencia" : this.nombre);
		String fun = this.funcion;
		
		JspWriter out = this.getJspContext().getOut();
		
		try {
			SchemaFactory          schema   = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");	        
	        DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
	                               factory.setValidating(false);
	                               factory.setNamespaceAware(true);
	                               factory.setSchema(schema.newSchema(new Source[] {new StreamSource(((PageContext)this.getJspContext()).getServletContext().getResourceAsStream("/WEB-INF/xml/tipos_preferencias.xsd"))}));
   	        DocumentBuilder        builder  = factory.newDocumentBuilder();        
			XPath                  xPath    =  XPathFactory.newInstance().newXPath();
			Document               document = builder.parse(((PageContext)this.getJspContext()).getServletContext().getResourceAsStream("/WEB-INF/xml/tipos_preferencias.xml"));

			
			
			out.println("<form action=\"JavaScript:void(0);\" method=\"#\" id=\"form\" >");
			out.println("<h5><b>Tipo de Preferencia</b></h5>");
			out.println("<select name=\""+ nom +"\" onChange=\""+ fun +"\">");
			out.println("<option value=\"\" selected> Debe seleccionar un tipo de preferencia</option>");
			
			String   codigoTipo = "";
			String 	 textoTipo = "";
			Node     tipo;
			NodeList tipos = NodeList.class.cast(xPath.compile("/tipos/tipo").evaluate(document, XPathConstants.NODESET));
			for (int i = 0, len = tipos.getLength(); i < len; i++) {
				out.println("<option value=\""+ xPath.compile("@codigo").evaluate(tipos.item(i), XPathConstants.STRING) 
							+ "\">"+ xPath.compile("@texto").evaluate(tipos.item(i), XPathConstants.STRING) +"</option>");
			}
		
			out.println("</select>");
			out.println("</form>");
			
		}
		catch (ParserConfigurationException | SAXException | IOException | IllegalArgumentException | IllegalStateException | XPathExpressionException ex) {
			out.println(ex.getMessage());
		} 
			
			
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}




}