$(function(){
    $('#btnUpdate').on('click', function(){
        url = contextPath + "/board/editForm"; 
        url = url + "?bid=" + bid; 
        url = url + "&mode=edit";
        location.href = url; 
    });
}); 