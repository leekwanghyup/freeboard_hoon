<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %> 

<%@ include file="include/header.jspf" %>
<script src="https://cdn.ckeditor.com/ckeditor5/28.0.0/classic/ckeditor.js"></script>

<h2>Board Form</h2>
<form:form name="form" id="form" role="form" modelAttribute="boardVO" method="post" 
	action="${contextPath}/board/saveBoard">
	<input type="hidden" value="1" name="cate_cd">
	<div class="mb-3">
		<label for="title">제목</label>
		<form:input class="form-control" path="title" placeholder="제목을 입력해 주세요"/>
	</div>
	<div class="mb-3">
		<label for="reg_id">작성자</label>
		<form:input class="form-control" path="reg_id" placeholder="이름을 입력해 주세요"/>
	</div>
	<div class="mb-3">
		<label for="content">내용</label>
		<form:textarea class="form-control" rows="5" path="content"  placeholder="내용을 입력해 주세요"/>
	</div>
	<div class="mb-3">
		<label for="tag">TAG</label>
		<form:input class="form-control" path="tag" placeholder="태그를 입력해 주세요"/>
	</div>
	
	<form:hidden path="bid" />
	<input type="hidden"  id="mode" name="mode" value="${param.mode}" />
</form:form>

<div>
	<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
	<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
</div>
<script>
	var mode = $('#mode').val(); 
	var bid = '${boardContent.bid}'; 
	var reg_id = '${boardContent.reg_id}'; 
	var title = '${boardContent.title}'; 
	var content = `'${boardContent.content}'`; 
	var tag = '${boardContent.tag}';
	     
</script>
<script src="${contextPath}/resources/js/boardForm.js"></script>
<script src="${contextPath}/resources/js/ckeditor.js"></script>

<%@ include file="include/footer.jspf" %>