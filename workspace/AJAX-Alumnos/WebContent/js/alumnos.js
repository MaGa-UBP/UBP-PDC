var jAlumnos = {
		
	getAlumnos: function() {
		jUtils.executing("result");
		$.ajax({
			url: "./alumnos.jsp",
			type: "post",
			dataType: "html",
			data: $.param($("select", $("#form"))),
			error: function(hr) {
				jUtils.hiding("result");
				jUtils.showing("message", hr.responseText);
			},
			success: function(html) {
				jUtils.showing("result", html);
			}		
		});
	}	
		
};