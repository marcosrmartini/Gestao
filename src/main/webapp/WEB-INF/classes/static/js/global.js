$(document).ready(function() {
	$("p").click(function() {
		alert("The paragraph was clicked.");
	});
});

$(document).ready(function() {
	$(".somenteNumero").bind("keyup blur focus", function(e) {
		e.preventDefault();
		var expre = /[^\d]/g;
		$(this).val($(this).val().replace(expre, ''));
	});
});