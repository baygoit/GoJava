$(document).ready(function() {
	$(".projectForm").validate(		{
		rules: {
			name: {
				required : true,
				minlength : 2,
				maxlength : 100
			},
			description: {
				required : true,
				maxlength : 500
			},
			story: {
				required : true,
				maxlength : 500
			},
			link: {
				required : false,
				url: true
			},
			requiredAmount: {
				required : true,
				maxlength : 10
			},
			daysLeft: {
				required : true,
				maxlength : 10
			},
			category: {
				required : true
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