package com.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tool.common.vo.PageObject;
import com.tool.common.vo.SysUserDeptVo;
import com.tool.common.web.JsonResult;
import com.tool.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("doUserFindPageObjects")
	@ResponseBody
	public JsonResult doUserFindPageObjects(String username,Integer pageCurrent){
		PageObject<SysUserDeptVo> pageObject=userService.findPageObjects(username,pageCurrent);
		return new JsonResult(pageObject);
	}
}
