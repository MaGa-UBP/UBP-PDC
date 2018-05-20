function catExists(array, cat){
	var exists = false;
	$.each(array, function(i, product) {
		 if(product.categoria_id == cat.ID){
			 exists = true;
			 return false;
		 }
	 });
	return exists;
}

function filter(categoria, texto, array){
	updateQueryStringParam("catID", categoria);
	updateQueryStringParam("searchQ", texto);
	var categoriesAux;
	var productsAux;

	if(texto!=""){
		productsAux = $.grep(array, function( product, i ) {
			return (product.nombre.toLowerCase().indexOf(texto.toLowerCase()) >= 0) || (product.descripcion.toLowerCase().indexOf(texto.toLowerCase()) >= 0); //Ver tema de acentos
		});
		categoriesAux = $.grep(categories, function( category, i ) {
			return catExists(productsAux, category); 
		});
	}else{
		productsAux = array;
		categoriesAux = categories;
	}
	
	if(categoria != "all"){
		productsAux = $.grep(productsAux, function( product, i ) {
					  return product.categoria_id == categoria;
					});
	}

	$("#subStoreLateral").empty();
	$("#subStoreLateral").append("<li class=\"p-t-4\"><a href=\"#\" class=\"s-text13 catSideFilter active1\" data-filter=\"all\">Todo</a></li>");

	$.each(categoriesAux, function(idx, category) {
		if(category.ID == categoria){
			$('.catSideFilter').removeClass("active1");
			$("#subStoreLateral").append("<li class=\"p-t-4\"><a href=\"#\" class=\"s-text13 catSideFilter active1\" data-filter=\""+category.ID+"\">"+category.nombre+"</a></li>");
		}else{
			$("#subStoreLateral").append("<li class=\"p-t-4\"><a href=\"#\" class=\"s-text13 catSideFilter\" data-filter=\""+category.ID+"\">"+category.nombre+"</a></li>");
		}
	});
	if(productsAux.length > 0){
		printProductsList(productsAux);
	}else{
		$("#productList").html("<p>No se han encontrado resultados</p>");
	}
}

function printProductsList(array){
	$("#productList").empty();
	for(var i = 0; i<array.length; i++){
		var prod = array[i];
		$("#cantResultados").text(array.length);
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
$(document).on('click','.catFilter', function(e){
	e.preventDefault();
	var cat = $(this).data('filter');
	filter(cat, "",products);
	$('.catFilter').removeClass("active1");
	$(this).addClass("active1");
});

$(document).on('click','.catSideFilter', function(e){
	e.preventDefault();
	var cat = $(this).data('filter');
	var text = getUrlParameter("searchQ");
	filter(cat, text,products); 
});

$(document).on('submit', '#searchForm',  function(e){
	e.preventDefault();
	var text = $("#searchForm input[name=searchQ]").val();
	filter('all', text, products);
	$('.nav-buscar').slideUp();
	$("#searchForm")[0].reset();
});