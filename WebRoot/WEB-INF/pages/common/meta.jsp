<%@ page language="java" pageEncoding="UTF-8"
import="com.cheer.mini.base.Constants"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  request.setAttribute("path", path);
  request.setAttribute("loginUser", request.getAttribute(Constants.CURRENT_USER));
  
%>        
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 禁止页面缓存 -->
	    <meta http-equiv="pragram" content="no-cache">
	    <meta http-equiv="Cache-Control" content="no-cache">
	    <meta http-equiv="expires" content="0">
		<title>管理后台</title>
		
		<script>
			_path = "${path }";
		</script>