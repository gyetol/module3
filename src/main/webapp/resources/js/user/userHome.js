$(document).ready(function(){
	$('#search_button').click(function(){
		if($('#search_input').val()===""){
			location.href="gm/전체/all-/1/store";
		}
		location.href="gm/all-/"+$('#search_input').val()+"/1/store";
	});
});
