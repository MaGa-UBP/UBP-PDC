jQuery(document).ready(function(){
	
	jRecursos.alternarColores();
	
	$("input[name=vigente]").click(function() {
		if($("input[name=vigente]").val()=="S"){
			$(this).val("N");
			jRecursos.habilitar($(this).closest("tr"));
			$(this).attr("value","N");
		}
		else{
			jRecursos.deshabilitar($(this).closest("tr"));
			//$(this).val("S");
			$(this).attr("value","S");
		}
	});


}); 
var jRecursos = {
		
	getPropietarios: function(obj, index) {
		jUtils.executing("prop_" + index);		
		
		$.ajax({
			url: "./propietarios.jsp",
			type: "post",
			datatype: "html",
			data: $.param({ "tipo_propietario" : $(obj).val() }),
			error: function(hr) {
				jUtils.showing("prop_" + index, hr.responseText);		
			},
			success: function(html) {
				jUtils.showing("prop_" + index, html);		
			}			
		});
	},	
	alternarColores: function(){
		$(function() {
			$("tr:even").css("background-color", "#FFFFCC"); 
		});
		$(function() {
			$("tr:odd").css("background-color", "##FFFF4D");
		});
	},
	//.find("input[name=cod_tipo_documento]").val()	
	habilitar: function(obj){
		$(obj).find("input[name=desc_recurso]").attr("disabled", true);
		$(obj).find("select[name=tipo_propietario]").attr("disabled", true);
		$(obj).find("input[type=radio]").attr("disabled", true);
		$(obj).find("[name=propietario]").attr("disabled", true);
		
	},
	deshabilitar: function(obj){
		$(obj).find("input[name=desc_recurso]").attr("disabled", false);
		$(obj).find("select[name=tipo_propietario]").attr("disabled", false);
		$(obj).find("input[type=radio]").attr("disabled", false);
		$(obj).find("[name=propietario]").attr("disabled", false);
		
	}
};