var jFormulario = {
		hideEmail : function (){
			$("#iEmail").val("")
			$("#dEmail").hide()
		},
		
		showEmail : function (){
			$("#dEmail").show()
		},
		
		traerTemas : function() {
			
			$.ajax({
			    url: "./getListaTemas.jsp",
			    type: "post",
			    dataType: "html",
			    data: "codigo="+ $("#serviciosSelect").val(),
			    error: function(hr){
			        jUtils.hiding("temas");
			        jUtils.showing("error", hr.responseText);
			    },
			    success: function(html) {
			        jUtils.hiding("error");
			        jUtils.showing("temas", html);
			    }
			});
		},
		
		guardar : function () {
			if(!this.validFields()){
				return
			}
				
			$.ajax({
			    url: "./guardar.jsp",
			    type: "post",
			    dataType: "html",
			    data: {
			    	cod_tipo_servicio: $("#serviciosSelect").val(),
			    	nro_tema: $("#listaTemas").val(),
			    	e_mail: $("#iEmail").val(),
			    	sugerencia: $("#comentario").val()
			    },
			    error: function(hr){
			        jUtils.hiding("contenido");
			        jUtils.showing("error", hr.responseText);
			    },
			    success: function(html) {
			    	alert("Insercion realizada con exito")
			    	window.location.href = "index.jsp";
			    }
			});
			
		}, 
		
		validFields : function(){
			if($("input[type=radio]").is("checked") != false){
				alert("Debes identificarte")
				return false
			}
			if($.trim($("#iEmail").val()) == ""){
				alert("Debes dar un email valido")
				return false
			}
			if($("#serviciosSelect").val() == "Debe seleccionar un servicio"){
				alert("Debes seleccionar un servicio")
				return false
			}
			if($.trim($("#comentario").val()) == ""){
				alert("Debes dejar un comentario")
				return false
			}
			return true
		},
		
		cancelar : function () {
			window.location.href = "index.jsp"
		}, 
}


jQuery(document).ready(function() {
	 $("input:visible:enabled:first").focus();
});