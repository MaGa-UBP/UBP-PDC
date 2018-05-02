var jProgAc = {
	
	insertar : function() {
		if($("input[type=text][name=cod_categoria]").val()==""){
			alert("Debe informar el codigo de la categoria");
			return;
		}
		if($("input[type=text][name=desc_categoria]").val()==""){
			alert("Debe informar una descripcion para la categoria");
			return;
		}
        jUtils.executing("error");
        $.ajax({
            url: "./ins-prog-acad.jsp",
            type: "post",
            dataType: "html",
            data: $.param($("input[type=text]", $("#form"))),
            error: function(hr){
                jUtils.showing("error", hr.responseText);
            },
            success: function(html) {
            	window.location.href="/ProgAcadClient"
            }
        });		
	},

	borrar: function(obj) {
		jUtils.executing("error");
		cod_cat = $(obj).attr("id");
		$.ajax({
			url: "http://localhost:8080/ProgAcadRestful/rest/progacad?cod_categoria="+cod_cat,
	        type: "delete",
	        dataType: "html",
	        error: function(hr){
	            jUtils.showing("error", hr.responseText);
	        },
	        success: function(html) {
	        	jUtils.showing("main");
	        	jUtils.hiding("error")
	    		$(obj).closest("tr").hide();
	        }
	    });		
	}
			
};