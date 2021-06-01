package com.freehoon.web.board.service;

import java.util.List;

import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.common.Pagination;
import com.freehoon.web.common.Search;

public interface BoardService {

	List<BoardVO>getBoardList(Search search); 
	
	void insertBoard(BoardVO boardVO); 
	
	BoardVO getBoardContent(Long bid); 
	
	void updateBoard(BoardVO boardVO);
	
	void deleteBoard(Long bid); 
	
	int getBoardListCnt(Search search);
}
