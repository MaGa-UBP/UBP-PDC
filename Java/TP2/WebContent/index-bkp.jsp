<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="icon" type="image/png" href="images/icons/favicon.png"/>

	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="fonts/themify/themify-icons.css">

	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

	<link rel="stylesheet" type="text/css" href="fonts/elegant-font/html-css/style.css">

	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">

	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">

	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">

	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">

	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">

	<link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">

	<link rel="stylesheet" type="text/css" href="vendor/lightbox2/css/lightbox.min.css">

	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/macgar.css">
	<script type="text/javascript" src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/priceFormat.js"></script>
	<script type="text/javascript" src="js/productsHandler.js"></script>

	
</head>
<body class="animsition">

	<!-- Header -->
	<header class="header1">
		<!-- Header desktop -->
		<div class="container-menu-header">
			<div class="topbar">
				<div class="topbar-social">
					<a href="#" class="topbar-social-item fa fa-facebook"></a>
					<a href="#" class="topbar-social-item fa fa-instagram"></a>
					<a href="#" class="topbar-social-item fa fa-pinterest-p"></a>
					<a href="#" class="topbar-social-item fa fa-snapchat-ghost"></a>
					<a href="#" class="topbar-social-item fa fa-youtube-play"></a>
				</div>

				<span class="topbar-child1">
					Envíos gratuitos en ordenes superiores a $3000
				</span>

				<div class="topbar-child2">
					<span class="topbar-email">
						<a href="mailto:contacto@mg.com">contacto@mg.com.ar</a>
					</span>
				</div>
			</div>

			<div class="wrap_header">
				<!-- Logo -->
				<a href="index.html" class="logo">
					<img src="images/logo/mg.png" alt="IMG-LOGO">
				</a>

				<!-- Menu -->
				<div class="wrap_menu">
					<nav class="menu">
						<ul class="main_menu"  id="subStore">
						</ul>
					</nav>
				</div>

				<!-- Header Icon -->
				<div class="header-icons">
					<a href="#" class="header-wrapicon1 dis-block a-buscar">
						<i class="fa fa-2x fa-search"></i>
					</a>

					<span class="linedivide1"></span>

					<div class="header-wrapicon2">
						<div class="header-icon1-wrapper">
							<img src="images/icons/icon-header-02.png" class="header-icon1 js-show-header-dropdown" alt="ICON">
							<span class="header-icons-noti" id="numberItemsCart">0</span>
						</div>
						<!-- Header cart noti -->
						<div class="header-cart header-dropdown">
							<ul class="header-cart-wrapitem">
								<p>Tu carrito est&aacute; vac&iacute;o</p>
							</ul>

							<div class="header-cart-total">
								Total: $0.00
							</div>

							<div class="header-cart-buttons">
								<div class="header-cart-wrapbtn">
									<!-- Button -->
									<a href="#" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										Finalizar Compra
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid nav-buscar">
				<form action="/search" method="GET" class="row justify-content-center">
					<div class="col col-10">
						<div class="input-group">
							<label for="cuadroBusqueda" style="display: none;">¿Qué estás buscando?</label> 
							<input type="text" name="q" id="cuadroBusqueda" class="form-control" placeholder="¿Qué estás buscando?">
							<span class="input-group-btn">
								<button class="btn btn-default" id="btn-buscar-cerrar" type="button">
									<span class="cerrar fa-3x" aria-hidden="true">X</span>
								</button>
								<button class="btn btn-default hide" type="submit" id="btn-buscar">
									<span class="fa fa-search fa-3x" aria-hidden="true"></span><span
										class="visuallyhidden">Buscar</span>
								</button>
							</span>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- Header Mobile -->
		<div class="wrap_header_mobile">
			<!-- Logo moblie -->
			<a href="index.html" class="logo-mobile">
				<img src="images/logo/mg.png" alt="IMG-LOGO">
			</a>

			<!-- Button show menu -->
			<div class="btn-show-menu">
				<!-- Header Icon mobile -->
				<div class="header-icons-mobile">
					<a href="#" class="header-wrapicon1 dis-block">
						<img src="images/icons/icon-header-01.png" class="header-icon1" alt="ICON">
					</a>

					<span class="linedivide2"></span>

					<div class="header-wrapicon2">
						<div class="header-icon1-wrapper">
							<img src="images/icons/icon-header-02.png" class="header-icon1 js-show-header-dropdown" alt="ICON">
							<span class="header-icons-noti" id="numberItemsCartMobile">0</span>
						</div>

						<!-- Header cart noti -->
						<div class="header-cart header-dropdown">
							<ul class="header-cart-wrapitem">
								<p>Tu carrito est&aacute; vac&iacute;o</p>
							</ul>

							<div class="header-cart-total">
								Total: $0
							</div>

							<div class="header-cart-buttons">
								<div class="header-cart-wrapbtn">
									<!-- Button -->
									<a href="#" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										Finalizar Compra
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
					<span class="hamburger-box">
						<span class="hamburger-inner"></span>
					</span>
				</div>
			</div>
		</div>

		<!-- Menu Mobile -->
		<div class="wrap-side-menu" >
			<nav class="side-menu">
				<ul class="main-menu" id="subStoreMobile">
					<li class="item-topbar-mobile p-l-20 p-t-8 p-b-8">
						<span class="topbar-child1">
							Envíos gratuitos en ordenes superiores a $3000
						</span>
					</li>

					<li class="item-topbar-mobile p-l-20 p-t-8 p-b-8">
						<div class="topbar-child2-mobile">
							<span class="topbar-email">
								<a href="mailto:contacto@mg.com">contacto@mg.com.ar</a>
							</span>
						</div>
					</li>

					<li class="item-topbar-mobile p-l-10">
						<div class="topbar-social-mobile">
							<a href="#" class="topbar-social-item fa fa-facebook"></a>
							<a href="#" class="topbar-social-item fa fa-instagram"></a>
							<a href="#" class="topbar-social-item fa fa-pinterest-p"></a>
							<a href="#" class="topbar-social-item fa fa-snapchat-ghost"></a>
							<a href="#" class="topbar-social-item fa fa-youtube-play"></a>
						</div>
					</li>

				</ul>
			</nav>
		</div>
	</header>

	<!-- Slide1 -->
	<section class="slide1">
		<div class="wrap-slick1">
			<div class="slick1">
				<div class="item-slick1 item1-slick1" style='background-image: url("images/slider/1.jpg");'>
					<div class="wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170">
						<span class="caption1-slide1 m-text1 t-center animated visible-false m-b-15" data-appear="fadeInDown">
							Colecci&oacute;n 2018
						</span>

						<h2 class="caption2-slide1 xl-text1 t-center animated visible-false m-b-37" data-appear="fadeInUp">
							Mir&aacute; las Novedades
						</h2>

						
					</div>
				</div>

				<div class="item-slick1 item2-slick1" style='background-image: url("images/slider/3.jpg");'>
					<div class="wrap-content-slide1 sizefull flex-col-c-m p-l-15 p-r-15 p-t-150 p-b-170">
						<span class="caption1-slide1 m-text1 t-center animated visible-false m-b-15" data-appear="rollIn">
							¡Nuevo Store online!
						</span>

						<h2 class="caption2-slide1 xl-text1 t-center animated visible-false m-b-37" data-appear="lightSpeedIn">
							Compr&aacute; sin culpa!
						</h2>
					</div>
				</div>

			</div>
		</div>
	</section>

	<!-- Banner -->

	<!-- New Product -->
	<section class="newproduct bgwhite p-t-45 p-b-105">
		<div class="container">
			<div class="sec-title p-b-60">
				<h3 class="m-text5 t-center">
					&uacute;ltimas Novedades
				</h3>
			</div>


		</div>
	</section>

	<!-- Shipping -->
	<section class="shipping bgwhite p-t-62 p-b-46">
		<div class="flex-w p-l-15 p-r-15">
			<div class="flex-col-c w-size5 p-l-15 p-r-15 p-t-16 p-b-15 respon1">
				<h4 class="m-text12 t-center">
					Envío Gratis
				</h4>

				<span  class="s-text11 t-center">
					En ordenes mayores a $3000
				</span>
			</div>

			<div class="flex-col-c w-size5 p-l-15 p-r-15 p-t-16 p-b-15 bo2 respon2">
				<h4 class="m-text12 t-center">
					10 días para devoluciones
				</h4>

				<span class="s-text11 t-center">
					Además, es gratuita
				</span>
			</div>

			<div class="flex-col-c w-size5 p-l-15 p-r-15 p-t-16 p-b-15 respon1">
				<h4 class="m-text12 t-center">
					Horarios de la tienda
				</h4>

				<span class="s-text11 t-center">
					Lunes a Domingos, 10AM - 10PM
				</span>
			</div>
		</div>
	</section>


	<!-- Footer -->
	<footer class="bg6 p-t-45 p-b-43 p-l-45 p-r-45">
		<div class="flex-w p-b-90">
			<div class="w-size6 p-t-30 p-l-15 p-r-15 respon3">
				<h4 class="s-text12 p-b-30">
					CONTACTANOS
				</h4>

				<div>
					<p class="s-text7 w-size27">
						Dudas? Encontranos en nuestro store en Patio Olmos, Av. Velez Sarsfield 361, Cordoba, AR o llamanos al (+54) 0351 457 16879
					</p>

					<div class="flex-m p-t-30">
						<a href="#" class="fs-18 color1 p-r-20 fa fa-facebook"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-instagram"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-pinterest-p"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-snapchat-ghost"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-youtube-play"></a>
					</div>
				</div>
			</div>

			

			

			

			
		</div>

		<div class="t-center p-l-15 p-r-15">
			<a href="#">
				<img class="h-size2" src="images/icons/paypal.png" alt="IMG-PAYPAL">
			</a>

			<a href="#">
				<img class="h-size2" src="images/icons/visa.png" alt="IMG-VISA">
			</a>

			<a href="#">
				<img class="h-size2" src="images/icons/mastercard.png" alt="IMG-MASTERCARD">
			</a>

			<a href="#">
				<img class="h-size2" src="images/icons/express.png" alt="IMG-EXPRESS">
			</a>

			<a href="#">
				<img class="h-size2" src="images/icons/discover.png" alt="IMG-DISCOVER">
			</a>

			<div class="t-center s-text8 p-t-20">
				Copyright © 2018 All rights reserved
			</div>
		</div>
	</footer>



	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	<!-- Container Selection1 -->
	<div id="dropDownSelect1"></div>




	<script type="text/javascript">
		categories.sort(function (a, b) {
		    return a.nombre.localeCompare(b.nombre);
		});
		$.each(categories, function(idx, category) {
			$("#subStoreMobile").append("<li><a href=\"#\">"+category.nombre+"</a></li>");
			$("#subStore").append("<li><a href=\"#\">"+category.nombre+"</a></li>");
		});
	</script>
	<script type="text/javascript" src="vendor/animsition/js/animsition.min.js"></script>

	<script type="text/javascript" src="vendor/bootstrap/js/popper.js"></script>
	<script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="vendor/slick/slick.min.js"></script>
	<script type="text/javascript" src="js/slick-custom.js"></script>

	<script type="text/javascript" src="vendor/sweetalert/sweetalert.min.js"></script>


	<script src="js/main.js" type="text/javascript"></script>
	<script src="js/searchNav.js" type="text/javascript"></script>
	<script src="js/cartHandler.js" type="text/javascript"></script>
</body>
</html>