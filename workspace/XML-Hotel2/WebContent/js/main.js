jQuery(document).ready(function(){
	
	//jUtils.hiding("divtemas", false);
	
	$("[name=area]").click(function() {
		jMain.buscar($(this));
	});
	

	$("a[name=eliminar]").click(function() {
		jMain.eliminar($(this));
	});

	$("a[name=editar]").click(function() {
		jMain.editar($(this).closest("tr").find("input[name=cod_tipo_documento]").val());
	});
	
	$("[name=guardar]").click(function() {
		jMain.guardar();
	});

}); 
var jMain = {
		
		buscar: function(obj) {
			
			jUtils.executing("divgrupos");
			var codigo = $(obj).val();
			$.ajax({
				url: "./BuscarGrupos.jsp",
				type: "post",
				datatype: "html",
				//data: $.param($("[name=area]:selected", $("#form"))),
				data: $.param({"area": codigo}),
	            error: function(hr){
	                jUtils.showing("error", hr.responseText);
	            },
	            success: function(html) {
	            	jUtils.hiding("error", false);
	              jUtils.showing("divgrupos", html);
	            }
			});
		},
		
		guardar: function() {
	        if($.trim($("input[name=coda]").val()) == "") {
	            alert("Debe informar codigo de area");
	            $("input[name=coda]").focus();
	            return false;
	        }
	        
	        if($.trim($("input[name=nrog]").val()) == "") {
	            alert("Debe informar el numero de grupo");
	            $("input[name=servicio]").focus();
	            return false;
	        }
	        
	        if($.trim($("input[name=nomg]").val()) == "") {
	            alert("Debe informar el nombre del grupo");
	            $("select[name=tema]").focus();
	            return false;
	        }
	        	
			$.ajax({
				url: "./GuardarGrupo.jsp",
				type: "post",
				data: $.param($("input[name=coda],input[name=nrog],input[name=nomg],input[name=vig]", $("#form"))),
				datatype: "html",		
				error: function(hr) {
					jUtils.showing("error2", hr.responseText);
				},
				success: function(html) {
					//$(location).attr("href", "./index.jsp");
				}
			});
		}



			
};