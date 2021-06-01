<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="include/header.jspf" %>
<script src="${contextPath}/resources/js/boardContent.js"></script>
<script>
	var bid = "${boardContent.bid}"; 
</script>
	<%-- 게시물 번호 : ${boardContent.bid}<br>
	게시물 카테고리 : ${boardContent.cate_cd}<br>
	게시물 제목 : ${boardContent.title}<br>
	게시물 내용 : ${boardContent.content}<br>
	게시물 태그 : ${boardContent.tag}<br>
	게시물 조회수 : ${boardContent.view_cnt}<br>
	게시물 작성자 : ${boardContent.reg_id}<br>
	게시물 등록일 : ${boardContent.reg_dt}<br>
	게시물 수정일 : ${boardContent.edit_dt}<br> --%>
	
	<h2>게시물 내용</h2>
	<form id="form">
		<input type="hidden" name="bid" id="bid" value="${boardContent.bid}">
		<div class="bg-white rounded shadow-sm">
			<div class="board_title">${boardContent.title}</div>
			<div class="board_info_box">
				<span class="board_author">${boardContent.reg_id}</span>
				<span class="board_date">${boardContent.reg_dt}</span>
			</div>
			<div class="board_content">${boardContent.content}</div>
			<div class="board_tag">${boardContent.tag}</div>
		</div>
		<div class="buttons">
			<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
			<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
			<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
		</div>
	</form>

<!-- Reply Form {s} -->
<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
    <form:form name="form" id="form" role="form" modelAttribute="replyVO" method="post">
        <form:hidden path="bid"/>
        <div class="row">
            <div class="col-sm-10">
                <form:textarea path="content" class="form-control" rows="3" placeholder="댓글을 입력해 주세요 ..."></form:textarea>
            </div>
            <div class="col-sm-2">
                <form:input path="reg_id" class="form-control" placeholder="작성자"></form:input>
                <button type="button" class="btn btn-sm btn-primary" id="btnReplySave" style="width: 100%; margin-top: 10px"> 저 장 </button>
            </div>
        </div>
    </form:form>
</div>
<!-- Reply Form {e} -->

<!-- Reply List {s}-->
<div class="my-3 p-4 bg-white rounded shadow-sm">
    <h6 class="pb-2 mb-0">댓글 </h6>
    <div id="replyList"></div>
</div> 

	
<%@ include file="include/footer.jspf" %>