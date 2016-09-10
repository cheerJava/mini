<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

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
		<table width="100%">
			<!--
					标题		金额			状态			 
			 -->
			<tr>
				<th>选择</th>
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
						<td>${user.dateCreate}</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty view.list}">			
			<tr><td colspan="5">No Record(s) Watch</td></tr>
			</c:if>
		</table>
		<br />
		<input type="button" value="Add" onclick="addOrders()">
		<input type="button" value="Delete" onclick="deleteOrders()">
		<input type="button" value="Search" onclick="searchOrders()">
		
	</form:form>
	

	
	<script>
	function editUser(userId){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/info";
		document.forms[0].editInfoId.value = userId;
		document.forms[0].submit();
	}
	
	function deleteOrders(){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/delete";
		document.forms[0].submit();
	}
	
	function addOrders(){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/addjsp";
		document.forms[0].submit();
	}
	
	function searchOrders(){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/search";
		document.forms[0].submit();
	}
	


	
	</script>
	
</layout:Default>