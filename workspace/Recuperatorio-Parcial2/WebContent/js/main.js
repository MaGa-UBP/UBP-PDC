jQuery(document).ready(function(){
	
	jUtils.hiding("divbotones", false);
	

	$("[name=guardar]").click(function() {
		jMain.guardar();
	});

});
var jRecu= {
	
		buscar : function(obj){
			
			jUtils.executing("divtareas");
			if($(obj).val()!=-1){
				$.ajax({
					url: "./BuscarTareas.jsp",
					dataType: "html",
					type: "post",
					data: $.param($("select[name=proceso]", $("#form"))),
					error: function(hr){
						jUtils.hiding("resultados");
						jUtils.showing("error", hr.responseText);
					},
					success: function(html) {
						jUtils.showing("divtareas", html);
						jUtils.showing("divbotones");
					}
				});
			}
			else{
				jUtils.hiding("divtareas");
			}
		},
		guardar: function() {
			
			if($("input[type=checkbox]:checked").length == 0) {
				alert("Debe seleccionar alguna tarea");
				$("input[name=tareasel]:first").focus();
				return false;
			}
	        
			//jUtils.executing("mensaje");
			//var seleccionados = $("input[type=checkbox]:checked").find
			//var seleccionadas = $("input[type=checkbox]:checked").closest("td").find("input[name=nro_tarea]").val();
			$.ajax({
				url: "./GuardarTarea.jsp",
				type: "post",
				data: $.param($("select[name=proceso],input[type=checkbox]:checked", $("#form"))),
				datatype: "html",		
				error: function(hr) {
					jUtils.showing("error", hr.responseText);
				},
				success: function(html) {
					$(location).attr("href", "./index.jsp");
				}
			});
		},
		cancelar: function(){
			$(location).attr("href", "./index.jsp");
		}
};