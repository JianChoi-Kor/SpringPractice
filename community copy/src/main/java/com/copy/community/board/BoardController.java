package com.copy.community.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.copy.community.Const;
import com.copy.community.SecurityUtils;
import com.copy.community.model.BoardDTO;
import com.copy.community.model.BoardEntity;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private SecurityUtils sUtils;
	
	@GetMapping("/home")
	public void home() {
		
	}
	
	@GetMapping("/list")
	public void list(BoardDTO p, Model model) {
		model.addAttribute(Const.KEY_LIST, service.selBoardList(p));
	}

	@GetMapping("/write")
	public void write() {

	}
	
	@PostMapping("/write")
	public String write(BoardEntity p, HttpSession hs) {
		System.out.println(p.getSeq());
		
		p.setUserPk(sUtils.getLoginUserPk(hs));
		service.insBoard(p);
		return "redirect:/board/detail?boardPk=" + p.getBoardPk();
	}
}
