package com.freehoon.web.board.mapper;

import java.util.List;

import com.freehoon.web.board.model.MenuVO;

public interface MenuMapper {
	
	List<MenuVO> getMenuList();
	
	int saveMenu(MenuVO menuVO);
	
	int updateMenu(MenuVO menuVO);
	
	int deleteMenu(String code);
}
