<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>

<layout:Default pageId="orderInfo">
	<div class="panel panel-primary">
		<div class="panel-heading">订单详情</div>
		<div class="panel-body">
			<form:form action="${pageContext.request.contextPath}/yushan/save"
				method="post" modelAttribute="view">
				<form:hidden path="condition.status" />
				<form:hidden path="editInfo.id" />			
				<layout:Page page="${view.page}" isView="false"/>
				
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
					
						<tr>
							<td><input type="hidden"
								name="editInfo.items[0].id" value="QE938PJ0YWHXPWVQL4Z3UMRAAXPJRP4R" />
							  <input type="hidden"
								name="editInfo.items[0].productName"
								value="苹果" /> 苹果</td>
							<td><input type="hidden"
								name="editInfo.items[0].price"
								value="10" /> 10</td>
							<td><input type="text"
								name="editInfo.items[0].number"
								value="${item.number}" /></td>
						</tr>
	
				</table>
				<input class="btn btn-primary" type="submit" value="添加">
				<input class="btn btn-default" type="button" value="取消" onclick="cancel()">
			</form:form>
		</div>
	</div>
	
	<script>
		function cancel(){
			document.forms[0].action = "${pageContext.request.contextPath}/yushan/list";
			document.forms[0].submit();
		}
	</script>


</layout:Default>