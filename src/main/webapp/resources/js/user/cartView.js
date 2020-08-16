$(document).ready(function() {
	deleteMenus();
	allCheck();
	clickCountButton();
	checkForCalc();
});

// 체크박스가 체크될 때마다 총금액이 변하도록 하는 함수
function checkForCalc() {
	var menus = $(".menuClass").get();
	for (let i = 0; i < menus.length; i++) {
		var jMenus = $(menus[i]);
		var checkBox = jMenus.find(".form-control");

		checkBox.change(function() {
			calcAllPrice();
		});
	}
}

// 체크되어있는 메뉴들의 가격을 더해서 총 금액에 출력해주는 함수
function calcAllPrice() {
	var allPrice = 0;
	var menus = $(".menuClass").get();
	for (let i = 0; i < menus.length; i++) {
		var jMenus = $(menus[i]);
		var checkBox = jMenus.find(".form-control");
		
		// 하나의 메뉴의 총 가격
		// "5000원"이렇게 넘어옴
		var amount = jMenus.find("#amount").text();
		amount = Number(amount.replace(/[^0-9]/g, ""));
		
		if (checkBox.is(":checked")) {
			allPrice += amount;
		}
	}
	$("#totalPrice").text(String(allPrice) + "원");
}

// -,+ 버튼을 클릭할 때마다 메뉴의 수량과 가격이 변하도록 하는 함수
function clickCountButton() {
	var menus = $(".menuClass").get();
	for (let i = 0; i < menus.length; i++) {
		var jMenus = $(menus[i]);
		var minusButton = jMenus.find("#minusButton");
		var plusButton = jMenus.find("#plusButton");
		var numTag = jMenus.find("#num");
		var num = Number($(numTag).text());

		minusButton.click(function() {
			--num;
			if (num <= 0) {
				num = 1;
			}
			// 버튼을 통해 메뉴의 수량을 바꿈
			($(this).siblings("#num")).text(num);
			// 메뉴 하나의 가격
			var price = Number(($(this).siblings("#amount")).data("amount"));
			// 메뉴의 개수만큼의 가격
			var priceMultNum = String(price * num) + "원";
			($(this).siblings("#amount")).text(priceMultNum);
			calcAllPrice();
		});
		plusButton.click(function() {
			++num;
			if (num > 5) {
				num = 5;
			}// 버튼을 통해 메뉴의 수량을 바꿈
			($(this).siblings("#num")).text(num);
			// 메뉴 하나의 가격
			var price = Number(($(this).siblings("#amount")).data("amount"));
			// 메뉴의 개수만큼의 가격
			var priceMultNum = String(price * num) + "원";
			($(this).siblings("#amount")).text(priceMultNum);
			calcAllPrice();
		});
	}
}

// 전체선택 박스를 클릭할 때를 처리하는 함수
function allCheck() {
	$("#totalToggle").click(function() {
		var menus = $(".menuClass").get();
		for (let i = 0; i < menus.length; i++) {
			var jMenus = $(menus[i]);
			var checkBox = jMenus.find(".form-control");

			// 전체선택 박스를 체크하면
			if ($(this).is(":checked")) {
				checkBox.prop("checked", true);
				calcAllPrice();
			}
			// 전체선택 박스 체크를 해제하면
			else {
				checkBox.prop("checked", false);
				calcAllPrice();
			}
		}
	});
}

// 선택메뉴삭제버튼을 클릭할 때를 처리하는 함수
function deleteMenus() {
	$("#delete").click(function() {
		var arr = [];
		var menus = $(".menuClass").get();
		for (let i = 0; i < menus.length; i++) {
			var jMenus = $(menus[i]);
			var checkBox = jMenus.find(".form-control");

			if (checkBox.is(":checked")) {
				arr.push(jMenus.data("menuid"));
			}
		}

		if (arr.length == 0) {
			alert("삭제할 메뉴를 선택해주세요.");
			return;
		}

		$.ajax({
			type : "DELETE",
			url : "cart",
			data : {
				"arr" : arr
			},
			success : function(data) {
				alert(data.msg);
				window.location.href = "cart";
			}
		});
	});
}
