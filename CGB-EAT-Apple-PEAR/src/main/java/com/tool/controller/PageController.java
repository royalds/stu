package com.tool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	@RequestMapping("doMenuEditUI")
	public String doMenuEditUI() {
		return "sys/menu_edit";
	}
	@RequestMapping("doMenuListUI")
	public String doMenuListUI() {
		return "sys/menu_list";
	}
	@RequestMapping("doDeptEditUI")
	public String doDeptEditUI() {
		return "sys/dept_edit";
	}
	@RequestMapping("doDeptListUI")
	public String doDeptListUI() {
		return "sys/dept_list";
	}
//	@RequestMapping("log/log_list")
//	public String doLogUI() {
//		return "sys/log_list";
//	}
//	@RequestMapping("menu/menu_list")
//	public String doMenuUI() {
//		return "sys/menu_list";
//	}
//	@RequestMapping("dept/dept_list")
//	public String doDeptUI() {
//		return "sys/dept_list";
//	}
//	@RequestMapping("role/role_list")
//	public String doRoleUI() {
//		return "sys/role_list";
//	}
//	@RequestMapping("user/user_list")
//	public String doUserUI() {
//		return "sys/user_list";
//	}
	@RequestMapping("{module}/{ui}")
	public String doModuleUI(@PathVariable("ui") String display) {
		return "sys/"+display;
	}
}