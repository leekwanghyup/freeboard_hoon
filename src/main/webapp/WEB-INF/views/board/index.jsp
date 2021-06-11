<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
 <%@ include file="include/header.jspf" %>

<h2>자유게시판</h2><br>
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
							<td>
								<a href="#" onclick="fn_contentView(${list.bid});">
									${list.title}
								</a>
							</td>
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
<div class="btn_area">
	<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">
		글쓰기
	</button>
	<a href="${contextPath}/board/getBoardList" style="margin-left: 10px;"> 새로고침	</a>
</div> <!-- button area end -->

<!-- 페이지네이션 -->
<div id="paginationBox">
    <ul class="pagination">
        <c:if test="${pagination.prev}">
            <li class="page-item"><a class="page-link" id="prev" href="#" >Previous</a></li>
        </c:if>

        <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
            <li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> ">
            	<a class="page-link idx_btn" href="#" data-idx="${idx}" > ${idx} </a>
            </li>
        </c:forEach>
        <c:if test="${pagination.next}">
            <li class="page-item"><a class="page-link" href="#" id="next">Next</a></li>
        </c:if>
    </ul>
</div> <!-- paginationBox -->

<!-- search{s} -->
<div class="form-group row justify-content-center">
    <div class="w100" style="padding-right:10px">
        <select class="form-control form-control-sm" name="searchType" id="searchType">
            <option value="title">제목</option>
            <option value="content">본문</option>
            <option value="reg_id">작성자</option>
        </select>
    </div>
    <div class="w300" style="padding-right:10px">
        <input type="text" class="form-control form-control-sm" name="keyword" id="keyword">
    </div>
    <div>
        <button class="btn btn-sm btn-primary" name="btnSearch" id="btnSearch">검색</button>
    </div>
</div><!-- search{e} -->

<script>
	var paginationParam = {
		page : '${pagination.page}',
		range : '${pagination.range}',
		rangeSize : '${pagination.rangeSize}',
		searchType : '${search.searchType}',
		keyword : '${search.keyword}'
	};  
	
</script>
<script src="${contextPath}/resources/js/index.js"></script>

<%@ include file="include/footer.jspf" %>