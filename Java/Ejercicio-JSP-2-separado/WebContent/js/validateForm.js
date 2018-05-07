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
			e.preventDefault();
			$("#prodeForm").hide();
			$("#results").html("<p>Procesando...</p>");
			
			$.ajax({
				url: "resultado.jsp",
				type: "post",
				dataType: "html",
				data:$.param($("input[type=checkbox]:checked"), $("#prodeForm")), //Buscamos los input number de la pagina.
				error: function(hr){
					$("#results").html("<p>"+hr.responseText+"</p>");
				},
				success: function(html){
					$("#prodeForm").show();
					$("#results").html(html);
				}
			});
			
			$('#submit').addClass('hidden');
			$('#reset').removeClass('hidden');
		}
	});
	
	 $('input[type="checkbox"]').change(function () {
         var row = $(this).closest('.filaPartido');
         var thisCb = $(this);
         var checked = $(this).is(':checked');
         $(row).find('input[type="checkbox"]').each(function() {
        	    $(this).prop('checked',false);
         });
 	    if(checked) {
	        $(this).prop('checked',true);
	    }
     });
	 
	$('#reset').click(function(){
		window.location = window.location.pathname;
	});

});


