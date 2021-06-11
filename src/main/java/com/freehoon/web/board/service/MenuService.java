package com.freehoon.web.board.service;

import java.util.List;

import com.freehoon.web.board.model.MenuVO;

public interface MenuService {
	public List<MenuVO> getMenuList();

	public void saveMenu(MenuVO menuVO); 
	
	public void updateMenu(MenuVO menuVO); 
	
	public void deleteMenu(String code);
}
