<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib uri="http://www.opensymphony.com/oscache" prefix="cache"%>
<script type="text/javascript" src="WebRoot/resources/jquery/jquery.scrollUp.js"></script>
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
            <a href="#" class="list-group-item" data-url="/tinglin/list">商品管理</a>
            <a href="#" class="list-group-item" data-url="/yusHan/list">订单列表</a>
            <a href="#" class="list-group-item" data-url="/loujiang/list">管理员用户列表</a>
          </div>
        </div><!--/.sidebar-offcanvas-->