package com.yc.shixun.nhres_2.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.shixun.nhres_2.bean.Resorder;
import com.yc.shixun.nhres_2.bean.Resorderitem;
import com.yc.shixun.nhres_2.dao.ResorderDao;
import com.yc.shixun.nhres_2.dao.ResorderitemDao;
import com.yc.shixun.nhres_2.service.ResorderBiz;
import com.yc.shixun.nhres_2.web.entity.CartItem;

@Service
@Transactional
public class ResorderBizImpl implements ResorderBiz {
	@Autowired
	private ResorderDao resorderDao;
	@Autowired
	private ResorderitemDao resorderitemDao;

	/*
	 * 1个订单+n个订单项
	 * 事务
	 */
	@Override  
	@Transactional(   rollbackFor=RuntimeException.class )
	public void completeOrder(Resorder resorder, Map<Integer, CartItem> shopCart) {
			//1. 插入订单
		   Resorder orderResult=resorderDao.insertResorder(   resorder );
		   //新订单的编号
		   int oid=orderResult.getRoid();
		   if(   shopCart!=null&&shopCart.size()>0) {
			   
			   for( Map.Entry<Integer, CartItem> entry: shopCart.entrySet() ) {
				   Resorderitem ri=new Resorderitem();
				   ri.setRoid(   oid );
				   ri.setNum(   entry.getValue().getNum()   );   // 数量
				   ri.setFid(   entry.getKey() );
				   ri.setDealprice(   entry.getValue().getFood().getRealprice()   );
				   resorderitemDao.insertResorderitem( ri );
				  
				   throw new RuntimeException("添加订单详情出问题了，网络抖动...");
				   
			   }
		   }
	}

}
