<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta name="viewport" content="width=device-width,initial-scale=1">
<layout:Default pageId="userList">
	<h1>User List</h1>
	<form:form action="${pageContext.request.contextPath}/loujiang/list" 
		method="post" modelAttribute="view">
		<input type="hidden" name="editInfo.id" id="editInfoId" />
		<label>Search :</label>
		<form:input path="condition.name"/> 
		<!--  <label>权限 :</label> -->
		 <%--  <select name="condition.name">
			 <option value="超级管理员" <c:if test="${view.condition.name ==超级管理员}">selected="true"</c:if>>超级管理</option> 
			 <option value="2" <c:if test="${view.condition.name ==2}">selected="true"</c:if>>普通用户</option>  
			 <option value="3" <c:if test="${view.condition.name ==3}">selected="true"</c:if>>Commit</option>
			  <option value="2" <c:if test="${view.condition.status ==2}">selected="true"</c:if>>Payment</option>
			<option value="3" <c:if test="${view.condition.status ==3}">selected="true"</c:if>>Received</option>
			<option value="4" <c:if test="${view.condition.status ==4}">selected="true"</c:if>>Close</option>  
		</select>   --%>
		</br>
		<!-- <input type="submit" value="Search" > -->
		</br>
		<table class="table table-bordered" width="100%">
			<!--
					标题		金额			状态			 
			 -->
			<tr>
				<th>选择
					<input type="checkbox" id="selectAll">
				</th>
				<th>用户名</th>
				<th>昵称</th>
				<th>性别</th>
				<th>权限</th>
				<th>创建日期</th>
			</tr>
			<c:if test="${!empty view.list}">
				<c:forEach items="${view.list}" var="user" varStatus="loopStatus">
					<tr>
						<td>
							<input type="checkbox" value="true" 
								name="list[${loopStatus.index}].selected">
							<input type="hidden" value="${user.id}"
								name="list[${loopStatus.index}].id">
						</td>
						<td><a href="#" onclick="editUser('${user.id}')" >${user.name}</a></td>
						 <td>${user.nickname}</td>
						 <td>${user.gender}</td>
						<td>${user.accountTypeFk}</td>
						<td>
							<fmt:formatDate value="${user.dateCreate}" 
								pattern="dd/MM/yyyy HH:mm:ss"/>
						</td>
						 
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty view.list}">			
			<tr><td colspan="5">No Record(s) Watch</td></tr>
			</c:if>
		</table>
		
		
		<c:if test="${!empty view.page }">
					<layout:Page page="${view.page }" isView="true"/>
				</c:if>
		
		
		<%-- <form:hidden path="page.pageNo" id="pageNo"/>
		<form:hidden path="page.pageSize" />
		<ul class="pagination">
			<c:if test="${view.page.pageNo eq 1 }">
			<li class = "disable"><a href ="#">&laquo;</a></li>
			</c:if>
			
			<c:if test="${view.page.pageNo ne 1 }">
			<li ><a href ="#" onclick="page(${view.page.pageNo-1})">&laquo;</a></li>
			</c:if>
			
			<c:forEach begin="1" end="${view.page.totalPage }" varStatus ="loop">
				<li><a href="#" onclick="page(${loop.index})">${loop.index}</a></li>
			</c:forEach>
				
			<c:if test="${view.page.pageNo eq view.page.totalPage }">
			<li class = "disable"><a href ="#">&raquo;</a></li>
			</c:if>	
			
			<c:if test="${view.page.pageNo ne view.page.totalPage }">
		   <li><a href="#" onclick="page(${view.page.pageNo+1})">&raquo;</a></li>
		    </c:if> --%>
		
		<br />
		<input class="btn btn-primary" type="button" value="Add" onclick="addOrders()">
		<input class="btn btn-warning" type="button" value="Delete" onclick="deleteOrders()">
		<input class="btn" type="button" value="Search" onclick="searchOrders()">
		
	</form:form>
	

	
	<script>
	function editUser(userId){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/info";
		document.forms[0].editInfoId.value = userId;
		document.forms[0].submit();
	}
	
	function deleteOrders(){
		var _selected=false;
		$("input[type=checkbox]").each(function(){
			if($(this).prop("checked")){
				_selected=true;
				return false;
			}
		})
		if(_selected){
			if(confirm("确定删除？")){
				document.forms[0].action = "${pageContext.request.contextPath}/loujiang/delete";
				document.forms[0].submit();
			}
		}else{
			alert("需要至少选择一条数据")
		}
		
	}
	
	function addOrders(){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/addjsp";
		document.forms[0].submit();
	}
	
	function searchOrders(){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/search";
		document.forms[0].submit();
	}
	
	function page(pageNo) {
		$("#pageNo").val(pageNo);
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/list";
		document.forms[0].submit();
	}
	
	$(function(){
		$.checkBoxEvent($("#selectAll"),
			$("input[name^=list][name$=selected]"));
	});

	
	</script>
	
</layout:Default>