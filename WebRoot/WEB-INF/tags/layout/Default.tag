<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="pageId" required="true" type="java.lang.String"%>

<!DOCTYPE HTML>
<html style="overflow-y:auto;">
<head>
<jsp:include page="../../pages/common/meta.jsp" />
<jsp:include page="../../pages/common/resources.jsp" />
<script src="${pageContext.request.contextPath}/scripts/demo/portal.js"></script>
</head>

<body>
	<jsp:include page="../common/header.jsp" />
	<div class="container-fluid">
		<div class="row row-offcanvas row-offcanvas-right">
			<jsp:include page="../../pages/common/menu.jsp" />
			<div class="col-md-10" style="overflow-y:auto;padding-bottom: 40px; padding-top: 30px;" id="<%=pageId%>">
				<jsp:doBody />
			</div>
			<jsp:include page="../../pages/common/footer.jsp" />
		</div>
		<!--/.container-->
	</div>
</body>
</html>