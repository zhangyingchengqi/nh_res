package com.yc.shixun.nhres_2.web.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.shixun.nhres_2.bean.Resfood;
import com.yc.shixun.nhres_2.service.ResfoodBiz;
import com.yc.shixun.nhres_2.web.entity.JsonModel;

@RestController    // 1. 这是控制层   2. Rest规范(   支持 GET/POST/DELETE/PUT,   回送数据格式  json)
public class ResfoodController {

	@Autowired
	private ResfoodBiz resfoodBiz;
	
	@RequestMapping( "/findFood")
	public JsonModel findFood( HttpSession session, Resfood food, JsonModel jm   ) {   
		ServletContext application=session.getServletContext();
		List<Resfood> list=null;
		if(   application.getAttribute("list")!=null) {
			list=(List<Resfood>)application.getAttribute("list");
		}else {
			list=resfoodBiz.findAll();
		}
		for( Resfood rf:list) {
			if(  rf.getFid()==   food.getFid()) {
				jm.setCode(1);
				jm.setObj(rf);
				return jm;
			}
		}
		jm.setCode(0);
		jm.setMsg("查无此商品");
		return jm;
	} 
	
	
	@RequestMapping( "/findAllFoods")
	public JsonModel findAllFoods( HttpSession session,  JsonModel jm   ) {   //  spring   IOC/DI
		ServletContext application=session.getServletContext();
		List<Resfood> list=null;
		if(   application.getAttribute("list")!=null) {
			list=(List<Resfood>)application.getAttribute("list");
		}else {
			list=resfoodBiz.findAll();
		}
		jm.setCode(1);
		jm.setObj(list);
		application.setAttribute("list", list);
		return jm;
	} 
}
