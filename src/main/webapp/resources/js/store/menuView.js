$(document).ready(function() {
	var contextPath=sessionStorage.getItem("contextPath");
	
	$('#update_button').on("click",function(){
		var password=prompt("비밀번호를 입력해주세요","");
		alert(password);
		//$('#password').val(password);
		//$('#update_form').attr("method","patch");
		//$('#update_form').submit();
		$.ajax({
			url:contextPath+"/mypage/checkPass",
			method:"POST",
			data:{
				"password":password
			},
			success:function(data){
				if(data.result){
					window.location.href=contextPath+"/mypage/update";
				}
				else{
					window.location.href=contextPath+"/mypage";
				}
			}
		});
	});
	
	$('#menuDelete').one('click', function() {
		let input = confirm("정말 삭제하시겠습니까? ");
		var storeId = $('#storeId').val();
		var menuId =$('#menuId').val();
		

		if (input) {
			$.ajax({
				url :contextPath+"/menu/delete",
				method: "GET",
				data : {
					"storeId": storeId,
			        "menuId" : menuId
				},
				success : function(data) {
					alert(data.message);
					if(data.result){
					window.location.href=contextPath+"/store/menuList";
					}
					else{
						window.location.href=contextPath+"/store/menuView";
					}
				},
			
			});
		}
	});

})
