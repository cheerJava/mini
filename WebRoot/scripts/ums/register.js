function register() {

	var formData = $("#form").serialize2Json();

	$.ajax({
		type : "POST",
		contentType : "application/json;charset=utf-8",
		url : _path + "/loujiang/register",
		dataType : "json",
		data : JSON.stringify(formData),
		success : function(data) {
			if (data.status == "S") {
				alert("注册成功")
				window.location = _path + "/loujiang/list";
			} else if (data.status == "F") {
				alert("注册失败" + data.message);
			}
		},
		/*error : function() {
			alert("进入register方法但报error");
			window.location = _path + "/loujiang/list";
		}*/
	});
}
