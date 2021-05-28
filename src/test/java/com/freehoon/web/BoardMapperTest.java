package com.freehoon.web;

import java.util.List;

import org.junit.Ignore;
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
public class BoardMapperTest {
	
	@Autowired
	private BoardMapper mapper; 
	
	@Test
	public void insertTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("2 번째 게시물 입니다.");
		boardVO.setContent("2 번째 게시물입니다.");
		boardVO.setTag("태그2");
		boardVO.setReg_id("작성자2");
		mapper.insertBoard(boardVO); 
	}
	 
	@Test
	@Ignore
	public void testGetBoardList() throws Exception {
		List<BoardVO> boardList = mapper.getBoardList();
		log.info("\n Board List");
		if(boardList.size() > 0) {
			for(BoardVO list : boardList) {
				log.info(list.getTitle());
			}
		} else {
			log.info("데이터가 없습니다.");
		}
	}
	
	@Test 
	@Ignore
	public void testGetBoardContent() throws Exception {
		BoardVO boardVO = mapper.getBoardContent(1);
		log.info("\n Board Contents ");
		if(boardVO != null) {
			log.info("글번호 : " + boardVO.getBid() );
			log.info("글제목 : " + boardVO.getTitle() );
			log.info("글내용 : " + boardVO.getContent() );
			log.info("글태그 : " + boardVO.getTag() );
			log.info("조회수 : " + boardVO.getView_cnt() );
			log.info("작성자 : " + boardVO.getReg_id() );
			log.info("작성일 : " + boardVO.getReg_dt() );
			log.info("수정일 : " + boardVO.getEdit_dt() );

		} else {
			log.info("데이터가 없습니다.");
		}
	}
	
	@Test @Ignore
	public void testUpdateBoard() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBid(1);
		boardVO.setCate_cd("1");
		boardVO.setTitle("첫번째 게시물 입니다-수정 합니다.");
		boardVO.setContent("첫번째 게시물입니다-수정합니다.");
		boardVO.setTag("1-1");
		int result = mapper.updateBoard(boardVO);
		log.info("\n Update Board Result");
		if(result > 0) {
			log.info("\n 게시물 수정 성공 ");
		} else {
			log.info("\n 게시물 수정 실패");
		}
	}
	
	@Test @Ignore  
	public void tesDeleteBoard() throws Exception {
		int result = mapper.deleteBoard(2);
		log.info("\n Delete Board Result \n ");
		if(result > 0) {
			log.info("\n 게시물 삭제 성공 ");
		} else {
			log.info("\n 게시물 삭제 실패");
		}
	}
}
