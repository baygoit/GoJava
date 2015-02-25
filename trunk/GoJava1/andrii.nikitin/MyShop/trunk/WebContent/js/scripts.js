function init(address, frame){		
	top.frames[frame].location.href = 'pages/' + address;
}

function drawForm(frame, action){
	var input = top.frames[frame]document.getElementsByName("catalog-hidden");	
	input.value = action;
}

function submitForm(id){
	var form = document.getElementById(id);	
	form.submit();
}
