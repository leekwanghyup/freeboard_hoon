package com.freehoon.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freehoon.web.board.mapper.BoardMapper;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.common.Pagination;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getBoardList(Pagination pagination) {
		return boardMapper.getBoardList(pagination);
	}

	@Override
	public void insertBoard(BoardVO boardVO) {
		boardMapper.insertBoard(boardVO);
	}

	@Transactional
	@Override
	public BoardVO getBoardContent(Long bid) {
		boardMapper.updateViewCnt(bid); 
		return boardMapper.getBoardContent(bid);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		boardMapper.updateBoard(boardVO); 
	}

	@Override
	public void deleteBoard(Long bid) {
		boardMapper.deleteBoard(bid); 
	}

	@Override
	public int getBoardListCnt() {
		return boardMapper.getBoardListCnt();
	}

}
