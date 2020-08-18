$(document).ready(function(){
	var errorCode=$('#modelData').data("errorcode");
	var errorMessage=$('#modelData').data("errormessage");
	if (errorCode){
		alert(errorMessage+"");
		if(errorCode==="1"){
			console.log('err코드가 0 입니다');
			$('#user_email').focus();
		}
		else if(errorCode==="2"){
			let defaultEmail=$('#modelData').data("defaultemail");
			$('#user_email').val(defaultEmail);
			$('#password_button').focus();
		}
	}

	$('#password_button').on("click",function(){
		//alert('임시비밀번호 받기 버튼 클릭 이벤트 발생');
		let email=$('#user_email').val();
		//alert(email);
		if(!email.trim()){
			alert("이메일을 입력해주세요");
			$('#user_email').focus();
		}
		else{
			//alert(email+"");
			$('#search_password_form').submit();
		}
	});
});