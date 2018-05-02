$( document ).ready(function() {
	// Controlo la prioridad y habilito/deshabilito el option y el mail en los casos que sea necesarios
	$('#iPrioridad').on('change', function(){
		if($(this).val() == "Alta"){
			$("#iNotificacionS").prop("checked", "checked");
			$("input[name=notif]").prop("disabled", "true");
			$("#iEmail").removeAttr("disabled");
		}else{
			$("input[name=notif]").removeAttr("disabled");
		}
	});
	
	//Controlo option y habilito/deshabilito el campo de mail 
	$('input[name=notif]').on('change', function(){
		if($(this).val() == "N"){
			$("#iEmail").prop("disabled", "true");
			$("#formAgenda").append("<input type=\"hidden\" name=\"email\" value=\" \" id=\"emailAlt\">")
		}else{
			$("#iEmail").removeAttr("disabled");
			$("#emailAlt").remove();
		}
	});
	
	
	// Vuelvo a habilitar el mail y el option si reseteo
	$('#formAgenda').on('reset', function(){
		$("#iEmail").removeAttr("disabled");
		$("input[name=notif]").removeAttr("disabled");
	});
	
	// Controlo Recuperar y Descartar
	$('.btnDescartar').on('click', function(){
		var posDescartar = $(this).closest("tr").find('.numero').html()-1;
		if($(this).html() == "Recuperar"){
			$(this).html("Descartar");
			$("#descartar_"+posDescartar).val("false");
			//$(this).closest("tr").removeClass("recuperar");
		}else{
			$(this).html("Recuperar");
			$("#descartar_"+posDescartar).val("true");
			//$(this).closest("tr").addlass("recuperar");
		}
		$(this).closest("tr").toggleClass("recuperar");
		
	});
	
});
