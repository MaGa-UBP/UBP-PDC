package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

/**
 * Servlet implementation class LugaresServlet
 */
@WebServlet("/lugares.jsp")
public class LugaresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LugaresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"./css/style.css\" />");
            out.println("<title>Listas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Lugares</h3>");
			try {
				SchemaFactory          schema   = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");	        
		        DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
		                               factory.setValidating(false);
		                               factory.setNamespaceAware(true);
		                               factory.setSchema(schema.newSchema(new Source[] {new StreamSource(this.getServletContext().getResourceAsStream("/WEB-INF/xml/lugares.xsd"))}));
		        DocumentBuilder        builder  = factory.newDocumentBuilder();        
				XPath                  xPath    =  XPathFactory.newInstance().newXPath();
				Document               document = builder.parse(this.getServletContext().getResourceAsStream("/WEB-INF/xml/lugares.xml"));
				
				NodeList origenes = NodeList.class.cast(xPath.compile("/lugares/origenes/origen").evaluate(document, XPathConstants.NODESET));
				out.println("<div class=\"fl\"><b>Origen:</b>");
				out.println("<select name=\"origen\">");
				for (int i = 0, len = origenes.getLength(); i < len; i++) {
				    out.println("<option value=\"" + xPath.compile("codigo").evaluate(origenes.item(i), XPathConstants.STRING) + "\">" + xPath.compile("nombre").evaluate(origenes.item(i), XPathConstants.STRING) + "</option>");		
				}			
				out.println("</select>");
				out.println("</div>");

				NodeList destinos = NodeList.class.cast(xPath.compile("/lugares/destinos/destino").evaluate(document, XPathConstants.NODESET));
				out.println("<div class=\"fl\"><b>Destino:</b>");
				out.println("<select name=\"destino\">");
				for (int i = 0, len = destinos.getLength(); i < len; i++) {
				    out.println("<option value=\"" + xPath.compile("codigo").evaluate(destinos.item(i), XPathConstants.STRING) + "\">" + xPath.compile("nombre").evaluate(destinos.item(i), XPathConstants.STRING) + "</option>");		
				}			
				out.println("</select>");				
				out.println("</div>");
		        out.println("<div class=\"cb\"><a href=\"index.html\" target=\"_self\">Volver al index principal</a></div>");
			}
			catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | IllegalArgumentException ex) {
	        	this.printMessage(out, ex.getMessage());
			}	
		}
		finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
		}	
	}

	private void printMessage(PrintWriter out, String message) throws IOException {
    	out.println("<div id=\"error\">" + message + "</div>");
    }

}
