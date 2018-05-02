jPreferencias = {
		read: function () {
				if($("select").val().trim()!== ""){
					jUtils.executing("resultados");
			        $.ajax({
			            url: "./busquedaPreferencias.jsp",
			            type: "POST",
			            dataType: "html",
			            data: $.param($("select", $("#form"))),
			            error: function(hr){
			                jUtils.hiding("resultados");
			                jUtils.showing("message", hr.responseText);
			            },
			            success: function(html) {
			            	
			                jUtils.showing("resultados", html);
			            }
			        });
				} else {
					alert("Debe seleccionar una opcion valida");
				}
				
	   },
	   
	   
		clicked: function (obj) {
			var html = $(obj).html();
			//$(obj).html("Procesando...");*/
			$(obj).children("#value").addClass("hide");
			$(obj).children("#proc").removeClass("hide");
	        $.ajax({
	            url: "./insertarPreferencias.jsp",
	            type: "POST",
	            dataType: "html",
	            data: $.param({"codPref": $("input[name='codPref']", $(obj)).val(),"nroPref": $("input[name='nroPref']", $(obj)).val() }),
	            error: function(hr){
	                jUtils.showing("message", hr.responseText);
	                //$(obj).html(html);
	                $(obj).children("#value").removeClass("hide");
	    			$(obj).children("#proc").addClass("hide");
	            },
	            success: function() {
	            	$(obj).closest("tr").remove();
	            	$("#misPref").append("<tr><td>"+ html +"</td></tr>")
	            }
	        });
   }
}
		