$(function(){
    $('#btnUpdate').on('click', function(){
        url = contextPath + "/board/editForm"; 
        url = url + "?bid=" + bid; 
        url = url + "&mode=edit";
        location.href = url; 
    });

    $('#btnDelete').on('click', function(){
        var url = contextPath + "/board/deleteBoard";
        $('#form').attr("method",'post')
                .attr("action", url).submit(); 
    });
}); 