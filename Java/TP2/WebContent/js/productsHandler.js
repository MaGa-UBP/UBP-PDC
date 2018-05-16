if (localStorage.productsData == null || localStorage.productsData == "null" || localStorage.productsData == "undefined") {
    $.getJSON( "js/data/productos.json", function( productsJSON ) {
        localStorage.productsData = JSON.stringify(productsJSON);
    });
}
if (localStorage.categoriesData == null || localStorage.categoriesData == "null" || localStorage.categoriesData == "undefined") {
	$.getJSON( "js/data/categorias.json", function( categoriesJSON ) {
        localStorage.categoriesData = JSON.stringify(categoriesJSON);
    });
}


