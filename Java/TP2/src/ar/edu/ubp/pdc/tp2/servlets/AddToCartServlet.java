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

import ar.edu.ubp.pdc.tp2.classes.Product;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCart.jsp")
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
			Product aux = (Product) session.getAttribute(attrName);
			out.println("Name: "+ aux.getNombre());
			out.println("Cant: "+ aux.getCantidad() +"\n");
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
		
		Integer cant = 1; //Aca hay que tomar el parametro cantidad cuanndo este hecho
		
		if(session.getAttribute(request.getParameter("prodID")) != null) {
			Product aux = (Product) session.getAttribute(request.getParameter("prodID"));
			cant += aux.getCantidad();
		}
		
		Product productToAdd = new Product(request.getParameter("prodID"), request.getParameter("prodName"), request.getParameter("prodImgUrl"), cant, Float.parseFloat(request.getParameter("prodPrice")));

		session.setAttribute(request.getParameter("prodID"), productToAdd);
		response.getWriter().append(request.getParameter("prodID")+";"+cant);
//		response.sendRedirect("./index.jsp");
	}

}
