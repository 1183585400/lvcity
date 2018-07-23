package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;







import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.ContactVO;
import com.neuedu.lvcity.model.ScenicTypeVO;
import com.neuedu.lvcity.model.ScenicVO;
import com.neuedu.lvcity.model.UsersVO;
import com.neuedu.lvcity.service.impl.ScenicService;
import com.neuedu.lvcity.service.impl.ScenicServiceImpl;

public class ScenicServlet extends HttpServlet {
	
	public ScenicServlet(){
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.getWriter().append("Served at: ").append(req.getContextPath());
		doPost(req, resp);
		System.out.println("go to post");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		
		String action = req.getParameter("action");
		System.out.println("this is post");
		if("show".equals(action)){
			System.out.println("go to show");
			 doShowTypeList(req,resp);

		}
		else if("showList".equals(action)){
			doShowList(req,resp);
			
		}else if("detail".equals(action)){
			doDetail(req,resp);
		}
		//模糊查询
				else if("search".equals(action)){
					System.out.println("first");
					doSearch(req,resp);
				}
		
		
	}

	private void doSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String like = req.getParameter("like");
		int stid =Integer.parseInt(req.getParameter("stid"));
		int pageNow =Integer.parseInt( req.getParameter("pageNow"));
		System.out.println("second");
		if(like.trim().equals("null")) {
			System.out.println("like is null");
			doShowList(req, resp);
			System.out.println("1111111");
		}else {
			System.out.println("do search");
			cx(like, stid, pageNow,req,resp);
			System.out.println("22222");
		}
		
		
	}

	private void cx(String like, int stid, int pageNow, HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		   //获取session
        HttpSession se = req.getSession();
        //将“暂无记录”标志先设置清空
        se.setAttribute("zwjl", null);
        
		// 获取美食service层实例
		ScenicService  scenicService =new ScenicServiceImpl();

		
		
		int pageSize = 9;//一页9条数据
		int rowCount = scenicService.getCountByLike("%"+like+"%", stid);//该类型一共有几条数据
		/*System.out.println("%"+like+"%");
		System.out.println(ftid);*/
		if(rowCount == 0) {
			se.setAttribute("zwjl", "1");
		}
		int pageCount;//一共有多少页
		if(rowCount % pageSize == 0){
		    pageCount = rowCount/pageSize;
		}else{
		    pageCount = rowCount/pageSize + 1;
		}
		
		if(pageNow<1){
			pageNow=1;
		}
		if(pageNow>pageCount){
			pageNow=pageCount;
		}
		
		int start=0;
		if(pageNow==1){
			start=0;
		}else if (pageNow==0) {
			start=(pageNow)*pageSize;
			pageNow = 1;
			pageCount= 1;
		}else{
			start=(pageNow-1)*pageSize;
		}
		
		
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("rowCount",rowCount);
		se.setAttribute("pageCount",pageCount);
		se.setAttribute("pageSize",pageSize);
		se.setAttribute("stid",stid);
		se.setAttribute("like","null");
		String scenictype = scenicService.getTypeBySid(stid);
		se.setAttribute("scenictype",scenictype);
		
		List<ScenicVO> sceniclist = scenicService.scenicListByLike("%"+like+"%", stid, start);		
		se.setAttribute("sceniclist",sceniclist);		
		//System.out.println(foodlist.size());
		System.out.println(like);
		 resp.sendRedirect(req.getContextPath()
					+ "/User/scenic.jsp");
		
	}

	private void doDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
HttpSession se = req.getSession();
        
        int pageNow = Integer.parseInt(req.getParameter("pageNow"));
        int stid = Integer.parseInt(req.getParameter("stid"));
        int aid = Integer.parseInt(req.getParameter("aid"));
        
        //获取service
        ScenicService scenicService = new ScenicServiceImpl(); 
        
		ArticleVO article = scenicService.getArticleById(aid);
		UsersVO admin = scenicService.getAdminById(article.getPublisher());
		
		se.setAttribute("article",article);
		se.setAttribute("admin",admin);
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("stid",stid);
		

		 resp.sendRedirect(req.getContextPath()
					+ "/User/fengjingtext.jsp");
		
	}

	private void doShowList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  //获取session
        HttpSession se = req.getSession();
        //将“暂无记录”标志先设置清空
        se.setAttribute("zwjl", null);
		
		// 获取美食service层实例
        ScenicService scenicService = new ScenicServiceImpl(); 

		
		//获取从JSP页面传递过来的pageNow当前页参数
		int pageNow = Integer.parseInt(req.getParameter("pageNow"));
		//获取从JSP页面传递过来的选择的当前美食分类
		int stid = Integer.parseInt(req.getParameter("stid"));


		int pageSize = 9;//一页9条数据
		int rowCount = scenicService.getCountByStid(stid);//该类型一共有几条数据
		if(rowCount == 0) {
			//设置“暂无记录”标准
			se.setAttribute("zwjl", "1");
		}
		int pageCount;//一共有多少页
		if(rowCount % pageSize == 0){
		    pageCount = rowCount/pageSize;
		}else{
		    pageCount = rowCount/pageSize + 1;
		}
		
		//不足一页，默认显示第一页
		if(pageNow<1){
			pageNow=1;
		}
     //当前页超过最大页，设置当前页为最大页
		if(pageNow>pageCount){
			pageNow=pageCount;
		}
		
		int start=0;
		if(pageNow==1){
			//如果是第一页，从0开始
			start=0;
		}else if (pageNow==0) {
			start=(pageNow)*pageSize;
			pageNow = 1;
			pageCount= 1;
		}else{
			start=(pageNow-1)*pageSize;
		}
		
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("rowCount",rowCount);
		se.setAttribute("pageCount",pageCount);
		se.setAttribute("pageSize",pageSize);
		se.setAttribute("stid",stid);
		se.setAttribute("like","null");
		String scenictype = scenicService.getTypeBySid(stid);
		se.setAttribute("scenictype",scenictype);
		
		List<ScenicVO> scenicList = scenicService.findScenicByStid(stid, start);
		se.setAttribute("sceniclist",scenicList);
		for(ScenicVO s:scenicList){
    		System.out.println(s.getImage());
    		System.out.println(s.getStid());
    	
    	}
		 resp.sendRedirect(req.getContextPath()
					+ "/User/scenic.jsp");
		
	}

	private void doShowTypeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		HttpSession se = req.getSession(); //获取session
		
		ScenicService scenicService = new ScenicServiceImpl(); //调用Service方法
		
		System.out.println("show");
		
		List<ScenicTypeVO> scenicTypeList = scenicService.findScenicType();
		se.setAttribute("scenictypeList",scenicTypeList);
        System.out.println("servlet");
		for(ScenicTypeVO s:scenicTypeList){
    		System.out.println(s.getStid());
    		System.out.println(s.getSt());
    	
    	}
		
		ContactVO contact=scenicService.findContact();
		se.setAttribute("contact",contact);
		resp.sendRedirect(req.getContextPath()
				+"/User/beautiful.jsp");

		
	}

}
