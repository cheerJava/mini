<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:Default pageId="userInfo">
	<form:form action="${pageContext.request.contextPath}/loujiang/save"
		method="post" modelAttribute="view">
		
		<form:hidden path="condition.name" />
		<form:hidden path="editInfo.id" />
		<from:hidden path="page.pageNo" />
		<from:hidden path="page.pageSize" />
		<table width="100%">
			<tr>
				<td>用户名</td><td><form:input path="editInfo.name" /></td>
			</tr>
			<tr>
				<td>昵称</td><td><form:input path="editInfo.nickname" /></td>
			</tr>
			<tr>
				<td>账户</td><td><form:input path="editInfo.account" /></td>
			</tr>
			<tr>
				<td>性别</td><td><form:input path="editInfo.gender" /></td>
			</tr>
			<tr>
				<td>权限</td><td><form:input path="editInfo.accountTypeFk" /></td>
			</tr>
			<tr>
				<td>创建日期</td><td><form:input path="editInfo.dateCreate" /></td>
			</tr>
			
				</td>
			
		</table>
		
		<input type="submit" value="保存">
		
			
	</form:form>
</layout:Default>