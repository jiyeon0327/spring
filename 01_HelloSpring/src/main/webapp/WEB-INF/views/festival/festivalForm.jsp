<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="pageTitle" value="축제알리미"/>
</jsp:include>
<style>
 h3 {border-style: dotted solid double;}
 section#content {font-family: 'Do Hyeon', sans-serif; }
</style>  
<script>
</script>
<section id="content">
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<h1 class="my-4">festival Name</h1>
			<div class="list-group">
				<a href="#" class="list-group-item active">Category1</a>
				<a href="#" class="list-group-item active">Category2</a>
				<a href="#" class="list-group-item active">Category3</a>
			</div>
		</div>
		
	</div>
</div>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

