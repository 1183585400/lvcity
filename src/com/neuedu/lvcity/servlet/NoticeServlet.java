package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.lvcity.model.AdminVO;
import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.BanarVO;
import com.neuedu.lvcity.model.ContactVO;
import com.neuedu.lvcity.model.FoodVO;
import com.neuedu.lvcity.model.NoticeVO;
import com.neuedu.lvcity.model.NoticetypeVO;
import com.neuedu.lvcity.model.ScenicVO;
import com.neuedu.lvcity.service.impl.IndexService;
import com.neuedu.lvcity.service.impl.IndexServiceImpl;
import com.neuedu.lvcity.service.impl.NoticeService;
import com.neuedu.lvcity.service.impl.NoticeServiceImpl;

public class NoticeServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	public NoticeServlet(){
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.getWriter().append("Served at").append(req.getContextPath());
		doPost(req, resp);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//doShow(req,resp);
		String action = req.getParameter("action");	
	    //显示左边所有美食分类
		if("show".equals(action)){
			doShow(req,resp);
	 	//显示对应分类下面的各种美食列表
		}else if("showList".equals(action)){
			doShowList(req,resp);
		}else if("watch".equals(action)){
			doWatch(req,resp);
		}
		//模糊查询
		else if("search".equals(action)){
			doSearch(req,resp);
		}
		//分页查询
		else if("search2".equals(action)){
					doSearch2(req,resp);
				}
	}
	
	private void doShow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		   //获取session
		HttpSession se = req.getSession();
		// 调用Service方法
		NoticeService NoticeService = new NoticeServiceImpl();
		List<NoticetypeVO> noticetypeList = NoticeService.findNoticetype();
		se.setAttribute("noticetypeList",noticetypeList);
		
		int firstnoticetypeid = noticetypeList.get(0).getNtid();
		se.setAttribute("firstnoticetypeid", firstnoticetypeid);

		// 联系方式处
		ContactVO contact = NoticeService.findContact();
		se.setAttribute("contact", contact);

		
		resp.sendRedirect(req.getContextPath()+ "/User/noticetype.jsp");
		for(NoticetypeVO u:noticetypeList)
		{
		System.out.println(u.getNtid());
		System.out.println(u.getNt());
		}
		
		
}
	private void doShowList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  
		//获取session
        HttpSession se = request.getSession();
        //将“暂无记录”标志先设置清空
        se.setAttribute("zwjl", null);
        NoticeService NoticeService = new NoticeServiceImpl();
		//获取从JSP页面传递过来的pageNow当前页参数
		int pageNow = Integer.parseInt(request.getParameter("pageNow"));
		 
		//获取从JSP页面传递过来的选择的当前美食分类
		String ntid = request.getParameter("ntid");
		System.out.println("hahhaa进了"+ntid);
		int ntid1 = Integer.parseInt(ntid);
		
		List<NoticeVO> noticelist = NoticeService.findNotice(ntid1);//该类型一共有几条数据
		if(noticelist == null) {
			//设置“暂无记录”标准
			se.setAttribute("zwjl", "1");
		}
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("ntid",ntid);
		NoticetypeVO noticetype1 = NoticeService.findNoticeById(ntid1);
		String noticetype =noticetype1.getNt();
		se.setAttribute("noticetype",noticetype);
		se.setAttribute("noticelist",noticelist);
		IndexService indexService = new IndexServiceImpl();
		List<ArticleVO> articlelist = indexService.findArticle();
		se.setAttribute("articlelist",articlelist);
		

		int pageSize = 9;// 一页9条数据
		int rowCount = 0 ;// 该类型一共有几条数据
		for(NoticeVO u:noticelist)
		{
			rowCount++;
		}
		if (rowCount == 0) {
			// 设置“暂无记录”标准
			se.setAttribute("zwjl", "1");
		}
		int pageCount;// 一共有多少页
		if (rowCount % pageSize == 0) {
			pageCount = rowCount / pageSize;
		} else {
			pageCount = rowCount / pageSize + 1;
		}

		// 不足一页，默认显示第一页
		if (pageNow < 1) {
			pageNow = 1;
		}
		// 当前页超过最大页，设置当前页为最大页
		if (pageNow > pageCount) {
			pageNow = pageCount;
		}

		int start = 0;
		if (pageNow == 1) {
			// 如果是第一页，从0开始
			start = 0;
		} else if (pageNow == 0) {
			start = (pageNow) * pageSize;
			pageNow = 1;
			pageCount = 1;
		} else {
			start = (pageNow - 1) * pageSize;
		}

		se.setAttribute("pageNow", pageNow);
		se.setAttribute("rowCount", rowCount);
		se.setAttribute("pageCount", pageCount);
		se.setAttribute("pageSize", pageSize);
		se.setAttribute("ntid", ntid);
		se.setAttribute("like", "null");
		
		
		
		
		
		System.out.println("名字："+noticetype);
		response.sendRedirect(request.getContextPath()+ "/User/noticelist.jsp");	
	}
	private void doWatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 获取session
		HttpSession se = req.getSession();

		int pageNow = Integer.parseInt(req.getParameter("pageNow"));
		int ntid = Integer.parseInt(req.getParameter("ntid"));
		int aid = Integer.parseInt(req.getParameter("aid"));

		// 获取service
		IndexService indexService = new IndexServiceImpl();
		List<ArticleVO> articlelist = indexService.findArticle();
		se.setAttribute("articlelist",articlelist);
		 NoticeService NoticeService = new NoticeServiceImpl();
		ArticleVO article = NoticeService.getArticleById(aid);
		AdminVO admin = NoticeService.getAdminById(article.getPublisher());
		se.setAttribute("article", article);
		se.setAttribute("admin", admin);
		se.setAttribute("pageNow", pageNow);
		se.setAttribute("ntid", ntid);
		resp.sendRedirect(req.getContextPath() + "/User/noticetext.jsp");

	}
	
	private void doSearch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		// 获取session
		HttpSession se = req.getSession();
		String like = new String(req.getParameter("mhcx").getBytes("ISO-8859-1"),"utf-8");
		
		int ntid = Integer.parseInt(req.getParameter("ntid"));
		int pageNow = Integer.parseInt(req.getParameter("pageNow"));

		if (like.trim().equals("null")) {
			doShowList(req, resp);
		} else {
			cx(like, ntid, pageNow, req, resp);
			
			
		}

	}
	
	private void cx(String like, int ntid, int pageNow, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 获取session
		HttpSession se = req.getSession();
		// 将“暂无记录”标志先设置清空
		se.setAttribute("zwjl", null);

		System.out.println("2hahhaa进了"+ntid);
		NoticeService NoticeService = new NoticeServiceImpl();
		NoticetypeVO noticetype1 = NoticeService.findNoticeById(ntid);
		String noticetype =noticetype1.getNt();
		se.setAttribute("noticetype", noticetype);
		List<NoticeVO> noticelist = NoticeService.noticeListByLike(like, ntid);
		int rowCount = 0;
		for(NoticeVO u:noticelist)
		{
			rowCount++;
		}
		se.setAttribute("noticelist", noticelist);
		IndexService indexService = new IndexServiceImpl();
		List<ArticleVO> articlelist = indexService.findArticle();
		se.setAttribute("articlelist",articlelist);
		System.out.println("名字2："+like+"   "+ntid);

		int pageSize = 9;// 一页9条数据
		/*
		 * System.out.println("%"+like+"%"); System.out.println(ntid);
		 */
		if (rowCount == 0) {
			se.setAttribute("zwjl", "1");
		}
		int pageCount;// 一共有多少页
		if (rowCount % pageSize == 0) {
			pageCount = rowCount / pageSize;
		} else {
			pageCount = rowCount / pageSize + 1;
		}

		if (pageNow < 1) {
			pageNow = 1;
		}
		if (pageNow > pageCount) {
			pageNow = pageCount;
		}

		int start = 0;
		if (pageNow == 1) {
			start = 0;
		} else if (pageNow == 0) {
			start = (pageNow) * pageSize;
			pageNow = 1;
			pageCount = 1;
		} else {
			start = (pageNow - 1) * pageSize;
		}

		se.setAttribute("pageNow", pageNow);
		se.setAttribute("rowCount", rowCount);
		se.setAttribute("pageCount", pageCount);
		se.setAttribute("pageSize", pageSize);
		se.setAttribute("ntid", ntid);
		se.setAttribute("like", "null");
		resp.sendRedirect(req.getContextPath()+ "/User/noticelist.jsp");
	}
	
	
	//分页查询
	private void doSearch2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		// 获取session
		HttpSession se = req.getSession();
		String like = new String(req.getParameter("mhcx").getBytes("ISO-8859-1"),"utf-8");
		int ntid = Integer.parseInt(req.getParameter("ntid"));
		String pageNo = req.getParameter("pageNow");
		if (like.trim().equals("null")) {
			doShowList(req, resp);
		} else {
			// 将“暂无记录”标志先设置清空
			se.setAttribute("zwjl", null);
			String pageSize1 = "9";// 一页9条数据
			System.out.println("2hahhaa进了"+ntid);
			NoticeService NoticeService = new NoticeServiceImpl();
			NoticetypeVO noticetype1 = NoticeService.findNoticeById(ntid);
			String noticetype =noticetype1.getNt();
			se.setAttribute("noticetype", noticetype);
			List<NoticeVO> noticelist = NoticeService.paginationShow(pageNo, pageSize1);
			List<NoticeVO> noticelist2 = NoticeService.findNotice(ntid);
			int rowCount = 0;
			for(NoticeVO u:noticelist2)
			{
				rowCount++;
			}
			se.setAttribute("noticelist", noticelist);
			IndexService indexService = new IndexServiceImpl();
			List<ArticleVO> articlelist = indexService.findArticle();
			se.setAttribute("articlelist",articlelist);
			System.out.println("名字2："+like+"   "+ntid);

			if (rowCount == 0) {
				se.setAttribute("zwjl", "1");
			}
			int pageSize = Integer.parseInt(pageSize1);
			int pageNow =Integer.parseInt(pageNo);
			int pageCount;// 一共有多少页
			if (rowCount % pageSize == 0) {
				pageCount = rowCount / pageSize;
			} else {
				pageCount = rowCount / pageSize + 1;
			}

			if (pageNow < 1) {
				pageNow = 1;
			}
			if (pageNow > pageCount) {
				pageNow = pageCount;
			}

			int start = 0;
			if (pageNow == 1) {
				start = 0;
			} else if (pageNow == 0) {
				start = (pageNow) * pageSize;
				pageNow = 1;
				pageCount = 1;
			} else {
				start = (pageNow - 1) * pageSize;
			}

			se.setAttribute("pageNow", pageNow);
			se.setAttribute("rowCount", rowCount);
			se.setAttribute("pageCount", pageCount);
			se.setAttribute("pageSize", pageSize);
			se.setAttribute("ntid", ntid);
			se.setAttribute("like", "null");
			resp.sendRedirect(req.getContextPath()+ "/User/noticelist.jsp");
			
		}

	}
}
