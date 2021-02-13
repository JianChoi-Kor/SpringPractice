package com.copy.community.board;

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
	
	@GetMapping("/update")
	public void update(BoardDTO p, Model model, HttpSession hs) {
		model.addAttribute(Const.KEY_DATE, service.selBoard(p, hs));
	}
	
	@PostMapping("/update")
	public String update(BoardEntity p, HttpSession hs) {
		System.out.println(p.getSeq());
		
		p.setUserPk(sUtils.getLoginUserPk(hs));
		service.updBoard(p);
		return "redirect:/board/detail?boardPk=" + p.getBoardPk();
	}
	
	@GetMapping("/detail")
	public void detail(BoardDTO p, Model model, HttpSession hs) {
		model.addAttribute(Const.KEY_DATE, service.selBoard(p, hs));
	}
	
	@DeleteMapping("/del/{boardPk}")
	public Map del(BoardEntity p, HttpSession hs) {
		p.setUserPk(sUtils.getLoginUserPk(hs));
		
		System.out.println("boardPk : " + p.getBoardPk());
		Map<String, Object> rVal = new HashMap<>();
		rVal.put(Const.KEY_DATE, service.updBoard(p));
		return rVal;
	}
}
