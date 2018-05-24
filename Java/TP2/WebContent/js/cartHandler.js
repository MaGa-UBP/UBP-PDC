$(document).on('click', '.addToCart', function(){  // Agregar al carrito
	var $prodQInput = $(this).closest('form').find("input[name=prodQuantity]");
	$.ajax({
		url: "cart.jsp",
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
			$prodQInput.val(1);
			if($("#ci"+product.ID).length){
				var cantActual = parseInt($('#ci'+product.ID+" .cantProdCart").text());
				$('#ci'+product.ID+" .cantProdCart").text(cantTotProd);
				$('#ci'+product.ID+"-Mobile .cantProdCart").text(cantTotProd);
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



function updateCarrito(formItem, cant){
	var serialized = formItem.find('input').serialize() + "&prodQuantToUpdate="+cant;
	$.ajax({
		url: "cart.jsp",
		type: "post",
		dataType: "html",
		data: formItem.find('input').serialize() + "&prodQuantToUpdate="+cant, //Buscamos los input number de la pagina.
		error: function(hr){
			swal({title: "Error!", html: "Por favor, intente nuevamente.", type:"error", buttonsStyling:false});
			console.log(hr);
		},
		success: function(response){
			console.log(response);

			var idProduct = response.split(';')[0];
			var cantUpdate = parseInt(response.split(';')[1]);
			var product = getProduct(idProduct);

			var $iTotalItem = formItem.find("input[name=iItemTotal]");
			
			var totalItemCart = parseFloat($iTotalItem.val());
			
			var totalCart = parseFloat($("input[name=inputTotalCart]").val());
			
			totalItemCart += parseFloat(product.precio)*cantUpdate;
			totalCart += parseFloat(product.precio)*cantUpdate;
			$iTotalItem.val(totalItemCart);
			$("input[name=inputTotalCart]").val(totalCart);
			
			console.log(totalItemCart);
			console.log(totalCart);
			$(".totalCart").text($.number( totalCart, 2, ',', '.' ));
			formItem.find(".itemTotal").text($.number( totalItemCart, 2, ',', '.' ));
			
//			swal({title: product.nombre, html: "fue a&ntilde;adido al carrito !", type:"success", buttonsStyling:false});
//			var num = parseInt($("#numberItemsCart").text())+cantAAgregar;
//			$(".header-icons-noti").text(num);
			
		}
	});
}


$(".table-row").on('click', '.btn-num-product-down',  function(e){
	e.preventDefault();
	var numProduct = Number($(this).next().val());
	if(numProduct > 1){
		$(this).next().val(numProduct - 1);
		var formItem = $(e.target).closest('tr');
		var cant= -1;
		updateCarrito(formItem , cant);
	}
});

$(".table-row").on('click', '.btn-num-product-up',  function(e){
	e.preventDefault();
	var numProduct = Number($(this).prev().val());
    $(this).prev().val(numProduct + 1);
    var formItem = $(e.target).closest('tr');
    var cant = 1;
    updateCarrito(formItem, cant);
});


$(".btnRemove").on('click', function(e){  
	e.preventDefault();
	var rowToDelete = $(e.target).closest('tr');
	console.log(rowToDelete);
	$.ajax({
		url: "cart.jsp",
		type: "post",
		dataType: "html",
		data:$.param({"deleteFromCart": $(rowToDelete).find("input[name=prodID]").val()}), //Buscamos los input number de la pagina.
		error: function(hr){
			swal({title: "Error!", html: "Por favor, intente nuevamente.", type:"error", buttonsStyling:false});
			console.log(hr);
		},
		success: function(response){
			console.log(response);
			var idProduct = response.split(';')[0];
			var cantDelete = parseInt(response.split(';')[1]);
			var product = getProduct(idProduct);
			
			var totalCart =  parseFloat($("input[name=inputTotalCart]").val());
			
			
			totalCart -= parseFloat(product.precio)*cantDelete;
			$("input[name=inputTotalCart]").val(totalCart)
			$(".totalCart").text($.number( totalCart, 2, ',', '.' ));
			if($(rowToDelete).parent().find('.table-row').length == 1){
				$(".emptyCart").show();
				$(rowToDelete).closest('form').remove();
				$(".btnFinalizar").hide();
				$(".btnVolver").show();
			}
			$(rowToDelete).remove();
		}
	});
});
$('.btnFinalizar').on("click", function() {
	$(this).hide();
	$('.formFinalizar').show();
});

$('.btnComprar').on("click", function(e) {
	e.preventDefault();
	var string = $('#finalizarCompraForm').serialize();
	console.log(string);
	$.ajax({
		url: "./cookies.jsp",
		type: "post",
		data: $('#finalizarCompraForm').serialize(),
		datatype: "html",
		error: function(hr) {
			console.log(hr.responseText);
		},
		success: function(html) {
			console.log(html);
			swal({title: "Perfecto!", html: "Tu compra se ha recibido exitosamente", type:"success", buttonsStyling:false}).then((result) => {
				  if (result.value) {
					  window.location.replace("./index.jsp");
				  }
				});
		}
	});
});