<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="../common/meta.jsp" />
<jsp:include page="../common/resources.jsp" />
<script src="${path }/scripts/demo/portal.js"></script>
<script type="text/javascript">
	$(function() {
		alert("aaaaa");

		$.ajax({
			type : "POST",
			contentType : "application/json;charset=utf-8",
			url : _path + "/ums/admin/searchAdminlist",
			dataType : "json",
			data : {},
			success : function(data) {
				if (data.status == "S") {
					//window.location = _path + "/ums/user/index";

					var _list = data.list;
					console.log(_list);
					//alert(_list);
					for ( var i = 0; i < _list.length; i++) {
						var item = _list[i];
						
						var _record = "<tr><td><input type='checkbox' value='"  + item.id + "'></td><td>"+item.id +"</td><td>"
								+ item.name + "</td><td>" + item.nickname
								+ "</td><td>" + item.account + "</td></tr>";

						$("#adminlistContent").append(_record);
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
			$("input[type=checkbox]",$("#adminlistContent")).each(function(){
				$(this).prop("checked",_checked);
			});
		});
	});
</script>
</head>

<body>
	<jsp:include page="../common/header.jsp" />
	<div class="container-fluid">

		<div class="row row-offcanvas row-offcanvas-right">
			<jsp:include page="../common/menu.jsp" />
			<div class="col-xs-12 col-sm-10">

				<table width="80%">
					<tr>
						<th>Select<input id="selectedAll" type="checkbox" ></th>
						<th>ID</th>
						<th>Name</th>
						<th>NicName</th>
						<th>Account</th>
					</tr>
					<tbody id="adminlistContent">
						
					</tbody>
				</table>

			</div>
			<!--/.col-xs-12.col-sm-9-->


		</div>
		<!--/row-->

		<jsp:include page="../common/footer.jsp" />

	</div>
	<!--/.container-->

</body>
</html>
