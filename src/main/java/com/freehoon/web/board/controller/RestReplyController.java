package com.freehoon.web.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.board.service.ReplyService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/restReply")
public class RestReplyController {
	
	@Autowired
	private ReplyService replyService; 
	
	@PostMapping("/getReplyList")
	public List<ReplyVO> getReplyList(Long bid) throws Exception {
		return replyService.getReplyList(bid);
	}
	
}
