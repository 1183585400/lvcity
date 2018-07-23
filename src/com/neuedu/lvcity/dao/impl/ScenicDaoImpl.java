package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.ScenicDao;
import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.ContactVO;
import com.neuedu.lvcity.model.ScenicTypeVO;
import com.neuedu.lvcity.model.ScenicVO;
import com.neuedu.lvcity.model.UsersVO;


public class ScenicDaoImpl implements ScenicDao{

	/**
	 * 数据库连接
	 */
	private Connection conn;

	/**
	 * 构造方法
	 * @param conn 数据库连接
	 */
	public ScenicDaoImpl(Connection conn){
		//给属性赋初始化值
		this.conn = conn;
	}

	public List<ScenicTypeVO> findScenicType() {
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<ScenicTypeVO> list = new ArrayList<ScenicTypeVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from scenictype order by stid");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				ScenicTypeVO scenictype = new ScenicTypeVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值

				scenictype.setStid(rs.getInt("stid"));
				scenictype.setSt(rs.getString("st"));
				list.add(scenictype); //将对象放入集合中
			}
			
			for(ScenicTypeVO s:list){
	    		System.out.println(s.getStid());
	    		System.out.println(s.getSt());
	    	
	    	}
			
		}catch(Exception e){
			System.out.println("查询ScenicType风景信息(风景类别)时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}

	@Override
	public List<ScenicVO> findScenicByStid(int stid,int start) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<ScenicVO> list = new ArrayList<ScenicVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from scenic where stid=? limit  ?,9");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, stid);
		    prep.setInt(2, start);
			rs = prep.executeQuery();
			while(rs.next()){
				ScenicVO scenic = new ScenicVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值

				scenic.setStid(rs.getInt("stid"));
				scenic.setAid(rs.getInt("aid"));
				scenic.setImage(rs.getString("image"));
				scenic.setLx(rs.getString("lx"));
				scenic.setSid(rs.getInt("sid"));
				scenic.setSname(rs.getString("sname"));
				
				list.add(scenic); //将对象放入集合中
			}
			
			for(ScenicVO s:list){
	    		System.out.println(s.getStid());
	    		System.out.println(s.getSname());
	    	
	    	}
			
		}catch(Exception e){
			System.out.println("查询ScenicByStid风景信息(风景图片)时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}

	@Override
	public int getCountByStid(int stid) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		int rowCount=0;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select count(sid) as rowCount from scenic where stid=? ");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, stid);
			
			rs = prep.executeQuery();
			if(rs.next()){
				
				rowCount=rs.getInt("rowCount");

			}
			
			
		}catch(Exception e){
			System.out.println("查询countScenicByStid风景信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return rowCount;
	}

	@Override
	public String getTypeBySid(int stid) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		String type=null;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from scenictype where stid=?");
			prep.setInt(1, stid);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			if(rs.next()){
				 
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
                type=rs.getString("st");
			//将对象放入集合中
			}
			
			
			
		}catch(Exception e){
			System.out.println("查询getTypeBystid时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return type;
	}

	@Override
	public ArticleVO getArticleById(int aid) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		ArticleVO article = null;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from article where aid=?");
			prep.setInt(1, aid);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			if(rs.next()){
				 article = new ArticleVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值

				 article.setAid(rs.getInt("aid"));
				 article.setArticlename(rs.getString("articlename"));
				 article.setAtid(rs.getInt("atid"));
				 article.setContent(rs.getString("content"));
				 article.setImage(rs.getString("image"));
				 article.setPublisher(rs.getInt("publisher"));
				 article.setReleasetime(rs.getDate("releasetime"));

			}
			
		
			
		}catch(Exception e){
			System.out.println("查询ScenicArticle风景信息(风景详细)时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return article;
	}

	@Override
	public UsersVO getAdminById(int id) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		UsersVO admin = null;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from users where id=?");
			prep.setInt(1, id);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			if(rs.next()){
				 admin = new UsersVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值

				 admin.setId(rs.getInt("id"));
				 admin.setName(rs.getString("name"));
				 admin.setAge(rs.getInt("age"));
				 admin.setPasswd(rs.getString("Passwd"));
				 admin.setEmail(rs.getString("email"));
				 admin.setPhone(rs.getString("phone"));
				 

			}
			
		
			
		}catch(Exception e){
			System.out.println("查询ScenicArticleAdmin时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return admin;
	}

	@Override
	public int getCountByLike(String like, int stid) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		int rowCount=0;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select count(sid) as rowCount from scenic where stid=? and sname like ?");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, stid);
			prep.setString(2, like);
			rs = prep.executeQuery();
			if(rs.next()){
				
				rowCount=rs.getInt("rowCount");

			}
			
			
		}catch(Exception e){
			System.out.println("模糊查询风景信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return rowCount;
	}

	@Override
	public List<ScenicVO> scenicListByLike(String like, int stid, int start) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<ScenicVO> list = new ArrayList<ScenicVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from scenic where stid=? and sname like ? limit ?,9");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, stid);
			prep.setString(2, like);
			prep.setInt(3, start);
			rs = prep.executeQuery();
			while(rs.next()){
				ScenicVO scenic = new ScenicVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值

				scenic.setStid(rs.getInt("stid"));
				scenic.setAid(rs.getInt("aid"));
				scenic.setImage(rs.getString("image"));
				scenic.setLx(rs.getString("lx"));
				scenic.setSid(rs.getInt("sid"));
				scenic.setSname(rs.getString("sname"));
				
				list.add(scenic); //将对象放入集合中
			}
			
			for(ScenicVO s:list){
	    		System.out.println(s.getStid());
	    		System.out.println(s.getSname());
	    	
	    	}
			
			
		}catch(Exception e){
			System.out.println("模糊查询风景信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}

	@Override
	public ContactVO findContact() {
		ResultSet rs = null;
		PreparedStatement prep = null;
		ContactVO contact =null;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from contact");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				contact = new ContactVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值

				contact.setAddress(rs.getString("address"));
				
				contact.setContactid(rs.getInt("contactid"));
				
				contact.setContactname(rs.getString("contactname"));
				
				contact.setFax(rs.getString("fax"));
				
				contact.setQq(rs.getString("qq"));
				
				contact.setTel(rs.getString("tel"));
				
				contact.setWeb(rs.getString("web"));
				
				contact.setZipcode(rs.getString("zipcode"));
				
			}
			
			
			
		}catch(Exception e){
			System.out.println("查询联系人信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return contact;
	}

}
