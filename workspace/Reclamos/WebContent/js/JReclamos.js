jQuery(document).ready(function(){
	
	$("input[name=chasis]").keyup(function() {
		jReclamosf.verificar();
	});
	
	jUtils.hiding("mensaje", false);
	
	$("#iconoceN").click(function() {
		jReclamosf.desactivar();
	});
	
	$("#iconoceS").click(function() {
		jReclamosf.activar();
	});
}); 

var jReclamosf = {
	
	desactivar: function(){
	$("#ichasis").attr("disabled", true);	
	},
	activar: function(){
		$("#ichasis").attr("disabled", false);	
	},
	
	registrar: function() {
        if($.trim($("input[name=chasis]").val()) == "") {
            alert("Debe informar el numero de chasis");
            $("input[name=reclamo]").focus();
            return false;
        }
        
        jUtils.hiding("response", false);
		jUtils.executing("mensaje");
		
		$.ajax({
			url: "./RegistrarReclamo.jsp",
			type: "post",
			data: $.param($("textarea[name=reclamo],input[type=text],input[type=text],input[type=radio]:checked,select", $("#form"))),
			datatype: "html",		
			error: function(hr) {
				jUtils.showing("response");
				jUtils.showing("aux", hr.responseText);
			},
			success: function(html) {
				jUtils.hiding("divreclamo", false);
				jUtils.showing("mensaje");
				jUtils.showing("mensaje", html);
			}
		});
	},

	
	
	verificar: function() {
		//jUtils.hiding("main", false);
		jUtils.executing("chasis");
		$.ajax({
			url: "./ValidarChasis.jsp",
			type: "get",
			data: $.param($("input[name=chasis],input[name=patente]", $("#form"))),
			//data: $.param({"chasis": chasis}),
			datatype: "html",
			error: function(hr) {
				jUtils.showing("response", hr.responseText);
				jUtils.showing("main");
			},
			success: function(html) {
				jUtils.showing("divchasis", html);
				
			}
		});
	 },
	volver: function(){
		$(location).attr("href", "./index.jsp");
	}
	
}