package com.copy.community.cmt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.copy.community.model.CmtEntity;

@Mapper
public interface CmtMapper {
	int insCmt(CmtEntity p);
	List<CmtEntity> selCmtList(CmtEntity p);
	int updCmt(CmtEntity p);
	int delCmt(CmtEntity p);
}
