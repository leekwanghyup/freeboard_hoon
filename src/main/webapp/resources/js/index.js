$(function(){
    // 글쓰기 폼으로 이동
    $('#btnWriteForm').on('click',function(e){  
        e.preventDefault();
        location.href = contextPath +"/board/boardForm"; 
    })

}); 

// 게시글 상세 조회 
function fn_contentView(bid){
    var url = contextPath + '/board/getBoardContent';
    url = url + "?bid="+bid;
    location.href = url;
}