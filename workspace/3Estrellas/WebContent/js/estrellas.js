var jForm = {
		
	select: function(element) {
		if($(element).hasClass("azul")) {
			if($("td.rojo").length == 3) {
				alert("No puede elegir más de 3 bloques");
				return false;
			}
			$(element).addClass("rojo").removeClass("azul");				
		}
		else {
			$(element).addClass("azul").removeClass("rojo");				
		}
	},	
		
	valid: function() {
		var i = 0, arr = Array(3);

		if($("td.rojo").length != 3) {
			alert("Debe elegir 3 bloques");
			return false;
		}
		
		$("td.rojo input[type=hidden]").each(function() {
			arr[i++] = $(this).val();
		});
		
		$("#celdas").val(arr.join(";"));
		$("#form").submit();
	}		
		
};