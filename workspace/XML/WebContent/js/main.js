var jVuelos = {
		buscar: function() {
		    if($.trim($("input[name=cantPasajeros][type=text]").val()) == "")  {
		        alert("Debe informar la cantidad de pasajeros");
		        $("input[name=cantPasajeros][type=text]").focus();
		        return false;
		    }
		    
		    if($.trim($("input[name=fechaDesde][type=text]").val()) == "")  {
		        alert("Debe informar la fechaDesde");
		        $("input[name=fechaDesde][type=text]").focus();
		        return false;
		    }
		    
		    if($.trim($("input[name=fechaHasta][type=text]").val()) == "")  {
		        alert("Debe informar la fechaHasta");
		        $("input[name=fechaHasta][type=text]").focus();
		        return false;
		    }
		    
		    if($("select[name=origen]").val()==$("select[name=destino]").val()){
		        alert("Origen y destino no pueden ser iguales");
		        return false;
		    }
		    
		    
		    
		    this.ajaxProcesar();
		    return true;
		  },
		  
		  /*
		  ajaxProcesar: function(){
				jUtils.executing( "resultados" );
				
				$.ajax( {
					url: "./busquedaTickets.jsp",
					dataType: "html",
					type: "post",
					data:  
						$.param( $( "input[name=busqueda], input[name=ordenar]:checked", $( "#form" ) ) ),
					error: function( hr ){ alert( "Error" + hr.responseText ); },
					success: function( html ){
						
						console.log("Parametros1!! "+ $.param( $( "input[type=text], input[name=ordPor]:checked", $( "#formulario" ) ) ));
						jUtils.showing("resultados",html);
					}
				});
			}
			*/
}