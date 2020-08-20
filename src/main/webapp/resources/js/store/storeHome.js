$(document).ready(function(){
	let contextPath=sessionStorage.getItem("contextPath");
	
	$('#openBtn').click(function(){
		 let name =$('#openBtn').attr('name');
		 alert(name);
		 location.href = contextPath+"/sm/switchOpenState/"+name+"/store";
	});
	
	$('#closeBtn').click(function(){
		let name =$('#closeBtn').attr('name');
		alert(name);
		location.href = contextPath+"/sm/switchOpenState/"+name+"/store";
	});
});