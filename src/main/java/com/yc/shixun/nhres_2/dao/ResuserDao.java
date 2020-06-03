package com.yc.shixun.nhres_2.dao;

import com.yc.shixun.nhres_2.bean.Resuser;

public interface ResuserDao {
		/*
		 * 登录功能:
		 * select * from resuser where username=? and password=?
		 */
		public Resuser login(Resuser user);
}
