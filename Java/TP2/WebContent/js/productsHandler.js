var categories;
var products;
var prodsInCart;

function loadData(catID, query){
	$('.loaderContainer').show();
	if (localStorage.categoriesData == null || localStorage.categoriesData == "null" || localStorage.categoriesData == "undefined") {
		$.getJSON( "js/data/categorias.json", function( categoriesJSON ) {
	        localStorage.categoriesData = JSON.stringify(categoriesJSON);
	        categories = categoriesJSON.results;
	        printCategories(categories);
	        getProducts(catID, query);
	    });
	}
	else
	{
		categories = JSON.parse(localStorage.categoriesData).results; // Para leer los datos del localStorage
		printCategories(categories);
		getProducts(catID, query);
	}
}


function getProducts(catID, query){
	if (localStorage.productsData == null || localStorage.productsData == "null" || localStorage.productsData == "undefined") {
	    $.getJSON( "js/data/productos.json", function( productsJSON ) {
	        localStorage.productsData = JSON.stringify(productsJSON);
	        products = productsJSON.results;
	        filter(catID, query, products);
	        $('.loaderContainer').hide();
	    });
	}
	else
	{
		products = JSON.parse(localStorage.productsData).results; // Para leer los datos del localStorage
		filter(catID, query, products);
		$('.loaderContainer').hide();
	}	
}

function printCategories(categories){
	categories.sort(function (a, b) {
		return a.nombre.localeCompare(b.nombre);
	});
	$.each(categories, function(idx, category) {
		$("#subStoreMobile").append("<li class=\"item-menu-mobile\"><a href=\"#\" data-filter=\""+category.ID+"\" class=\"catFilter\">"+category.nombre+"</a></li>"); 
		$("#subStore").append("<li><a href=\"#\" data-filter=\""+category.ID+"\" class=\"catFilter\">"+category.nombre+"</a></li>"); 
	});

}



function getProduct(id){
	//Solo pueden entrar IDs definidos en el array de productos 
	var pos = -1;
	 $.each(products, function(i, product) {
		 if(product.ID == id){
			 pos = i;
			 return false;
		 }
	 });
	 if(pos != -1){
		 return products[pos];
	 }
}


var updateQueryStringParam = function (key, value) {

    var baseUrl = [location.protocol, '//', location.host, location.pathname].join(''),
        urlQueryString = document.location.search,
        newParam = key + '=' + value,
        params = '?' + newParam;

    // If the "search" string exists, then build params from it
    if (urlQueryString) {
        var updateRegex = new RegExp('([\?&])' + key + '[^&]*');
        var removeRegex = new RegExp('([\?&])' + key + '=[^&;]+[&;]?');

        if( typeof value == 'undefined' || value == null || value == '' ) { // Remove param if value is empty
            params = urlQueryString.replace(removeRegex, "$1");
            params = params.replace( /[&;]$/, "" );

        } else if (urlQueryString.match(updateRegex) !== null) { // If param exists already, update it
            params = urlQueryString.replace(updateRegex, "$1" + newParam);

        } else { // Otherwise, add it to end of query string
            params = urlQueryString + '&' + newParam;
        }
    }

    // no parameter was set so we don't need the question mark
    params = params == '?' ? '' : params;

    window.history.replaceState({}, "", baseUrl + params);
};

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};


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
	if(categoria!=""&&categoria!=null){
		scrollToProducts();
	}else{
		categoria = "all";
	}
	updateQueryStringParam("catID", categoria);
	updateQueryStringParam("searchQ", texto);
	var categoriesAux;
	var productsAux;

	if(texto!="" && texto!=undefined){
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
	$("#searchResultsText").empty();
	if(texto!="" && texto != undefined){
		$("#searchResultsText").html("<p>Se est&aacute;n mostrando los resultados de: \""+texto+"\"</p><br/>");
	}
	if(productsAux.length > 0){
		$("#productList").empty();
		printProductsList(productsAux);
	}else{
		$("#productList").html("<p>No se han encontrado resultados</p>");
	}
}

function printProductsList(array){
	for(var i = 0; i<array.length; i++){
		var prod = array[i];
		$("#cantResultados").text(array.length);
		var prodImg = (prod.imagenes.length > 0? prod.imagenes[prod.imagen_portada].urlImg : "images/categorias/default.jpg");
		var del = "";
		if(prodsInCart.includes(prod.ID)){
			del = "<a href=\"#\" class=\"block2-btn-addwishlist hov-pointer trans-0-4 btnRemove\" id=\"btnRemove-"+prod.ID+"\">\
				<i class=\"icon-wishlist icon_close_alt2\" aria-hidden=\"true\"></i>\
				<i class=\"icon-wishlist icon_close_alt dis-none\" aria-hidden=\"true\"></i>\
				<input type=\"hidden\" name=\"deleteFromCart\" value=\""+prod.ID+"\">\
			</a>";
		}
		$("#productList").append("<div class=\"col-sm-12 col-md-6 col-lg-4 p-b-50\">\
									<div class=\"prodItem\">\
										<form class=\"block2\">\
										<div class=\"block2-img wrap-pic-w of-hidden pos-relative\">\
												<img src=\""+prodImg+"\" alt=\"IMG-PRODUCT\">\
												<div class=\"block2-overlay trans-0-4\">\
												"+del+"\
													<div class=\"block2-btn-addcart dark w-size1 trans-0-4\">\
														<div class=\"flex-w w-size17\">\
															<a href=\"#\" class=\"btn-num-product-down color1 flex-c-m size7 bg8 eff2\">\
																<i class=\"fs-12 fa fa-minus\" aria-hidden=\"true\"></i>\
															</a>\
															<input class=\"size8 m-text18 t-center num-product\" type=\"number\" name=\"prodQuantity\" value=\"1\">\
															<a href=\"#\"  class=\"btn-num-product-up color1 flex-c-m size7 bg8 eff2\">\
																<i class=\"fs-12 fa fa-plus\" aria-hidden=\"true\"></i>\
															</a>\
														</div>\
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
									</div>\
									</div>");
	}
	

}

function scrollToProducts(){
	$('html, body').animate({
        scrollTop: $("#productList").offset().top-200
    }, 1000);
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

/*[ +/- num product ]
===========================================================*/
$("#productList").on('click', '.btn-num-product-down',  function(e){
	e.preventDefault();
	var numProduct = Number($(this).next().val());
	if(numProduct > 1) $(this).next().val(numProduct - 1);
});

$("#productList").on('click', '.btn-num-product-up',  function(e){
	e.preventDefault();
	var numProduct = Number($(this).prev().val());
    $(this).prev().val(numProduct + 1);
});


$(document).on('submit', '#searchForm',  function(e){
	e.preventDefault();
	var text = $("#searchForm input[name=searchQ]").val();
	filter('all', text, products);
	$('.nav-buscar').slideUp();
	$("#searchForm")[0].reset();
});
