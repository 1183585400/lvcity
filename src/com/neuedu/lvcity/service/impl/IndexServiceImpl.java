package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.DaoException;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.impl.IndexDaoImpl;
import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.BanarVO;
import com.neuedu.lvcity.model.FoodVO;
import com.neuedu.lvcity.model.ScenicVO;

public class IndexServiceImpl implements IndexService{

	/**
	 * 查找横幅广告信息
	 * @return
	 */
	public List<BanarVO> findBanar(){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<BanarVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			IndexDaoImpl IndexMgrDao = new IndexDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = IndexMgrDao.findBanar();
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service:查找横幅广告信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}
	
	/**
	 * 查找Article（走进南宁）信息
	 * @return 
	 */
	public List<ArticleVO> findArticle(){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<ArticleVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			IndexDaoImpl IndexMgrDao = new IndexDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = IndexMgrDao.findArticle();
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service查找Article（走进南宁）信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}
	
	
	/**
	 * 查找Scenic风景信息
	 * @return
	 */
	public List<ScenicVO> findScenic(){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<ScenicVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			IndexDaoImpl IndexMgrDao = new IndexDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = IndexMgrDao.findScenic();
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service查找Article（走进南宁）信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}
	
	/**
	 * 查找Food食物信息
	 * @return
	 */
	public List<FoodVO> findFood(){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<FoodVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			IndexDaoImpl IndexMgrDao = new IndexDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = IndexMgrDao.findFood();
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service查找Food（食物）信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}
	
	
}
