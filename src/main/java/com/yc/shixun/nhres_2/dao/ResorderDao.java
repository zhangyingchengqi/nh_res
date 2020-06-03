package com.yc.shixun.nhres_2.dao;

import com.yc.shixun.nhres_2.bean.Resorder;

public interface ResorderDao {
	
	/**
	 * 将  resorder对象中的数据添加到   resorder表中,  
	 * 请注意;   添加成功后，要在  返回的Resorder 中加入   自动生成的订单编号.
	 * spring jdbctemplate   返回自增列
	 * @param resorder
	 * @return
	 */
	public Resorder insertResorder(  Resorder resorder);
}

/*
      resorder表 ：
      1     1    xx yy   xxx xxx   xxx   no 
      
      resorderitem表:
      序号 订单号    菜
      1   1          1   20   1
      2   1          2   30   1 
 */
