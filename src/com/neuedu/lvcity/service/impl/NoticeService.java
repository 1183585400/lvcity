package com.neuedu.lvcity.service.impl;

import java.util.List;

import com.neuedu.lvcity.model.AdminVO;
import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.ContactVO;
import com.neuedu.lvcity.model.NoticeVO;
import com.neuedu.lvcity.model.NoticetypeVO;

public interface NoticeService {
	/**
	 *动态目录查找
	 * @return
	 */
	public List<NoticetypeVO> findNoticetype();
	/**
	 * 查看详细分类的新闻
	 * @return
	 */
	public List<NoticeVO> findNotice(Integer ntid);
	/**
	 * 查看首页后面跟的数据
	 * @param ntid
	 * @return
	 */
	public NoticetypeVO findNoticeById(Integer ntid);
	/**
	 * 查看新闻的详细信息
	 * @param aid
	 * @return
	 */
	public ArticleVO getArticleById(Integer aid);
	/**
	 * 查找发布人
	 * @param adminid
	 * @return
	 */
	public AdminVO getAdminById(Integer adminid);
	/**
	 * 查找联系人
	 * @return
	 */
	public ContactVO findContact();
	/**
	 * 模糊查询
	 * @param like
	 * @param ntid
	 * @return
	 */
	public List<NoticeVO> noticeListByLike(String like,Integer ntid);
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<NoticeVO> paginationShow(String pageNo,String pageSize);
}
