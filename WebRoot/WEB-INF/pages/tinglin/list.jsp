<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>

<layout:Default pageId="ProList">
	<div id="content" class="float_r">
		<h1 align="center">产品列表</h1>
		<form:form action="${pageContext.request.contextPath}/tinglin/list"
			method="post" modelAttribute="view">
			<input type="hidden" name="proInfo.id" id="proInfoId" />
			<table width="90%" cellspacing="0" cellpadding="5" border="2"
				class="table table-striped  table-hover">
				<tr bgcolor="gray">
					<th width="5%" align="left"><input type="checkbox"
						id="selectAll" />全 选</th>
					<th width="20%" align="left">Image</th>
					<th width="20%" align="left">Description</th>
					<th width="15%" align="right">Name</th>
					<th width="10%" align="right">Price</th>
					<th width="12%">Read More</th>

				</tr>
				<c:if test="${!empty view.list}">
					<c:forEach items="${view.list}" var="pro" varStatus="loopStatus">
						<tr>
							<td><input type="checkbox" value="true"
								name="list[${loopStatus.index}].selected"> <input
								type="hidden" value="${pro.id}"
								name="list[${loopStatus.index}].id"></td>
							<td><img src="${pro.imageFullPath}" width="80%" height="10%"
								alt="image 1" /></td>
							<td>${pro.description}</td>
							<td align="left">${pro.name}</td>
							<td align="left">${pro.price}</td>
							<td align="left"><a href="#" onclick="Profind('${pro.id}')">详细信息</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty view.list}">
					<tr>
						<td colspan="7">仓库没有商品，页面显示错误,请刷新</td>
					</tr>
				</c:if>
			</table>
			<div style="float: left; width: 215px; margin-top: 20px;">

				<p>
					<input class="btn btn-warning" type="button" value="REFRESH"
						onclick="backhome()">
				</p>
				<p>
					<input class="btn btn-warning" type="button" value="DELETE THIS"
						onclick="deletePro()">
				</p>

			</div>

			<div style="float: right; width: 215px; margin-top: 20px;">

				<p>

					<form:input path="condition.name" cssClass="input-text" />
					<input class="btn btn-warning" type="submit" value="Search">
				</p>

			</div>

			<div style="float: right; width: 115px; margin-top: 20px;">
				<h2>搜索栏:</h2>
			</div>
	</div>
	<c:if test="${!empty view.page}">
		<layout:Page page="${view.page}" />
	</c:if>

	</form:form>



	<script>
		$(function() {
			$.checkBoxEvent($("#selectAll"),
					$("input[name^=list][name$=selected]"));
		});

		function Profind(proId) {

			document.forms[0].action = "${pageContext.request.contextPath}/tinglin/info";
			document.forms[0].proInfoId.value = proId;
			document.forms[0].submit();
		}
		function deletePro() {
			var _selected = false;
			$("input[type=checkbox]").each(function() {
				if ($(this).prop("checked")) {
					_selected = true;
					return false;
				}
			})
			if (_selected) {
				if (confirm("你确定要删除这些记录？")) {
					document.forms[0].action = "${pageContext.request.contextPath}/tinglin/delete";
					document.forms[0].submit();
				}
			} else {
				alert("需要至少选一条记录！");
			}
		}
		function backhome() {
			document.forms[0].action = "${pageContext.request.contextPath}/tinglin/list";
			document.forms[0].submit();
		}

		function page(pageNo) {
			$("#pageNo").val(pageNo);
			document.forms[0].action = "${pageContext.request.contextPath}/tinglin/list";
			document.forms[0].submit();

		}
	</script>
</layout:Default>