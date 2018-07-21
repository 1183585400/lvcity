package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.BanarVO;
import com.neuedu.lvcity.model.FoodVO;
import com.neuedu.lvcity.model.ScenicVO;

public class IndexDaoImpl {

	/**
	 * 数据库连接
	 */
	private Connection conn;

	/**
	 * 构造方法
	 * @param conn 数据库连接
	 */
	public IndexDaoImpl(Connection conn){
		//给属性赋初始化值
		this.conn = conn;
	}
	
	/**
	 * 查找横幅广告信息
	 * @return
	 */
	public List<BanarVO> findBanar(){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<BanarVO> list = new ArrayList<BanarVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from banar");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				BanarVO banar = new BanarVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				banar.setBanarid(rs.getInt("banarid"));
				banar.setImage(rs.getString("image"));
				banar.setState(rs.getInt("state"));
				list.add(banar); //将对象放入集合中
			}
			
		}catch(Exception e){
			System.out.println("查询Banar信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}

	
	/**
	 * 查找Article（走进南宁）信息
	 * @return 
	 */
	public List<ArticleVO> findArticle(){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from article where atid = 1 ORDER BY aid DESC limit 3");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				ArticleVO article = new ArticleVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				
				article.setAid(rs.getInt("aid"));
//				article.setAtid(rs.getInt("atid"));
//				article.setPublisher(rs.getInt("publisher"));
//				article.setReleasetime(rs.getDate("releasetime"));
				article.setContent(rs.getString("content"));
				article.setImage(rs.getString("image"));
				article.setArticlename(rs.getString("articlename"));
				
				list.add(article); //将对象放入集合中
			}
			
		}catch(Exception e){
			System.out.println("查询Article信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	
	
	/**
	 * 查找Scenic风景信息
	 * @return
	 */
	public List<ScenicVO> findScenic(){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<ScenicVO> list = new ArrayList<ScenicVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from scenic where stid = 1 ORDER BY sid DESC limit 7");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				ScenicVO scenic = new ScenicVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				scenic.setSid(rs.getInt("sid"));
				scenic.setStid(rs.getInt("stid"));
				scenic.setSname(rs.getString("sname"));
				scenic.setImage(rs.getString("image"));
				scenic.setAid(rs.getInt("aid"));
				scenic.setLx(rs.getString("lx"));
				list.add(scenic); //将对象放入集合中
			}
			
		}catch(Exception e){
			System.out.println("查询Scenic风景信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	
	/**
	 * 查找Food食物信息
	 * @return
	 */
	public List<FoodVO> findFood(){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<FoodVO> list = new ArrayList<FoodVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from food");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				FoodVO food = new FoodVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				
				food.setFid(rs.getInt("fid"));
				food.setFtid(rs.getInt("ftid"));
				food.setFname(rs.getString("fname"));
				food.setImage(rs.getString("image"));
				food.setAid(rs.getInt("aid"));
				list.add(food); //将对象放入集合中
			}
			
		}catch(Exception e){
			System.out.println("查询food食物信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	
}
