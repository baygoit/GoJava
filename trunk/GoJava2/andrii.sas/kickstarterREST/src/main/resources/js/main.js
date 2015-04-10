$(document).ready(function() {
	$.get("quote", function(quote) {
		$("#quote").html('<p>' + quote.mainQuote + '</p><p id="author">' + quote.author + '</p>');
	});
	$.get("categories", function(categories) {
		for (var id in categories) {
			var category = categories[id];
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
	}
	
	var categoriesListener = function(category) {
		var id = category.id;
		var cssId = 'category' + id;
		
		$("#categories").append('<a id="' + cssId + '" href="#categories/' + id + '">' + category.name + '</a> ');
		
		$("#" + cssId).click(function(){
			setHash('#categories/' + id);
			loadProjectsOfCategory(id)
		});
	}
	
	var loadProjectsOfCategory = function(id){
		$.get("categories/" + id, function(projects){
			$("#projects").html('');
			for (var id in projects) {
				var project = projects[id];
				$("#projects").append('<div class="project"><h3>' + project.name + '</h3><p>' + project.description +'</p></div>');
			}
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