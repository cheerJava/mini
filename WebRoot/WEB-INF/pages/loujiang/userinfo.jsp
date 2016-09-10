<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:Default pageId="userInfo">
<div class="panel panel-primary">
	<div class="panel-heading">用户资料明细</div>
	<div class="panel-body">
<!-- <h1>用户资料明细</h1> -->
	<form:form action="${pageContext.request.contextPath}/loujiang/update"
		method="post" modelAttribute="view">
		<form:hidden path="editInfo.id" />
		<layout:Page page="${view.page }" isView="false"/>
		<table  class="table table-striped table-hover">
			<tr>
				<td>姓名</td><td><form:input path="editInfo.name" /></td>
			</tr>
			<tr>
				<td>昵称</td><td><form:input path="editInfo.nickname" /></td>
			</tr>
			<tr>
				<td>账号</td><td><form:input path="editInfo.account" /></td>
			</tr>
			<tr>
				<td>密码</td><td><form:input path="editInfo.password" /></td>
			</tr>
			<tr>
				<td>颜值</td><td><form:input path="editInfo.salt" /></td>
			</tr>
			<tr>
				<td>性别</td><td><form:input path="editInfo.gender" /></td>
			</tr>
			<tr>
				<td>用户组</td><c:if test="${view.editInfo.accountTypeFk!='200'}"><td style="color:red"><form:input path="editInfo.accountTypeFk" />
							提示:用户组权限为200才可进入系统
							</td></c:if>
							<c:if test="${view.editInfo.accountTypeFk=='200'}"><td><form:input path="editInfo.accountTypeFk" /></td></c:if>
			</tr>
			
			<tr>
				<td>创建日期</td>
				<form:input type="hidden" path="editInfo.dateCreate"/>
				<td>
					<fmt:formatDate value="${view.editInfo.dateCreate}" 
						pattern="dd/MM/yyyy HH:mm:ss"/>
				</td>
				<%-- <td><form:input path="editInfo.dateCreate" /></td> --%>
			</tr>
			
			<tr>
				<td>更新日期</td><td>
				<fmt:formatDate value="${view.editInfo.dateUpdate}" 
						pattern="dd/MM/yyyy HH:mm:ss"/>
				<%-- <form:input path="editInfo.dateUpdate" /> --%>
				</td>
			</tr>
			<tr>
				<td>建号者ID</td><td><form:input path="editInfo.creatorFk" /></td>
			</tr>
			<tr>
				<td>更新者ID</td><td><form:input path="editInfo.updaterFk" /></td>
			</tr>
			<tr>
				<td>可用状态</td><c:if test="${view.editInfo.isValid!='1'}"><td style="color:red"><form:input path="editInfo.isValid" />
								提示:账号状态只有为1时才能正常使用
								</td></c:if>
								<c:if test="${view.editInfo.isValid=='1'}"><td><form:input path="editInfo.isValid" /></td></c:if>
			</tr>
		</table>
		<input type="submit" class="btn btn-primary" value="保存">
		<input type="button" class="btn btn-primary" value="取消" onclick="cancel()">
	</form:form>
	</div>
</div>

<script>
	
	function cancel(){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/userShow";
		document.forms[0].submit();
	}
</script>
</layout:Default>