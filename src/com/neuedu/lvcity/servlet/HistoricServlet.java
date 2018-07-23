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
import com.neuedu.lvcity.model.ContactVO;
import com.neuedu.lvcity.service.impl.ContactServiceImpl;
import com.neuedu.lvcity.service.impl.HistoricServiceImpl;

public class HistoricServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoricServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//防止取中文参数出现乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");			   
		if("show".equals(action)){ //显示左边所有历史类文章
			doShow(request,response);     	
		}else if("showList".equals(action)){//显示对应的各种历史类文章
			doShowList(request,response);
		}
	}


	private void doShowList(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//获取session
        HttpSession se = request.getSession();
		
		// 获取美食service层实例
        HistoricServiceImpl  historicServiceImpl = new HistoricServiceImpl();
		
		//获取从JSP页面传递过来的选择的当前历史类
		int aid = Integer.parseInt(request.getParameter("aid"));
		System.out.println("==================="+aid);
		
		ArticleVO HistoricleList = historicServiceImpl.findHistoricArticleByAid(aid);
		
		AdminVO admin = historicServiceImpl.getAdminById(1);
		se.setAttribute("admin",admin);
		
		se.setAttribute("articlename",HistoricleList.getArticlename());
		
		se.setAttribute("article",HistoricleList);
		
		response.sendRedirect(request.getContextPath()+ "/User/historictext.jsp");		
	}

	private void doShow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 //获取session
        HttpSession se = request.getSession();
		
		// 调用Service方法
        HistoricServiceImpl  historicServiceImpl = new HistoricServiceImpl();
        ContactServiceImpl contactService = new ContactServiceImpl();
		
		// TODO Auto-generated method stub
		List<ArticleVO> articlelist = historicServiceImpl.findHistoricArticle();
		se.setAttribute("articlelist",articlelist);
		
		//联系方式处
		ContactVO contact = contactService.findContact();
		se.setAttribute("contact",contact);

		 response.sendRedirect(request.getContextPath()+ "/User/historic.jsp");		
	}
}
