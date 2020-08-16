$(document).ready(function(){
	$('#search_button').on("click",function(){
		var address='';
        new daum.Postcode({
            oncomplete: function(data) {
            	address=data.roadAddress;
            },
            onclose:function(state){
				$('#wrap').css('display','none');
				$('#user_address').val(address);
				$('#user_sub_address').focus();
            }
        }).embed(
        		document.getElementById('wrap'),
        		{autoClose:'true'}
        );
        $('#wrap').css('display','block');
	});
	$('#goBackButton').on("click",function(){
		alert('뒤로가기버튼 클릭이벤트 발생');
		window.history.back;
	});
	
	$('#update_password_button').on("click",function(){
		alert("비밀번호 수정하기 버튼 클릭이벤트 발생");
		$('#InputNewPassword').css("display","block");
		$('#InputNewPasswordConfirm').css("display","block");
	});
});