package com.freehoon.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freehoon.web.board.mapper.MenuMapper;
import com.freehoon.web.board.model.MenuVO;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuMapper menuMapper; 
	
	@Override
	public List<MenuVO> getMenuList(){
		return menuMapper.getMenuList();
	}

	@Override
	public void saveMenu(MenuVO menuVO){
		menuMapper.saveMenu(menuVO);
	}

	@Override
	public void updateMenu(MenuVO menuVO){
		menuMapper.updateMenu(menuVO); 
	}

	@Override
	public void deleteMenu(String code) {
		menuMapper.deleteMenu(code);
	}
}
