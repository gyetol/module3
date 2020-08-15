$(document).ready(function() {
	insertCart();
});

function insertCart() {
	var storeId = $(".container-fluid").data("storeid");
	var menuId = $(".container-fluid").data("menuid");
	
	$("#insertCart").click(function() {
		$.ajax({
			type : "POST",
			url : "gm/cart",
			data : {
				"storeId" : storeId,
				"menuId" : menuId
			},
			success : function(data) {
				if (data.result) {
					if (data.msg1 != undefined) {
						alert(data.msg1);
					}
					alert(data.msg2);
					window.location.href = "menuView";
				}
				else {
					alert(data.msg);
					// 로그인 화면으로 이동하는 URL
					winow.location.href = "/dinner41";
				}
			}
		});
	});
	
	$("#cartButton").click(function() {
		window.location.href = "gm/cart";
	});
}