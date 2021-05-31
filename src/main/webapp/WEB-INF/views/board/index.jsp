<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
 <%@ include file="include/header.jspf" %>
<script src="${contextPath}/resources/js/index.js"></script>

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
<div>
	<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">
		글쓰기
	</button>
	<a href="${contextPath}">홈	</a>
</div> <!-- button area end -->

<!-- 페이지네이션 -->
<div id="paginationBox">
    <ul class="pagination">
        <c:if test="${pagination.prev}">
            <li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
        </c:if>

        <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
            <li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a></li>
        </c:forEach>

        <c:if test="${pagination.next}">

            <li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')" >Next</a></li>
        </c:if>
    </ul>
</div> <!-- paginationBox -->


<%@ include file="include/footer.jspf" %>