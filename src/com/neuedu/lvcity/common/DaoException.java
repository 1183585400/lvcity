package com.neuedu.lvcity.common;

/**
 * Dao异常类
 * @author Administrator
 *
 */
public class DaoException extends RuntimeException{
	/**
	 * 默认构造方法
	 */
	public DaoException(){
		
	}
	/**
	 * 构造方法
	 * @param arg0 arg0 异常的详情信息
	 */
	public DaoException(String arg0){
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * @param arg0 arg0产生异常的原因
	 */
	public DaoException(Throwable arg0){
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * @param arg0 异常的详情信息
	 * @param arg1 产生异常的原因
	 */
	public DaoException(String arg0,Throwable arg1){
		super(arg0, arg1);
	}
	
}

