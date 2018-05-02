/**
 * 
 */

jQuery(document).ready(function() {
    $("input:visible:enabled:first").focus();
});

var jForm = {

	valid: function(evt) {
		

		$("#formAgenda").submit();
	},

	selPrioridad: function(selObj) {
		if($(selObj).val() == "A") {
			$("#inotificarsi").val("S");
			$("#inotificarsi").prop("disabled", true);
			$("#inotificarno").prop("disabled", true);
		}
		else {
			$("#inotificarsi").prop("disabled", false);
			$("#inotificarno").prop("disabled", false);
		}
	},
	
	selNotificar: function(selObj) {
		if($(selObj).val() == "N") {
			$("#iemail").prop("disabled", true);
			$("#iemail").val("");
		}
		else {
			$("#iemail").prop("disabled", false);
			$("#iemail").val("");
		}
	},
	
	click: function(evt) {
		confirm("Esta seguro que quiere descartar?");
	}
	
	

};

