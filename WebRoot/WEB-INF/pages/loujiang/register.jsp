<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="field" tagdir="/WEB-INF/tags/field" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<jsp:include page="../common/meta.jsp" />
<jsp:include page="../common/resources.jsp" />
<script src="${path }/scripts/demo/portal.js"></script>
<script src="${path}/scripts/ums/register.js?20160811" ></script>
<!-- <script>
$(function(){
	$("#submit").click(function(){
	window.location = _path + "/ums/user/validateregister";
	});
});
</script> -->

<script>

</script>


<style type="text/css">
	body {
	  padding-top: 40px;
	  padding-bottom: 40px;
	  background-color: #eee;
	}
	
	.form-signin {
	  max-width: 330px;
	  padding: 15px;
	  margin: 0 auto;
	}
	.form-signin .form-signin-heading,
	.form-signin .checkbox {
	  margin-bottom: 10px;
	}
	.form-signin .checkbox {
	  font-weight: normal;
	}
	.form-signin .form-control {
	  position: relative;
	  height: auto;
	  -webkit-box-sizing: border-box;
	     -moz-box-sizing: border-box;
	          box-sizing: border-box;
	  padding: 10px;
	  font-size: 16px;
	}
	.form-signin .form-control:focus {
	  z-index: 2;
	}
	.form-signin input[type="email"] {
	  margin-bottom: -1px;
	  border-bottom-right-radius: 0;
	  border-bottom-left-radius: 0;
	}
	.form-signin input[type="password"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
</style>
</head>
<body>

	<jsp:include page="../common/header.jsp" />
	<div class="container-fluid">
		<div class="row row-offcanvas row-offcanvas-right">
			<jsp:include page="../common/menu.jsp" />
			
			<div class="col-xs-12 col-sm-10">
	<div class="container">
		<form class="form-signin" role="form" id="form" modelAttribute="view" action="">
			<h2 class="form-signin-heading">Please Register</h2>
			<input name = "name" class="form-control" placeholder="name" required autofocus>
			<input name = "nickname" class="form-control" placeholder="nickname" required autofocus>
			<input name = "gender" class="form-control" placeholder="Gender 男：1 女：2" required autofocus>
			<input name ="accountTypeFk" type="form-control" class="form-control" placeholder="accountTypeFk" required>
			<input name = "account" class="form-control" placeholder="account" required autofocus>
			<input name ="password" type="password" class="form-control" placeholder="Password" required>
			<field:images suffixName="salt" styleId="salt" preffixName="salt"
				limit="1" />
			<button id="btnSubmit" class="btn btn-lg btn-primary btn-block" type="button" onclick="register()">Submit</button>
		</form>
	</div>
	</div>
			<!--/.col-xs-12.col-sm-9-->
		</div>
		<!--/row-->

		<jsp:include page="../common/footer.jsp" />

	</div>
	<!--/.container-->
	<script type="text/javascript">
		$("#birthday").datetimepicker();
		
		
		function register()
		{
			$("input[name='salt.[0].salt']").attr("name","salt");
			var formData = $("#form").serialize2Json();
			console.log(formData);
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

	</script>
</body>
</html>