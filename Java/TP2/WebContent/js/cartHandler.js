$('.addToCart').on('click', function(){ // Agregar al carrito
	$.ajax({
		url: "cart/add",
		type: "post",
		dataType: "html",
		data:$(this).closest('form').serialize(), //Buscamos los input number de la pagina.
		error: function(hr){
			swal("¡Error!", "Por favor, intente nuevamente.", "error");
			console.log(hr);
		},
		success: function(response){
			var nameProduct = response;
			swal(response, "fue añadido al carrito !", "success");
			var num = parseInt($("#numberItemsCartMobile").text());
			$(".header-icons-noti").text(num+1);
		}
	});
});

$('.deleteFromCart').on('click', function(){ // Agregar al carrito
	$.ajax({
		url: "cart/delete",
		type: "post",
		dataType: "html",
		data:$(this).closest('form').serialize(), //Buscamos los input number de la pagina.
		error: function(hr){
			swal("¡Error!", "Por favor, intente nuevamente.", "error");
			console.log(hr);
		},
		success: function(response){
			var nameProduct = response;
			swal(response, "fue añadido al carrito !", "success");
			var num = parseInt($("#numberItemsCartMobile").text());
			$(".header-icons-noti").text(num+1);
		}
	});
});