
jQuery(document).ready(function(){
	
	jUtils.hiding("divfecha", false);
	jUtils.hiding("divsedes", false);
	jUtils.hiding("divbotones", false);
	$("#conf").click(function() {
		jUtils.hiding("divfechas", false);
		jUtils.showing("divfecha");
		$("input[name=fechas1]").val("");
		$("input[name=fechas2]").val("");
	});
	$("#prev").click(function() {
		jUtils.hiding("divfecha", false);
		jUtils.showing("divfechas");
		$("input[name=fecha]").val("");
	});
	
	jMain.getSedes();
	
	$("#todas").click(function() {
		jMain.seleccionarTodas();
	});
	$("#ultimas").click(function() {
		jMain.seleccionarUltimas();
	});
	

}); 
var jMain = {
		
	getSedes: function() {
		jUtils.executing("divsedes");		
		
		$.ajax({
			url: "./GetSedes.jsp",
			type: "post",
			datatype: "html",
			error: function(hr) {
				jUtils.showing("divsedes",hr);		
			},
			success: function(html) {
				jUtils.showing("divsedes",html);
				jUtils.showing("divbotones");
			}			
		});
	},	
	guardar: function() {
        if(($("#prev").is(':checked'))&&(($.trim($("input[name=fechas1]").val()) == "")||($.trim($("input[name=fechas2]").val()) == ""))) {
            alert("Debe informar el rango de fechas");
            $("input[name=fechas1]").focus();
            return false;
        }
        
        if(($("#conf").is(':checked'))&&($.trim($("input[name=fecha]").val()) == "")) {
            alert("Debe informar la fecha");
            $("input[name=fecha]").focus();
            return false;
        }
        
		if($("input[name=seleccionadas]:checked").length == 0) {
			alert("Debe informar al menos una sede");
			$("input[name=seleccionadas]:first").focus();
			return false;
		}
        	
		$.ajax({
			url: "./GuardarFecha.jsp",
			type: "post",
			data: $.param($("input[type=text],input[name=seleccionadas]:checked,[name=carreras]", $("#form"))),
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
	},
	
	seleccionarTodas: function(){
		$("input[name=seleccionadas]").attr('checked',true);
	},
	seleccionarUltimas: function(){
		$("input[name=ult]").val("si");
		$.ajax({
			url: "./GetSedes.jsp",
			type: "post",
			datatype: "html",	
			data: $.param($("input[name=ult]", $("#form"))),
			error: function(hr) {
				jUtils.showing("response");
				jUtils.showing("aux", hr.responseText);
			},
			success: function(html) {
				jUtils.showing("divsedes",html);
			}
		});
	}
};