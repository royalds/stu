package com.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tool.common.web.JsonResult;
import com.tool.service.DeptService;

@RequestMapping("/")
@Controller
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("doDeptFindObjects")
	@ResponseBody
	public JsonResult doDeptFindObjects() {
		return new JsonResult(deptService.findObjects());
	}
}
