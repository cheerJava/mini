<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<layout:Default pageId="userShow">

<script type="text/javascript">
	$(function() {

		$.ajax({
			type : "POST",
			contentType : "application/json;charset=utf-8",
			url : _path + "/loujiang/searchUser",
			dataType : "json",
			success : function(data) {
				if (data.status == "S") {
					var _list = data.list;
					for ( var i = 0; i < _list.length; i++) {
						var item = _list[i];
						var _record = "<tr><td><input type='checkbox' value='"+ item.id +"'/></td><td>"
								+ item.name + "</td><td>" + item.nickname
								+ "</td><td>" + item.account + "</td><td>"+item.gender+"</td><td>"+item.dateCreate+"</td><td>"
								+item.accountTypeFk+"</td></tr>";

						$("#searchUserContext").append(_record)
					}
				} else if (data.status == "F") {
					alert(data.message);
				}
			},
			error : function() {
				alert("error");
			}
			
		});
		$("#selectedAll").click(function(){
			var _checked=$(this).prop("checked");
			$("input[type=checkbox]",$("#searchUserContext")).each(function(){
				$(this).prop("checked",_checked);
				
		});
		});

	});
	
</script>
<body>
<div class="container-fluid">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-12 col-sm-10">
				<table width="100%" border="1">
					<tr>
						<th>选择<input id="selectedAll" type="checkbox" ></th>
						<th>姓名</th>
						<th>昵称</th>
						<th>密码</th>
						<th>性别</th>
						<th>创建日期</th>
						<th>用户组</th>
					</tr>
					<tbody id="searchUserContext"></tbody>
				</table>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />

	</div>
</body>
</layout:Default>