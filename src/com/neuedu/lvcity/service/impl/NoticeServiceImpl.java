package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.DaoException;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.impl.IndexDaoImpl;
import com.neuedu.lvcity.dao.impl.NoticeDaoImpl;
import com.neuedu.lvcity.model.AdminVO;
import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.BanarVO;
import com.neuedu.lvcity.model.ContactVO;
import com.neuedu.lvcity.model.NoticeVO;
import com.neuedu.lvcity.model.NoticetypeVO;

public class NoticeServiceImpl implements NoticeService{
	/**
	 * 查找动态信息
	 */
	public List<NoticetypeVO> findNoticetype(){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<NoticetypeVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			NoticeDaoImpl NoticeMgrDao = new NoticeDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = NoticeMgrDao.findNoticetype();
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("1Service:查找动态信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}

	/**
	 * 查看详细分类的新闻
	 */
	public List<NoticeVO> findNotice(Integer ntid){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<NoticeVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			NoticeDaoImpl NoticeMgrDao = new NoticeDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = NoticeMgrDao.findNotice(ntid);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2Service:查找详细新闻信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}
	public NoticetypeVO findNoticeById(Integer ntid){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		NoticetypeVO noticetype = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			NoticeDaoImpl NoticeMgrDao = new NoticeDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			noticetype = NoticeMgrDao.findNoticeById(ntid);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("3Service:查找详细新闻信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return noticetype;
	}
	public ArticleVO getArticleById(Integer aid){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		ArticleVO article = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			NoticeDaoImpl NoticeMgrDao = new NoticeDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			article = NoticeMgrDao.getArticleById(aid);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("3Service:查找详细新闻信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return article;
	}
	public AdminVO getAdminById(Integer adminid){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		AdminVO admin = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			NoticeDaoImpl NoticeMgrDao = new NoticeDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			admin = NoticeMgrDao.getAdminById(adminid);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("3Service:查找详细新闻信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return admin;
	}
	public ContactVO findContact(){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		ContactVO contact = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			NoticeDaoImpl NoticeMgrDao = new NoticeDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			contact = NoticeMgrDao.findContact();
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("3Service:查找详细新闻信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return contact;
	}
	
	public List<NoticeVO> noticeListByLike(String like,Integer ntid){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<NoticeVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			NoticeDaoImpl NoticeMgrDao = new NoticeDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = NoticeMgrDao.noticeListByLike(like, ntid);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2Service:查找详细新闻信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}
	
	public List<NoticeVO> paginationShow(String pageNo,String pageSize){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<NoticeVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			NoticeDaoImpl NoticeMgrDao = new NoticeDaoImpl(conn);
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = NoticeMgrDao.paginationShow(pageNo, pageSize);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2Service:查找详细新闻信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}
}
