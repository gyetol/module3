$(document).ready(function() {
	var contextPath=sessionStorage.getItem("contextPath");
	
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
					if(data.result){
					window.location.href=contextPath+"/sm/1/menu/list";
					}
					else{
						window.location.href=contextPath+"/sm/1/menu/list";
					}
				},
			
			});
		}
	});

})
