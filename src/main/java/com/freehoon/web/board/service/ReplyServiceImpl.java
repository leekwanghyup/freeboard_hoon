package com.freehoon.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freehoon.web.board.mapper.ReplyMapper;
import com.freehoon.web.board.model.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper; 
	
	@Override
	public List<ReplyVO> getReplyList(Long bid) { 
		return replyMapper.getReplyList(bid);
	}

	@Override
	public int saveReply(ReplyVO replyVO) {
		return replyMapper.saveReply(replyVO);
	}

	@Override
	public int updateReply(ReplyVO replyVO) {
		return replyMapper.updateReply(replyVO);
	}

	@Override
	public int deleteReply(Long rid) {
		return replyMapper.deleteReply(rid);
	}
}
