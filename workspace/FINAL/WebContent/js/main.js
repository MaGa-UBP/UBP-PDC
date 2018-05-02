jFinal = {
		
		read: function () {
			/*
				if($("select").val().trim()!== ""){
					jUtils.executing("resultados");
			        $.ajax({
			            url: "./busquedaPreferencias.jsp",
			            type: "POST",
			            dataType: "html",
			            data: $.param($("select", $("#form"))),
			            error: function(hr){
			                jUtils.hiding("resultados");
			                jUtils.showing("message", hr.responseText);
			            },
			            success: function(html) {
			            	
			                jUtils.showing("resultados", html);
			            }
			        });
				} else {
					alert("Debe seleccionar una opcion valida");
				}
				*/
				
	   },

   vigencia: function(obj){
	   
	   var input = $(obj).parent().prev().children("input[name='inputDescTema']");
	   var custom = $(obj).parent().prev().prev().children();
	   //var custom = $(obj).closest(":select");
		$(obj).prop("checked",$(obj).prop("checked"));
		input.prop("disabled",!$(obj).prop("checked"));
		custom.prop("disabled",!$(obj).prop("checked"));
   },
   
   guardarTemp: function() {
       /*$("#form").attr("action", "guarTemp.jsp");
       $("#form").submit();*/
       $.ajax({
           url: "./guarTemp.jsp",
           type: "POST",
           dataType: "html",
           data: $.param( $( "input[name=inputDescTema], select[name=listGroup], input[type=checkbox]:checked", $( "#form" ) ) ),
           error: function(hr){
        	   jUtils.showing("message", hr.responseText);
           },
           success: function(html) {
           	
               
           }
       });
   },
   guardar: function() {
	   if(($("input[type=text]").val()!=="").size() != $("tbody tr").size()) {
			alert("Debe indicar todas las descripciones");	
		}
	   else{
	       $.ajax({
	           url: "./guardar.jsp",
	           type: "POST",
	           dataType: "html",
	           data: $.param( $( "input[name=inputDescTema], select[name=listGroup], input[type=checkbox]:checked", $( "#form" ) ) ),
	           error: function(hr){
	        	   jUtils.showing("message", hr.responseText);
	           },
	           success: function(html) {
	           	
	               
	           }
	       });
	   }
   },
}
		