$(document).ready(function(){
	alert("document ready");
	$('submitForm').click(function(event){
		alert("submit clicked");
		//set form values
		var name=$('name').val();
		var email=$('email').val();
		var address=$('address').val();
		
		//ajax call
		$.ajax(){
			type:'GET',
			url:'reg',
			data:"name="+name+"&email="+email+"&address="+address,
			success:function(msg){
				alert("success");
			},
			error:function(msg){
				alert("error");
			}
		}
	})
})