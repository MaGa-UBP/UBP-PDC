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
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

@WebServlet("/index.jsp")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormularioServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        try {
	    	String path    = this.getServletContext().getRealPath("/WEB-INF/xml/") + System.getProperty("file.separator");
	        String xsdFile = path + "servicios.xsd";
	        String xmlFile = path + "servicios.xml";
	        String xslFile = path + "servicios.xsl";
	
	        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
	        
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	                               factory.setValidating(false);
	                               factory.setNamespaceAware(true);
	                               factory.setSchema(schemaFactory.newSchema(new Source[] {new StreamSource(xsdFile)}));
	
	        DocumentBuilder builder = factory.newDocumentBuilder();        
	       				    builder.setErrorHandler(
	       				    	new ErrorHandler() {
	       				    		@Override
	       				            public void warning(SAXParseException e) throws SAXException {
	       				    			throw e;
	       				            }
	       				
	       				            @Override
	       				            public void error(SAXParseException e) throws SAXException {
	       				                throw e;
	       				            }
	       				
	       				            @Override
	       				            public void fatalError(SAXParseException e) throws SAXException {
	       				                throw e;
	       				            }
	       				        });        
	                               
	        Document doc = builder.parse(new InputSource(xmlFile));      
	        
	        StreamResult result = new StreamResult(out);
	        
	        TransformerFactory tFactory = TransformerFactory.newInstance();
		    Transformer transformer = tFactory.newTransformer(new StreamSource(xslFile));
			                transformer.transform(new DOMSource(doc), result);
	    }
		catch (TransformerException | SAXException | ParserConfigurationException ex) {
	        this.printMessage(out, ex.getMessage());
	    } 
	    finally {            
	        out.close();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	     
	private void printMessage(PrintWriter out, String message) throws IOException {
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"./css/style.css\" />");
	    out.println("<title>Ejemplo XSLT</title>");            
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<div id=\"error\">" + message + "</div>");
	    out.println("</body>");
	    out.println("</html>");
	}
}
