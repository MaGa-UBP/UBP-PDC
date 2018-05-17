package ar.edu.ubp.pdc.tp2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/cart/add")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true); 
		String attrName;
		PrintWriter out = response.getWriter();
		out.println("Session: \n");
		
		Enumeration<String> attrs = session.getAttributeNames();
		while(attrs.hasMoreElements()) {
			attrName = attrs.nextElement();
			out.println("Key:"+ attrName +", ");
			out.println("Value: "+ session.getAttribute(attrName) +"\n");
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ACA VA TODO LO DE SESION
		
		HttpSession session = request.getSession(true); 
//		Integer 
		Integer cant = (session.getAttribute(request.getParameter("prodID")) != null? ((Integer)session.getAttribute(request.getParameter("prodID")))+1 : 1);
		
		session.setAttribute(request.getParameter("prodID"), cant);
		response.getWriter().append(request.getParameter("prodName"));
//		response.sendRedirect("./index.jsp");
	}

}
