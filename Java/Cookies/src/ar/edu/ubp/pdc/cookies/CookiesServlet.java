package ar.edu.ubp.pdc.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesServlet
 */
@WebServlet("/index.jsp")
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesServlet() {
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
	Cookie cookies [] = request.getCookies();
//	try{  
	if(cookies!=null) {
		for(Cookie ck : cookies){  
			out.println("<tr>");
			out.println("<td>"+ck.getName()+"</td>");
			out.println("<td>"+ck.getValue()+"</td>");
			out.println("</tr>");
		}  
	}
//	}catch(Exception e){System.out.println(e);}  
	
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
		//doGet(request, response);
		
		Cookie ck = new Cookie(request.getParameter("key"), request.getParameter("value"));//creating cookie object  
		response.addCookie(ck);//adding cookie in the response  
		
		response.sendRedirect("./index.jsp");
	}

}
