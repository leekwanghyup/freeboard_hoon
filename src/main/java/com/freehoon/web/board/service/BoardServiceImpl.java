package com.freehoon.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freehoon.web.board.mapper.BoardMapper;
import com.freehoon.web.board.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.getBoardList();
	}

	@Override
	public void insertBoard(BoardVO boardVO) {
		boardMapper.insertBoard(boardVO);
	}

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

}
