$( document ).ready(function() {
  var isMobile = /iPhone|iPad|iPod|Android/i.test(navigator.userAgent);

  $('.a-buscar').on('click',function(e){
    e.preventDefault();
    $('.nav-buscar').slideToggle();
    if($('#nav-expander').hasClass('is-open')){
      $('body').removeClass('nav-expanded');
      $('#nav-expander').toggleClass('is-closed is-open');
    }
  });
//  $('.dropdown-submenu a.dd').on("click", function(e){
//   $(this).next('ul').toggle();
//   e.stopPropagation();
//   e.preventDefault();
// });

  $('input').on('keyup', function() {
         if (this.value.length > 1) {
              // do search for this.value here
              $("#btn-buscar-cerrar").addClass("hide");
              $("#btn-buscar").removeClass("hide");
         }else{
           $("#btn-buscar").addClass("hide");
           $("#btn-buscar-cerrar").removeClass("hide");
         }
    });
    $('#btn-buscar-cerrar').on('click',function(e){
      e.preventDefault();
      $('.nav-buscar').slideUp();
    });

 
});
