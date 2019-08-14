package com.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tool.common.vo.PageObject;
import com.tool.common.web.JsonResult;
import com.tool.entity.SysLog;
import com.tool.service.LogService;

@Controller
@RequestMapping("/")
public class LogController {
	@Autowired
	private LogService logService;
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username,Integer pageCurrent){
		PageObject<SysLog> pageObject=logService.findPageObjects(username,pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer ...ids) {
		logService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}
}
