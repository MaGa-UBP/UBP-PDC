jQuery(document).ready(function(){
	
	$("a[name=eliminar]").click(function() {
		jTiposDoc.eliminar($(this));
	});

}); 
var jMain = {
		
		buscarCertif: function(obj) {
			
			jUtils.executing("divcertificados");
			var codigo = $(obj).val();
			$.ajax({
				url: "./BuscarTiposCertificados.jsp",
				type: "post",
				datatype: "html",
				data: $.param($("[name=cod_grupo]:checked", $("#form"))),
				error: function(hr){
	                jUtils.showing("error", hr.responseText);
	            },
	            success: function(html) {
	            	jUtils.hiding("error", false);
	              jUtils.showing("divcertificados", html);
	            }
			});
		},
		eliminar: function(obj) {
			jUtils.executing("aux");
			jUtils.hiding("divcertificados", false);
			
			var num = $(obj).closest("tr").find("input[name=numeroC]").val();
			var cg = $("[name=cod_grupo]:checked").val();
			$.ajax({
				url: "./EliminarCertificado.jsp",
				type: "post",
				data: $.param({"numeroC": num, "cod_grupo": cg}),
				datatype: "html",
				error: function(hr) {
					jUtils.showing("aux", hr.responseText);
					jUtils.showing("divcertificados");
				},
				success: function(html) {
					jUtils.hiding("aux");
					jUtils.showing("divcertificados");
					$(obj).closest("tr").remove();
				}
			});		
		},
		
		guardar: function() {
			$("#form").submit();
			//$(location).attr("href", "./EliminarCertificado.jsp");
			
		},
		cancelar: function(){
			$(location).attr("href", "./index.jsp");
		}


			
};