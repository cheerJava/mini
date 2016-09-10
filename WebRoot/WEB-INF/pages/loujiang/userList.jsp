<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>

<layout:Default pageId="userList">
	<div class="panel panel-primary">
		<div class="panel-heading">用户资料维护</div>
		<div class="panel-body">
			<!-- <h1>用户资料维护</h1> -->
			<form:form
				action="${pageContext.request.contextPath}/loujiang/listByFk"
				method="post" modelAttribute="view">
				<input type="hidden" name="editInfo.id" id="editInfoId" />
				<input type="hidden" name="condition.account" id="conditionAccount" />
				<label>用户组 :</label>
				<select name="condition.accountTypeFk">
					<option value="200"
						<c:if test="${view.condition.accountTypeFk ==200}">selected="true"</c:if>>超级管理员组</option>
					<option value="100"
						<c:if test="${view.condition.accountTypeFk ==100}">selected="true"</c:if>>普通用户组</option>
				</select>
				<input type="submit" class="btn btn-primary" value="Search" />
				<%-- <div class="btn-group" name="condition.accountTypeFk">
			<button value="200" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
				<c:if test="${view.condition.accountTypeFk ==200}">selected="true"</c:if>>超级管理员组
					<span class="caret"></span>
			</button>
				<ul class="dropdown-menu">
					<li><a href="#" value="100" <c:if test="${view.condition.accountTypeFk ==100}">selected="true"</c:if>>普通用户组</a></li>
				</ul>
		</div> --%>

				<input type="text" id="serchByAccount" size=100
					style="margin-left: 300px; width: 100px; height: 20px;" />
				<input type="submit" class="btn btn-primary" value="按姓名查找"
					onclick="searchByAccount()" />
				<input type="submit" class="btn btn-primary" value="查找所有用户"
					onclick="showAll()" />


				</br>
				<br />
				<table width="100%" class="table table-striped table-hover">
					<tr>
						<th>选择</th>
						<th>姓名</th>
						<th>昵称</th>
						<th>账号</th>
						<th>密码</th>
						<th>性别</th>
						<th>创建日期</th>
						<th>用户组</th>
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
								<td>${user.password}</td>
								<td>${user.gender}</td>
								<td><fmt:formatDate value="${user.dateCreate}"
										pattern="dd/MM/yyyy HH:mm:ss" /></td>
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
				<c:if test="${!empty view.page }">
					<layout:Page page="${view.page}"/>
				</c:if>
				<br />
				<input type="button" class="btn btn-danger" value="删除用户"
					onclick="deleteUser()">
				<input type="button" class="btn btn-warning" value="新建账号"
					onclick="register()">
			</form:form>
		</div>
	</div>
	<script>
	
	function editUser(id){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/userinfo";
		document.forms[0].editInfoId.value = id;
		document.forms[0].submit();
	}
	
	 <%-- function deleteUser(){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/delete";
		document.forms[0].submit();
	} 
	 --%>
	function deleteUser(){
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
	
	function searchByAccount(){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/listByAccount";
		document.forms[0].conditionAccount.value = document.getElementById('serchByAccount').value;
		document.forms[0].submit();
	}
	
	function showAll(){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/userShow";
		document.forms[0].submit();
	}
	
	function register(){
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/register";
		document.forms[0].submit();
	}
	
	function page(pageNo){
		$("#pageNo").val(pageNo);
		document.forms[0].action = "${pageContext.request.contextPath}/loujiang/userShow";
		document.forms[0].submit();
	}
	
	</script>

</layout:Default>