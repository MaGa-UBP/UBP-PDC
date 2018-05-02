var email = ""

$(document).ready(function(){
	$("#txt-email").focus();
	$("#rb-id-s").click(function(){
		jUtils.showing("div-email");
		$("#txt-email").val(email);
		$("#txt-email").focus();
	});
	$("#rb-id-n").click(function(){
		jUtils.hiding("div-email", false);
		email = $("#txt-email").val(); 
		$("#txt-email").val("");
	});
	$("#but-save").click(function(){
		if($("#rb-id-n:checked").val() == undefined && $("#txt-email").val()==""){
			alert("Debe informar el mail");
			$("#txt-email").focus();
			return;
		}
		if( $("#sel-serv").val()==null){
			alert("Debe seleccionar un servicio");
			$("#sel-serv").focus();
			return;
		}
		if($("#txta-sugg").val()==""){
			alert("El texto de la sugerencia no puede estar vacio");
			$("#txta-sugg").focus();
			return;
		}
		
		jUtils.executing("div-message");
		jUtils.hiding("div-main", false);
		sugg.guardarSug();
	});
	
	$("#sel-serv").change(function(){
		jUtils.executing("div-temas");
        $.ajax({
            url: "./getTemasServicio.jsp",
            type: "post",
            dataType: "html",
            data: $.param($("#sel-serv")),
            error: function(hr){
                jUtils.showing("div-error", hr.responseText);
            },
            success: function(html) {
                jUtils.showing("div-temas", html);
            }
        });	
	});
});

sugg = {
	guardarSug:function(){
        $.ajax({
            url: "./guardarSugerencia.jsp",
            type: "post",
            dataType: "html",
            data: $.param($("input[type=text]:enabled, input[type=radio]:checked, #txta-sugg, select")),
            error: function(hr){
                jUtils.showing("div-main");
                jUtils.showing("div-error", hr.responseText)
                jUtils.hiding("div-message")
            },
            success: function(html) {
            	jUtils.hiding("div-message")
                alert("Gracias por su sugerencia (^.^)")
                $(location).attr("href", "./index.jsp");
            }
        });
	}
		
}