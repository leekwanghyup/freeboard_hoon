package com.freehoon.web.board.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@PostMapping(value = "/saveReply" , 
		consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> saveReply(@RequestBody ReplyVO replyVO) throws Exception {
		int result =  replyService.saveReply(replyVO);
		return result == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  
	}
	
	@RequestMapping(value="/{rid}", method = {RequestMethod.PUT, RequestMethod.PATCH}, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE ) 
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rid") Long rid){
		vo.setRid(rid);
		if(replyService.updateReply(vo) != 1) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<String>("success", HttpStatus.OK); 
	}
	
	@DeleteMapping(value = "/{rid}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rid") Long rid){
		if(replyService.deleteReply(rid) != 1) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("succes",HttpStatus.OK); 
	}
}
