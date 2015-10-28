$(document).ready(function(){
	$("#form").validate({
		rules : {
			pass : {required: true, minlength: 5},
			email : {required: true, email: true}
		},
		messages : {
			email : {
				required: "Enter your current email adress",
				email: "Unsupported email adress"
			},
			pass : {
				required: "Enter password",
				minlength: "Password must include minimun 5 letters",
			}
		}
	});
});
jQuery.validator.addMethod("lettersonly", function(value, element) {
  return this.optional(element) || /^[a-z]+$/i.test(value);
}, "Letters only please");
function changeStatus(){
	if(form.checkbox.checked) form.registr.disabled = false;
	else form.registr.disabled = true;
}
jQuery.validator.addMethod("digitssonly", function(value, element) {
  return this.optional(element) || /^\+?[0-9\-\(\)\s]+$/i.test(value);
}, "Letters only please");