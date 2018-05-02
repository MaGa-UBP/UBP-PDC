var jTicketsf = {
	
		buscar : function(){
			jUtils.executing("resultados");
			$.ajax({
	            url: "./tablaTickets.jsp",
	            dataType: "html",
	            type: "post",
	            data: $.param($("input[type=text],input[type=radio]:checked", $("#form"))),
	            error: function(hr){
	                jUtils.hiding("resultados");
	                jUtils.showing("message", hr.responseText);
	            },
	            success: function(html) {
	                jUtils.showing("resultados", html);
	            }
	        });
			
		}
};