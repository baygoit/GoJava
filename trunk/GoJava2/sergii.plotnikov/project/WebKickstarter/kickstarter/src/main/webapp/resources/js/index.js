$(document).ready(function() {
	$.get('categories', function(categories) {
		$('#categories').html('');
		for (var index in categories) {
			var category = categories[index];
			addCategory(category);
		}
	});
	
	var skipLoad = false;
	
	var setHash = function(hash) {
		skipLoad = true;
		window.location.hash = hash;
	}
	
	var getHash = function() {
		return window.location.hash;
	}
	
	var loadHash = function(hash) {
		var regexp = /^#categories\/([0-9]+)$/;
		if (regexp.test(hash)) {
			var result = regexp.exec(hash);
			var categoryId = result[1];
			loadCategoryProjects(categoryId);
		} 
		
		regexp = /^#categories\/([0-9]+)\/projects\/([0-9]+)$/;
		if (regexp.test(hash)) {
			var result = regexp.exec(hash);
			var categoryId = result[1];
			var projectId = result[2];
			loadCategoryProjects(categoryId, function() {
				loadProject(categoryId, projectId);
			});
			
		}
		
		regexp = /^#categories\/([0-9]+)\/projects\/([0-9]+)\/option\/faq\/([0-9]+)$/;
		if (regexp.test(hash)) {
			var result = regexp.exec(hash);
			var categoryId = result[1];
			var projectId = result[2];
			loadCategoryProjects(categoryId, function() {
				loadProject(categoryId, projectId);
				loadFaq(categoryId, projectId);
			});
			
		}
		
		
	}
	
	var addCategory = function(category) {
		var categoryContainerId = 'category_' + category.id;
		$('#categories').append('<div id="' + categoryContainerId + '">'+category.title + '</div>');
		$('#' + categoryContainerId).addClass("buttonCategory");
			
		$('#' + categoryContainerId).click(function() {	
			$(".buttonCategory").removeClass("clickedCategory");
			$(this).addClass("clickedCategory");
			
			setHash('#categories/' + category.id);
			loadCategoryProjects(category.id);
		});
	}
	
	var loadCategoryProjects = function(categoryId, onLoad) {
		$.get('categories/' + categoryId + '/projects', function(projects) {
			$('#projects').html('');
			$('#project').html('');
			for (var index in projects) {
				var project = projects[index];
				addProject(categoryId, project);
			}
			if (!!onLoad) {
				onLoad();
			}
		});
	}
	
	var addProject = function(categoryId, project) {
		var projectContainerId = 'project_' + project.id;
		$('#projects').append('<div id="' + projectContainerId + '">' + project.title + '</div>');
		$('#' + projectContainerId).addClass("buttonProject");
		
		$('#' + projectContainerId).click(function() {	
		$(".buttonProject").removeClass("clickedProject");
			$(this).addClass("clickedProject");
			
			setHash('#categories/' + categoryId + '/projects/' + project.id);			
			loadProject(categoryId, project.id);
		});
	}
	
	var loadProject = function(categoryId, projectId) {
		var faqContainerId = 'projectFaq_' + projectId;
		var donateContainerId = 'projectDonate_' + projectId;
		$.get('projects/' + projectId, function(project) {
			$('#project').html('<div>name: ' + project.title + '</div>' + 
					'<div>description: ' + project.description + '</div>' +
					'<div>story: ' + project.story + '</div>' +
					'<div>link: ' + project.link + '</div>' +
					'<div>price: ' + project.price + '</div>' +
					'<div>collected: ' + project.collected + '</div>' +
					'<div>days: ' + project.days + '</div>'+
					'<div id="'+ faqContainerId+'"> FAQ </div>'+
					'<div id="'+ donateContainerId+'"> Donate </div>');
					
			$('#' + faqContainerId).addClass("buttonOption");
			$('#' + donateContainerId).addClass("buttonOption");
		
			$('#' + faqContainerId).click(function() {
				$(".buttonOption").removeClass("clickedOption");
				$(this).addClass("clickedOption");
				
				setHash('#categories/' + categoryId + '/projects/' + projectId + '/option/faq/' + projectId);			
				loadFaq(categoryId, projectId);
			});	

			$('#' + donateContainerId).click(function() {
				$(".buttonOption").removeClass("clickedOption");
				$(this).addClass("clickedOption");
				
				setHash('#categories/' + categoryId + '/projects/' + projectId + '/option/donate/' + projectId);			
				loadDoante(categoryId, projectId);
			});				
		
		});
	}
	
	var loadFaq = function(categoryId, projectId) {
		var faqButtonId = 'faqButtonId_' + projectId;
		
		$('#option').html('');		
		
		$.get('option/faq/' + projectId, function(faqs) {
			for (var index in faqs) {
				var faq = faqs[index];
				$('#option').append('<div id="q">Q: ' + faq.question + '</div>');
				if(faq.answer!=null){
					$('#option').append('<div id="a">A: ' + faq.answer + '</div>');
				}
			}
			$('#option').append('<form method="POST"><input type="text" name="lastname">'+
							'<input id ="' + faqButtonId + '" type="submit" value="Ask question"></form>');
			
			$('#' + faqButtonId).click(function() {
				loadCategoryProjects(categoryId, function() {
					loadProject(categoryId, projectId);
				});	
			});				
		});
	}
	
	var loadDonate = function(categoryId, projectId) {
		var donateButtonId = 'donateButtonId_' + projectId;
		
		$('#option').html('');		
		
		$.get('option/donate/' + projectId, function(faqs) {
			for (var index in faqs) {
				var faq = faqs[index];
				$('#option').append('<div id="q">Q: ' + faq.question + '</div>');
				if(faq.answer!=null){
					$('#option').append('<div id="a">A: ' + faq.answer + '</div>');
				}
			}
			$('#option').append('<form method="POST"><input type="text" name="lastname">'+
							'<input id ="' + faqButtonId + '" type="submit" value="Ask question"></form>');
			
			$('#' + faqButtonId).click(function() {
				loadCategoryProjects(categoryId, function() {
					loadProject(categoryId, projectId);
				});	
			});				
		});
	}
	
	loadHash(getHash());
	
	window.onhashchange = function () {
		if (!skipLoad) {
			loadHash(getHash());
		}
		skipLoad = false;
	};
});