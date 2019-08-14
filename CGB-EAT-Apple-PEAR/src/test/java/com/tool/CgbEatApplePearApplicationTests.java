package com.tool;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tool.dao.LogDao;
import com.tool.entity.SysLog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CgbEatApplePearApplicationTests {
	@Autowired
	private SqlSessionFactory sqlSessionFacyory;
	@Autowired
	private LogDao logDao;
	@Test
	public void getRowCount() {
		int rowCount = logDao.getRowCount("admin");
		System.out.println(rowCount);
	}
	@Test
	public void findPageObjects() {
		List<SysLog> list = logDao.findPageObjects("admin", 0, 3);
		System.out.println(list);
	}
	@Test
	public void testDataSource() {
		SqlSession session = sqlSessionFacyory.openSession();
		Connection conn = session.getConnection();
		System.out.println(conn);
	}
}
