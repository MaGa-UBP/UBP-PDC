/**
 * 
 */
var parcial = {
	calcular: function() {
		jUtils.hiding("message");

		

		jUtils.executing("result");

		$.ajax({
            url: "./ParcialServlet",
            type: "post",
            dataType: "html",
            data: $.param($("input[type=text]", $("#factorial"))),
            error: function(hr){
                jUtils.showing("message", hr.responseText);
        		jUtils.hiding("result");
            },
            success: function(html) {
        		jUtils.showing("result", html);
            }
        });
	}
};