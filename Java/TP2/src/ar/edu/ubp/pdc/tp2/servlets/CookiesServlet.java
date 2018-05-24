package ar.edu.ubp.pdc.tp2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CookiesServlet
 */
@WebServlet("/cookies.jsp")
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
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (cookies != null) {
		 for (Cookie cookie : cookies) {
		   if (cookie.getName().equals("rememberData")) {
			   out.println( URLDecoder.decode(cookie.getValue(), "UTF-8"));
		    }
		  }
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Cookie cookie = null;
		if(request.getParameter("rememberCookie") == null || request.getParameter("rememberCookie") == "") {
			cookie = new Cookie("rememberData", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		else {
			String cookieStr = ""; 
			cookieStr+= request.getParameter("nameCookie") +";";
			cookieStr+= request.getParameter("surnameCookie") +";";
			cookieStr+= request.getParameter("emailCookie") +";";
			cookieStr+= request.getParameter("addressCookie");

			cookie = new Cookie("rememberData", URLEncoder.encode(cookieStr, "UTF-8"));
			//cookie.setMaxAge(24 * 60 * 60);  // 24 horas
			response.addCookie(cookie);
		}
		
		HttpSession session = request.getSession(true);
		session.invalidate();
		response.sendRedirect("./index.jsp");
	}

}
