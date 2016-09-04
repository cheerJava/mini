<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:Default pageId="orderList">
	<h1>Order List</h1>
	<form:form action="${pageContext.request.contextPath}/taishan/list" 
		method="post" modelAttribute="view">
		<input type="hidden" name="editInfo.id" id="editInfoId" />
		<label>Title :</label>
		<form:input path="condition.title" cssClass="input-text"/>
		<label>Status :</label>
		<select name="condition.status" class="dropdown">
			<option value="-1" <c:if test="${view.condition.status ==-1}">selected="true"</c:if>>All</option>
			<option value="0" <c:if test="${view.condition.status ==0}">selected="true"</c:if>>Draf0t</option>
			<option value="1" <c:if test="${view.condition.status ==1}">selected="true"</c:if>>Commit</option>
			<option value="2" <c:if test="${view.condition.status ==2}">selected="true"</c:if>>Payment</option>
			<option value="3" <c:if test="${view.condition.status ==3}">selected="true"</c:if>>Received</option>
			<option value="4" <c:if test="${view.condition.status ==4}">selected="true"</c:if>>Close</option>
		</select>
		<input class="btn btn-default" type="submit" value="Search" >
		</br>
		</br>
		<table width="100%" class="table table-hover table-condensed">
			<tr>
				<th>选择</th>
				<th>标题</th>
				<th>金额</th>
				<th>状态</th>
				<th>创建日期</th>
			</tr>
			<c:if test="${!empty view.list}">
				<c:forEach items="${view.list}" var="order" varStatus="loopStatus">
					<tr>
						<td>
							<input type="checkbox" value="true" 
								name="list[${loopStatus.index}].selected">
							<input type="hidden" value="${order.id}"
								name="list[${loopStatus.index}].id">
						</td>
						<td><a href="#" onclick="editOrder('${order.id}')" >${order.title}</a></td>
						<td>${order.amount}</td>
						<td>${order.status}</td>
						<td>
							<fmt:formatDate value="${order.dateCreate}" 
								pattern="dd/MM/yyyy HH:mm:ss" />
							<fm
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty view.list}">			
			<tr><td colspan="5">No Record(s) Watch</td></tr>
			</c:if>
		</table>
		
		<c:if test="${!empty view.page}">
			<form:hidden path="page.pageNo" id="pageNo" />
			<form:hidden path="page.pageSize" />
			<ul class="pagination">
				<c:if test="${view.page.pageNo eq 1}">
				<li class="disabled"><a href="#">&laquo;</a></li>
				</c:if>
				<c:if test="${view.page.pageNo ne 1}">
				<li><a href="#" onclick="page(${view.page.pageNo-1})">&laquo;</a></li>
				</c:if>
				<c:forEach begin="1" end="${view.page.totalPage}" varStatus="loop" >
					<li><a href="#" onclick="page(${loop.index})">${loop.index}</a></li>
				</c:forEach>
				<c:if test="${view.page.pageNo eq view.page.totalPage}">
				<li class="disabled"><a href="#">&raquo;</a></li>
				</c:if>
				<c:if test="${view.page.pageNo ne view.page.totalPage}">
				<li><a href="#" onclick="page(${view.page.pageNo+1})">&laquo;</a></li>
				</c:if>
			</ul>
		</c:if>
		<br>
		<input class="btn btn-warning" type="button" value="Delete" onclick="deleteOrders()">
	</form:form>
	
	<script>
	function editOrder(orderId){
		document.forms[0].action = "${pageContext.request.contextPath}/taishan/info";
		document.forms[0].editInfoId.value = orderId;
		document.forms[0].submit();
	}
	
	function deleteOrders(){
		var _selected = false;
		$("input[type=checkbox]").each(function(){
			if($(this).prop("checked")){
				_selected = true;
				return false;
			}
		})
		if(_selected){
			if(confirm("你确定要删除这些记录？")){
				document.forms[0].action = "${pageContext.request.contextPath}/taishan/delete";
				document.forms[0].submit();	
			}
		}else{
			alert("需要至少选一条记录！");
		}
	}
	
	function page(pageNo){
		$("#pageNo").val(pageNo);
		document.forms[0].action = "${pageContext.request.contextPath}/taishan/list";
		document.forms[0].submit();
		
	}
	
	</script>
	
</layout:Default>