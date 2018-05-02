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

public class parserXMLTagHandler extends SimpleTagSupport {

	private String name;
	private String func;

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		JspWriter out = this.getJspContext().getOut();
		
		String nameLista = (this.name == "" ? "tipo_preferencia" : this.name);
		String funcion = this.func;	
		try {
			SchemaFactory          schema   = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");	        
	        DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
	                               factory.setValidating(false);
	                               factory.setNamespaceAware(true);
	                               factory.setSchema(schema.newSchema(new Source[] {new StreamSource(((PageContext)this.getJspContext()).getServletContext().getResourceAsStream("/WEB-INF/xml/tipos_preferencias.xsd"))}));
	        DocumentBuilder        builder  = factory.newDocumentBuilder();        
			XPath                  xPath    =  XPathFactory.newInstance().newXPath();
			Document               document = builder.parse(((PageContext)this.getJspContext()).getServletContext().getResourceAsStream("/WEB-INF/xml/tipos_preferencias.xml"));
			
			
			out.println("<form id=\"form\" action=\"JavaScript:void(0);\" method=\"#\">");
			NodeList preferencias = NodeList.class.cast(xPath.compile("/tipos/tipo").evaluate(document, XPathConstants.NODESET));
			out.println("<select name=\""+ nameLista +"\" onChange=\""+ funcion +"\">");
			out.println("<option value=\"\" selected> Debe seleccionar un tipo de preferencia</option>");
			for (int i = 0, len = preferencias.getLength(); i < len; i++) {
			    out.println("<option value=\"" + xPath.compile("@codigo").evaluate(preferencias.item(i), XPathConstants.STRING) + "\">" + xPath.compile("@texto").evaluate(preferencias.item(i), XPathConstants.STRING) + "</option>");		
			}			
			out.println("</select>");
			out.println("</form>");
			
		}
		catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | IllegalArgumentException ex) {
        	//this.printMessage(out, ex.getMessage());
			out.println(ex.getMessage());
		}	
	}
	
	public void setName(String nLista) {
		this.name = nLista;
	}
	public void setFunc(String funcion) {
		this.func = funcion;
	}

}
