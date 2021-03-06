package com.freehoon.web.board.mapper;
import java.util.List;

import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.common.Pagination;
import com.freehoon.web.common.Search;

public interface BoardMapper {

	List<BoardVO> getBoardList(Search search);

	BoardVO getBoardContent(Long bid);

	int insertBoard(BoardVO boardVO);
	
	int updateBoard(BoardVO boardVO);

	int deleteBoard(Long bid);

	int updateViewCnt(Long bid);
	
    int getBoardListCnt(Search search); 
}
