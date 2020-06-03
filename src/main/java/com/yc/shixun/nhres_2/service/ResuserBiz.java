package com.yc.shixun.nhres_2.service;

import com.yc.shixun.nhres_2.bean.Resuser;


public interface ResuserBiz {
	/*
	 * 登录:  密码md5加密.
	 */
	public Resuser login( Resuser user);
}
