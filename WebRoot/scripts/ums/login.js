function login()
		{
				
				var formData = $("#form").serialize2Json();
				
				$.ajax({
				type :"POST",
				contentType : "application/json;charset=utf-8",
				url : _path+"/ums/user/validatelogin",
				dataType : "json",
				data : JSON.stringify(formData),
				success : function(data) {
					if (data.status == "S") {
						window.location = _path + "/ums/user/index";
					} else if (data.status == "F") {
						alert(data.message);
					}
				},
				error : function() {
					alert("error");
				}
			});
						
					
		}
