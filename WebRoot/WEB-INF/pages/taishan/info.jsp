<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:Default pageId="orderInfo">
	<form:form action="${pageContext.request.contextPath}/taishan/save"
		method="post" modelAttribute="view">
		<form:hidden path="condition.status" />
		<form:hidden path="editInfo.id" />
		<fieldset>订单详情</fieldset>
		<div class="form-group">
			<label>标题</label>
			<form:input path="editInfo.title" cssClass="form-control" />
		</div>
		
		<div class="form-group">
			<label>金额</label>
			<form:input path="editInfo.amount" cssClass="form-control" />
		</div>
		
		<div class="form-group">
			<label>备注</label>
			<form:input path="editInfo.remark" cssClass="form-control" />
		</div>
		
		<div class="form-group">
			<label>状态</label>
			<form:input path="editInfo.status" cssClass="form-control" />
		</div>
		
		
		
		<table width="100%">
			<tr>
				<th>商品名</th>
				<th>价格</th>	
				<th>数量</th>
			</tr>
			<c:forEach items="${view.editInfo.items}" var="item" varStatus="loopStatus">
			<tr>
				<td>
					<input type="hidden" name="editInfo.items[${loopStatus.index}].id" 
						value="${item.id}" />
					<input type="hidden" name="editInfo.items[${loopStatus.index}].orderId" 
						value="${item.orderId}" />
					<input type="hidden" name="editInfo.items[${loopStatus.index}].productName" 
						value="${item.productName}" />
					${item.productName}
				</td>
				<td>
					<input type="hidden" name="editInfo.items[${loopStatus.index}].price" 
						value="${item.price}" />
					${item.price}
				</td>
				<td>
					<input type="text" name="editInfo.items[${loopStatus.index}].number"
						value="${item.number}" />
				</td>
			</tr>
			</c:forEach>
		</table>
		<input class="btn btn-primary" type="submit" value="保存">
	</form:form>
</layout:Default>