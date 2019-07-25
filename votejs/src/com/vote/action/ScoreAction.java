package com.vote.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vote.bean.AdminBean;
import com.vote.bean.Wjbfb;
import com.vote.service.AdminService;
import com.vote.service.ReplayService;


public class ScoreAction extends ActionSupport{

	
	
 public String execute(){	
	 
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	
	ReplayService service=new  ReplayService();

	String xxdm="310117";
	List<Wjbfb> alt=new ArrayList();
	if(null!=request.getParameter("xxdm") && !"".equals(request.getParameter("xxdm"))){
		alt=service.getScoreByXXdm(request.getParameter("xxdm"));
	}else{
		alt=service.getScoreByXXdm(xxdm);
	}
	
	
	
	 AdminBean admin=new AdminBean();
	 admin.setUsername("admin");
	 
	   String chk="true";
	   session.setAttribute("user",admin);
	   session.setAttribute("Enter",chk);
	   session.setAttribute("userName","admin");
	 
	   session.setAttribute("scorelist", alt);
	   
	 return "success";
 } 	
}
