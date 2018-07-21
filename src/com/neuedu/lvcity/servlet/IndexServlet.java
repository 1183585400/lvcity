package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.impl.IndexDaoImpl;
import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.BanarVO;
import com.neuedu.lvcity.model.FoodVO;
import com.neuedu.lvcity.model.ScenicVO;
import com.neuedu.lvcity.service.impl.IndexService;
import com.neuedu.lvcity.service.impl.IndexServiceImpl;

public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public IndexServlet(){
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.getWriter().append("Served at").append(req.getContextPath());
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession se = req.getSession(); //获取session
		
		IndexService indexService = new IndexServiceImpl(); //调用Service方法
		
		List<BanarVO> banarList = indexService.findBanar();
		se.setAttribute("banarList",banarList );
		
		List<ArticleVO> articleList = indexService.findArticle();
		se.setAttribute("articleList",articleList);
				
		List<ScenicVO> scenicList = indexService.findScenic();
		se.setAttribute("scenicList",scenicList);

		List<FoodVO> foodList = indexService.findFood();
		se.setAttribute("foodList",foodList);
		
		resp.sendRedirect(req.getContextPath()
				+"/User/index.jsp");
		
	}
}
