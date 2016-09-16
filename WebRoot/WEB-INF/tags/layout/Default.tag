<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="pageId" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${pageId==null}">
	<c:set var="_pageId" value="main" />
</c:if>
<c:if test="${pageId!=null}">
	<c:set var="_pageId" value="${pageId}" />
</c:if>

<!DOCTYPE HTML>
<html style="overflow-y:auto;">
<head>
<jsp:include page="../../pages/common/meta.jsp" />
<jsp:include page="../../pages/common/resources.jsp" />
<script src="${pageContext.request.contextPath}/scripts/demo/portal.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<jsp:include page="../../pages/common/menu.jsp" />
			<div class="col-md-10" >
					<div class="row">
						<div class="col-md-12" id="alertMsgDiv" >
						</div>
					</div>
					<div class="row">
						<div class="col-md-12" id="${_pageId}" >
							<jsp:doBody />
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/.container-->
	</div>
	<jsp:include page="../../pages/common/footer.jsp" />
</body>
</html>
