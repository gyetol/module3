$(document).ready(function(){

	
	$('#deleteStoreBtn').click(function(){
		let check;
		check= confirm("정말로 삭제하시겠습니까?");
		
		if(check){
			location.href=contextPath+"/sm/delete/store";
		}
		else{
			location.href=contextPath+"/sm/store";
		}
	})
	
	
	$('#updateBtn').click(function(){
		alert("승인대기중입니다");
	});
	
});