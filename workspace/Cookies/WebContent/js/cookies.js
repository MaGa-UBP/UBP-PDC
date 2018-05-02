 jQuery(document).ready(function() {
	 $("input:visible:enabled:first").focus();
 });

 var jCookies = {
	
    add: function() {
    	if($.trim($("input[name=cookieName]").val()) == "") {
    		alert("Debe informar el nombre de la cookie");
    		$("input[name=cookieName]").focus();
    		return false;
    	}
    	
    	if($.trim($("input[name=cookieValue]").val()) == "") {
    		alert("Debe informar el valor de la cookie");
    		$("input[name=cookieValue]").focus();
    		return false;
    	}
    	
    	$("#form").submit();
    },
    
    del: function(cookieName) {
    	$("#delCookieName").val(cookieName);
    	$("#form").submit();
    }
		 
 };