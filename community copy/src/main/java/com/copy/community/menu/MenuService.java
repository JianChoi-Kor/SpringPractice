package com.copy.community.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.copy.community.model.MenuEntity;

@Service
public class MenuService {
	
	@Autowired
	private MenuMapper mapper;
	
	public List<MenuEntity> selMenuList() {
		return mapper.selMenuList(); 
	}
}
