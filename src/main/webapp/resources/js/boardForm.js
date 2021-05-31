$(function(){
    $('#btnSave').on('click',function(){
        $("#form").submit();
    })
    
    if( mode == 'edit'){
		$("#reg_id").prop('readonly', true);
	    $("input:hidden[name='bid']").val(bid);
	    $("input:hidden[name='mode']").val(mode);
	    $("#reg_id").val(reg_id);
	    $("#title").val(title);
	    $("#content").val(content);
	    $("#tag").val(tag);
	}    
}); 


