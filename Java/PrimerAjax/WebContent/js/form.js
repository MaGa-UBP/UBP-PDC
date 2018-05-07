var jForm = {
		enviar: function(e){
			e.preventDefault();
			$("#main").hide();
			$("#result").html("<p>Procesando...</p>");
			
			$.ajax({
				url: "resultado.jsp",
				type: "post",
				dataType: "html",
				data:$.param($("input[type=number]")), //Buscamos los input number de la pagina.
				error: function(hr){
					$("#result").html("<p>"+hr.responseText+"</p>");
					$("#main").show();
				},
				success: function(html){
					$("#result").html(html);
				}
			});
		},
		volver: function(){
			$("#main").show();
			$("#form")[0].reset();
			$("#result").empty();
		}
}