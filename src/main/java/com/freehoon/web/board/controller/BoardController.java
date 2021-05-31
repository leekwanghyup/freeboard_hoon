package com.freehoon.web.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public void boardForm(@ModelAttribute("boardVO") BoardVO boardVO) {}
	
	@PostMapping("/saveBoard")
	public String saveBoard(BoardVO boardVO, RedirectAttributes rttr, String mode) {
		if(mode.equals("edit")) {
			boardService.updateBoard(boardVO); 
		} else {
			boardService.insertBoard(boardVO);			
		}
		return "redirect:/board/getBoardList"; 
	}
	
	@GetMapping("/getBoardContent")
	public String getBoardContent(Model model, Long bid) {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		return "/board/boardContent"; 
	}
	
	@GetMapping("/editForm")
	public String editForm(Long bid, String mode, Model model, @ModelAttribute("boardVO") BoardVO boardVO) {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("mode", mode);
		return "board/boardForm";
	}
	
	@PostMapping("/deleteBoard")
	public String deleteBoard(Long bid, RedirectAttributes rttr) {
		boardService.deleteBoard(bid);
		return "redirect:/board/getBoardList"; 
	}
	
}
