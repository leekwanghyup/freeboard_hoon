package com.freehoon.web.board.mapper;
import java.util.List;

import com.freehoon.web.board.model.BoardVO;

public interface BoardMapper {

	List<BoardVO> getBoardList();

	BoardVO getBoardContent(int bid);

	int insertBoard(BoardVO boardVO);
	
	int updateBoard(BoardVO boardVO);

	int deleteBoard(int bid);

	int updateViewCnt(int bid);

}
