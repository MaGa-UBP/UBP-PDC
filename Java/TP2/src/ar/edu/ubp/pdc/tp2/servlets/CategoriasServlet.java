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
 * Servlet implementation class CategoriasServlet
 */
@WebServlet("/index.jsp")
public class CategoriasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	HttpSession session = request.getSession(true);   
        	
            out.println("<!DOCTYPE html>");
        	out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Home</title>");
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
            out.println("<script type=\"text/javascript\" src=\"js/latinize.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/productsHandler.js\"></script>");
            out.println("</head>");
            out.println("<body class=\"animsition\">");
            out.println("<header class=\"header1\">\n" + 
            		"		<!-- Header desktop -->\n" + 
            		"		<div class=\"container-menu-header\">\n" + 
            		"			<div class=\"topbar\">\n" + 
            		"				<div class=\"topbar-social\">\n" + 
            		"					<a href=\"#\" class=\"topbar-social-item fa fa-facebook\"></a>\n" + 
            		"					<a href=\"#\" class=\"topbar-social-item fa fa-instagram\"></a>\n" + 
            		"					<a href=\"#\" class=\"topbar-social-item fa fa-pinterest-p\"></a>\n" + 
            		"					<a href=\"#\" class=\"topbar-social-item fa fa-snapchat-ghost\"></a>\n" + 
            		"					<a href=\"#\" class=\"topbar-social-item fa fa-youtube-play\"></a>\n" + 
            		"				</div>\n" + 
            		"\n" + 
            		"				<span class=\"topbar-child1\">\n" + 
            		"					Envíos gratuitos en ordenes superiores a $3000\n" + 
            		"				</span>\n" + 
            		"\n" + 
            		"				<div class=\"topbar-child2\">\n" + 
            		"					<span class=\"topbar-email\">\n" + 
            		"						<a href=\"mailto:contacto@mg.com\">contacto@mg.com.ar</a>\n" + 
            		"					</span>\n" + 
            		"				</div>\n" + 
            		"			</div>\n" + 
            		"\n" + 
            		"			<div class=\"wrap_header\">\n" + 
            		"				<!-- Logo -->\n" + 
            		"				<a href=\"index.jsp\" class=\"logo\">\n" + 
            		"					<img src=\"images/logo/mg.png\" alt=\"IMG-LOGO\">\n" + 
            		"				</a>\n" + 
            		"\n" + 
            		"				<!-- Menu -->\n" + 
            		"				<div class=\"wrap_menu\">\n" + 
            		"					<nav class=\"menu\">\n" + 
            		"						<ul class=\"main_menu\"  id=\"subStore\">\n" + 
            		"							<li><a href=\"#\" class=\"catFilter active1\" data-filter=\"all\">Todo</a></li>\n"+
            		"						</ul>\n" + 
            		"					</nav>\n" + 
            		"				</div>\n" + 
            		"\n" + 
            		"				<!-- Header Icon -->\n" + 
            		"				<div class=\"header-icons\">\n" + 
            		"					<a href=\"#\" class=\"header-wrapicon1 dis-block a-buscar\">\n" + 
            		"						<i class=\"fa fa-2x fa-search\"></i>\n" + 
            		"					</a>\n" + 
            		"\n" + 
            		"					<span class=\"linedivide1\"></span>\n" + 
            		"\n" + 
            		"					<div class=\"header-wrapicon2\">\n" + 
            		"						<div class=\"header-icon1-wrapper\">\n" + 
            		"							<img src=\"images/icons/icon-header-02.png\" class=\"header-icon1 js-show-header-dropdown\" alt=\"ICON\">\n"); 
           
            String attrName;
            Enumeration<String> attrNames = session.getAttributeNames();   
            Integer cantTotItems = 0;
            Float total = (float) 0;
            
            List<ProductBean> productsArray = new ArrayList<ProductBean>();
            
            while (attrNames.hasMoreElements()) {
            	attrName = attrNames.nextElement();
            	ProductBean aux = (ProductBean) session.getAttribute(attrName);
            	productsArray.add(aux);
            	cantTotItems+=aux.getCantidad();
            	total += aux.getCantidad()*aux.getPrecio();
            }
            
            out.println("							<span class=\"header-icons-noti\" id=\"numberItemsCart\">"+cantTotItems+"</span>\n" + 
            		"						</div>\n" + 
            		"						<!-- Header cart noti -->\n" + 
            		"						<div class=\"header-cart header-dropdown\">\n" + 
            		"							<ul class=\"header-cart-wrapitem\" id=\"cartItems\">\n");
            
            if(cantTotItems == 0) {
            	 out.println("								<p class=\"emptyCart\">Tu carrito est&aacute; vac&iacute;o</p>");
            }else {
	        	out.println("<p class=\"emptyCart\" style=\"display: none;\">Tu carrito est&aacute; vac&iacute;o</p>");
	            for(ProductBean auxProd : productsArray) {
	                out.println("<form action=\"cart.js\" method=\"post\"><li class=\"header-cart-item\" id=\"ci"+auxProd.getID()+"\">");
	                out.println("<input type=\"hidden\" name=\"deleteFromCart\" value=\""+auxProd.getID()+"\">");
	                out.println("<a href=\"#\" class=\"btnRemove\"><div class=\"header-cart-item-img\">");
	                out.println("<img src=\""+auxProd.getUrlImagen()+"\" alt=\"IMG\">"); 
	                out.println("</div></a>");
	                out.println("<div class=\"header-cart-item-txt\">");
	                out.println("<a href=\"#\" class=\"header-cart-item-name\">" + auxProd.getNombre() + "</a>");
	                out.println("<div class=\"header-cart-item-info\">");
	                out.println("<span class=\"cantProdCart\">"+auxProd.getCantidad()+"</span> x ");
	                out.println("<span class=\"precioProdCart\">$"+NumberFormat.getInstance(new Locale("es", "AR")).format(auxProd.getPrecio())+"</span>");
	                out.println("</div>");
	                out.println("</div>");
	                out.println("</li></form>");
	              }
            }
            
            out.println("							</ul>\n" + 
            		"\n" + 
            		"							<div class=\"header-cart-total\">\n" + 
            		"							<input type=\"hidden\" value=\""+total+"\" name=\"inputTotalCart\"/>\n"+
            		"								Total: $<span class=\"totalCart\">"+NumberFormat.getInstance(new Locale("es", "AR")).format(total)+"</span>\n" + 
            		"							</div>\n" + 
            		"\n" + 
            		"							<div class=\"header-cart-buttons\">\n" + 
            		"								<div class=\"header-cart-wrapbtn\">\n" + 
            		"									<!-- Button -->\n" + 
            		"									<a href=\"#\" class=\"flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4 btnFinalizarCompra\">\n" + 
            		"										Finalizar Compra\n" + 
            		"									</a>\n" + 
            		"								</div>\n" + 
            		"							</div>\n" + 
            		"						</div>\n" + 
            		"					</div>\n" + 
            		"				</div>\n" + 
            		"			</div>\n" + 
            		"			<div class=\"container-fluid nav-buscar\">\n" + 
            		"				<form action=\"index.jsp\" id=\"searchForm\" method=\"GET\" class=\"row justify-content-center\">\n" + 
            		"					<div class=\"col col-10\">\n" + 
            		"						<div class=\"input-group\">\n" + 
            		"							<label for=\"cuadroBusqueda\" style=\"display: none;\">¿Qué estás buscando?</label> \n" + 
            		"							<input type=\"text\" name=\"searchQ\" id=\"cuadroBusqueda\" class=\"form-control\" placeholder=\"¿Qué estás buscando?\">\n" + 
            		"							<span class=\"input-group-btn\">\n" + 
            		"								<button class=\"btn btn-default\" id=\"btn-buscar-cerrar\" type=\"button\">\n" + 
            		"									<span class=\"cerrar fa-3x\" aria-hidden=\"true\">X</span>\n" + 
            		"								</button>\n" + 
            		"								<button class=\"btn btn-default hide\" type=\"submit\" id=\"btn-buscar\">\n" + 
            		"									<span class=\"fa fa-search fa-3x\" aria-hidden=\"true\"></span><span\n" + 
            		"										class=\"visuallyhidden\">Buscar</span>\n" + 
            		"								</button>\n" + 
            		"							</span>\n" + 
            		"						</div>\n" + 
            		"					</div>\n" + 
            		"				</form>\n" + 
            		"			</div>\n" + 
            		"		</div>\n" + 
            		"		<!-- Header Mobile -->\n" + 
            		"		<div class=\"wrap_header_mobile\">\n" + 
            		"			<!-- Logo moblie -->\n" + 
            		"			<a href=\"index.jsp\" class=\"logo-mobile\">\n" + 
            		"				<img src=\"images/logo/mg.png\" alt=\"IMG-LOGO\">\n" + 
            		"			</a>\n" + 
            		"\n" + 
            		"			<!-- Button show menu -->\n" + 
            		"			<div class=\"btn-show-menu\">\n" + 
            		"				<!-- Header Icon mobile -->\n" + 
            		"				<div class=\"header-icons-mobile\">\n" + 
            		"					<div class=\"header-wrapicon2\">\n" + 
            		"						<div class=\"header-icon1-wrapper\">\n" + 
            		"							<img src=\"images/icons/icon-header-02.png\" class=\"header-icon1 js-show-header-dropdown\" alt=\"ICON\">\n" + 
            		"							<span class=\"header-icons-noti\" id=\"numberItemsCartMobile\">"+cantTotItems+"</span>\n" + 
            		"						</div>\n" + 
            		"\n" + 
            		"						<!-- Header cart noti -->\n" + 
            		"						<div class=\"header-cart header-dropdown\">\n" + 
            		"							<ul class=\"header-cart-wrapitem\" id=\"cartItemsMobile\">\n");
            if(cantTotItems == 0) {
           	 out.println("								<p class=\"emptyCart\">Tu carrito est&aacute; vac&iacute;o</p>");
		   }else {
	        	out.println("<p class=\"emptyCart\" style=\"display: none;\">Tu carrito est&aacute; vac&iacute;o</p>");
		        for(ProductBean auxProd : productsArray) {
		            out.println("<form action=\"cart.js\" method=\"post\"><li class=\"header-cart-item\" id=\"ci"+auxProd.getID()+"-Mobile\">");
	                out.println("<input type=\"hidden\" name=\"deleteFromCart\" value=\""+auxProd.getID()+"\">");
		            out.println("<a href=\"#\" class=\"btnRemove\"><div class=\"header-cart-item-img\">");
					out.println("<img src=\""+auxProd.getUrlImagen()+"\" alt=\"IMG\">"); 
					out.println("</div></a>");
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
            out.println("							</ul>\n" + 
            		"\n" + 
            		"							<div class=\"header-cart-total\">\n" + 
            		"								Total: $<span class=\"totalCart\">0.00</span>\n" + 
            		"							</div>\n" + 
            		"\n" + 
            		"							<div class=\"header-cart-buttons\">\n" + 
            		"								<div class=\"header-cart-wrapbtn\">\n" + 
            		"									<!-- Button -->\n" + 
            		"									<a href=\"#\" class=\"flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4 btnFinalizarCompra\">\n" + 
            		"										Finalizar Compra\n" + 
            		"									</a>\n" + 
            		"								</div>\n" + 
            		"							</div>\n" + 
            		"						</div>\n" + 
            		"					</div>\n" + 
            		"				</div>\n" + 
            		"\n" + 
            		"				<div class=\"btn-show-menu-mobile hamburger hamburger--squeeze\">\n" + 
            		"					<span class=\"hamburger-box\">\n" + 
            		"						<span class=\"hamburger-inner\"></span>\n" + 
            		"					</span>\n" + 
            		"				</div>\n" + 
            		"			</div>\n" + 
            		"		</div>\n" + 
            		"\n" + 
            		"		<!-- Menu Mobile -->\n" + 
            		"		<div class=\"wrap-side-menu\" >\n" + 
            		"			<nav class=\"side-menu\">\n" + 
            		"				<ul class=\"main-menu\" id=\"subStoreMobile\">\n" + 
            		"					<li class=\"item-topbar-mobile p-l-20 p-t-8 p-b-8\">\n" + 
            		"						<span class=\"topbar-child1\">\n" + 
            		"							Envíos gratuitos en ordenes superiores a $3000\n" + 
            		"						</span>\n" + 
            		"					</li>\n" + 
            		"\n" + 
            		"					<li class=\"item-topbar-mobile p-l-20 p-t-8 p-b-8\">\n" + 
            		"						<div class=\"topbar-child2-mobile\">\n" + 
            		"							<span class=\"topbar-email\">\n" + 
            		"								<a href=\"mailto:contacto@mg.com\">contacto@mg.com.ar</a>\n" + 
            		"							</span>\n" + 
            		"						</div>\n" + 
            		"					</li>\n" + 
            		"\n" + 
            		"					<li class=\"item-topbar-mobile p-l-10\">\n" + 
            		"						<div class=\"topbar-social-mobile\">\n" + 
            		"							<a href=\"#\" class=\"topbar-social-item fa fa-facebook\"></a>\n" + 
            		"							<a href=\"#\" class=\"topbar-social-item fa fa-instagram\"></a>\n" + 
            		"							<a href=\"#\" class=\"topbar-social-item fa fa-pinterest-p\"></a>\n" + 
            		"							<a href=\"#\" class=\"topbar-social-item fa fa-snapchat-ghost\"></a>\n" + 
            		"							<a href=\"#\" class=\"topbar-social-item fa fa-youtube-play\"></a>\n" + 
            		"						</div>\n" + 
            		"					</li>\n" + 
            		"\n" + 
            		"					<li class=\"item-menu-mobile\"><a href=\"#\" class=\"catFilter active1\" data-filter=\"all\">Todo</a></li>\n"+
            		"				</ul>\n" + 
            		"			</nav>\n" + 
            		"		</div>\n" + 
            		"	</header>");
            out.println("<div class=\"loaderContainer\" style=\"display: none;\">");
            out.println("<div class=\"loader\"></div>");
            out.println("</div>");
            out.println("<div id=\"website\">");
            out.println("<section class=\"slide1\">\n" + 
            		"		<div class=\"wrap-slick1\">\n" + 
            		"			<div class=\"slick1\">\n" + 
            		"				<div class=\"item-slick1 item1-slick1\" style='background-image: url(\"images/slider/1.jpg\");'>\n" + 
            		"					<div class=\"wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170\">\n" + 
            		"						<span class=\"caption1-slide1 m-text1 t-center animated visible-false m-b-15\" data-appear=\"fadeInDown\">\n" + 
            		"							Colecci&oacute;n 2018\n" + 
            		"						</span>\n" + 
            		"\n" + 
            		"						<h2 class=\"caption2-slide1 xl-text1 t-center animated visible-false m-b-37\" data-appear=\"fadeInUp\">\n" + 
            		"							Mir&aacute; las Novedades\n" + 
            		"						</h2>\n" + 
            		"\n" + 
            		"						\n" + 
            		"					</div>\n" + 
            		"				</div>\n" + 
            		"\n" + 
            		"				<div class=\"item-slick1 item2-slick1\" style='background-image: url(\"images/slider/3.jpg\");'>\n" + 
            		"					<div class=\"wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170\">\n" + 
            		"						<span class=\"caption1-slide1 m-text1 t-center animated visible-false m-b-15\" data-appear=\"rollIn\">\n" + 
            		"							¡Nuevo Store online!\n" + 
            		"						</span>\n" + 
            		"\n" + 
            		"						<h2 class=\"caption2-slide1 xl-text1 t-center animated visible-false m-b-37\" data-appear=\"lightSpeedIn\">\n" + 
            		"							Compr&aacute; sin culpa!\n" + 
            		"						</h2>\n" + 
            		"					</div>\n" + 
            		"				</div>\n" + 
            		"\n" + 
            		"			</div>\n" + 
            		"		</div>\n" + 
            		"	</section>");

            out.println("<section class=\"bgwhite p-t-55 p-b-65\">\n" + 
            		"		<div class=\"container\">\n" + 
            		"			<div class=\"row\">\n" + 
            		"				<div class=\"col-sm-6 col-md-4 col-lg-3 p-b-50\">\n" + 
            		"					<div class=\"leftbar p-r-20 p-r-0-sm\">\n" + 
            		"						<h3 class=\"m-text16 p-b-9\">Filtros</h3>\n" + 
            		"						<h4 class=\"m-text14 p-b-7\">\n" + 
            		"							Categor&iacute;as\n" + 
            		"						</h4>\n" + 
            		"\n" + 
            		"						<ul class=\"p-b-54\" id=\"subStoreLateral\">\n" + 
            		"						</ul>\n" + 
            		"					</div>\n" + 
            		"				</div>\n" + 
            		"\n" + 
            		"				<div class=\"col-sm-6 col-md-8 col-lg-9 p-b-50\">\n" + 
            		"					<!--  -->\n" + 
            		"					<div class=\"flex-sb-m flex-w p-b-35\">\n" + 
            		"						<div class=\"flex-w\" id=\"searchResultsText\">\n" + 
            		"\n" + 
            		"						</div>\n" + 
            		"\n" + 
            		"						<span class=\"s-text8 p-t-5 p-b-5\">\n" + 
            		"							Mostrando <span id=\"cantResultados\"></span> resultados\n" + 
            		"						</span>\n" + 
            		"					</div>\n" + 
            		"\n" + 
            		"					<!-- Product -->\n" + 
            		"					<div class=\"row\" id=\"productList\">\n" + 
            		"					</div>\n" + 
            		"\n" + 
            		"\n" + 
            		"				</div>\n" + 
            		"			</div>\n" + 
            		"		</div>\n" + 
            		"	</section>");
            out.println("</div>");
            out.println("<div id=\"cartResults\">");

            out.println("</div>");
            out.println("<footer class=\"bg6 p-t-45 p-b-43 p-l-45 p-r-45\">");
            out.println("<div class=\"flex-w p-b-90\">");
            out.println("<div class=\"w-size6 p-t-30 p-l-15 p-r-15 respon3\">");
            out.println("<h4 class=\"s-text12 p-b-30\">CONTACTANOS</h4>");
            out.println("<div>");
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
            out.println("<div class=\"t-center s-text8 p-t-20\">Copyright © 2018 All rights reserved</div>");
            out.println("</div>");
            out.println("</footer>");
            out.println("<script type=\"text/javascript\" src=\"vendor/animsition/js/animsition.min.js\"></script>\n" + 
            		"\n" + 
            		"	<script type=\"text/javascript\" src=\"vendor/bootstrap/js/popper.js\"></script>\n" + 
            		"	<script type=\"text/javascript\" src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\n" + 
            		"\n" + 
            		"	<script type=\"text/javascript\" src=\"vendor/slick/slick.min.js\"></script>\n" + 
            		"	<script type=\"text/javascript\" src=\"js/slick-custom.js\"></script>\n" + 
            		"\n" + 
            		"	<script type=\"text/javascript\" src=\"vendor/sweetalert/sweetalert.min.js\"></script>\n" + 
            		"\n" + 
            		"\n" + 
            		"	<script src=\"js/main.js\" type=\"text/javascript\"></script>\n" + 
            		"	<script src=\"js/searchNav.js\" type=\"text/javascript\"></script>");
            String catID = "";
            if(request.getParameter("catID")!=null && request.getParameter("catID")!="") {
            	if(request.getParameter("catID")=="all") {
            		catID = "all";
            	}else {
            		catID = request.getParameter("catID");
            	}
            	
            }
            out.println("<script type=\"text/javascript\">");
	        out.println("var prodsInCart = [];");
            if(cantTotItems != 0) {
   	        	out.println("prodsInCart= [");
   		        for(ProductBean auxProd : productsArray) {
   	                out.println(auxProd.getID()+",");
   		          }
   		     out.println("];");
   		   	}
            out.println("</script>");
            String searchQ = (request.getParameter("searchQ")==null || request.getParameter("searchQ")==""? "\"\"" : "\""+request.getParameter("searchQ")+"\"");
            out.println("<script type=\"text/javascript\">loadData(\""+catID+"\", "+searchQ+");</script>");
            out.println("<script src=\"js/miniCartHandler.js\" type=\"text/javascript\"></script>");
            out.println("</body>");
            out.println("</html>");
		}
        finally {
            out.close();
        }
	}

}
