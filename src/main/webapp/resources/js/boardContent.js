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

    showReplyList(); 
}); 

function showReplyList(){
    var url = contextPath + "/restReply/getReplyList";
    var paramData = {"bid" : bid};
    $.ajax({
        type: 'post',
        url: url,
        data: paramData,
        dataType: 'json',
        success: function(result) {
            var htmls = "";
            if(result.length < 1){
                htmls.push("등록된 댓글이 없습니다.");
            } else {000
                $(result).each(function(){
                    htmls += `
                    <div class="media text-muted pt-3" id="rid${this.rid}">
                        <svg class="bd-placeholder-img mr-2 rounded" width="16" height="16" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">
                            <title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#007bff"></rect>
                            <text x="50%" fill="#007bff" dy=".3em">32x32</text>
                        </svg>
                        <p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">
                            <span class="d-block">
                                <strong class="text-gray-dark"> ${this.reg_id} </strong>
                                <span style="padding-left: 7px; font-size: 9pt">
                                    <a href="javascript:void(0)" onclick="fn_editReply('${this.rid}', '${this.reg_id}', '${this.content}')" style="padding-right:5px">수정</a>
                                    <a href="javascript:void(0)" onclick="fn_deleteReply(${this.rid}')" >삭제</a>
                                </span>
                            </span>
                            ${this.content}
                        </p>
                    </div>`
                });	//each end
            }
            $("#replyList").html(htmls);
        }	   // Ajax success end
    });	// Ajax end
}



