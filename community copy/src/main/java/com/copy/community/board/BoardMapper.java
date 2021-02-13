package com.copy.community.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.copy.community.model.BoardDTO;
import com.copy.community.model.BoardDomain;
import com.copy.community.model.BoardEntity;

@Mapper
public interface BoardMapper {
	
	List<BoardDomain> selBoardList(BoardDTO p);
	int insBoard(BoardEntity p);
	BoardDomain selBoard(BoardDTO p);
	int updBoard(BoardEntity p);

}