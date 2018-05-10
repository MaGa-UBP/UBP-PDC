package ar.edu.ubp.pdc.sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionsServlet
 */
@WebServlet("/index.jsp")
public class SessionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
					  
	PrintWriter out = response.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<body>");
	out.println("<form action=\"index.jsp\" method=\"post\">");
	out.println("<table>");
	out.println("<thead>");
	out.println("<tr><th>Clave</th><th>Valor</th></tr>");
	out.println("</thead>");
	out.println("<tbody>");
	
	HttpSession session = request.getSession(true); 
	String attrName;
	
	Enumeration<String> attrs = session.getAttributeNames();
	while(attrs.hasMoreElements()) {
		attrName = attrs.nextElement();
		out.println("<tr>");
		out.println("<td>"+ attrName +"</td>");
		out.println("<td>"+ session.getAttribute(attrName) +"</td>");
		out.println("</tr>");
	}
	
	out.println("<tr>");
	out.println("<td><input type=\"text\" name=\"key\" required></td>");
	out.println("<td><input type=\"text\" name=\"value\" required></td>");
	out.println("</tr>");
	
	out.println("</tbody>");
	out.println("</table>");
	out.println("<input type=\"submit\" value=\"Agregar\">");
	out.println("</form>");
	out.println("</body>");
	out.println("</html>");
	out.close();
			  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// si no pongo nada entre (), interpreta que la sesion existe. Si le pongo true, valida si la tiene, sino la crea.
		HttpSession session = request.getSession(true); 
		
		session.setAttribute(request.getParameter("key"), request.getParameter("value"));
		response.sendRedirect("./index.jsp");
	}


}
