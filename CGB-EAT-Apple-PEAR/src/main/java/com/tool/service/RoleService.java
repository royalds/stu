package com.tool.service;

import com.tool.common.vo.PageObject;
import com.tool.entity.SysRole;

public interface RoleService {
	 /**
     * 通过此方法实现分页查询操作
     * @param name 基于条件查询时的参数名
     * @param pageCurrent 当前的页码值
     * @return 当前页记录+分页信息
     */
	 PageObject<SysRole> findPageObjects(String username,Integer pageCurrent);
}
