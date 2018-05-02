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

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Servlet implementation class ProductosFaltantesServlet
 */
@WebServlet("/index.jsp")
public class ProductosFaltantesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductosFaltantesServlet() {
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
				Document               document = builder.parse(this.getServletContext().getResourceAsStream("/WEB-INF/xml/stock.xml"));
				
				out.println("<table>");
				out.println("<tr>");
				out.println("<th align=\"left\">Producto</th>");
				out.println("</tr>");
				
				String   nomProducto = "";
				Node     producto;
				NodeList productos = document.getElementsByTagName("producto");
				for(int i = 0; i < productos.getLength(); i ++) {
					for(int j = 0; j < productos.item(i).getChildNodes().getLength(); j ++) {
						producto = productos.item(i).getChildNodes().item(j);
						if(producto.getNodeType() == Node.ELEMENT_NODE) {
							if(producto.getNodeName().equals("nom")) {
								nomProducto = producto.getFirstChild().getNodeValue();
							}
							else if(producto.getNodeName().equals("cant") && Integer.parseInt(producto.getFirstChild().getNodeValue()) == 0) {
								out.println("<tr>");
								out.println("<td>" + nomProducto + "</td>");
								out.println("</tr>");
							}
						}	
					}					
				}
				
				out.println("</table>");
			}
			catch (ParserConfigurationException | SAXException | IOException | IllegalArgumentException ex) {
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
