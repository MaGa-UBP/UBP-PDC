jQuery(document).ready(function() {
    $("input:visible:enabled:first").focus();
});

var jForm = {

	cantMaxCAct: 0,

	valid: function() {
		if($.trim($("#iapellido").val()) == "") {
			alert("Debe informar su apellido");
			$("#iapellido").focus();
			return false;
		}

		if($.trim($("#inombre").val()) == "") {
			alert("Debe informar su nombre");
			$("#inombre").focus();
			return false;
		}

		if($.trim($("#iclave").val()) == "") {
			alert("Debe informar su clave");
			$("#iclave").focus();
			return false;
		}
		else if($("#iclave").val().length < 6) {
			alert("La clave debe contener al menos 6 caracteres");
			$("#iclave").focus();
			return false;
		}

		if($.trim($("#iconfirmar_clave").val()) == "") {
			alert("Debe repetir su clave");
			$("#iconfirmar_clave").focus();
			return false;
		}

		if($("#iclave").val() != $("#iconfirmar_clave").val()) {
			alert("Las claves no coinciden");
			$("#iclave").focus();
			return false;
		}

		if($.trim($("#inacionalidad").val()) == "") {
			alert("Debe informar su nacionalidad");
			$("#inacionalidad").focus();
			return false;
		}

		if($("#inacionalidad").val() == "-1" && $.trim($("#iotranac").val()) == "") {
			alert("Debe informar la otra nacionalidad");
			$("#iotranac").focus();
			return false;
		}

		if($("#iequipo :selected").length > 2) {
			alert("Debe informar hasta dos equipos");
			$("#iequipo").focus();
			return false;
		}

		if($("input[name=hobbies]:checked").length == 0) {
			alert("Debe informar al menos un hobby");
			$("input[name=hobbies]:first").focus();
			return false;
		}

		if($.trim($("#iactividades").val()) == "") {
			alert("Debe informar otras actividades");
			$("#iactividades").focus();
			return false;
		}
		
		$("#form").submit();
	},

	validActLen: function(txtA) {
		$("#icact").html(this.cantMaxCAct - $(txtA).val().length);
		if($(txtA).val().length > this.cantMaxCAct) {
  			$(txtA).val($(txtA).val().substring(0, this.cantMaxCAct));
		}
	},

	setActLen: function() {
		this.cantMaxCAct = $("#iactividades").attr("maxlength") != undefined ? $("#iactividades").attr("maxlength") : 300;
		$("#icact").html(this.cantMaxCAct);
	},

	selNacionalidad: function(selObj) {
		if($(selObj).val() == "-1") {
			$("#iotranac").prop("disabled", false);
			$("#iotranac").focus();
		}
		else {
			$("#iotranac").prop("disabled", true);
			$("#iotranac").val("");
		}
	}

};


