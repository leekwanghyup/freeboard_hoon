package com.freehoon.web.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freehoon.web.board.model.MenuVO;
import com.freehoon.web.board.service.MenuService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/restMenu")
public class RestMenuController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/getMenuList", method = RequestMethod.POST)
	public Map<String, Object> getMenuList() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("menuList", menuService.getMenuList());
			result.put("status", "OK");
		} catch (Exception e) {
			result.put("status", "False");
			log.info(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
	public Map<String, Object> saveMenu(MenuVO menuVO) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		log.info("menuVO : " + menuVO.toString());
		try {
			menuService.saveMenu(menuVO);
			result.put("status", "OK");
		} catch (Exception e) {
			result.put("status", "False");
			log.info(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
	public Map<String, Object> updateMenu(MenuVO menuVO) throws Exception {
		Map<String, Object> result = new HashMap<>();
		try {
			menuService.updateMenu(menuVO);
			result.put("status", "OK");
		} catch (Exception e) {
			result.put("status", "False");
			log.info(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	public Map<String, Object> deleteMenu(@RequestParam("code") String code) throws Exception {
		Map<String, Object> result = new HashMap<>();
		try {
			menuService.deleteMenu(code);
			result.put("status", "OK");
		} catch (Exception e) {
			result.put("status", "False");
			log.info(e.getMessage());
		}
		return result;
	}
}
