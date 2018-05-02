var jFactorial = {
	calcular: function() {
		jUtils.hiding("message");

		if($.trim($("#nro").val()) == "") {
			alert("Debe informar un valor");
			$("#nro").focus();
			return false;
		}
		if(isNaN($("#nro").val())) {
			alert("El valor informado debe ser numérico");
			$("#nro").focus();
			return false;
		}

		jUtils.executing("result");

		$.ajax({
            url: "./factorial.jsp",
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
