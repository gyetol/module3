$(document).ready(function(){
	var contextPath=sessionStorage.getItem("contextPath");
	
	$('#deleteStoreBtn').click(function(){
		var check;
		check= confirm("정말로 삭제하시겠습니까?");
		
		if(check){
			location.href=contextPath+"/sm/delete/store";
		}
		else{
			location.href=contextPath+"/sm/store";
		}
	})
});