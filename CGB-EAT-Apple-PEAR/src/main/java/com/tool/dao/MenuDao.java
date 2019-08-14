package com.tool.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tool.common.vo.Node;
import com.tool.entity.SysMenu;

@Mapper
public interface MenuDao {
	//查询所有菜单数据
	List<Map<String,Object>> findObjects();
	//根据id查询子菜单
	int findChildCount(Integer id);
	//根据id删除菜单
	int deleteObject(Integer id);
	//查询上级菜单并数据封装
	List<Node> findzTree();
	//添加数据
	int insertObject(SysMenu entity);
	//更新数据
	int updateObject(SysMenu entity);
}
