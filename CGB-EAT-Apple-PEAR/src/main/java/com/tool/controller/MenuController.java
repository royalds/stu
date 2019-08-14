package com.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tool.common.web.JsonResult;
import com.tool.entity.SysMenu;
import com.tool.service.MenuService;

@RequestMapping("/")
@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;
	@ResponseBody
	@RequestMapping("doMenuFindObjects")
	public JsonResult doMenuFindObjects() {
		return new JsonResult(menuService.findObjects());
	}
	@RequestMapping("doMenuDeleteObject")
	@ResponseBody
	public JsonResult doMenuDeleteObject(Integer id) {
		menuService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	@RequestMapping("doFindzTree")
	@ResponseBody
	public JsonResult doFindzTree() {
		return new JsonResult(menuService.findzTree());
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysMenu entity){
		menuService.saveObject(entity);
		return new JsonResult("save ok");
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysMenu entity){
	    menuService.updateObject(entity);
	    return new JsonResult("update ok");
	}
}
