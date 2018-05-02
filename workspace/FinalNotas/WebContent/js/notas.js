jQuery(document).ready(function(){
	
	jNotas.buscarNotas();
//	$("a[name=borrar]").click(function() {
//		jNotas.borrar($(this));
//	});
	
}); 
var jNotas = {

	cantMaxCAct: 0,

	valid: function() {
		if($.trim($("#inota").val()) == "") {
			alert("La nota esta vacia");
			$("#inota").focus();
			return false;
		}
		$("#form").submit();
		//$(location).attr("href", "./GuardarNota.jsp");
	},

	validActLen: function(txtA) {
		$("#icact").html($(txtA).val().length++);
		if($(txtA).val().length > this.cantMaxCAct) {
  			$(txtA).val($(txtA).val().substring(0, this.cantMaxCAct));
		}
	},

	setActLen: function(carac) {
		this.cantMaxCAct = $("#inota").attr("maxlength") != undefined ? $("#inota").attr("maxlength") : carac;
		$("#icact").html("0");
	},

	cancelar: function() {
		$("#inota").val("");
		$("#icact").html("0");
	},
	buscarNotas: function() {
		jUtils.executing("divnotas");		
		
		$.ajax({
			url: "./BuscarNotas.jsp",
			type: "get",
			datatype: "html",
			//data: $.param({ "tipo_propietario" : $(obj).val() }),
			error: function(hr) {
				jUtils.showing("divnotas", hr.responseText);		
			},
			success: function(html) {
				jUtils.showing("divnotas", html);		
			}			
		});
	},
	mensaje: function(){
		alert("no se pueden guardar mas de 4 notas por sesion");
	},
	borrar: function(obj){
		jUtils.executing("aux");
		//jUtils.hiding("divnotas", false);
		
		var anot = $(obj).closest("h4").find("input[name=anoNota]").val();
		var nrot = $(obj).closest("h4").find("input[name=nroNota]").val();
		$.ajax({
			url: "./EliminarNota.jsp",
			type: "post",
			data: $.param({"anoNota": anot,"nroNota": nrot}),
			datatype: "html",
			error: function(hr) {
				jUtils.showing("aux", hr);
				jUtils.showing("divnotas");
			},
			success: function(html) {
				jUtils.hiding("aux");
				jUtils.showing("divnotas");
				$(obj).closest("h4").remove();
			}
		});	
	}
	

};