<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>

<layout:Default pageId="list">
	<h1>User List</h1>
	<form:form action="${pageContext.request.contextPath}/loujiang/list"
		method="post" modelAttribute="view">
		<input type="hidden" name="editInfo.id" id="editInfoId" />
		<label>Name:</label>
		<form:input path = "accountCondition.name" />
		<label>Status :</label>
		<select name="accountCondition.accountTypeFk">
			<option value="-1" <c:if test="${view.accountCondition.accountTypeFk == -1}"> selected="true" </c:if> >All</option>
			<option value="100" <c:if test="${view.accountCondition.accountTypeFk == 100}"> selected="true" </c:if> >Worker</option>
			<option value="200" <c:if test="${view.accountCondition.accountTypeFk == 200}"> selected="true" </c:if> >Administor</option>

		</select>
		</br>
		<input type="submit" value="Search">
		</br>
		<table width="80%">
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>昵称</th>
				<th>账户</th>
				<th>权限</th>
			</tr>
			<c:if test="${!empty view.list}">
				<c:forEach items="${view.list}" var="user" varStatus="loopStatus">
					<tr>
						<td><input type="checkbox" value="true"
							name="list[${loopStatus.index}].selected"> <input
							type="hidden" value="${user.id}"
							name="list[${loopStatus.index}].id"></td>
						<td><a href="#" onclick="editUser('${user.id}')">${user.name}</a></td>
						<td>${user.nickname}</td>
						<td>${user.account}</td>
						<td>${user.accountTypeFk}</td>

					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty view.list}">
				<tr>
					<td colspan="5">No Record(s) Watch</td>
				</tr>
			</c:if>
		</table>
		<br />
		<input type="button" value="Delete" onclick="deleteUsers()">
		<br />
		
			<input type="button" value="save" onclick="insterUsers()"> 
		
	</form:form>



	<script>
		function editUser(userId) {
			document.forms[0].action = "${pageContext.request.contextPath}/loujiang/info";
			document.forms[0].editInfoId.value = userId;
			document.forms[0].submit();
		}

		function deleteUsers() {
			document.forms[0].action = "${pageContext.request.contextPath}/loujiang/delete";
			document.forms[0].submit();
		}

		function insterUsers() {
			document.forms[0].action = "${pageContext.request.contextPath}/loujiang/insterUsers";
			document.forms[0].submit();
		}
	</script>
</layout:Default>