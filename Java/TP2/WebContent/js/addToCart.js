$('.addToCart').on('click', function(){
	//AJAX para agregar producto a sesion
	$.ajax({
		url: "addToCart",
		type: "post",
		dataType: "html",
		data:$(this).closest('form').serialize(), //Buscamos los input number de la pagina.
		error: function(hr){
			swal(hr, "Por favor, intente nuevamente!", "error");
			var num = parseInt($("#numberItemsCartMobile").text());
			$(".header-icons-noti").text(num+1);
		},
		success: function(html){
			var nameProduct = html;
			swal(html, "fue añadido al carrito !", "success");
			var num = parseInt($("#numberItemsCartMobile").text());
			$(".header-icons-noti").text(num+1);
		}
	});
});