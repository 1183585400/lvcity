package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.impl.HistoricDaoImpl;
import com.neuedu.lvcity.model.AdminVO;
import com.neuedu.lvcity.model.ArticleVO;

public class HistoricServiceImpl implements HistoricService{

	@Override
	public List<ArticleVO> findHistoricArticle() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<ArticleVO> articles = new ArrayList<ArticleVO>();
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建ArticleDao的实现类对象
			HistoricDaoImpl articleDao = new HistoricDaoImpl(conn);
			//调用dao中的.getCountByFtid(ftid方法，进行数据库查询操作，结果赋值给查询结果变量
			articles = articleDao.findHistoricArticle();
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有article错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return articles;
	}

	@Override
	public ArticleVO findHistoricArticleByAid(int aid) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		ArticleVO article = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建ArticleDao的实现类对象
			HistoricDaoImpl articleDao = new HistoricDaoImpl(conn);
			//调用dao中的.getCountByFtid(ftid方法，进行数据库查询操作，结果赋值给查询结果变量
			article = articleDao.findHistoricArticleByAid(aid);		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有article错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return article;
	}

	/**
	 * 根据adminid 获取发布人信息
	 * @return 发布人信息
	 */
	public AdminVO getAdminById(int adminId){
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		AdminVO admin = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			HistoricDaoImpl adminDao  = new HistoricDaoImpl(conn);
			//调用dao中的.getAdminById(adminId)方法，进行数据库查询操作，结果赋值给查询结果变量
			admin  = adminDao.getAdminById(adminId);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有admin错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return admin;
	}
}
