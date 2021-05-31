package com.freehoon.web.board.service;

import java.util.List;

import com.freehoon.web.board.model.BoardVO;

public interface BoardService {

	List<BoardVO>getBoardList(); 
	
	void insertBoard(BoardVO boardVO); 
	
	BoardVO getBoardContent(Long bid); 
	
	void updateBoard(BoardVO boardVO);
	
	void deleteBoard(Long bid); 
	
}
