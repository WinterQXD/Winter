package com.vote.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vote.bean.AdminBean;
import com.vote.service.AdminService;


public class LoginAction extends ActionSupport{

	
	
 public String execute(){	
	 
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	HttpServletResponse response = ServletActionContext.getResponse();
	 
	 String username = request.getParameter("username");
	 String password = request.getParameter("password");
	 AdminService as=new AdminService();
	 AdminBean admin=new AdminBean();//as.longin(username,password);
	 admin.setPassword("admin");
	 admin.setUsername("admin");
	 if(  null!=username && username.equals(admin.getUsername())) {
	   String chk="true";
	   session.setAttribute("Enter",chk);
	   session.setAttribute("userName",username);
	   return "loginsuccess";
			
	 }
	 return "loginerror";
 } 	
}
