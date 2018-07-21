package com.neuedu.lvcity.dao.impl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.model.BanarVO;
import com.neuedu.lvcity.model.ScenicVO;


public class IndexDaoImplTest {

//	@Test
//	public void testFindBanar() {
//
//		Connection conn = DBUtils.getConnection();
//		IndexDaoImpl index = new IndexDaoImpl(conn);
//		List<BanarVO> b = index.findBanar();
//		System.out.print(b);
//	}
//	
	
	@Test
	public void testFindScenic() {

		Connection conn = DBUtils.getConnection();
		IndexDaoImpl index = new IndexDaoImpl(conn);
		List<ScenicVO> b = index.findScenic();
		for(ScenicVO scenic :b){
			System.out.print(scenic.getImage());
		}
		
	}

}
