package com.neuedu.lvcity.dao.impl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.ContactVO;
import com.neuedu.lvcity.model.ScenicVO;
import com.neuedu.lvcity.model.UsersVO;

public class ScenicDaoImplTest {

	@Test
//	public void testFindScenicType() {
//		Connection conn=null;
//		
//		conn=DBUtils.getConnection();
//		ScenicDaoImpl userconn=new ScenicDaoImpl(conn);
//		userconn.findScenicType();
//	}

//	public void testFindScenicByStid() {
//		Connection conn=null;
//		
//		conn=DBUtils.getConnection();
//		ScenicDaoImpl userconn=new ScenicDaoImpl(conn);
//		userconn.findScenicByStid(1,0);
//	}
	
//	public void testGetCountByStid() {
//		Connection conn=null;
//		
//		conn=DBUtils.getConnection();
//		ScenicDaoImpl userconn=new ScenicDaoImpl(conn);
//		int sum=userconn.getCountByStid(1);
//		System.out.println(sum);
//	}
	
//	public void testGetTypeByStid() {
//		Connection conn=null;
//		
//		conn=DBUtils.getConnection();
//		ScenicDaoImpl userconn=new ScenicDaoImpl(conn);
//		String type=userconn.getTypeBySid(1);
//		System.out.println(type);
//	}
	
//	public void testGetArticleById() {
//		Connection conn=null;
//		
//		conn=DBUtils.getConnection();
//		ScenicDaoImpl userconn=new ScenicDaoImpl(conn);
//		ArticleVO article=userconn.getArticleById(1);
//		System.out.println(article.getReleasetime());
//	}
	
//	public void testGetAdminById() {
//		Connection conn=null;
//		
//		conn=DBUtils.getConnection();
//		ScenicDaoImpl userconn=new ScenicDaoImpl(conn);
//		UsersVO user=userconn.getAdminById(1);
//		System.out.println(user.getName());
//	}
	
//	public void testGetCountByLike() {
//		Connection conn=null;
//		
//		conn=DBUtils.getConnection();
//		ScenicDaoImpl userconn=new ScenicDaoImpl(conn);
//		int count=userconn.getCountByLike("%公园%", 2);
//		System.out.println(count);
//	}
	
//	public void testScenicListByLike() {
//		Connection conn=null;
//		
//		conn=DBUtils.getConnection();
//		ScenicDaoImpl userconn=new ScenicDaoImpl(conn);
//		List<ScenicVO> scenicVO=userconn.scenicListByLike("%公园%", 2,0);
//		
//	}
	
	public void testGetArticleById() {
	Connection conn=null;
	
	conn=DBUtils.getConnection();
	ScenicDaoImpl userconn=new ScenicDaoImpl(conn);
	ContactVO contact=userconn.findContact();
	System.out.println(contact.getContactname());
	System.out.println(contact.getTel());
}
	
}
