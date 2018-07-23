package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.AdminVO;
import com.neuedu.lvcity.model.ArticleVO;
import com.neuedu.lvcity.model.ContactVO;
import com.neuedu.lvcity.model.NoticeVO;
import com.neuedu.lvcity.model.NoticetypeVO;

public interface NoticeDao {
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
	 *查找首页后显示的属性
	 * @return
	 */
	public NoticetypeVO findNoticeById(Integer ntid);
	/**
	 * 查找新闻的详细信息
	 * @param aid
	 * @return
	 */
	public ArticleVO getArticleById(Integer aid);
	/**
	 * 查找发表人
	 * @param adminid
	 * @return
	 */
	public AdminVO getAdminById(Integer adminid);
	/**
	 * 查看联系人
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
