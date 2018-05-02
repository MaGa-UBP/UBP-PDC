var jBlog ={
	
		enviar: function(tema){
			$("#tema_elegido").val(tema);
			$("#form").submit();
		},
		
		publicar: function(){

			if($.trim($("#autor").val()) == "") { 
				alert("Verifique el campo autor");
					$("#autor").focus();
					return false;
			}
			if($.trim($("#emailAutor").val()) == "") { 
				alert("Debe informar el email");
					$("#emailAutor").focus();
					return false;
			}
			if($.trim($("#textoMensaje").val()) == "") { 
				alert("El campo comentario está vacío");
					$("#textoMensaje").focus();
					return false;
			}
			
			if ($("#recordar").attr("checked", "true")){
				//$("#autor").autocomplete("enabled");
				$("#autor").val($("#autor").val);
			}
			
			$("#comentarios").submit();
			return true;
		},
};