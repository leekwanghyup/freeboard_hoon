<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/index.js"></script>
<style>
	body { padding-top : 70px; padding-bottom: 30px}
</style>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<article>
		<div class="container">
			<h2>Board List</h2>
			<div class="table-reponsive">
				<table class="table table-striped table-sm">
					<colgroup>
						<col style="width: 5%;">
						<col style="width: auto;">
						<col style="width: 15%;">
						<col style="width: 10%;">
						<col style="width: 10%;">
					</colgroup>
					<thead>
						<tr>
							<td>번호</td>
							<td>글제목</td>
							<td>작성자</td>
							<td>조회수</td>
							<td>작성일</td>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty boardList}">
								<tr>
									<td colspan="5">데이터가 없습니다.</td>
								</tr>
							</c:when>
							<c:when test="${!empty boardList}">
								<c:forEach items="${boardList}" var="list">
									<tr>
										<td>${list.bid}</td>
										<td>${list.title}</td>
										<td>${list.reg_id}</td>
										<td>${list.view_cnt}</td>
										<td>${list.reg_dt}</td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</tbody>
				</table> <!-- table end -->
			</div> <!-- table div end -->
			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">
					글쓰기
				</button>
				<a href="${contextPath}">홈	</a>
			</div>
		</div><!-- container end -->
	</article>
	
	<script type="text/javascript">
		var contextPath = '${contextPath}'; 
	</script>
</body>
</html>

