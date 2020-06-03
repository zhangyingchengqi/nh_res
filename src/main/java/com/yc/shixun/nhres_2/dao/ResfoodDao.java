package com.yc.shixun.nhres_2.dao;

import java.util.List;

import com.yc.shixun.nhres_2.bean.Resfood;

/**
 * 对菜品表  resfood  的操作
* @author 张影 QQ:1069595532  WX:zycqzrx1
* @date Jun 2, 2020
*/
public interface ResfoodDao {

	/**
	 * 查询所有的菜s
	 * @return
	 */
	public List<Resfood>   findAllFood();
}
