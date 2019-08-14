package com.tool.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMenuDao {
	//根据menuId删除关系数据
	int deleteObjectsByMenuId(Integer menuId);
}
