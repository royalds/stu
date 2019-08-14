package com.tool.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tool.dao.DeptDao;
import com.tool.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;
	@Override
	public List<Map<String, Object>> findObjects() {
		return deptDao.findObjects();
	}

}
