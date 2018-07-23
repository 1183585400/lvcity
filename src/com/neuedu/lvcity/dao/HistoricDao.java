package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.AdminVO;
import com.neuedu.lvcity.model.ArticleVO;

public interface HistoricDao {
	
	public List<ArticleVO> findHistoricArticle(); //查询历史类文章
	
	public ArticleVO findHistoricArticleByAid(int aid); //根据ID查询历史文章
		
	public AdminVO getAdminById(int adminId);//根据adminid 获取发布人信息
}
