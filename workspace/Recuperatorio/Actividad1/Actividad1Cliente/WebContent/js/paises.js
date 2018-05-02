var jPaises = {
	getPaises: function() {
		jUtils.executing("paises");

		$.ajax({
            url: "./paises.jsp",
            type: "get",
            dataType: "html",
            error: function(hr){
                jUtils.hiding("paises");
                jUtils.showing("message", hr.responseText);
            },
            success: function(html) {
                jUtils.showing("paises", html);
            }
        });
	},
	
	getProvincias: function() {
		if($.trim($("select[name=cod_pais]").val()) == "") {
            jUtils.hiding("provincias");
		}
		else {
	        jUtils.executing("provincias");
	        $.ajax({
	            url: "http://localhost:8080/Actividad1Rest/rest/provincias/getProvincias",
	            type: "post",
	            dataType: "json",
	            data: $.param($("select", $("#form"))),
	            error: function(hr){
	                jUtils.hiding("provincias");
	                jUtils.showing("message", hr.responseText);
	            },
	            success: function( json ) {
	            	$('#provincias').empty();
                	$('#provincias').append($('<select name=\"cod_provincia\" id=\"cod_provincia\">'));
                	$('#cod_provincia').append($('<option value=\"\">Debe seleccionar una provincia</option>'));
	                $.each(json, function(i, obj) {
                    	$('#cod_provincia').append($('<option>').text(obj.nomProvincia).attr('value', obj.codProvincia));
	                });
	                $('#provincias').append($('</select>'));
	            }
	        });
		}
	}	
};
