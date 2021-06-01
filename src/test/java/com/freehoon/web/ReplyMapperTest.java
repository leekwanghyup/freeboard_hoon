package com.freehoon.web;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.freehoon.web.board.mapper.ReplyMapper;
import com.freehoon.web.board.model.ReplyVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class ReplyMapperTest {
	
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	@Ignore
	public void insertTest() {
		ReplyVO vo = new ReplyVO(); 
		vo.setBid(1L);
		vo.setContent("댓글 테스트03 입니다.");
		vo.setReg_id("댓글테스터03");
		int result = replyMapper.saveReply(vo);
		if(result > 0 ) {
			log.info("댓글 등록 성공!!");
		} else {
			log.info("댓글 등록 실패!!");
		}
	}
	
	@Test
	@Ignore
	public void getReplyListTest() {
		List<ReplyVO> replyList = replyMapper.getReplyList(1L); 
		replyList.forEach(list -> log.info(list) );
	}
	
	@Test
	@Ignore
	public void updateReplyTest() {
		 ReplyVO vo = new ReplyVO(); 
		 vo.setRid(1L);
		 vo.setContent("댓글 테스트 입니다. -- 수정");
		 int result = replyMapper.updateReply(vo);
		 if(result > 0 ) {
			 log.info("업데이트 성공!!");
		 } else {
			 log.info("업데이트 실패!!");
		 }
	}
	
	@Test
	@Ignore
	public void deleteReplyTest() {
		int result = replyMapper.deleteReply(1L); 
		if(result > 0 ) {
			log.info("삭제 성공!!");
		} else {
			log.info("삭제 실패!!");
		}
	}
	
}
