<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>

<layout:Default pageId="userInfo">

	<form:form action="${pageContext.request.contextPath }/loujiang/update"
		method="post" modelAttribute="view">


		<form:hidden path="accountCondition.accountTypeFk" />

		<form:hidden path="editInfo.id" />
		<table width="100%">

			<tr>
				<td>账户名</td>

				<td><form:input path="editInfo.account" name="editInfo.account" /></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><form:input path="editInfo.name" /></td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><form:input path="editInfo.nickname" /></td>
			</tr>
			<tr>
				<td>权限</td>
				<td><form:input path="editInfo.accountTypeFk" /></td>
			</tr>

			<tr>
				<td>性别</td>
				<td><form:input path="editInfo.gender" /></td>
			</tr>

			<tr>
				<td>密码</td>
				<td><form:input path="editInfo.password" /></td>
			</tr>



		</table>
		<input type="submit" value="保存" />




	</form:form>
</layout:Default>