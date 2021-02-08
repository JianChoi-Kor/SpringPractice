package com.koreait.community.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.community.Const;
import com.koreait.community.SecurityUtils;
import com.koreait.community.model.BoardDTO;
import com.koreait.community.model.BoardEntity;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private SecurityUtils sUtils;
	
	@GetMapping("/home")
	public void home() {}
	
	@GetMapping("/list")
	public void list(BoardDTO p, Model model) {
		model.addAttribute(Const.KEY_LIST, service.selBoardList(p));
	}
	
	@GetMapping("/write")
	public String wirte() {
		return "board/writeEdit";
	}
	
	@PostMapping("/write")
	
	// void or String + ajax 일때 객체 타입
	public String write(BoardEntity p, HttpSession hs) {
		System.out.println(p.getSeq());
		
		p.setUserPk(sUtils.getLoginUserPk(hs));
		int result = service.insBoard(p);
		return "redirect:/board/detail?boardPk=" + p.getBoardPk();
	}
	
	@GetMapping("/detail")
	public void detail(BoardDTO p, Model model, HttpSession hs) {
		model.addAttribute(Const.KEY_DATA, service.selBoard(p, hs));
	}
	
	
	@DeleteMapping("/del/{boardPk}")
	public Map del(BoardEntity p, HttpSession hs) {
		p.setUserPk(sUtils.getLoginUserPk(hs));
		
		System.out.println("boardPk : " + p.getBoardPk());
		Map<String, Object> rVal = new HashMap<>();
		rVal.put(Const.KEY_DATA, service.updBoard(p));
		return rVal;
	}
	
}
