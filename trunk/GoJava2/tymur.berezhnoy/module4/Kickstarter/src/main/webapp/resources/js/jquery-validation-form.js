$(document).ready(function() {
	$(".registrationForm").validate(
		{
			rules: {
				name: {
					required : true,
					minlength : 3
				},
				email: {
					required : true,
					email : true
				},
				password: {
					required : true,
					minlength : 5
				},
				password_again: {
					required : true,
					minlength : 5,
					equalTo: "#password"
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			}
		}
	);
});