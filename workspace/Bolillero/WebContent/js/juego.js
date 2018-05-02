var jJuego = {

  agregar: function() {
    if($.trim($("input[name=participante][type=text]").val()) == "")  {
        alert("Debe informar el nombre del participante");
        $("input[name=participante][type=text]").focus();
        return false;
    }
    $("#form").submit();
    return true;
  },

  extraer: function() {
    if($("input[name=iniciado]").val() == "N") {
        $("input[name=iniciado]").val("S");
        return jJuego.agregar();
    }  
    else {
        $("#form").submit();
    }
  },
  
  reiniciar: function() {
      window.location.href = "index.jsp";
  }

};

