$('.addToCart').on('click', function(){ // Agregar al carrito
	$.ajax({
		url: "addToCart.jsp",
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
			
			if($("#ci"+product.ID).length){
				var cantActual = parseInt($('#ci'+product.ID+" .cantProdCart").text());
				$('#ci'+product.ID+" .cantProdCart").text(cantTotProd);
				cantAAgregar = cantTotProd-cantActual;
			}else{
				cantAAgregar = cantTotProd;
				agregarACarrito(product, cantAAgregar, "#cartItems");
			}
			var totalCart = parseFloat($("input[name=inputTotalCart]").val());
			totalCart += parseFloat(product.precio)*cantAAgregar;
			$("input[name=inputTotalCart]").val(totalCart)
			$(".totalCart").text($.number( totalCart, 2, ',', '.' ));
			
			
			swal({title: product.nombre, html: "fue a&ntilde;adido al carrito !", type:"success", buttonsStyling:false});
			var num = parseInt($("#numberItemsCart").text())+cantAAgregar;
			$(".header-icons-noti").text(num);
		
		}
	});
});

function agregarACarrito(product, cant, selector){
	$(".emptyCart").hide();
	$(selector).append("<li class=\"header-cart-item\" id=\"ci"+product.ID+"\">\
			<div class=\"header-cart-item-img\">\
				<img src=\""+(product.imagenes.length > 0? product.imagenes[product.imagen_portada].urlImg : "images/categorias/default.jpg")+"\" alt=\"Imagen "+product.nombre+"\"/>\
			</div>\
			<div class=\"header-cart-item-txt\">\
				<a href=\"#\" class=\"header-cart-item-name\">"+product.nombre+"</a>\
				<div class=\"header-cart-item-info\">\
					<span class=\"cantProdCart\">"+cant+"</span> x <span class=\"precioProdCart\">"+product.precio+"</span>\
			</div></div></li>");
		
		
//		$(selector+"Mobile").append("<li class=\"header-cart-item\" id=\"ci"+product.ID+"\">\
//				<div class=\"header-cart-item-img\">\
//					<img src=\""+(product.imagenes.length > 0? product.imagenes[product.imagen_portada].urlImg : "images/categorias/default.jpg")+"\" alt=\"Imagen "+product.nombre+"\"/>\
//				</div>\
//				<div class=\"header-cart-item-txt\">\
//					<a href=\"#\" class=\"header-cart-item-name\">"+product.nombre+"</a>\
//					<div class=\"header-cart-item-info\">\
//						<span class=\"cantProdCart\">"+cant+"</span> x <span class=\"precioProdCart\">"+product.precio+"</span>\
//				</div></div></li>");
	
}
