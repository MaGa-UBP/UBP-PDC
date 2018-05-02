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
 * Servlet implementation class ProductosServlet
 */
@WebServlet("/productos.jsp")
public class ProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductosServlet() {
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
            out.println("<title>Lista</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Productos Faltantes</h3>");
			try {
				SchemaFactory          schema   = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");	        
		        DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
		                               factory.setValidating(false);
		                               factory.setNamespaceAware(true);
		                               factory.setSchema(schema.newSchema(new Source[] {new StreamSource(this.getServletContext().getResourceAsStream("/WEB-INF/xml/stock.xsd"))}));
		        DocumentBuilder        builder  = factory.newDocumentBuilder();        
				XPath                  xPath    =  XPathFactory.newInstance().newXPath();
				Document               document = builder.parse(this.getServletContext().getResourceAsStream("/WEB-INF/xml/stock.xml"));
				
				out.println("<table>");
				out.println("<tr>");
				out.println("<th align=\"left\">Producto</th>");
				out.println("</tr>");
				
				NodeList productos = NodeList.class.cast(xPath.compile("/productos/producto/cant[text()=0]").evaluate(document, XPathConstants.NODESET));
				for (int i = 0, len = productos.getLength(); i < len; i++) {
					out.println("<tr>");
					out.println("<td>" + xPath.compile("../nom").evaluate(productos.item(i), XPathConstants.STRING) + "</td>");
					out.println("</tr>");
				}	
				
				out.println("</table>");
				out.println("<br/>");
		        out.println("<a href=\"index.html\" target=\"_self\">Volver al index principal</a>");
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
