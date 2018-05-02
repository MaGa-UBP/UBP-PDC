package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/index.jsp")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        try {
        	HttpSession session = request.getSession(true);

            out.println("<!DOCTYPE html>");
        	out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html\">");
            out.println("<meta charset=\"ISO-8859-1\">");
            out.println("<title>Sessions with Cookies</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Ejemplo 1: Manejo de Sesiones con uso de Cookies</h2>");
            out.println("<h3>Sesi&oacute;n</h3>");
            out.println("<p>Identificador: " + session.getId() + "</p>");
            out.println("<p>¿Nueva?: " + (session.isNew() ? "Si" : "No") + "</p>");
            out.println("<p>Fecha de Creaci&oacute;n: " + new Date(session.getCreationTime()) + "</p>");
            out.println("<p>Fecha &Uacute;lt. Acceso: " + new Date(session.getLastAccessedTime()) + "</p>");
            out.println("<p>¿Usa cookie?: " + (request.isRequestedSessionIdFromCookie() ? "Si" : "No") + "</p>");
            out.println("<a href=\"./index.jsp\">Recargar</a>");
            out.println("</body>");
            out.println("</html>");
        } 
        finally {            
            out.close();
        }
	}

}
