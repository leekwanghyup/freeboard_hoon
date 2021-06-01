package com.freehoon.web.board.service;

import java.util.List;

import com.freehoon.web.board.model.ReplyVO;

public interface ReplyService {
	
	List<ReplyVO> getReplyList(Long bid);
	
	int saveReply(ReplyVO replyVO); 
	
	int updateReply(ReplyVO replyVO); 

	int deleteReply(Long rid);
}
