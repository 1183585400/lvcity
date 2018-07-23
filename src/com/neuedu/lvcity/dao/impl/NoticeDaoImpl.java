package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.model.AdminVO;
import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.ContactVO;
import com.neuedu.lvcity.model.NoticeVO;
import com.neuedu.lvcity.model.NoticetypeVO;

public class NoticeDaoImpl {
	/**
	 * 数据库连接
	 */
	private Connection conn;

	/**
	 * 构造方法
	 * @param conn 数据库连接
	 */
	public NoticeDaoImpl(Connection conn){
		//给属性赋初始化值
		this.conn = conn;
	}
	
	/**
	 * 查找横幅广告信息
	 * @return
	 */
	public List<NoticetypeVO> findNoticetype(){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<NoticetypeVO> list = new ArrayList<NoticetypeVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from noticetype");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				NoticetypeVO noticetype = new NoticetypeVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				noticetype.setNtid(rs.getInt("ntid"));
				noticetype.setNt(rs.getString("nt"));
				list.add(noticetype); //将对象放入集合中
			}
			
		}catch(Exception e){
			System.out.println("查询noticetype信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	
	public List<NoticeVO> findNotice(Integer ntid){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from notice where ntid = ?");
			prep.setInt(1, ntid);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				NoticeVO notice = new NoticeVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				notice.setNid(rs.getInt("nid"));
				notice.setNtid(rs.getInt("ntid"));
				notice.setNname(rs.getString("nname"));
				notice.setAid(rs.getInt("aid"));
				list.add(notice); //将对象放入集合中
			}
			
		}catch(Exception e){
			System.out.println("1查询notice信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	/**
	 * 查看首页后面加的页面
	 * @param ntid
	 * @return
	 */
	public NoticetypeVO findNoticeById(Integer ntid){
		ResultSet rs = null;
		PreparedStatement prep = null;
		NoticetypeVO Noticetype =null;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from noticetype where ntid=?");
			//给问号赋值
			prep.setInt(1, ntid);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			if(rs.next()){
				//创建一个新的用户对象，赋予给用户对象变量
				Noticetype = new NoticetypeVO();
				Noticetype.setNtid(rs.getInt("ntid"));
				Noticetype.setNt(rs.getString("nt"));
			}

		}catch(Exception e){
			System.out.println("2查询notice信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return Noticetype;
	}
	
	public ArticleVO getArticleById(Integer aid){
		ResultSet rs = null;
		PreparedStatement prep = null;
		ArticleVO article =null;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from article where aid=?");
			//给问号赋值
			prep.setInt(1, aid);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			if(rs.next()){
				//创建一个新的用户对象，赋予给用户对象变量
				article = new ArticleVO();
				article.setAid(rs.getInt("aid"));
				article.setAtid(rs.getInt("atid"));
				article.setPublisher(rs.getInt("publisher"));
				article.setReleasetime(rs.getDate("releasetime"));
				article.setContent(rs.getString("content"));
				article.setImage(rs.getString("image"));
				article.setArticlename(rs.getString("articlename"));
			}

		}catch(Exception e){
			System.out.println("2查询notice信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return article;
	}
	/**
	 * 查找发布人
	 * @param adminid
	 * @return
	 */
	public AdminVO getAdminById(Integer adminid){
		ResultSet rs = null;
		PreparedStatement prep = null;
		AdminVO admin =null;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from admin where adminid=?");
			//给问号赋值
			prep.setInt(1, adminid);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			if(rs.next()){
				//创建一个新的用户对象，赋予给用户对象变量
				admin = new AdminVO();
				admin.setAdminid(rs.getInt("adminid"));
				admin.setAdminname(rs.getString("adminname"));
				admin.setPasswd(rs.getString("passwd"));
				}

		}catch(Exception e){
			System.out.println("2查询notice信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return admin;
	}
	public ContactVO findContact(){
		ResultSet rs = null;
		PreparedStatement prep = null;
		ContactVO contact =null;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from contact");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			if(rs.next()){
				//创建一个新的用户对象，赋予给用户对象变量
				contact = new ContactVO();
				contact.setContactid(rs.getInt("contactid"));
				contact.setContactname(rs.getString("contactname"));
				contact.setTel(rs.getString("tel"));
				contact.setQq(rs.getString("qq"));
				contact.setWeb(rs.getString("web"));
				contact.setZipcode(rs.getString("zipcode"));
				contact.setFax(rs.getString("fax"));
				contact.setAddress(rs.getString("address"));
				}

		}catch(Exception e){
			System.out.println("2查询notice信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return contact;
	}
	public List<NoticeVO> noticeListByLike(String mhcx,Integer ntid){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from notice where ntid=? and nname like ?");
			prep.setInt(1, ntid);
			prep.setString(2, "%"+mhcx+"%");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				NoticeVO notice = new NoticeVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				notice.setNid(rs.getInt("nid"));
				notice.setNtid(rs.getInt("ntid"));
				notice.setNname(rs.getString("nname"));
				notice.setAid(rs.getInt("aid"));
				list.add(notice); //将对象放入集合中

			}
			
		}catch(Exception e){
			System.out.println("5查询notice信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
		
	}
	//分页查询
	public List<NoticeVO> paginationShow(String pageNo,String pageSize){
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		System.out.println("传进来的数据："+pageNo+pageSize);
		//声明结果集对象变量，用于保存数据查询结果
		ResultSet rs = null;
		//声明预编译的声明对象变量，用于运行数据库操作的载体
		PreparedStatement pstat =null;	
		//把字符转成整型
		int pn=Integer.parseInt(pageNo);
		int ps=Integer.parseInt(pageSize);
		try {
			//调用连接对象的preparedStatement方法，得到预编译对象，赋值给预编译对象变量
			pstat = conn.prepareStatement("select * from notice limit ?,?  ");
			//调用预编译的setXXX方法，给？赋值
			pstat.setInt(1,(pn-1)*ps);
			pstat.setInt(2,pn*ps);
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstat.executeQuery();
			//如果查询结果不为空将取出结果中的各个字段，封装在各个对象的属性中
			
			while(rs.next()){
				//创建一个新的用户对象，赋予给用户对象变量
				NoticeVO notice = new NoticeVO();
				 /**
				  * 先用结果集的get方法，取出各个字段的值
				  * 然后再调用新创建的对象包含了查询结果中的所有字段的值
				  */
				notice.setNid(rs.getInt("nid"));
				notice.setNtid(rs.getInt("ntid"));
				notice.setNname(rs.getString("nname"));
				notice.setAid(rs.getInt("aid"));
				list.add(notice); //将对象放入集合中
			}
		} catch (SQLException e) {
			//将异常封装成自定义异常
			System.out.println("5查询notice信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, pstat);
			}
		return list;
}
	
}
