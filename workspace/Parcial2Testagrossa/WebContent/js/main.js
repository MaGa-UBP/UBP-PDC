jParcial = {
		seleccion: function () {
				if($("select").val().trim()!== ""){
					jUtils.executing("iresult");
			        $.ajax({
			            url: "./BuscarServlet.jsp",
			            type: "POST",
			            dataType: "html",
			            data: $.param($("select", $("#form"))),
			            error: function(hr){
			                jUtils.hiding("iresult");
			                jUtils.showing("message", hr.responseText);
			            },
			            success: function(html) {
			                jUtils.showing("iresult", html);
			            }
			        });
				} else {
					alert("Debe seleccionar una opcion valida");
				}
				
	   },
		registrar: function (preferencia) {
			$("input[name=preferenciaRegistrada]").val($(preferencia).attr("id"));
			var html = $(preferencia).html();
			$(preferencia).html("Procesando...");
	        $.ajax({
	            url: "./RegistrarServlet.jsp",
	            type: "POST",
	            dataType: "html",
	            data: $.param($("input[name=preferenciaRegistrada]", $("#formReg"))),
	            error: function(hr){
	                jUtils.showing("message", hr.responseText);
	                $(preferencia).html(html);
	            },
	            success: function() {
	            	$(preferencia).closest("tr").remove();
	            	$("#iregistradas").append("<tr><td>"+ html +"</td></tr>")
	            }
	        });			
   }
}
		