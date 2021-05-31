<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jspf" %>
	
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
	
<%@ include file="include/footer.jspf" %>