$(document).ready(function() {
	clickOrder();
});

function clickOrder() {
	$("#order").click(function() {
		var getTime = $("#get_time").val();
		var payTotal = $("#pay_total").val();

		if (getTime.trim() == "") {
			alert("수령 소요 시간을 입력해주세요.");
			$("#get_time").focus();
			return;
		}
		
		$.ajax({
			type : "POST",
			url : "order",
			data : {
				"getTime" : getTime,
				"payTotal" : payTotal
			},
			success : function(data) {
				alert(data.msg);
				window.location.href = "결제 페이지로 이동";
			}
		});
	});
}