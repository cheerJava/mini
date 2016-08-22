<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<jsp:include page="../common/meta.jsp" />
<jsp:include page="../common/resources.jsp" />
<script src="${path}/scripts/ums/login.js?20160811" ></script>
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
	<div class="container">

		<form class="form-signin" role="form" id = "form" action="${path}/ums/user/validatelogin">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input name = "account" class="form-control" placeholder="Account" required autofocus>
			<input name ="password" type="password" class="form-control" placeholder="Password" required>
			<button class="btn btn-lg btn-primary btn-block" type="button" onclick="login()">Sign in</button>
		</form>

	</div>
	<!-- /container -->

</body>

</html>
