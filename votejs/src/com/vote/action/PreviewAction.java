package com.vote.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vote.bean.ObjectBean;
import com.vote.service.ObjectBeanService;
import com.vote.service.QuestionService;
import com.vote.service.SelecterService;
import com.vote.service.UploadService;

public class PreviewAction extends ActionSupport {

	public String execute(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		//从请求当中获取到ID，根据ID查询出题目和内容
		String id = request.getParameter("oid");
		int oid = Integer.parseInt(id);
		ObjectBean ob = ObjectBeanService.findPublishedObjectBeanByID(oid);//查找发布后的问卷
		
		QuestionService qs = new QuestionService();
		UploadService us=new UploadService();
		SelecterService ss = new SelecterService();
		List quesList = qs.litQuesByOid(oid);//查找题目
		
		return "previewsuccess";
	}
}
