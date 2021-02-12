package com.copy.community.menu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.copy.community.model.MenuEntity;

@Mapper
public interface MenuMapper {
	List<MenuEntity> selMenuList();
}
