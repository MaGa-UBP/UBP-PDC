var jCine = {
  
  seleccionar: function(index) {
    if($("#" + index).val() == "L") {
        $("#" + index).closest("td").removeClass("libre").addClass("seleccionada");
        $("#" + index).val("C");
    }
    else {
        $("#" + index).closest("td").removeClass("seleccionada").addClass("libre");
        $("#" + index).val("L");
    }
  },
  
  comprar: function() {
      var butacas = '';
      $("input[type='hidden'][value='C']", $("#form")).each(function(){
          butacas += $(this).attr("name") + "; ";
      });
      
      if(butacas == '') {
          alert("Debe seleccionar al menos una butaca");
          return false;
      }     
      
      $("#butacas").html(butacas);
      $("#bloque-compra").show();
      $("#compra").show();
  },
  
  confirmar: function() {
      $("#form").submit();
  },
  
  cancelar: function() {
      $("#butacas").html("&nbsp;");
      $("#compra").hide();
      $("#bloque-compra").hide();
  }

};

