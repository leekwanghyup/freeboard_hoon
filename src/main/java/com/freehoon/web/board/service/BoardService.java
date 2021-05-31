package com.freehoon.web.board.service;

import java.util.List;

import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.common.Pagination;

public interface BoardService {

	List<BoardVO>getBoardList(Pagination pagination); 
	
	void insertBoard(BoardVO boardVO); 
	
	BoardVO getBoardContent(Long bid); 
	
	void updateBoard(BoardVO boardVO);
	
	void deleteBoard(Long bid); 
	
	int getBoardListCnt();
}
