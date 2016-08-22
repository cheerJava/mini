<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:Default pageId="taishanHome">
<h1>Hello, Taishan<h1>


${user.name} <br> <!-- call User.getName()  -->

${user.nickname} <br> <!-- call User.getNickname()  -->

ToString output:
${user} <br> <!-- call User.toString()  -->

Info output :

${user.info} <br>  <!-- call User.getInfo()  -->

<form:form
	modelAttribute="user" 
	method="post" action="${pageContext.request.contextPath}/taishan/post">
	<form:input path="name" />   <!-- call User.setName($js.this.value)  -->
	<form:input path="nickname" /> <!-- call User.setNickname($js.this.value)  -->
	<form:input path="gender" />	<!-- call User.setGender($js.this.value)  -->
	<form:input path="account" />	<!-- call User.setAccount($js.this.value)  -->
	<form:input path="password" />	<!-- call User.setPassword($js.this.value)  -->
	
	<select id="userList">
		<c:if test="${!empty userList }">
			<c:forEach items="${userList}" var="item" varStatus="loopStatus">
				<option value="${item.id}">${item.name}</option>
			</c:forEach>
		</c:if>
	</select>	
	<input type="submit" value="Submit" >
	
</form:form>

<script type="text/javascript">
$(function (){
	//$("#taishanHome").find
});
</script>

</layout:Default>