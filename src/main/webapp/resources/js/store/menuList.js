$(document).ready(function() {
	clickCountButton();
});
	
function clickCountButton() {
		var menus = $(".menuClass").get();
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
				
				($(this).siblings("#amount")).text(priceMultNum);
				calcAllPrice();
			});
		}
	}
	