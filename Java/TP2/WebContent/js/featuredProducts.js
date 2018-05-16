for(var i = products.length-1; i>products.length-9; i--){
	var prod = products[i];
	$("#featuredProducts").append("<div class=\"item-slick2 p-l-15 p-r-15\">\
									<form class=\"block2\">\
									<div class=\"block2-img wrap-pic-w of-hidden pos-relative\">\
											<img src=\""+(prod.imagenes.length > 0? prod.imagenes[prod.imagen_portada].urlImg : "images/categorias/default.jpg")+"\" alt=\"IMG-PRODUCT\">\
											<div class=\"block2-overlay trans-0-4\">\
												<a href=\"#\" class=\"block2-btn-addwishlist hov-pointer trans-0-4\">\
													<i class=\"icon-wishlist icon_heart_alt\" aria-hidden=\"true\"></i>\
													<i class=\"icon-wishlist icon_heart dis-none\" aria-hidden=\"true\"></i>\
												</a>\
												<div class=\"block2-btn-addcart w-size1 trans-0-4\">\
													<a class=\"flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4 addToCart\">A&ntilde;adir</a>\
												</div>\
											</div>\
										</div>\
										<div class=\"block2-txt p-t-20\">\
										<input type=\"hidden\" name=\"prodID\" value=\""+prod.ID+"\">\
										<input type=\"hidden\" name=\"prodName\" value=\""+prod.nombre+"\">\
											<a href=\"#\" class=\"block2-name dis-block s-text3 p-b-5\">\
												"+prod.nombre+"\
											</a>\
											<span class=\"block2-price m-text6 p-r-5 formatted_price\">$"+$.number( prod.precio, 2, ',', '.' )+"</span>\
										</div>\
									</form>\
								</div>");
}