package com.neuedu.lvcity.service.impl;

import java.util.List;

import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.ContactVO;
import com.neuedu.lvcity.model.ScenicTypeVO;
import com.neuedu.lvcity.model.ScenicVO;
import com.neuedu.lvcity.model.UsersVO;

public interface ScenicService {
	
	public List<ScenicTypeVO> findScenicType(); 
	
	public List<ScenicVO> findScenicByStid(int stid,int start);
	
	public int getCountByStid(int stid);
	
	public String getTypeBySid(int stid);
	
	public ArticleVO getArticleById(int aid);

	public UsersVO getAdminById(int id);
	
	public int getCountByLike(String like,int stid);
	
	public List<ScenicVO> scenicListByLike(String like,int stid,int start);
	
	public ContactVO findContact();


}
