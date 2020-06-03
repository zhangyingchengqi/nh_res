package com.yc.shixun.nhres_2.service;

import java.sql.SQLException;
import java.util.Map;

import com.yc.shixun.nhres_2.bean.Resorder;
import com.yc.shixun.nhres_2.web.entity.CartItem;


public interface ResorderBiz {
	
	/**
	 *  下订
	 * @param resorder: 订单信息
	 * @param shopCart:  购物车，对应订单项
	 *   Map<Integer, CartItem>    Integer:菜的编号
	 *                             CartItem:  num数量    菜的信息
	 */
	public void  completeOrder(  Resorder resorder, Map<Integer, CartItem> shopCart  ) ;
}
