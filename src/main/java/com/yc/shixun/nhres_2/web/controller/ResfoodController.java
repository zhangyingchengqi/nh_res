package com.yc.shixun.nhres_2.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.shixun.nhres_2.service.ResfoodBiz;
import com.yc.shixun.nhres_2.web.entity.JsonModel;

@RestController    // 1. 这是控制层   2. Rest规范(   支持 GET/POST/DELETE/PUT,   回送数据格式  json)
public class ResfoodController {

	@Autowired
	private ResfoodBiz resfoodBiz;
	
	@RequestMapping( "/findFood")
	public JsonModel findFood(  JsonModel jm   ) {   //  spring   IOC/DI
		jm.setCode(1);
		jm.setObj("hello world 222222");
		return jm;
	} 
}
