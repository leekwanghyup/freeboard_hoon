$(function(){
    // 글쓰기 폼으로 이동 이벤트 
    $('#btnWriteForm').on('click',function(e){  
        e.preventDefault();
        location.href = contextPath +"/board/boardForm"; 
    })

    // 게시물 검색 이벤트
    $('#btnSearch').on('click',function(e){
		e.preventDefault();
		var url =  contextPath + "/board/getBoardList";
		url = url + "?searchType=" + $('#searchType').val();
		url = url + "&keyword=" + $('#keyword').val();
		location.href = url;
	});

    //페이지네이션 이벤트 
    $('#prev').on('click',function(){
        // alert('이전'); 
        fn_prev(paginationParam); 
    }); 
    
    $('#next').on('click',function(){
        fn_next(paginationParam); 
    }); 

    $('.idx_btn').on('click', function(){
        var idx = $(this).data("idx"); 
        fn_pagination(idx, paginationParam);
    }); 

}); 

// 게시글 상세 조회 
function fn_contentView(bid){
    var url = contextPath + '/board/getBoardContent';
    url = url + "?bid="+bid;
    location.href = url;
}

/* 페이지네이션 영역 */
//이전 버튼 이벤트
function fn_prev(p) {
    p.page = ((p.range - 2) * p.rangeSize) + 1;
    p.range = p.range - 1;
    var url = generateUrl(p.page, p.range, p.searchType, p.keyword); 
    location.href = url;
}

//페이지 번호 클릭
function fn_pagination(page, p) {
    var url = generateUrl(page, p.range, p.searchType, p.keyword); 
    location.href = url;	
}

//다음 버튼 이벤트
function fn_next(p) {
    p.page = parseInt((p.range * p.rangeSize)) + 1;
    p.range = parseInt(p.range) + 1;
    var url = generateUrl(p.page, p.range, p.searchType, p.keyword); 
    location.href = url;
}


// 페이지네이션 url 생성 
function generateUrl(page, range, searchType, keyword){ 
    var url = contextPath +"/board/getBoardList";
    url = url + "?page=" + page;
    url = url + "&range=" + range;
    if(searchType != null && keyword != null  ){
        if(searchType != '' && keyword != '' ){
            url = url + "&searchType=" + searchType;
            url = url + "&keyword=" + keyword;
        }
    }
    return url; 
}
