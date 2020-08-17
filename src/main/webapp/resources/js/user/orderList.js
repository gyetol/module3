$(document).ready(function() {
	clickReview();
});

// 무송이가 사용할 리뷰쓰기 클릭 함수
function clickReview() {
	var orders = $(".orderClass").get();
	for (let i = 0; i < orders.length; i++) {
		var order = $(orders[i]);
		order.find("#reviewClick").click(function() {
			var orderId = $(this).parents(".orderClass").data("orderid");
			window.location = orderId + "/review"
		});
	}
}
