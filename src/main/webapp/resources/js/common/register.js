$(document).ready(function(){
	var wrap=$('#wrap');
	var geocoder = new kakao.maps.services.Geocoder();
	$('#searchButton').on("click",function(){
		//alert('주소검색버튼 클릭 이벤트 발생');
		var address='';
        new daum.Postcode({
            oncomplete: function(data) {
            	address=data.roadAddress;
            },
            onclose:function(state){
				$('#wrap').css('display','none');
				$('#user_address').val(address);
				$('#user_detailAddress').focus();
            }
        }).embed(
        		document.getElementById('wrap'),
        		{autoClose:'true'}
        );
        $('#wrap').css('display','block');
	});
	$('#register_apply_button').on("click",function(){
		var address=$('#user_address').val();
		geocoder.addressSearch(address, function(result, status) {
		     if (status === kakao.maps.services.Status.OK) { //정상 검색

		    	 var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		    	 var lat=coords.getLat();
		    	 var lng=coords.getLng();
		    	 //alert(lat);
		    	 //alert(lng);
		    	 //alert("latitude:"+lat+",longitude:"+lng);
		    	 var latitude=document.getElementById('user_latitude');
		    	 latitude.value=lat;
		    	 var longitude=document.getElementById('user_longitude');
		    	 longitude.value=lng;
		    	 //alert(latitude.value);
		    	 //alert(longitude.value);
		    	 Swal.fire({
		    		  title: '정말로 가입하시겠습니까?',
		    		  text: "dinner41의 회원이 되어주세요",
		    		  icon: 'question',
		    		  showCancelButton: true,
		    		  confirmButtonColor: '#3085d6',
		    		  cancelButtonColor: '#d33',
		    		  confirmButtonText: '네',
		    		cancelButtontext: '아니오'
		    		}).then((result) => {
		    		  if (result.value) {
		    		    Swal.fire(
		    		      '환영합니다',
		    		      'dinner41의 회원이 되셨습니다',
		    		      'success'
		    		    )
		    		    $('#register_form').submit();
		    		  }
		    		});
		    	 
		    	 
		    	
		    	 /*
		    	 $('#user_latitude').val(""+latitude);
		    	 const la=$('#user_latitude');
		    	 alert(""+la);
		    	 $('#user_longitude').val(""+longitude);
		    	 */
		    } 
		});    
		
		
	})
});
