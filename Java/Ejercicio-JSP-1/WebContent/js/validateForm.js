$(document).ready(function(){
	$('#jugadaForm').on('submit',function(e){
		$opcion = $(this).find("[name=opcion]").val();
		if($opcion==="-1"){
			$("#errorSelect").removeClass('hide');
			e.preventDefault();
		}else{
			$("#errorSelect").addClass('hide');
			//e.preventDefault();
		}
	});
	$('#volverJugar').click(function(){
		window.location = window.location.pathname;
	});
});

