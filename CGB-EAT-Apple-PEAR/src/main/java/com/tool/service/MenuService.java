package com.tool.service;

import java.util.List;
import java.util.Map;

import com.tool.common.vo.Node;
import com.tool.entity.SysMenu;

public interface MenuService {
	//查询菜单数据
	List<Map<String,Object>> findObjects();
	//删除菜单
	int deleteObject(Integer id);
	//查询上级菜单数据
	List<Node> findzTree();
	//添加数据
	int saveObject(SysMenu entity);
	//更新数据
	int updateObject(SysMenu entity);
}
