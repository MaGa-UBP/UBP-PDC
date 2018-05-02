var cant = 0;
$(document).ready(function() {
	$("img").click(function() {
		jEstrellas.check(this);
		
	});	
	
	$("input[name=jugar]").click(function() {
		jEstrellas.valGrilla();
		$("#form").submit();
		//jEstrellas.sorteadas();
	});	

	$("input[name=volver]").click(function() {
		window.location.href="index.jsp";
	});	
});

var jEstrellas = {
	check: function(obj) {
		var hidden = $(".casilla", $(obj).closest("td"));
		//var value;
		if (cant<3){
				if ($(hidden).val()==""){
					$(obj).attr("src","./resources/rojo.png");
					var value=$(hidden).attr("id");
					$(hidden).val(value);
					cant++;
				}
				else if ($(hidden).val()!=""){
					$(obj).attr("src","./resources/azul.png");
					$(hidden).val("");
					cant--;
				}
		}
		else if ($(hidden).val()!=""){
			$(obj).attr("src","./resources/azul.png");
			$(hidden).val("");
			cant--;} 
		else{
			alert("no puede seleccionar mas de 3 casillas");
			return false;
		}
	},
	
	valGrilla: function() {		
		if (cant<3){
			alert("Debe seleccionar 3 casillas");
			return false;
		}
		$("#form").submit();
	},
	
	sorteadas: function(a) {
		$("#imagen"+a).attr("src","./resources/verde.png");		
	},
	seleccionadas: function(a) {
		$("#imagen"+a).attr("src","./resources/rojo.png");		
	}
};