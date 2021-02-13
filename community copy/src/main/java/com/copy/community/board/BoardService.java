package com.copy.community.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.copy.community.SecurityUtils;
import com.copy.community.model.BoardDTO;
import com.copy.community.model.BoardDomain;
import com.copy.community.model.BoardEntity;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private SecurityUtils sUtils;
	
	public List<BoardDomain> selBoardList(BoardDTO p) {
		return mapper.selBoardList(p);
	}
	
	public int insBoard(BoardEntity p) {
		return mapper.insBoard(p);
	}
	
	public BoardDomain selBoard(BoardDTO p, HttpSession hs) {
		if(sUtils.getLoginUser(hs) != null) {
			BoardEntity p2 = new BoardEntity();
			p2.setBoardPk(p.getBoardPk());
			p2.setHits(1);
			mapper.updBoard(p2);
		}
		return mapper.selBoard(p);
	}
	
	public int delBoard(BoardEntity p) {
		p.setIsDel(1);
		return mapper.updBoard(p);
	}
	
	public int updBoard(BoardEntity p) {
		return mapper.updBoard(p);
	}
}
