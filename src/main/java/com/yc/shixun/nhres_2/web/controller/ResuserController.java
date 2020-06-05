package com.yc.shixun.nhres_2.web.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yc.shixun.nhres_2.bean.Resfood;
import com.yc.shixun.nhres_2.bean.Resuser;
import com.yc.shixun.nhres_2.service.ResfoodBiz;
import com.yc.shixun.nhres_2.service.ResuserBiz;
import com.yc.shixun.nhres_2.utils.Encrypt;
import com.yc.shixun.nhres_2.web.entity.JsonModel;

@RestController
public class ResuserController {
	@Autowired
	private ResuserBiz resuserBiz;
	
	@RequestMapping( value="checkLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonModel checkLogin(HttpSession session, JsonModel jm) {
		//退出的核心是将session中保存的loginuser删除
		if(   session.getAttribute("loginuser")!=null ) {
			jm.setCode(1);
			Resuser u=(Resuser)session.getAttribute("loginuser");
			jm.setObj(u.getUsername());
		}else {
			jm.setCode(0);
		}
		return jm;
	}
	@RequestMapping( value="logout", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonModel logout(HttpSession session, JsonModel jm) {
		//退出的核心是将session中保存的loginuser删除
		session.removeAttribute("loginuser");
		jm.setCode(1);
		return jm;
	}
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonModel login(HttpSession session, JsonModel jm, String username, String pwd, String valcode) {
		if(  valcode==null||"".equals(valcode)) {
			jm.setCode(0);
			jm.setMsg("验证码不能为空....");
			return jm;
		}
		//从session中取出标准验证码
		String code=(String)session.getAttribute("validateCode");
		if(   !code.equals(valcode) ) {
			jm.setCode(0);
			jm.setMsg("验证码错误....");
			return jm;
		}
		Resuser u=new Resuser();
		u.setUsername(username);
		u.setPwd(pwd);
		try {
			Resuser user=resuserBiz.login(u);
			if(   user!=null) {
				session.setAttribute("loginuser", u);   //保存登录的状态
				jm.setCode( 1);
			}
		}catch( Exception e) {
			jm.setCode(0);
			jm.setMsg("用户名或密码错误,"+e.getMessage());
		}
		return jm;
	}
	
}
