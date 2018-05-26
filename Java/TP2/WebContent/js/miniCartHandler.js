$(document).on('click', '.addToCart', function(e){  // Agregar al carrito
	e.preventDefault();
	var $prodQInput = $(this).closest('form').find("input[name=prodQuantity]");
	$('.loaderContainer').show();
	$.ajax({
		url: "cart.jsp",
		type: "post",
		dataType: "html",
		data:$(this).closest('form').serialize(), //Buscamos los input number de la pagina.
		error: function(hr){
			swal({title: "Error!", html: "Por favor, intente nuevamente.", type:"error", buttonsStyling:false});
			console.log(hr);
		},
		success: function(response){
			var idProduct = response.split(';')[0];
			var cantTotProd = parseInt(response.split(';')[1]);
			var product = getProduct(idProduct);

			var cantAAgregar = 0;
			$prodQInput.val(1);
			if($("#ci"+product.ID).length){
				var cantActual = parseInt($("#c"+product.ID+" .cantProdCart").text());
				$("#ci"+product.ID+" .cantProdCart").text(cantTotProd);
				$("#ci"+product.ID+"-Mobile .cantProdCart").text(cantTotProd);
				cantAAgregar = cantTotProd-cantActual;
			}else{
				cantAAgregar = cantTotProd;
				agregarACarrito(product, cantAAgregar, "#cartItems");

				$(e.target).closest('.block2-overlay').append("<a href=\"#\" class=\"block2-btn-addwishlist hov-pointer trans-0-4 btnRemove\" id=\"btnRemove-"+product.ID+"\">\
						<i class=\"icon-wishlist icon_close_alt2\" aria-hidden=\"true\"></i>\
						<i class=\"icon-wishlist icon_close_alt dis-none\" aria-hidden=\"true\"></i>\
						<input type=\"hidden\" name=\"deleteFromCart\" value=\""+idProduct+"\">\
					</a>");
			}
			var totalCart = parseFloat($("input[name=inputTotalCart]").val());
			totalCart += parseFloat(product.precio)*cantAAgregar;
			$("input[name=inputTotalCart]").val(totalCart)
			$(".totalCart").text($.number( totalCart, 2, ',', '.' ));
			
			
			swal({title: product.nombre, html: "fue a&ntilde;adido al carrito !", type:"success", buttonsStyling:false});
			$('.loaderContainer').hide();
			var num = parseInt($("#numberItemsCart").text())+cantAAgregar;
			$(".header-icons-noti").text(num);
		}
	});
});



function agregarACarrito(product, cant, selector){
	$(".emptyCart").hide();
	var img = (product.imagenes.length > 0? product.imagenes[product.imagen_portada].urlImg : "images/categorias/default.jpg");
	$(selector).append("<form action=\"cart.js\" method=\"post\" ><li class=\"header-cart-item\" id=\"ci"+product.ID+"\">\
			<input type=\"hidden\" name=\"deleteFromCart\" value=\""+product.ID+"\">\
			<a href=\"#\" class=\"btnRemove\"> <div class=\"header-cart-item-img\">\
				<img src=\""+img+"\" alt=\"Imagen "+product.nombre+"\"/>\
			</div></a>\
			<div class=\"header-cart-item-txt\">\
				<a href=\"#\" class=\"header-cart-item-name\">"+product.nombre+"</a>\
				<div class=\"header-cart-item-info\">\
					<span class=\"cantProdCart\">"+cant+"</span> x <span class=\"precioProdCart\">"+product.precio+"</span>\
			</div></div></li></form>");
		
	
		$(selector+"Mobile").append("<li class=\"header-cart-item\">\
				<div class=\"header-cart-item-img\">\
					<img src=\""+img+"\" alt=\"Imagen "+product.nombre+"\"/>\
				</div>\
				<div class=\"header-cart-item-txt\">\
					<a href=\"#\" class=\"header-cart-item-name\">"+product.nombre+"</a>\
					<div class=\"header-cart-item-info\">\
						<span class=\"cantProdCart\">"+cant+"</span> x <span class=\"precioProdCart\">"+product.precio+"</span>\
				</div></div></li>");
	
}



$("#cartItems, #website").on('click', '.btnRemove', function(e){  
	e.preventDefault();

	$('.loaderContainer').show();
	$.ajax({
		url: "cart.jsp",
		type: "post",
		dataType: "html",
		data:$(this).closest('form').serialize(), //Buscamos los input number de la pagina.
		error: function(hr){
			swal({title: "Error!", html: "Por favor, intente nuevamente.", type:"error", buttonsStyling:false});
			console.log(hr);
		},
		success: function(response){
			var idProduct = response.split(';')[0];
			var cantDelete = parseInt(response.split(';')[1]);
			var product = getProduct(idProduct);
			
			var totalCart =  parseFloat($("input[name=inputTotalCart]").val());
			$("#btnRemove-"+idProduct).remove();
			$('.loaderContainer').hide();
			totalCart -= parseFloat(product.precio)*cantDelete;
			$("input[name=inputTotalCart]").val(totalCart)
			$(".totalCart").text($.number( totalCart, 2, ',', '.' ));
			var num = parseInt($("#numberItemsCart").text())-cantDelete;
			$(".header-icons-noti").text(num);
			$("#ci"+idProduct).remove();
			$("#ci"+idProduct+"-Mobile").remove();
			if(num == 0){
				$(".emptyCart").show();
			}
		}
	});
});

$('.btnFinalizarCompra').on('click', function(e){
	$("#website").hide();
	$('.loaderContainer').show();
	$.ajax({
		url: "cart.jsp",
		type: "get",
		dataType: "html",
		error: function(hr){
			swal({title: "Error!", html: "Por favor, intente nuevamente.", type:"error", buttonsStyling:false});
			console.log(hr);
		},
		success: function(response){
			$('.loaderContainer').hide();
			$("#cartResults").html(response);
			$('.wrap_menu').hide();
			$('.header-icons').hide();
		}
	});
});