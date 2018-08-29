function getLoginState() {
	result = "获取用户名出错";
	$.ajax({		
		url:"http://localhost:8080/OnlineMall/loginstate",
		async:false,
		success:function(resultFromApi){
			mbody = $.parseJSON(resultFromApi).Mbody;
			// return 	
			// "Mbody": [{
			// 	"state": "logged",
			// 	"userName": "create"
			// }]
			result = mbody[0].userName;
		}
	});
	return result;
}