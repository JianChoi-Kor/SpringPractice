package com.koreait.community;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("MenuPreparer")
public class MenuPreparer implements ViewPreparer{
	
	@Autowired
	private CommonMapper mapper;
	
	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		System.out.println("페이지 바뀔 때마다");
		
		if(Const.menus == null) {	
			
			Const.menus= mapper.selMenuList();
			
		} else {
			System.out.println("있을 때는 실행하지 않는다.");
		}
		
		
		attributeContext.putAttribute(Const.KEY_MENULIST, new Attribute(Const.menus), true);
	}

}
