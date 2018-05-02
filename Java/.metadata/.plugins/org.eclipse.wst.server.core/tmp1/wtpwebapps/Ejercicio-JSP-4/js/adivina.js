$( document ).ready(function() {
	$('.optionSelect').on('click', function(){
		if(!$(this).hasClass('correct')){
			if($(this).hasClass('selected')){
				$(this).removeClass('selected');
				$('#celdaSeleccionada').val('-1');
			}else{
				$('.optionSelect').removeClass('selected');
				$(this).addClass('selected');
				$('#celdaSeleccionada').val($(this).data("value"));
			}
		}else{
			alert("Esta celda ya fue seleccionada!");
		}
		
	});
	$('#formJuego').on('submit', function(e){
		if($('#celdaSeleccionada').val()=="-1"){
			e.preventDefault();
			alert("Debe seleccionar una casilla");
		}
		if($('#respuestaNumero').val() == ''){
			e.preventDefault();
			alert("Debe ingresar un valor");
		}
		if(!$.isNumeric($('#respuestaNumero').val())){
			e.preventDefault();
			alert("El valor debe ser un número");
		}
	});
	
});
