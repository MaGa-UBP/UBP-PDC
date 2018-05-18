function filter(categoria, array){
	var productsAux;
	var carParam = "";
	if(categoria == "*"){
		productsAux = array;
		catParam = "all";
		
	}else{
		productsAux = $.grep(array, function( product, i ) {
					  return product.categoria_id == categoria;
					});
	}
	
	$("#productList").empty();
	for(var i = 0; i<productsAux.length; i++){
		var prod = productsAux[i];
		$("#cantResultados").text(productsAux.length);
		var prodImg = (prod.imagenes.length > 0? prod.imagenes[prod.imagen_portada].urlImg : "images/categorias/default.jpg");
		$("#productList").append("<div class=\"col-sm-12 col-md-6 col-lg-4 p-b-50\">\
										<form class=\"block2\">\
										<div class=\"block2-img wrap-pic-w of-hidden pos-relative\">\
												<img src=\""+prodImg+"\" alt=\"IMG-PRODUCT\">\
												<div class=\"block2-overlay trans-0-4\">\
													<div class=\"block2-btn-addcart w-size1 trans-0-4\">\
														<a class=\"flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4 addToCart\">A&ntilde;adir</a>\
													</div>\
												</div>\
											</div>\
											<div class=\"block2-txt p-t-20\">\
											<input type=\"hidden\" name=\"prodID\" value=\""+prod.ID+"\">\
											<input type=\"hidden\" name=\"prodPrice\" value=\""+prod.precio+"\">\
											<input type=\"hidden\" name=\"prodQuantity\" value=\"1\">\
											<input type=\"hidden\" name=\"prodImgUrl\" value=\""+prodImg+"\">\
											<input type=\"hidden\" name=\"prodName\" value=\""+$("<div/>").text(prod.nombre).html()+"\">\
												<a href=\"#\" class=\"block2-name dis-block s-text3 p-b-5\">\
													"+prod.nombre+"\
												</a>\
												<span class=\"block2-price m-text6 p-r-5 formatted_price\">$"+$.number( prod.precio, 2, ',', '.' )+"</span>\
											</div>\
										</form>\
									</div>");
	}
}
$('.catFilter').on('click', function(e){
	e.preventDefault();
	var cat = $(this).data('filter');
	filter(cat, products);
	location.search = $.param("catID="+cat );
	$('.catFilter').removeClass("active1");
	$('.catFilter').each(function( index ) {
		  if($(this).data('filter')==cat){
			  $(this).addClass("active1");
			  
		  }
	});
});

