package com.yc.shixun.nhres_2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.shixun.nhres_2.bean.Resfood;
import com.yc.shixun.nhres_2.dao.ResfoodDao;
import com.yc.shixun.nhres_2.service.ResfoodBiz;

@Service
public class ResfoodBizImpl implements ResfoodBiz {
	
	@Autowired
	private ResfoodDao resfoodDao;

	@Override
	public List<Resfood> findAll() {
		return resfoodDao.findAllFood();
	}

}
