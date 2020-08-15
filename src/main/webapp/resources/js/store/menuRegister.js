$.fn.menuWriteClick = function() {
	
	var storeId = $(".container-fluid").data("store_id");

	this.click(function() {
		
		$.ajax({
			url : "../menu",
			type : "GET",
			traditional: "true",
			data : {
				store_id : storeId,
				offer_type_id : $('#offerType').val(),
				menu_tag : $('#menuTag').val(),
				menu_name : $('#menuName').val(),
				menu_price : $('#menuPrice').val(),
				menu_amount : $('#menuAmount').val(),
				menu_description : $('#menuIntro').val(),
				menu_notice : $('#menuNotice').val(),
				menu_photo : $('#menuPhoto').val()
			},
			success : function(data) {

				alert(data.message);
				if (data.result) {
					alert("메뉴 등록되었습니다.")
					location.href = 'menuRegister.jsp';
				}
			},
			error : function(e) {
				console.log(e);
			}

		});
	});
}
