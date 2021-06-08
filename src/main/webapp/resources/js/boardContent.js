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

    // 댓글 저장 
    $('#btnReplySave').on('click',function(e){
        var content = $('#content').val(); 
        var reg_id = $('#reg_id').val(); 
        
        var replyToJson = JSON.stringify({
            'content' : content, 
            'reg_id' : reg_id, 
            'bid' : bid
        }); 
        const headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};
        
        $.ajax({
            url : contextPath + "/restReply/saveReply",
            headers : headers, 
			type : 'POST',
            data : replyToJson, 
		    dataType : 'text',
            success : function(result){ 
                console.log(result);
                showReplyList(); 
                $('#content').val('');
				$('#reg_id').val('');
            }, 
            error : function(error){
                console.log("에러" + error); 
            }
        });
    }); 

    // 댓글 수정 
    $('.edit_reply').on('click',function(){
        alert('test');
    })
    
}); 

// 댓글 리스트 
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
            } else {
                $(result).each(function(){
                    htmls += `
                    <div class="media text-muted pt-3" id="rid${this.rid}">
                        <svg class="bd-placeholder-img mr-2 rounded" width="16" height="16" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">
                            <title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#007bff"></rect>
                            <text x="50%" fill="#007bff" dy=".3em">32x32</text>
                        </svg>
                        <p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray" >
                            <span class="d-block">
                                <strong class="text-gray-dark writer${this.rid}"> ${this.reg_id} </strong>
                                <span style="padding-left: 7px; font-size: 9pt">
                                    <a href="javascript:void(0)" onclick="reply_edit('${this.rid}')" style="padding-right:5px">수정</a>
                                    <a href="javascript:void(0)" onclick="deleteReply('${this.rid}')" >삭제</a>
                                </span>
                            </span>
                            <span class="content${this.rid}">${this.content}</span>
                        </p>
                    </div>`
                });	//each end
            }
            $("#replyList").html(htmls);
        }	   // Ajax success end
    });	// Ajax end
}

// 댓글 수정 화면 실행 함수 
function reply_edit(rid){
    var content = $('.content'+rid).text(); 
    var writer = $('.writer'+rid).html(); 
    editReply(rid,writer,content); 
}

//댓글 수정 화면 
function editReply(rid, reg_id, content){
    
    var htmls = "";
    htmls += `
        <div class="media text-muted pt-3" id="rid${rid}">
            <svg class="bd-placeholder-img mr-2 rounded" width="16" height="16" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:16x16">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#007bff"></rect>
                <text x="50%" fill="#007bff" dy=".3em">32x32</text>
            </svg>
            <p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">
                <span class="d-block">
                    <strong class="text-gray-dark">${reg_id}</strong>
                    <span style="padding-left: 7px; font-size: 9pt">
                        <a href="javascript:void(0)" onclick="updateReply('${rid}')" style="padding-right:5px">저장</a>
                        <a href="javascript:void(0)" onClick="showReplyList()">취소<a>
                    </span>
                </span>
                <textarea name="editContent" id="editContent" class="form-control" rows="3" style="margin-top:10px;">
                    ${content}
                </textarea>
            </p>
        </div>`; 
    $('#rid' + rid).replaceWith(htmls);
    $('#rid' + rid + ' #editContent').focus();
}

// 댓글 수정 처리 
function updateReply(rid){
    var replyEditContent = $('#editContent').val().trim();
    var paramData = JSON.stringify({
            "content": replyEditContent, 
            "rid": rid
        });

    const headers = {
            "Content-Type" : "application/json", 
            "X-HTTP-Method-Override" : "POST"
        };
    $.ajax({
        url: contextPath + "/restReply/" + rid,
        headers : headers,
        data : paramData,
        type : 'put',
        dataType : 'text',
        success: function(result){
            console.log(result);
            showReplyList();
        },
        error: function(error){
            console.log("에러 : " + error);
        }
    });
}

// 댓글 삭제 
function deleteReply(rid){
    var paramData = {"rid": rid};
    $.ajax({
        url: contextPath + "/restReply/" + rid ,
        data : paramData,
        type : 'delete',
        dataType : 'text',
        success: function(result){
            console.log("success");
            alert('댓글이 삭제되었습니다.')
            showReplyList();
        },
        error: function(error){
            console.log("에러 : " + error);
        }
    });
}


