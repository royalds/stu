package com.tool.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tool.common.exception.ServiceException;
import com.tool.common.vo.Node;
import com.tool.dao.MenuDao;
import com.tool.dao.RoleMenuDao;
import com.tool.entity.SysMenu;
import com.tool.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private RoleMenuDao roleMenuDao;
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> list = menuDao.findObjects();
		//验证数据合法性
		if(list==null || list.size()==0) {
			throw new ServiceException("没有菜单信息");
		}
		return list;
	}

	@Override
	public int deleteObject(Integer id) {
		//验证数据合法性
		if(id==null || id<=0) {
			throw new IllegalArgumentException("请先选中");
		}
		int count = menuDao.findChildCount(id);
		if(count>0) {
			throw new ServiceException("请先删除子菜单");
		}
		int rows = menuDao.deleteObject(id);
		if(rows==0) {
			throw new ServiceException("没有菜单记录");
		}
		roleMenuDao.deleteObjectsByMenuId(id);
		return rows;
	}

	@Override
	public List<Node> findzTree() {
		return menuDao.findzTree();
	}

	@Override
	public int saveObject(SysMenu entity) {
		//1.合法验证
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");
		int rows;
		//2.保存数据
		try{
				rows=menuDao.insertObject(entity);
		}catch(Exception e){
				e.printStackTrace();
				throw new ServiceException("保存失败");
		}
		//3.返回数据
		return rows;
	}

	@Override
	public int updateObject(SysMenu entity) {
		//1.合法验证
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");
		//2.更新数据
		int rows=menuDao.updateObject(entity);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		//3.返回数据
		return rows;
	}

}
