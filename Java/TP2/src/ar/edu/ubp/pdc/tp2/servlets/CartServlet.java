package ar.edu.ubp.pdc.tp2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.ubp.pdc.tp2.beans.PersonDataBean;
import ar.edu.ubp.pdc.tp2.beans.ProductBean;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/cart.jsp")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        try {
        	HttpSession session = request.getSession(true);

            
        	String attrName;
            Enumeration<String> attrNames = session.getAttributeNames();
            Integer cantTotItems = 0;
            Float totalItem = (float) 0;
            Float total = (float) 0;;
            List<ProductBean> productsArray = new ArrayList<ProductBean>();
            while (attrNames.hasMoreElements()) {
            	attrName = attrNames.nextElement();
            	ProductBean aux = (ProductBean) session.getAttribute(attrName);
            	productsArray.add(aux);
            	cantTotItems+=aux.getCantidad();
            	totalItem += aux.getCantidad()*aux.getPrecio();
            }

            out.println("<section class=\"cart bgwhite p-t-70 p-b-100\">");
            out.println("<div class=\"container\">");
            out.println("<div class=\"container-table-cart pos-relative\">");
            out.println("<div class=\"wrap-table-shopping-cart bgwhite\">");
            Float totalItemCart = (float) 0;
            Float totalCart = (float) 0;;
            
            if(cantTotItems == 0) {
            	out.println("<p class=\"emptyCart\">Tu carrito est&aacute; vac&iacute;o</p>");
            	out.println("</div>");
            	out.println("</div>");
            	out.println("<div class=\"bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm\">");
                out.println("<div class=\"flex-w flex-sb-m p-t-26 p-b-30\">");
            	out.println("<div class=\"size15 trans-0-4\">");
                out.println("<a href=\"index.jsp\" class=\"flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4 btnVolver\"> Volver al cat&aacute;logo </a>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
            }else {
            	out.println("<p class=\"emptyCart\" style=\"display: none;\">Tu carrito est&aacute; vac&iacute;o</p>");
          		out.println("<form action=\"cart.js\" method=\"post\" id=\"formItems\">");
            	out.println("<table class=\"table-shopping-cart\" id=\"tableItems\">");
                out.println("<tr class=\"table-head\">");
                out.println("<th class=\"column-1\"></th>");
                out.println("<th class=\"column-2\">Producto</th>");
                out.println("<th class=\"column-3\">Precio</th>");
                out.println("<th class=\"column-4 p-l-70\">Cantidad</th>");
                out.println("<th class=\"column-5\">Total</th>");
                out.println("</tr>");
            	for(ProductBean auxProd : productsArray) {
     
                    out.println("<tr class=\"table-row\">");
                    out.println("<td class=\"column-1\">");
                    out.println("<input type=\"hidden\" name=\"prodID\" value=\""+auxProd.getID()+"\">");
                    out.println("<input type=\"hidden\" name=\"update\" value=\"true\">");
                    out.println("<a href=\"#\" class=\"btnRemove\">");
                    out.println("<div class=\"cart-img-product b-rad-4 o-f-hidden\">");
                    out.println("<img src=\""+auxProd.getUrlImagen()+"\" alt=\"Imagen de "+auxProd.getNombre()+"\">");
                    out.println("</div>");
                    out.println("</a>");
                    out.println("</td>");
                    out.println("<td class=\"column-2\">" + auxProd.getNombre() + "</td>");
                    out.println("<td class=\"column-3\"><span>$" +NumberFormat.getInstance(new Locale("es", "AR")).format(auxProd.getPrecio())+ "</span></td>");
                    out.println("<td class=\"column-4\">");
                    out.println("<div class=\"flex-w bo5 of-hidden w-size17\">");
                    out.println("<a href=\"#\" class=\"btn-num-product-down color1 flex-c-m size7 bg8 eff2\">");
                    out.println("<i class=\"fs-12 fa fa-minus\" aria-hidden=\"true\"></i>");
                    out.println("</a>");
                    out.println("<input class=\"size8 m-text18 t-center num-product\" type=\"number\" name=\"ci"+auxProd.getID()+"\" value=\""+auxProd.getCantidad()+"\">");
                    out.println("<a href=\"#\" class=\"btn-num-product-up color1 flex-c-m size7 bg8 eff2\">");
                    out.println("<i class=\"fs-12 fa fa-plus\" aria-hidden=\"true\"></i>");
                    out.println("</a>");
                    out.println("</div>");
                    out.println("</td>");
                    totalItemCart = auxProd.getCantidad() * auxProd.getPrecio();
                    totalCart += totalItemCart;
                    out.println("<td class=\"column-5\">$<span class=\"itemTotal\">"+NumberFormat.getInstance(new Locale("es", "AR")).format(totalItemCart) +"</span></td>");
                    out.println("<input type=\"hidden\" value=\""+totalItemCart+"\" name=\"iItemTotal\"/>");
                    out.println("</tr>");
                   
            	}
                out.println("</table>");
                out.println("</form>");
                out.println("</div>");
                out.println("</div>");
               
                out.println("<div class=\"row\">");
                out.println("<div class=\"col-md-6 p-b-30 m-t-30 bo9 formFinalizar\" style=\"display:none; \">");
                out.println("<form id=\"finalizarCompraForm\">");
                out.println("<h4 class=\"m-text26 p-b-36 p-t-15\">Finalizar compra</h4>");
                out.println("<div class=\"bo4 of-hidden size15 m-b-20\">");
                
                
                Cookie[] cookies = request.getCookies();
        		PersonDataBean person = new PersonDataBean();
        		Boolean exists = false;
        		
        		if (cookies != null) {
        		 for (Cookie cookie : cookies) {
        		   if (cookie.getName().equals("rememberData")) {
        			   String[] parts = URLDecoder.decode(cookie.getValue(), "UTF-8").split(";");
        			   person.setName(parts[0]);
        			   person.setSurname(parts[1]);
        			   person.setEmail(parts[2]);
        			   person.setAddress(parts[3]);
        			   exists = true;
        		    }
        		  }
        		}
        		if(!exists){
        			person.setName("");
     			   	person.setSurname("");
     			   	person.setEmail("");
     			   	person.setAddress("");
        		}
                out.println("<input class=\"sizefull s-text7 p-l-22 p-r-22\" type=\"text\" name=\"nameCookie\" placeholder=\"Nombre\" value=\""+person.getName()+"\">");
                out.println("</div>");
                out.println("<div class=\"bo4 of-hidden size15 m-b-20\">");
                out.println("<input class=\"sizefull s-text7 p-l-22 p-r-22\" type=\"text\" name=\"surnameCookie\" placeholder=\"Apellido\" value=\""+person.getSurname()+"\">");
                out.println("</div>");
                out.println("<div class=\"bo4 of-hidden size15 m-b-20\">");
                out.println("<input class=\"sizefull s-text7 p-l-22 p-r-22\" type=\"text\" name=\"emailCookie\" placeholder=\"Email\" value=\""+person.getEmail()+"\">");
                out.println("</div>");
                out.println("<div class=\"bo4 of-hidden size15 m-b-20\">");
                out.println("<input class=\"sizefull s-text7 p-l-22 p-r-22\" type=\"text\" name=\"addressCookie\" placeholder=\"Direccion Postal\" value=\""+person.getAddress()+"\">");
                out.println("</div>");
                out.println("<div class=\"size15 m-b-20\">");
                out.println("<label class=\"s-text3\"><input type=\"checkbox\" name=\"rememberCookie\" value=\"remember\" "+(!person.getName().equals("")? "checked" : "")+"> Mantener datos</label>");
                out.println("</div>");
                out.println("<div class=\"w-size25\">");
                out.println("<!-- Button -->");
                out.println("<button class=\"flex-c-m size2 bg1 bo-rad-23 hov1 m-text3 trans-0-4 btnComprar\">Comprar</button>");
                out.println("</div>");
                out.println("</form>");
                out.println("</div>");
                
                out.println("<div class=\"col-md-6 bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm fixedHeight\">");
                out.println("<div class=\"flex-w flex-sb-m p-t-26 p-b-30\">");
                out.println("<span class=\"m-text22 w-size19 w-full-sm\"> Total carrito </span>");
                out.println("<input type=\"hidden\" value=\""+totalCart+"\" name=\"inputTotalCart\"/>");
                out.println("<div class=\"m-text21 w-size20 w-full-sm\">$<span class=\"totalCart\">"+NumberFormat.getInstance(new Locale("es", "AR")).format(totalCart) + " </span></div>");
                out.println("</div>");
                out.println("<div class=\"size15 trans-0-4\">");
                out.println("<button class=\"flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4 btnFinalizar\"> Finalizar compra </button>");
                out.println("<a href=\"index.jsp\" class=\"flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4 btnVolver\" style=\"display:none;\"> Volver al cat&aacute;logo </a>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
            }
            out.println("</div>");
            out.println("</section>");
            out.println("<script src=\"js/cartHandler.js\" type=\"text/javascript\"></script>");
            out.println("</body>");
            out.println("</html>");

        }
        finally {
        	out.close();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ACA VA TODO LO DE SESION

		HttpSession session = request.getSession(true);

		if(request.getParameter("deleteFromCart") != null && request.getParameter("deleteFromCart") != "") {
			ProductBean productToDelete = new ProductBean();
			productToDelete = (ProductBean) session.getAttribute(request.getParameter("deleteFromCart"));
			
			Integer deletedQ = productToDelete.getCantidad();
			session.removeAttribute(request.getParameter("deleteFromCart"));
			response.getWriter().append(request.getParameter("deleteFromCart")+";"+deletedQ);
		}
		else if(request.getParameter("update") != null && request.getParameter("update") != "") {
			Integer cant =  Integer.parseInt(request.getParameter("prodQuantToUpdate")); 
			ProductBean productToAdd = new ProductBean();
			productToAdd = (ProductBean) session.getAttribute(request.getParameter("prodID"));
			cant += productToAdd.getCantidad();
			productToAdd.setCantidad(cant);
			response.getWriter().append(request.getParameter("prodID")+";"+request.getParameter("prodQuantToUpdate"));
		}else{
			Integer cant = Integer.parseInt(request.getParameter("prodQuantity"));
			
			ProductBean productToAdd = new ProductBean();
			
			if(session.getAttribute(request.getParameter("prodID")) != null) {
				productToAdd = (ProductBean) session.getAttribute(request.getParameter("prodID"));
				cant += productToAdd.getCantidad();
			}else {
				productToAdd.setID(request.getParameter("prodID"));
				productToAdd.setNombre(request.getParameter("prodName"));
				productToAdd.setUrlImagen(request.getParameter("prodImgUrl"));
				productToAdd.setPrecio(Float.parseFloat(request.getParameter("prodPrice")));
			}
			productToAdd.setCantidad(cant);

			session.setAttribute(request.getParameter("prodID"), productToAdd);
			response.getWriter().append(request.getParameter("prodID")+";"+cant);
		}
	}

}
