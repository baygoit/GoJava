function updateCustomAmount() {
	if ($("#radio_custom").prop("checked")) {
		$("#in_custom_amount").show("fast", function() {});
		$("#lb_custom_amount").show("fast", function() {});
	} else {
		$("#in_custom_amount").hide("fast", function() {});
		$("#lb_custom_amount").hide("fast", function() {});
	}
}

$(document).ready(function(){
	updateCustomAmount();
});