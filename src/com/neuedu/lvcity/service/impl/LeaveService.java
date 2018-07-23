package com.neuedu.lvcity.service.impl;

import java.util.List;

import com.neuedu.lvcity.model.MessageVO;

public interface LeaveService {
	/**
	 * 留言
	 * @return
	 */
	public List<MessageVO> findLeavetype();
}
