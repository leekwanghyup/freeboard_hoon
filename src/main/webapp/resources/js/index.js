$(function(){
    $('#btnWriteForm').on('click',function(e){  
        e.preventDefault();
        location.href = contextPath +"/board/boardForm"; 
    })
}); 
