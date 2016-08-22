<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:Default pageId="orderInfo">
	${view.editInfo.id}
	<br />
	${view.editInfo.title}
	<br />
	${view.editInfo.items[0].productName}
	
	<br />
	${view.editInfo.items[1].productName}
	
	<br />
	${view.editInfo.items[2].productName}
	<br />
	
</layout:Default>