package ar.edu.ubp.pdc.tp2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.ubp.pdc.tp2.beans.ProductBean;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/cart.jsp")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession(true);
//
//		String attrName;
//		PrintWriter out = response.getWriter();
//		out.println("Session: \n");

//		Enumeration<String> attrs = session.getAttributeNames();
//		while(attrs.hasMoreElements()) {
//			attrName = attrs.nextElement();
//			out.println("Key:"+ attrName +", ");
//			Product aux = (Product) session.getAttribute(attrName);
//			out.println("Name: "+ aux.getNombre());
//			out.println("Cant: "+ aux.getCantidad() +"\n");
//		}

//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        try {
        	HttpSession session = request.getSession(true);

            out.println("<!DOCTYPE html>");
        	out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Carrito de compras</title>");
            out.println("<link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.png\"/>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/themify/themify-icons.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/Linearicons-Free-v1.0.0/icon-font.min.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/elegant-font/html-css/style.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animsition/css/animsition.min.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/daterangepicker/daterangepicker.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/slick/slick.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/lightbox2/css/lightbox.min.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/macgar.css\">");
            out.println("<script type=\"text/javascript\" src=\"vendor/jquery/jquery-3.2.1.min.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/priceFormat.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/productsHandler.js\"></script>");
            out.println("</head>");

            out.println("<header class=\"header1\">");
            out.println("<!-- Header desktop -->");
            out.println("<div class=\"container-menu-header\">");
            out.println("<div class=\"topbar\">");
            out.println("<div class=\"topbar-social\">");
            out.println("<a href=\"#\" class=\"topbar-social-item fa fa-facebook\"></a>");
            out.println("<a href=\"#\" class=\"topbar-social-item fa fa-instagram\"></a>");
            out.println("<a href=\"#\" class=\"topbar-social-item fa fa-pinterest-p\"></a>");
            out.println("<a href=\"#\" class=\"topbar-social-item fa fa-snapchat-ghost\"></a>");
            out.println("<a href=\"#\" class=\"topbar-social-item fa fa-youtube-play\"></a>");
            out.println("</div>");
            out.println("<span class=\"topbar-child1\"> Env&iacute;os gratuitos en ordenes superiores a $3000 </span>");
            out.println("<div class=\"topbar-child2\">");
            out.println("<span class=\"topbar-email\"> <a href=\"mailto:contacto@mg.com\">contacto@mg.com.ar</a> </span>");
            out.println("</div>");
            out.println("</div>");

            out.println("<div class=\"wrap_header\">");
            out.println("<!-- Logo -->");
            out.println("<a href=\"index.html\" class=\"logo\"> <img src=\"images/logo/mg.png\" alt=\"IMG-LOGO\"> </a>");
            out.println("<!-- Header Icon -->");
            out.println("<div class=\"header-icons\">");
            out.println("<div class=\"header-wrapicon2\">");
            out.println("<div class=\"header-icon1-wrapper\">");
            out.println("<img src=\"images/icons/icon-header-02.png\" class=\"header-icon1 js-show-header-dropdown\" alt=\"ICON\">");
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
            out.println("<span class=\"header-icons-noti\" id=\"numberItemsCart\">\"+cantTotItems+\"</span>");
            out.println("</div>");

            out.println("<div class=\"header-cart header-dropdown\">");
            out.println("<ul class=\"header-cart-wrapitem\" id=\"cartItems\">");
            if(cantTotItems == 0) {
           	 out.println("<p class=\"emptyCart\">Tu carrito est&aacute; vac&iacute;o</p>");
            }else {
	            for(ProductBean auxProd : productsArray) {
	                out.println("<li class=\"header-cart-item\" id=\"ci"+auxProd.getID()+"\">");
	                out.println("<div class=\"header-cart-item-img\">");
	                out.println("<img src=\""+auxProd.getUrlImagen()+"\" alt=\"IMG\">");
	                out.println("</div>");
	                out.println("<div class=\"header-cart-item-txt\">");
	                out.println("<a href=\"#\" class=\"header-cart-item-name\">" + auxProd.getNombre() + "</a>");
	                out.println("<div class=\"header-cart-item-info\">");
	                out.println("<span class=\"cantProdCart\">"+auxProd.getCantidad()+"</span> x ");
	                out.println("<span class=\"precioProdCart\">$"+NumberFormat.getInstance(new Locale("es", "AR")).format(auxProd.getPrecio())+"</span>");
	                out.println("</div>");
	                out.println("</div>");
	                out.println("</li>");
	              }
            }
            out.println("</ul>");
            out.println("<div class=\"header-cart-total\">");
            out.println("<input type=\"hidden\" value=\""+totalItem+"\" name=\"inputTotalCart\"/> Total: $<span class=\"totalCart\">"+NumberFormat.getInstance(new Locale("es", "AR")).format(totalItem)+"</span>");
            out.println("</div>");
            out.println("<div class=\"header-cart-buttons\">");
            out.println("<div class=\"header-cart-wrapbtn\">");
            out.println("<!-- Button -->");
            out.println("<a href=\"#\" class=\"flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4\"> Finalizar Compra </a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");


            out.println("<!-- Header Mobile -->");
            out.println("<div class=\"wrap_header_mobile\">");
            out.println("<!-- Logo moblie -->");
            out.println("<a href=\"index.html\" class=\"logo-mobile\"> <img src=\"images/logo/mg.png\" alt=\"IMG-LOGO\"> </a>");
            out.println("<!-- Button show menu -->");
            out.println("<div class=\"btn-show-menu\">");
            out.println("<!-- Header Icon mobile -->");
            out.println("<div class=\"header-icons-mobile\">");
            out.println("<div class=\"header-wrapicon2\">");
            out.println("<div class=\"header-icon1-wrapper\">");
            out.println("<img src=\"images/icons/icon-header-02.png\" class=\"header-icon1 js-show-header-dropdown\" alt=\"ICON\">");
            out.println("<span class=\"header-icons-noti\" id=\"numberItemsCartMobile\">0</span>");
            out.println("</div>");

            out.println("<!-- Header cart noti -->");
            out.println("<div class=\"header-cart header-dropdown\">");
            out.println("<ul class=\"header-cart-wrapitem\" id=\"cartItemsMobile\">");
            out.println("<p class=\"emptyCart\">Tu carrito est&aacute; vac&iacute;o</p>");
            out.println("</ul>");
            out.println("<div class=\"header-cart-total\">");
            out.println("Total: $<span class=\"totalCart\">0.00</span>");
            out.println("</div>");
            out.println("<div class=\"header-cart-buttons\">");
            out.println("<div class=\"header-cart-wrapbtn\">");
            out.println("<!-- Button -->");
            out.println("<a href=\"#\" class=\"flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4\">Finalizar Compra </a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

            out.println("<div class=\"btn-show-menu-mobile hamburger hamburger--squeeze\">");
            out.println("<span class=\"hamburger-box\">");
            out.println("<span class=\"hamburger-inner\"></span>");
            out.println("</span>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

            out.println("<!-- Menu Mobile -->");
            out.println("<div class=\"wrap-side-menu\" >");
            out.println("<nav class=\"side-menu\">");
            out.println("<ul class=\"main-menu\" id=\"subStoreMobile\">");
            //out.println("<li class=\"item-menu-mobile\"><a href=\"#\" class=\"catFilter active1\" data-filter=\"all\">Todo</a></li>");
            out.println("</ul>");
            out.println("</nav>");
            out.println("</div>");

            out.println("</header>");

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
            }else {
            	out.println("<table class=\"table-shopping-cart\">");
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
                    out.println("<div class=\"cart-img-product b-rad-4 o-f-hidden\">");
                    out.println("<img src=\""+auxProd.getUrlImagen()+"\" alt=\"IMG\">");
                    out.println("</div>");
                    out.println("</td>");
                    out.println("<td class=\"column-2\">" + auxProd.getNombre() + "</td>");
                    out.println("<td class=\"column-3\"><span>$" +NumberFormat.getInstance(new Locale("es", "AR")).format(auxProd.getPrecio())+ "</span></td>");
                    out.println("<td class=\"column-4\">");
                    out.println("<div class=\"flex-w bo5 of-hidden w-size17\">");
                    out.println("<button class=\"btn-num-product-down color1 flex-c-m size7 bg8 eff2\">");
                    out.println("<i class=\"fs-12 fa fa-minus\" aria-hidden=\"true\"></i>");
                    out.println("</button>");
                    out.println("<input class=\"size8 m-text18 t-center num-product\" type=\"number\" name=\"ci"+auxProd.getID()+"\" value=\""+auxProd.getCantidad()+"\">");
                    out.println("<button class=\"btn-num-product-up color1 flex-c-m size7 bg8 eff2\">");
                    out.println("<i class=\"fs-12 fa fa-plus\" aria-hidden=\"true\"></i>");
                    out.println("</button>");
                    out.println("</div>");
                    out.println("</td>");
                    totalItemCart = auxProd.getCantidad() * auxProd.getPrecio();
                    totalCart += totalItemCart;
                    out.println("<td class=\"column-5\">$"+NumberFormat.getInstance(new Locale("es", "AR")).format(totalItemCart) +"</td>");
                    out.println("</tr>");
            	}
                out.println("</table>");
                out.println("</div>");
                out.println("</div>");
                out.println("<div class=\"flex-w flex-sb-m p-t-25 p-b-25 bo8 p-l-35 p-r-60 p-lr-15-sm\">");
                //  out.println("<div class=\"flex-w flex-m w-full-sm\">");
                //  out.println("</div>");
                out.println("<div class=\"size11 trans-0-4 m-t-10 m-b-10\">");
                out.println("<!-- Button -->");
                out.println("<button class=\"flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4\"> Actualizar carrito </button>");
                out.println("</div>");
                out.println("</div>");
                
                
                out.println("<div class=\"bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm\">");
                out.println("<div class=\"flex-w flex-sb-m p-t-26 p-b-30\">");
                out.println("<span class=\"m-text22 w-size19 w-full-sm\"> Total carrito </span>");
                out.println("<span class=\"m-text21 w-size20 w-full-sm\">$"+NumberFormat.getInstance(new Locale("es", "AR")).format(totalCart) + " </span>");
                out.println("</div>");
                out.println("<div class=\"size15 trans-0-4\">");
                out.println("<button class=\"flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4\"> Finalizar compra </button>");
                out.println("</div>");
                out.println("</div>");
            }
            out.println("</div>");
            out.println("</section>");

            out.println("<!-- Footer -->");
            out.println("<footer class=\"bg6 p-t-45 p-b-43 p-l-45 p-r-45\">");
            out.println("<div class=\"flex-w p-b-90\">");
            out.println("<div class=\"w-size6 p-t-30 p-l-15 p-r-15 respon3\">");
            out.println("<h4 class=\"s-text12 p-b-30\"> CONTACTANOS </h4>");
            out.println("</div>");
            out.println("<p class=\"s-text7 w-size27\">");
            out.println("Dudas? Encontranos en nuestro store en Patio Olmos, Av. Velez Sarsfield 361, Cordoba, AR o llamanos al (+54) 0351 457 16879");
            out.println("</p>");
            out.println("<div class=\"flex-m p-t-30\">");
            out.println("<a href=\"#\" class=\"fs-18 color1 p-r-20 fa fa-facebook\"></a>");
            out.println("<a href=\"#\" class=\"fs-18 color1 p-r-20 fa fa-instagram\"></a>");
            out.println("<a href=\"#\" class=\"fs-18 color1 p-r-20 fa fa-pinterest-p\"></a>");
            out.println("<a href=\"#\" class=\"fs-18 color1 p-r-20 fa fa-snapchat-ghost\"></a>");
            out.println("<a href=\"#\" class=\"fs-18 color1 p-r-20 fa fa-youtube-play\"></a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"t-center p-l-15 p-r-15\">");
            out.println("<div class=\"t-center s-text8 p-t-20\">Copyright � 2018 All rights reserved</div>");
            out.println("</div>");
            out.println("</footer>");

            out.println("<script type=\"text/javascript\">");
            out.println("categories.sort(function (a, b) {\n" +
            		" 		    return a.nombre.localeCompare(b.nombre);\n" +
            		"    });\n" +
            		"    $.each(categories, function(idx, category) {\n" +
            		"        $(\"#subStoreMobile\").append(\"<li class=\\\"item-menu-mobile\\\"><a href=\\\"#\\\" data-filter=\\\"\"+category.ID+\"\\\" class=\\\"catFilter\\\">\"+category.nombre+\"</a></li>\");\n" +
            		"        $(\"#subStore\").append(\"<li><a href=\\\"#\\\" data-filter=\\\"\"+category.ID+\"\\\" class=\\\"catFilter\\\">\"+category.nombre+\"</a></li>\");\n" +
            		"        $(\"#subStoreLateral\").append(\"<li class=\\\"p-t-4\\\"><a href=\\\"#\\\" class=\\\"s-text13 catFilter\\\" data-filter=\\\"\"+category.ID+\"\\\">\"+category.nombre+\"</a></li>\");\n" +
            		"    });");
            out.println("</script>");
            out.println("<script type=\"text/javascript\" src=\"vendor/animsition/js/animsition.min.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"vendor/bootstrap/js/popper.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"vendor/slick/slick.min.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/slick-custom.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"vendor/sweetalert/sweetalert.min.js\"></script>");
            out.println("<script src=\"js/main.js\"></script>");
            out.println("<script src=\"js/searchNav.js\" type=\"text/javascript\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/productsList.js\"></script>");
            String catID = ((request.getParameter("catID")==null || request.getParameter("catID")=="" || request.getParameter("catID").equals("all"))? "\"all\"" : request.getParameter("catID"));
            String searchQ = (request.getParameter("searchQ")==null || request.getParameter("searchQ")==""? "\"\"" : "\""+request.getParameter("searchQ")+"\"");
            out.println("<script type=\"text/javascript\">filter("+catID+", "+searchQ+", products);</script>");
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

		Integer cant = 1; //Aca hay que tomar el parametro cantidad cuanndo este hecho
		
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
