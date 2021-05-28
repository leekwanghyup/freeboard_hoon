package com.freehoon.web.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(Model model){
		model.addAttribute("boardList", boardService.getBoardList()); 
		return "board/index";
	}
	
	@GetMapping("/boardForm")
	public void boardForm() {}
	
	@PostMapping("/saveBoard")
	public String saveBoard(BoardVO boardVO, RedirectAttributes rttr) {
		boardService.insertBoard(boardVO);
		return "redirect:/board/getBoardList"; 
	}
	
}
