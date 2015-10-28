<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(document).ready(function() {
		$("#test").click(function() {
			$.get("/ajaxtest", function(data, status) {
				alert("Data: " + data + "\nStatus: " + status);
			});
		});

		$("#category").click(function() {
			$.get("/ajaxcategory", function(data, status) {
                alert("Category = " + data.name + "\nStatus : " + status);	
                console.log(data);
			});
			
		});
		$("#categories").click(function() {
			$.get("/ajaxcategories", function(data, status) {
				for (var i = 0; i < data.length; i++){
					alert(data[i].name);
				}
			});
		});
	});
</script>

<button id="test">Load Test</button>

<button id="categories">Load Categories</button>

<button id="category">Load Category</button>

