<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:Default pageId="addUser">
<head>
<script src="${path}/scripts/ums/register.js?20160811"></script>
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
<!--${pageContext.request.contextPath}/loujiang/register  -->
		<form class="form-signin" role="form" id = "form" action="">
			<h2 class="form-signin-heading">Please Register</h2>
			<input name = "name" class="form-control" placeholder="name" required autofocus>
			<input name = "nickname" class="form-control" placeholder="nickname" required autofocus>
			<input name = "gender" class="form-control" placeholder="Gender 男：1 女：2" required autofocus>
			<input name = "account" class="form-control" placeholder="account" required autofocus>
			<input name ="password" type="password" class="form-control" placeholder="Password" required>
			<button  class="btn btn-lg btn-primary btn-block" type="submit" onclick="register()">Submit</button>
		</form>
		
	</div>
</body>
</layout:Default>
