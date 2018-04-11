$(document).ready(function(){
	$('#jugadaForm').on('submit',function(e){
		$opcion = $(this).find("[name=opcion]").filter(":selected").val();;
		console.log($opcion);
		if($opcion==="-1"){
			// Mostrar error
			e.preventDefault();
		}else{
			e.preventDefault();
		}
	});
});