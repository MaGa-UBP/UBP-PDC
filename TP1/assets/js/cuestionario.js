$(document).ready(function(){

	$('#pregunta10').on("change mousemove", function() {
    $('#pregunta10Value').html($(this).val());
	});

	$('#cuestionarioForm').on('submit',function(e){
   	e.preventDefault();

		var nombre = $(this).find('[name=nombre]').val();
		var email = $(this).find('[name=email]').val();
		var edad = $(this).find('[name=edad]').val();

		var formattedBody = "Nombre: "+nombre+"\n";
		formattedBody += "Email: "+email+"\n";
		formattedBody += "Edad: "+edad+"\n\n";

		formattedBody += "Respuestas al cuestionario sobre Islandia: \n\n";

		//Preguntas Simples
		$preg1 = $(this).find('[name=pregunta1]');
		var respuestaPreg1 = $preg1.val();
		formattedBody += "1. ¿Cuál es una de las actividades favoritas de los habitantes de Reykjavik y qué define su modo de vida?\n"
		formattedBody += $("[name=pregunta1] option:selected").text();
		if(respuestaPreg1 === 'c'){
			$preg1.closest('.form-group').addClass('has-success');
			formattedBody += ' [correcta]\n\n';
		}else{
			$preg1.closest('.form-group').addClass('has-error');
			formattedBody += ' [incorrecta]\n\n';
		}

		$preg2 = $(this).find('[name=pregunta2]');
		var respuestaPreg2 = $preg2.val();
		formattedBody += "2. ¿Cuál es el nombre del salto famoso que se encuentra en los fiordos del oeste de Islandia?\n"
		formattedBody += $("[name=pregunta2] option:selected").text();
		if(respuestaPreg2 === 'd'){
			$preg2.closest('.form-group').addClass('has-success');
			formattedBody += ' [correcta]\n\n';
		}else{
			$preg2.closest('.form-group').addClass('has-error');
			formattedBody += ' [incorrecta]\n\n';
		}

		$preg3 = $(this).find('[name=pregunta3]:checked');
		var respuestaPreg3 = $preg3.val();
		formattedBody += "3. ¿Cuántos cm al año se alejan las placas continentales de Eurasia y América?\n"
		var textoRespPreg3 = $preg3.parent().find('label').text();
		formattedBody += textoRespPreg3;

		if(respuestaPreg3 === 'a'){
			$preg3.closest('.form-group').addClass('has-success');
			formattedBody += ' [correcta]\n\n';
		}else{
			$preg3.closest('.form-group').addClass('has-error');
			formattedBody += ' [incorrecta]\n\n';
		}

		$preg4 = $(this).find('[name=pregunta4]:checked');
		var respuestaPreg4 = $preg4.val();
		var textoRespPreg4 = $preg4.parent().find('label').text();
		formattedBody += "4. ¿Cuántas veces ha entrado en erupción el volcán Hekla?\n"
		formattedBody += textoRespPreg4;
		if(respuestaPreg4 === 'b'){
			$preg4.closest('.form-group').addClass('has-success');
			formattedBody += ' [correcta]\n\n';
		}else{
			$preg4.closest('.form-group').addClass('has-error');
			formattedBody += ' [incorrecta]\n\n';
		}

		console.log(formattedBody);
		// Preguntas múltiples
		$preg5 = $('#pregunta5');
		var respuestaPreg5 = [];
		$("[name=pregunta5]:checked").each(function(){
		    respuestaPreg5.push($(this).val());
		});

		if(jQuery.inArray('a', respuestaPreg5)!=-1 && jQuery.inArray('c', respuestaPreg5)!=-1 && jQuery.inArray('d', respuestaPreg5)!=-1
		&& (jQuery.inArray('b', respuestaPreg5) == -1 && jQuery.inArray('e', respuestaPreg5) == -1)){
			$preg5.closest('.form-group').addClass('has-success');
			formattedBody += ' [correcta]\n\n';
		}else{
			$preg5.closest('.form-group').addClass('has-error');
			formattedBody += ' [incorrecta]\n\n';
		}

		$preg6 = $('#pregunta6');
		var respuestaPreg6 = [];
		$("[name=pregunta6]:checked").each(function(){
		    respuestaPreg6.push($(this).val());
		});

		if(jQuery.inArray('b', respuestaPreg6)==-1 && jQuery.inArray('c', respuestaPreg6)==-1 && jQuery.inArray('e', respuestaPreg6)==-1
		&& (jQuery.inArray('a', respuestaPreg6) != -1 && jQuery.inArray('d', respuestaPreg6) != -1)){
			$preg6.closest('.form-group').addClass('has-success');
			formattedBody += ' [correcta]\n\n';
		}else{
			$preg6.closest('.form-group').addClass('has-error');
			formattedBody += ' [incorrecta]\n\n';
		}


		$preg7 = $('#pregunta7');
		var respuestaPreg7 = [];
		$("[name=pregunta7]:checked").each(function(){
		    respuestaPreg7.push($(this).val());
		});

		if(jQuery.inArray('b', respuestaPreg7)==-1 && (jQuery.inArray('a', respuestaPreg7) != -1 &&
		jQuery.inArray('c', respuestaPreg7) != -1 && jQuery.inArray('d', respuestaPreg7) != -1)){
			$preg7.closest('.form-group').addClass('has-success');
			formattedBody += ' [correcta]\n\n';
		}else{
			$preg7.closest('.form-group').addClass('has-error');
			formattedBody += ' [incorrecta]\n\n';
		}

		$preg8 = $('#pregunta8');
		var respuestaPreg8 = [];
		$("[name=pregunta8]:checked").each(function(){
		    respuestaPreg8.push($(this).val());
		});

		if(jQuery.inArray('a', respuestaPreg8)!=-1 && jQuery.inArray('b', respuestaPreg8)!=-1
		&& (jQuery.inArray('c', respuestaPreg8) == -1 && jQuery.inArray('d', respuestaPreg8) == -1)){
			$preg8.closest('.form-group').addClass('has-success');
			formattedBody += ' [correcta]\n\n';
		}else{
			$preg8.closest('.form-group').addClass('has-error');
			formattedBody += ' [incorrecta]\n\n';
		}

		//Preguntas %
		$preg9 = $(this).find('[name=pregunta9]');
		var respuestaPreg9 = $preg9.val();
		if(respuestaPreg9 === '90'){
			$preg9.closest('.form-group').addClass('has-success');
			formattedBody += ' [correcta]\n\n';
		}else{
			$preg9.closest('.form-group').addClass('has-error');
			formattedBody += ' [incorrecta]\n\n';
		}

		$preg10 = $(this).find('[name=pregunta10]');
		var respuestaPreg10 = $preg10.val();
		if(respuestaPreg10 === '11'){
			$preg10.closest('.form-group').addClass('has-success');
			formattedBody += ' [correcta]\n\n';
		}else{
			$preg10.closest('.form-group').addClass('has-error');
			formattedBody += ' [incorrecta]\n\n';
		}


	// var mailToLink = "mailto:x@y.com?body=" + encodeURIComponent(formattedBody);
	// window.location.href = mailToLink;
  });


});
