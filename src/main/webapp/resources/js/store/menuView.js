$(document).ready(function() {
	$('#menuDelete').one('click', function() {
		alert("1");
		let input = confirm("정말 삭제하시겠습니까? ");

		if (input) {
			$.ajax({
				url : '/sm/menu',
				type : 'post' ,
				data : {
					id : $(this).data('id')
				},
				success : function(data) {
					alert(data.message);
					location.href = "menuList.jsp";
				}
			});
		}
	});

})
