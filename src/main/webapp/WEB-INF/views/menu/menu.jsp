<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../board/include/header.jspf"%>

<h4 class="mb-3">Menu Info</h4>
<div>
	<form:form name="form" id="form" role="form" modelAttribute="menuVO"
		method="post"
		action="${pageContext.request.contextPath}/menu/saveMenu">
		<form:hidden path="mid" />
		<div class="row">
			<div class="col-md-4 mb-3">
				<label for="code">Code</label>
				<form:input path="code" class="form-control" placeholder="" value=""
					required="" />
				<div class="invalid-feedback">Valid Code is required.</div>
			</div>
			<div class="col-md-5 mb-3">
				<label for="codename">Code name</label>
				<form:input path="codename" class="form-control" placeholder=""
					value="" required="" />
				<div class="invalid-feedback">Valid Code name is required.</div>
			</div>
			<div class="col-md-3 mb-3">
				<label for="sort_num">Sort</label>
				<form:input path="sort_num" class="form-control" placeholder=""
					required="" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 mb-3">
				<label for="comment">Comment</label>
				<form:input path="comment" class="form-control" placeholder=""
					value="" required="" />
			</div>
		</div>
	</form:form>
</div>
<!-- Menu form {e} -->

<div>
	<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
	<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
	<button type="button" class="btn btn-sm btn-primary" id="btnInit">초기화</button>
</div>

<h4 class="mb-3" style="padding-top: 30px;">Menu List</h4>
<!-- List{s} -->
<div class="table-responsive">
	<table class="table table-striped table-sm">
		<colgroup>
			<col style="width: 10%;" />
			<col style="width: 15%;" />
			<col style="width: 15%;" />
			<col style="width: 10%;" />
			<col style="width: auto;" />
		</colgroup>
		<thead>
			<tr>
				<th>menu id</th>
				<th>code</th>
				<th>codename</th>
				<th>sort</th>
				<th>command</th>
			</tr>
		</thead>
		<tbody id="menuList"></tbody>
	</table>
</div>
<!-- List{e} -->

<%@ include file="../board/include/footer.jspf"%>

<script>
$(function(){

fn_showList(); 

function fn_showList() {
	var paramData = {};
	$.ajax({
		url : contextPath + "/menu/getMenu",
		type : "POST",
		dataType : "json",
		data : paramData,
		success : function(result) {
			console.log(result);
			if (result.status == "OK") {
				if (result.menuList.length > 0) {
					var list = result.menuList;
					var htmls = "";
					result.menuList.forEach(function(e) {
						htmls += '<tr>';
						htmls += '<td>' + e.mid + '</td>';
						htmls += '<td>' + e.code + '</td>';
						htmls += '<td>' + e.codename + '</td>';
						htmls += '<td>' + e.sort_num + '</td>';
						htmls += '<td>' + e.comment + '</td>';
						htmls += '</tr>';
					});
				}
			} else {
				console.log("조회실패");
			}
				$('#menuList').html(htmls);
			}
		});
	}
});
</script>
