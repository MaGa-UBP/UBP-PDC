$(document).ready(function(){
	$('#prodeForm').on('submit',function(e){
		var error = false;
		$(this).find(".filaPartido").each(function(){
			var cant = $(this).find('input:checked').length;
			$(this).removeClass('has-error');
			if(cant>1){
				$(this).addClass('has-error');
				e.preventDefault();
				error=true;
			}else if(cant<1){
				$(this).addClass('has-error');
				e.preventDefault();
				error=true;
			}
		});
		if(!error){
			$('#submit').addClass('hidden');
			$('#reset').removeClass('hidden');
		}
	});
	$('#reset').click(function(){
		window.location = window.location.pathname;
	});
	
});


