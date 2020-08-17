$(document).ready(function(){
	$('#itemBtn').click(function(){
		var contextPath=sessionStorage.getItem("contextPath");
		var name =$('#itemBtn').attr('name');
			location.href=context+"gm/"+name+"/menu/store";
	});
});