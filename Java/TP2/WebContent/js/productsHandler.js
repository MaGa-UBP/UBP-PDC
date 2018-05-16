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

console.log("Productos: ");
console.log(products);
console.log("Categorias: ");
console.log(categories);

