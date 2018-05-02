var jFeriados = {
	getAñosFeriados: function() {
		jUtils.executing("feriados");

		$.ajax({
            url: "http://localhost:8080/Actividad3Rest/rest/feriados/getAñosFeriados",
            type: "get",
            dataType: "json",
            error: function(hr){
                jUtils.hiding("feriados");
                jUtils.showing("message", hr.responseText);
            },
            success: function(json) {
                $('#feriados').empty();
                $('#feriados').append('<select id=\"ano\" name=\"ano\" onchange=\"jFeriados.getFeriados()\">');
                $('#ano').append('<option value=\"\"> Debe seleccionar un año</option>');
                $.each(json, function(i, obj) {
                	$('#ano').append($('<option class=\"'+obj.año+'\">').text(obj.año).attr('value', obj.año));
                	$('.' + obj.año).prop('selected', obj.actual == "S" ? true : false);
                });
                $('#feriados').append('</select>');
                jFeriados.getFeriados();
            }
        });
	},
	
	getFeriados: function()
	{
		if($.trim($("select[name=ano]").val()) == "") 
            jUtils.hiding("feriadosTable");
		else 
		{
			jUtils.executing("feriadosTable");
			
			$.ajax(
			{
				url: "./feriados.jsp",
				type: "post",
				dataType: "html",
				data:{ ano: $("select[name=ano]").val() },
				error: function(hr){
	                jUtils.hiding("feriadosTable");
	                jUtils.showing("message", hr.responseText);
	            },
	            success: function(html) {
	            	jUtils.showing("feriadosTable", html);
	            }
			});
		}
	}
};
