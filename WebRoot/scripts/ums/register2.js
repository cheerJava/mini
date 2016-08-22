function register2()
{
	
	var formData = $("#form").serialize2Json();
	
	$.ajax({
	type :"POST",
	contentType : "application/json;charset=utf-8",
	url : _path + "/ums/creat/register2",
	dataType : "json",
	data : JSON.stringify(formData),
	success : function(data) {
		if (data.status == "S") {
			window.location = _path + "/ums/user/login";
		} else if (data.status == "F") {
			alert("注册失败"+data.message);
		}
	},
/*	error : function() {
		alert("error");
	}*/
});
}
	
	

	
		
