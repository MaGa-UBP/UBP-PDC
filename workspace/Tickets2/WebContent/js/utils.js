var jUtils = {

    executing: function(divId) {
    	$('#' + divId).html("<h1> Realizando busqueda... </h1>").show();
    },

    showing: function(divId, html) {
        $('#' + divId).html(html !== null ? html : '').show();
    },
    hiding: function(divId, clean) {
        clean = (clean === false ? false : true);
        $('#' + divId).hide();
        if(clean) {
            $('#' + divId).html('&nbsp;');
        }
    },
};


