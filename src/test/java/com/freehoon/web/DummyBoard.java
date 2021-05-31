package com.freehoon.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.freehoon.web.board.mapper.BoardMapper;
import com.freehoon.web.board.model.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class DummyBoard {
	
	@Autowired
	private BoardMapper boardMapper; 
	
	@Test
	public void dummyBoard() {
		BoardVO boardVO = new BoardVO(); 
		boardVO.setCate_cd("1");
		boardVO.setTag("Tag");
		boardVO.setReg_id("테스터");
		for( int i = 1; i < 1234 ; i++) {
		    boardVO.setTitle(i + " 번째 게시물 입니다.");
		    boardVO.setContent(i + " 번째 게시물 입니다.");
		    int result = boardMapper.insertBoard(boardVO);
			log.info("\n Insert Board Result " +result);

			if(result == 1) {
				log.info("\n 게시물 등록 성공 ");
			} else {
				log.info("\n 게시물 등록 실패");
			}
		  }
	}
}
