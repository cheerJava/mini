function register()
{
	var formData = $("#form").serialize2Json();
	
	$.ajax({
	type :"POST",
	contentType : "application/json;charset=utf-8",
	url : _path+"/loujiang/add",
	dataType : "json",
	data : JSON.stringify(formData),
	success : function(data) {
		if (data.status == "S") {
			window.location = _path + "/loujiang/list";
		} else if (data.status == "F") {
			//alert(data.message);	
			window.location = _path + "/loujiang/list";
		}
	},
	error : function() {
		//alert("error");
		window.location = _path + "/loujiang/list";
	}
});			
}
/**
function register()
{
	
	var formData = $("#form").serialize2Json();
	
	$.ajax({
	type :"POST",
	contentType : "application/json;charset=utf-8",
	url : _path + "/loujiang/validateregister",
	dataType : "json",
	data : JSON.stringify(formData),
	success : function(data) {
		if (data.status == "S") {
			alert("注册成功");
			window.location = _path + "/loujiang/register";
		} else if (data.status == "F") {
			alert(data.message);
		}
	},
	error : function() {
		alert("error");
	}
});
}
***/		
