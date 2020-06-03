package com.yc.shixun.nhres_2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.shixun.nhres_2.bean.Resuser;
import com.yc.shixun.nhres_2.dao.ResuserDao;
import com.yc.shixun.nhres_2.service.ResuserBiz;
import com.yc.shixun.nhres_2.utils.Encrypt;

@Service // spring业务层注解( 异常,事务) , 由spring托管这个类( new,管理对象 )
public class ResuserBizImpl implements ResuserBiz {
	// 注入Dao类的对象
	@Autowired
	private ResuserDao resuserDao;
	@Override
	public Resuser login(Resuser user) {
		user.setPwd(Encrypt.md5(user.getPwd())); // 业务
		return resuserDao.login(user);
	}
}
