<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>


<layout:Default pageId="InfoList">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h1>Product Detail</h1>
		</div>
		<div class="panel-body">
			<form:form action="${pageContext.request.contextPath}/tinglin/update"
				method="post" modelAttribute="view">

				<form:hidden path="proInfo.id" />
				<div id="content" class="float_r">
					<div class="content_half float_l">
						<a href="#"><img
							src="D:/cheer/sourceold/mini/WebRoot/WEB-INF/images/product/01.jpg"
							alt="image" /></a>
					</div>
					<div class="content_half float_r">
						<table width="60%">
							<tr>
								<td width="160">Name:</td>
								<td><form:input path="proInfo.name" cssClass="form-control"
										name="proInfo.name" /></td>
							</tr>
							<tr>
								<td>Description:</td>
								<td><form:input path="proInfo.description"
										cssClass="form-control" /></td>
							</tr>
							<tr>
								<td>Price:</td>
								<td><form:input path="proInfo.price"
										cssClass="form-control" /></td>
							</tr>
							<tr>
								<td>ImageFullPath:</td>
								<td><form:input path="proInfo.imageFullPath"
										cssClass="form-control" /></td>
							</tr>
							<tr>
								<td>Quantity</td>
								<td><input type="text" value="1"
									style="width: 20px; text-align: right" /></td>
							</tr>
						</table>
						<div class="cleaner h20"></div>

						<a href="#" class="addtocart"></a>

					</div>
					<div class="cleaner h30"></div>

					<h5>Product Description</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Curabitur semper quam sit amet turpis rhoncus id venenatis tellus
						sollicitudin. Fusce ullamcorper, dolor non mollis pulvinar, turpis
						tortor commodo nisl, et semper lectus augue blandit tellus.
						Quisque id bibendum libero. Validate</p>

					<div class="cleaner h50"></div>
				</div>
				<p>
					<input class="btn btn-warning" type="submit" value="Update THIS">
				</p>
				<p>
					<input class="btn btn-warning" type="button" value="BACK HOME"
						onclick="backhome()">
				</p>
			</form:form>
		</div>
		<div class="">


			<form class="form-signin" role="form" id="form"
				action="${pageContext.request.contextPath}/tinglin/add">
				<h2 class="form-signin-heading">ADD Product</h2>
				<input name="proInfo.name" class="form-control" placeholder="name"
					required autofocus /> <input name="proInfo.description"
					class="form-control" placeholder="description" required autofocus />
				<input name="proInfo.price" class="form-control" placeholder="price"
					required autofocus /> <input name="proInfo.imageFullPath"
					class="form-control" placeholder="imageFullPath" required autofocus />

				<p>
					<input class="btn btn-warning" type="submit" value="ADD THIS">
				</p>
			</form>

		</div>
	</div>

	<script>
		function backhome() {
			document.forms[0].action = "${pageContext.request.contextPath}/tinglin/index";
			document.forms[0].submit();
		}
	</script>
</layout:Default>