var jLista = {
	traer: function() {

		jUtils.executing("result");
		console.log("trayendo");
		$.ajax({
            url: "./ListaObrasSocialesServlet.jsp",
            type: "post",
            dataType: "html",
            error: function(hr){
                jUtils.showing("lista", hr.responseText);
            },
            success: function(html) {
        		jUtils.showing("lista", html);
        	}
        });
	},
	afiliados: function(obj) {

		jUtils.executing("afiliados");
		console.log("trayendo");
		$.ajax({
            url: "./AfiliadosServlet.jsp",
            type: "post",
            dataType: "html", 
            data: {"obra_social" : $(obj).val()},
            error: function(hr){
                jUtils.showing("afiliados", hr.responseText);
        		
            },
            success: function(json) {
        		jUtils.showing("afiliados", json);
        		console.log(json);
            }
        });
	}
};
