package com.neuedu.lvcity.service.impl;

import java.util.List;

import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.BanarVO;
import com.neuedu.lvcity.model.FoodVO;
import com.neuedu.lvcity.model.ScenicVO;

public interface IndexService {

	/**
	 * 查找横幅广告信息
	 * @return
	 */
	public List<BanarVO> findBanar();
	
	/**
	 * 查找Article（走进南宁）信息
	 * @return 
	 */
	public List<ArticleVO> findArticle();
	
	/**
	 * 查找Scenic风景信息
	 * @return
	 */
	public List<ScenicVO> findScenic();
	
	/**
	 * 查找Food食物信息
	 * @return
	 */
	public List<FoodVO> findFood();
	
}
