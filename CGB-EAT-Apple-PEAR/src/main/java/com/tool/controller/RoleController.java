package com.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tool.common.vo.PageObject;
import com.tool.common.web.JsonResult;
import com.tool.entity.SysRole;
import com.tool.service.RoleService;

@RequestMapping("/")
@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("doRoleFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username,Integer pageCurrent){
		PageObject<SysRole> pageObject=roleService.findPageObjects(username,pageCurrent);
		return new JsonResult(pageObject);
	}
}
