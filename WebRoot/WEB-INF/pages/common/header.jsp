<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

  <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span> 
          <span class="icon-bar"></span> 
          <span class="icon-bar"></span> 
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand">管理后台</a>
      </div>
      <div class="navbar-right">
	      <ul>
	        <li style="float:left;" class="dropdown"><span class="navbar-brand" data-toggle="dropdown">您好, ${sessionScope.LOGIN_USER.nickname } !</span></li>
	        <li style="float:left;"><a class="navbar-brand" href="${path }/ums/user/logout" onclick="javascript:sessionStorage.clear();">登出</a></li>
	      </ul>
      </div>
	
    </div>
  </div>