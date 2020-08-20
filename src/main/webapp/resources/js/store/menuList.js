$(document).ready(function() {
	var contextPath = sessionStorage.getItem("contextPath");
	clickCountButton();
	clickCountUpdate(contextPath);
});

function clickCountButton() {
	var menus = $(".menuList").get();
	for (let i = 0; i < menus.length; i++) {
		var jMenus = $(menus[i]);
		var minusButton = jMenus.find("#minusButton");
		var plusButton = jMenus.find("#plusButton");

		minusButton.click(function() {
			var num = Number(($(this).siblings('#num')).text());
			--num;
			if (num <= 0) {
				num = 1;
			}
			// 버튼을 통해 메뉴의 수량을 바꿈
			($(this).siblings("#num")).text(num);

		});
		plusButton.click(function() {
			var num = Number(($(this).siblings('#num')).text());
			++num;
			// 버튼을 통해 메뉴의 수량을 바꿈
			($(this).siblings("#num")).text(num);
		});
	}
}

function clickCountUpdate(contextPath) {
	var menus = $(".menuList").get();
	for (let i = 0; i < menus.length; i++) {
		var menu = $(menus[i]);
		
		menu.find("#countUpdate").click(function() {
			var storeId = $(this).parents(".menuList").find("#data").data("storeid");
			var menuId = $(this).parents(".menuList").find("#data").data("menuid");
			var amount = $(this).parents(".menuList").find("#num").text();
			
			let input = confirm("해당 수량으로 변경하시겠습니까? ");
			if (input) {
				$.ajax({
					url : contextPath + "/sm/menu/list",
					method : "POST",
					data : {
						"storeId" : storeId,
						"menuId" : menuId,
						"amount" : amount
					},
					success : function(data) {
						if (data.result) {
							alert(data.msg);
						} else {
							window.location.href = contextPath + "/sm/1/menu/list";
						}
					},
				});
			}
		})
	}
	/*
	$('#countUpdate').click(function() {
		let input = confirm("해당 수량으로 변경하시겠습니까? ");
		if (input) {
			$.ajax({
				url : contextPath + "/sm/menu/list",
				method : "POST",
				data : {
					"storeId" : storeId,
					"menuId" : menuId,
					"num" : num
				},
				success : function(data) {
					if (data.result) {
						console.log(data);
						alert(data.msg);
					} else {
						window.location.href = contextPath + "/sm/1/menu/list";
					}
				},

			});
		}

	});
	*/
}
