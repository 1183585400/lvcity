package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.DaoException;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.impl.IndexDaoImpl;
import com.neuedu.lvcity.dao.impl.ScenicDaoImpl;
import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.ContactVO;
import com.neuedu.lvcity.model.ScenicTypeVO;
import com.neuedu.lvcity.model.ScenicVO;
import com.neuedu.lvcity.model.UsersVO;

public  class ScenicServiceImpl implements ScenicService{

	@Override
	public List<ScenicTypeVO> findScenicType() {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<ScenicTypeVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			ScenicDaoImpl ScenicMgrDao = new ScenicDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = ScenicMgrDao.findScenicType();
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service查找ScenicType信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}

	@Override
	public List<ScenicVO> findScenicByStid(int stid,int start) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<ScenicVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			ScenicDaoImpl ScenicMgrDao = new ScenicDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = ScenicMgrDao.findScenicByStid(stid,start);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service查找ScenicByStid信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}

	@Override
	public int getCountByStid(int stid) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		int rowCount=0;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			ScenicDaoImpl ScenicMgrDao = new ScenicDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			rowCount = ScenicMgrDao.getCountByStid(stid);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service查找countScenicByStid信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return rowCount;
	}

	@Override
	public String getTypeBySid(int stid) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		String type=null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			ScenicDaoImpl ScenicMgrDao = new ScenicDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			type = ScenicMgrDao.getTypeBySid(stid);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service查找getTypeByStid信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return type;
	}

	@Override
	public ArticleVO getArticleById(int aid) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		ArticleVO article=null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			ScenicDaoImpl ScenicMgrDao = new ScenicDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			article = ScenicMgrDao.getArticleById(aid);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service查找getArticle信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return article;
	}

	@Override
	public UsersVO getAdminById(int id) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		UsersVO user=null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			ScenicDaoImpl ScenicMgrDao = new ScenicDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			user = ScenicMgrDao.getAdminById(id);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service查找getAdmin信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return user;
	}

	@Override
	public int getCountByLike(String like, int stid) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		int rowCount=0;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			ScenicDaoImpl ScenicMgrDao = new ScenicDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			rowCount = ScenicMgrDao.getCountByLike(like, stid);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service模糊查找信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return rowCount;
	}

	@Override
	public List<ScenicVO> scenicListByLike(String like, int stid, int start) {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<ScenicVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			ScenicDaoImpl ScenicMgrDao = new ScenicDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = ScenicMgrDao.scenicListByLike(like, stid, start);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service模糊查找信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}

	@Override
	public ContactVO findContact() {
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		ContactVO contact=null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			ScenicDaoImpl ScenicMgrDao = new ScenicDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			contact = ScenicMgrDao.findContact();
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("Service查找getAdmin信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return contact;
	}

}
