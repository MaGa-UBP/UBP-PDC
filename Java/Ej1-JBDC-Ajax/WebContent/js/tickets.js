var jTickets = {
		buscar: function(){
			$("#result").html("<p>Procesando...</p>");
			$.ajax({
				url: "./tickets.jsp",
				type: "post",
				dataType: "html",
				data: $("#form").serialize(),
				error: function(hr){
					$("#message").html(hr.responseText);
					$("#result").empty();
				},
				success: function(html){
					console.log(html);
					$("#result").html(html);
				}
			});
		},
		registrar: function(e){
			e.preventDefault();
			$("#ticket_form").hide();
			$("#executing").html("<p>Procesando...</p>");
			$.ajax({
				url: "./registrarTicket.jsp",
				type: "post",
				dataType: "html",
				data: $("#ticket_form").serialize(),
				error: function(hr){
					$("#message").html(hr.responseText);
					$("#ticket_form").show();
					$("#executing").hide();
				},
				success: function(html){
					window.location.href="index.jsp";
				}
			})
		}
}