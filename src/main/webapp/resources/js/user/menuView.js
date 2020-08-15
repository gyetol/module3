$(document).ready(function() {
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
			success : function() {
				alert("장바구니에 등록되었습니다!");
				window.location.href = "storeDetail_menu";
			}
		});
	});
	
	$("#cartButton").click(function() {
		window.location.href = "gm/cart";
	});
});