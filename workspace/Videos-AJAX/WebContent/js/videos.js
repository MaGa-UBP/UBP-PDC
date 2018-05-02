var jVideos = {
	
	buscar: function() {
        jUtils.executing("result");
        $.ajax({
            url: "./buscar.jsp",
            type: "post",
            dataType: "html",
            data: $.param($("input[type=text],input[type=radio]:checked", $("#form"))),
            error: function(hr){
                jUtils.hiding("result");
                jUtils.showing("message", hr.responseText);
            },
            success: function(html) {
                jUtils.showing("result", html);
            }
        });		
	},
	
	ver: function(obj) {
        jUtils.hiding("main", false);
        jUtils.executing("response");
        
        $("#span-" + $(obj).closest("p").find("input[name=nroVideo]").val()).html("[ Visto ]");
        
        $.ajax({
            url: "./ver.jsp",
            type: "post",
            dataType: "html",
            data: $.param($(obj).closest("p").find("input[type=hidden]")),
            error: function(hr){
                jUtils.hiding("response");
                jUtils.showing("main");
                jUtils.showing("message", hr.responseText);
            },
            success: function(html) {
                jUtils.showing("response", html);
            }
        });		
	},
	
	volver: function() {
		jUtils.hiding("response");
        jUtils.showing("main");
	}
		
};