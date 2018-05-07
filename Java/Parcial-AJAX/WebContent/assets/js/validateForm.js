$( document ).ready(function() {
	$('#iPrioridad').on('change', function(){
		if($(this).val() == "Alta"){
			$("#iNotificacionS").prop("checked", "checked");
			$("input[name=notif]").prop("disabled", "true");
			$("#iEmail").removeAttr("disabled");
		}else{
			$("input[name=notif]").removeAttr("disabled");
		}
	});
	
	$('input[name=notif]').on('change', function(){
		if($(this).val() == "N"){
			$("#iEmail").prop("disabled", "true");
			$("#iEmail").val("");
		}else{
			$("#iEmail").removeAttr("disabled");
		}
	});
	
	// Vuelvo a habilitar el mail y el option si reseteo
	$('#formAgenda').on('reset', function(){
		$("#iEmail").removeAttr("disabled");
		$("input[name=notif]").removeAttr("disabled");
	});
	
	var index = 0;
	
	
	$('#formAgenda').on('submit', function(e){
		e.preventDefault();
		index++;
		$('.table.hidden').removeClass('hidden');
		$.ajax({
			url: "resultado.jsp",
			type: "post",
			dataType: "html",
			data:$("#formAgenda").serialize() + "&index=" + index, 
			error: function(hr){
				$("#results").html("<p>"+hr.responseText+"</p>");
			},
			success: function(html){
				$("#resultsTable").append(html);
				$('#formAgenda')[0].reset();
			}
		});
	});
});
