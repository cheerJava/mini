<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib uri="http://www.opensymphony.com/oscache" prefix="cache"%>
<script type="text/javascript" src="WebRoot/resources/jquery/jquery.scrollUp.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery.scrollUp.js"></script>


<script>
$(function(){
	$("#sidebar .list-group a").each(function(){
		$(this).click( function(){
			//alert($(this).attr("data-url"));
			window.location="${pageContext.request.contextPath}" + $(this).attr("data-url");
		});
	});

	 $("#showuser").click(function(){
		window.location = _path + "/loujiang/userShow";
	}); 
	 /* $("#register").click(function(){
		window.location ="${pageContext.request.contextPath}/loujiang/register";
	}); */
});
</script>
<!-- <script src="WebRoot/resources/jquery/jquery-1.11.1.min.js"></script>
<script>
$(document).ready(function(){
  $("#showuser").click(function(){
	  alert("11");
    $("#register").fadeToggle();
    $("#edituser").fadeToggle("slow");
    $("#div3").fadeToggle(300);
  });
});
</script> -->

	  <div class="col-xs-6 col-sm-2 sidebar-offcanvas" id="sidebar" role="navigation">
          <div class="list-group">
          	<a href="#" class="list-group-item" data-url="/taishan/list">Taishan</a>	
            <a href="#" class="list-group-item" data-url="/tinglin/list">商品管理</a><!-- fukuan,puweihua -->
            <a href="#" id="1" class="list-group-item" data-url="/yushan/list">订单列表</a><!-- zhangli,shiwei -->
            <a href="#" class="list-group-item" id="showuser" data-url="/loujiang/list">管理员用户列表</a><!-- luzhiming,liugaoming,zheng -->
          	<!-- <a href="#" id="register" class="list-group-item">新建账号</a> -->
          	<!-- <a href="#" id="showuser" class="list-group-item">客户维护</a> -->
          	<!-- <div id="register" class="list-group-item" style="display:none;"><a href="#">新建账号</a></div>
			<div id="edituser" class="list-group-item" style="display:none;"><a href="#">编辑用户</a></div> -->
          </div>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib uri="http://www.opensymphony.com/oscache" prefix="cache"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery.scrollUp.js"></script>
<script>
$(function(){
	$("#sidebar .list-group a").each(function(){
		$(this).click( function(){
			//alert($(this).attr("data-url"));
			window.location="${pageContext.request.contextPath}" + $(this).attr("data-url");
		});
	})
	/***
	**/
});

</script>


	  <div class="col-xs-6 col-sm-2 sidebar-offcanvas" id="sidebar" role="navigation">
          <div class="list-group">
          	<a href="#" class="list-group-item" data-url="/taishan/list">Taishan</a>	
            <a href="#" class="list-group-item" data-url="/tinglin/list">商品管理</a><!-- fukuan,puweihua -->
            <a href="#" class="list-group-item" data-url="/yushan/list">订单列表</a><!-- zhangli,shiwei -->
            <a href="#" class="list-group-item" data-url="/loujiang/list">管理员用户列表</a><!-- luzhiming,liugaoming,zheng -->
          </div>
        </div><!--/.sidebar-offcanvas-->