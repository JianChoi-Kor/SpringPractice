package com.copy.community.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.copy.community.model.BoardDTO;
import com.copy.community.model.BoardDomain;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardDomain> selBoardList(BoardDTO p) {
		return mapper.selBoardList(p);
	}
	
}
