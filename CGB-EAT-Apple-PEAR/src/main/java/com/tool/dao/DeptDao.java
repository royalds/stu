package com.tool.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao {
	//查询部门数据
	List<Map<String,Object>> findObjects();
}
