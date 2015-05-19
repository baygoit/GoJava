$(document).ready(function() {
	$.get("quote", function(quote) {
		$("#quote").html('<p>' + quote.mainQuote + '</p><p id="author">' + quote.author + '</p>');
	});
	$.get("categories", function(categories) {
		for (var index in categories) {
			var category = categories[index];
			categoriesListener(category);
		}
	});
	
	var scipLoad = false;
	
	var setHash = function(hash){
		scipLoad = true;
		window.location.hash = hash;
	}
	
	var getHash = function(){
		return window.location.hash;
	}
	
	var loadHash = function(hash){
		var regexp = /^#categories\/([0-9]+)$/;
		
		if(regexp.test(hash)){
			var result = regexp.exec(hash);
			loadProjectsOfCategory(result[1]);
		}
		
		var regexp = /^#categories\/([0-9]+)\/project\/([0-9]+)$/;
		
		if(regexp.test(hash)){
			var result = regexp.exec(hash);
			var id = result[2];
			loadProjectsOfCategory(result[1]);
			loadProject(id);
		}
	}
	
	var categoriesListener = function(category) {
		var id = category.id;
		var cssId = 'category' + id;
		
		$("#categories").append('<a id="' + cssId + '" href="#categories/' + id + '">' + category.name + '</a> ');
		
		$("#" + cssId).click(function(){
			setHash('#categories/' + id);
			loadProjectsOfCategory(id);
		});
	}
	
	var loadProjectsOfCategory = function(id){
		$.get("categories/" + id, function(projects){
			$("#projects").html('');
			for (var index in projects) {
				var project = projects[index];
				projectListener(project, id);
			}
		});
	}
	var projectListener = function(project, categoryId) {
		
		var id = project.id;
		var ccsProjectId = 'project' + id;
		
		$("#projects").append('<div id="'+ ccsProjectId +'" class="project"><div class="main-info"><h3>' + project.name +
				'</h3><p>' + project.description +'</p></div></div>');
		
		$("#" + ccsProjectId).on('click', '.main-info', function(){
			var selectProjectClass = $(this).closest(".project");

			selectProjectClass.toggleClass('highlighted');
			loadProject(id);
			if (!selectProjectClass.hasClass('highlighted')){
				setHash('#categories/' + categoryId);
			} else {
				setHash('#categories/' + categoryId + '/project/' + id);
			} 
		});
	}
	
	var loadProject = function(id){
		if ($("div").hasClass('info-container')){
			$(".info-container").remove();
			$(".project").show();
		} else {
			$.get("project/" + id, function(project){
				$("#project" + id).append('<div class="info-container"><p>Money we have: ' + project.moneyHas + '</p>'
						+ '<p>Money wee need: ' + project.moneyNeed
						+ '</p> <p>Days left: ' + project.daysLeft + '</p></div>');
				$(".info-container").append('<div class="faq">' +
						'<form method="POST" action="/">' +
							'<textarea name="question" placeholder="Add your question"></textarea>' +
							'<input type="submit">' +
						'</form></div>');
				getFaqs(id);
				$('form').submit(function(event){
					event.preventDefault();
					var addedQuestion = $(this).find('textarea').val();
					$(this).find('textarea').val('');
					if (addedQuestion !== ''){
						sendAjax(addedQuestion, id);
						$(this).parent('.faq').append('<p>' + addedQuestion + '</p>');
					}
				});
			}).done(function(){
				$("#project" + id).addClass("highlighted");
				$(".project").not("#project"  + id).hide();
			});
		} 
	}
	
	var getFaqs = function(id){
		$.get("faq/" + id, function(faqs){
			for (var index in faqs){
				var faq = faqs[index];
				$("#project" + id).find(".faq").append('<p>' + faq.question + '</p>');
			}
		});
	}
	
	function sendAjax(content, projectId) {
		$.ajax({ 
		    url: "faq/" + projectId, 
		    type: 'POST', 
		    dataType: 'json', 
		    data: "{\"question\":\"" + content +"\"}", 
		    contentType: 'application/json',
		    mimeType: 'application/json',
		});
	}

	loadHash(getHash());
	
	window.onhashchange = function(){
		if (!scipLoad){
			loadHash(getHash());
		}
		scipLoad = false;
	}
	
});