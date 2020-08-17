$(document).ready(function(){
	var wrap=$('#wrap');
	var geocoder = new kakao.maps.services.Geocoder();
	$('#searchButton').on("click",function(){
		alert('주소검색버튼 클릭 이벤트 발생');
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
		    	 alert(lat);
		    	 alert(lng);
		    	 //alert("latitude:"+lat+",longitude:"+lng);
		    	 var latitude=document.getElementById('user_latitude');
		    	 latitude.value=lat;
		    	 var longitude=document.getElementById('user_longitude');
		    	 longitude.value=lng;
		    	 //alert(latitude.value);
		    	 //alert(longitude.value);
		    	 $('#register_form').submit();
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
