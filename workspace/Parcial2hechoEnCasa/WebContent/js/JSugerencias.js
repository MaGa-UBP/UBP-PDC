jQuery(document).ready(function(){
	
	$("#iemail").focus();
	
	$("#iidentificaN").click(function() {
		jUtils.hiding("divemail", false);
	});
	
	$("#iidentificaS").click(function() {
		jUtils.showing("divemail");
	});
	
	jUtils.hiding("divtemas", false);

}); 

var jSugerencias = {
		
	buscarTemas: function(objSelec){
		jUtils.executing("divtemas");
		$.ajax({
			url: "./temas.jsp",
			type: "post",
			datatype: "html",
			data: $.param($("select[name=servicio]", $("#form"))),
			error: function(hr) {
				jUtils.showing("divtemas", hr.responseText);
				jUtils.showing("main");
			},
			success: function(html) {
				jUtils.showing("divtemas", html);
			}
		});
	},
	
	guardar: function() {
        if(($.trim($("input[name=email]").val()) == "")&&(($("#iidentificaS").is(':checked')))) {
            alert("Debe informar e-mail");
            $("input[name=email]").focus();
            return false;
        }
        
        if($.trim($("select[name=servicio]").val()) == "") {
            alert("Debe informar un servicio");
            $("input[name=servicio]").focus();
            return false;
        }
        
        if($.trim($("select[name=tema]").val()) == "") {
            alert("Debe informar un tema");
            $("select[name=tema]").focus();
            return false;
        }
        if($.trim($("textarea[name=sugerencias]").val()) == "") {
            alert("Debe escribir una sugerencia");
            $("input[name=sugerencias]").focus();
            return false;
        }
        	
		$.ajax({
			url: "./GuardarSugerencia.jsp",
			type: "post",
			data: $.param($("input[name=email],select[name=servicio],select[name=tema],textarea[name=sugerencias],input[name=identifica]:checked", $("#form"))),
			datatype: "html",		
			error: function(hr) {
				jUtils.showing("response");
				jUtils.showing("aux", hr.responseText);
			},
			success: function(html) {
				$(location).attr("href", "./index.jsp");
			}
		});
	},
	cancelar: function(){
		$(location).attr("href", "./index.jsp");
	}
}