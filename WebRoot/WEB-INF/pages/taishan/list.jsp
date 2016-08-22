<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:Default pageId="orderList">
	<h1>Order List</h1>
	<form:form action="${pageContext.request.contextPath}/taishan/list" 
		method="post" modelAttribute="view">
		<input type="hidden" name="editInfo.id" id="editInfoId" />
		<label>Status :</label>
		<select name="condition.status">
			<option value="-1" <c:if test="${view.condition.status ==-1}">checked="checked"</c:if>>All</option>
			<option value="0" <c:if test="${view.condition.status ==0}">checked="checked"</c:if>>Draf0t</option>
			<option value="1" <c:if test="${view.condition.status ==1}">checked="checked"</c:if>>Commit</option>
			<option value="2" <c:if test="${view.condition.status ==2}">checked="checked"</c:if>>Payment</option>
			<option value="3" <c:if test="${view.condition.status ==3}">checked="checked"</c:if>>Received</option>
			<option value="4" <c:if test="${view.condition.status ==4}">checked="checked"</c:if>>Close</option>
		</select>
		</br>
		<input type="submit" value="Search" >
		</br>
		<table width="100%">
			<!--
					标题		金额			状态			 
			 -->
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
						<td><a href="#" onclick="editOrder(${order.id})" >${order.title}</a></td>
						<td>${order.amount}</td>
						<td>${order.status}</td>
						<td>&nbsp;</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty view.list}">			
			<tr><td colspan="5">No Record(s) Watch</td></tr>
			</c:if>
		</table>
	</form:form>
	
	<script>
	function editOrder(orderId){
		document.forms[0].action = "${pageContext.request.contextPath}/taishan/info";
		document.forms[0].editInfoId.value = orderId;
		document.forms[0].submit();
	}
	</script>
	
</layout:Default>