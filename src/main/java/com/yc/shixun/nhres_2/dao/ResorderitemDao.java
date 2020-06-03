package com.yc.shixun.nhres_2.dao;

import com.yc.shixun.nhres_2.bean.Resorderitem;

public interface ResorderitemDao {
	
	/**
	 * 订单详情添加到数据库 
	 * @param item
	 */
	public void insertResorderitem(  Resorderitem item);
}
