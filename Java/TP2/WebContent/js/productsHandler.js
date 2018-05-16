if (localStorage.productsData == null || localStorage.productsData == "null" || localStorage.productsData == "undefined") {
    $.getJSON( "js/data/productos.json", function( productsJSON ) {
        localStorage.productsData = JSON.stringify(productsJSON);
    });
}
//else
//{
//	var products = JSON.parse(localStorage.productsData); // Para leer los datos del localStorage
//}
if (localStorage.categoriesData == null || localStorage.categoriesData == "null" || localStorage.categoriesData == "undefined") {
	$.getJSON( "js/data/categorias.json", function( categoriesJSON ) {
        localStorage.categoriesData = JSON.stringify(categoriesJSON);
    });
}


