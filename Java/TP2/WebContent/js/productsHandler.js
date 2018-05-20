var categories;
var products;

if (localStorage.productsData == null || localStorage.productsData == "null" || localStorage.productsData == "undefined") {
    $.getJSON( "js/data/productos.json", function( productsJSON ) {
        localStorage.productsData = JSON.stringify(productsJSON);
        products = productsJSON;
    });
}
else
{
	products = JSON.parse(localStorage.productsData).results; // Para leer los datos del localStorage
}
if (localStorage.categoriesData == null || localStorage.categoriesData == "null" || localStorage.categoriesData == "undefined") {
	$.getJSON( "js/data/categorias.json", function( categoriesJSON ) {
        localStorage.categoriesData = JSON.stringify(categoriesJSON);
        categories = categoriesJSON;
    });
}
else
{
	categories = JSON.parse(localStorage.categoriesData).results; // Para leer los datos del localStorage
}

categories.sort(function (a, b) {
	return a.nombre.localeCompare(b.nombre);
});
$.each(categories, function(idx, category) {
	$("#subStoreMobile").append("<li class=\"item-menu-mobile\"><a href=\"#\" data-filter=\""+category.ID+"\" class=\"catFilter\">"+category.nombre+"</a></li>"); 
	$("#subStore").append("<li><a href=\"#\" data-filter=\""+category.ID+"\" class=\"catFilter\">\"+category.nombre+\"</a></li>"); 
});

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
