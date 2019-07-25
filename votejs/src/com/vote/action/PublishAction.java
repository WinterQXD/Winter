package com.vote.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vote.dao.ObjectBeanDao;
import com.vote.service.MyTool;
import com.vote.service.ObjectBeanService;

public class PublishAction extends ActionSupport {

	  private ObjectBeanDao objectBeanDao;
		
		public ObjectBeanDao getObjectBeanDao() {
			return objectBeanDao;
		}

		public void setObjectBeanDao(ObjectBeanDao objectBeanDao) {
			this.objectBeanDao = objectBeanDao;
		}
	
	public String execute(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String id = request.getParameter("oid");
		String action = request.getParameter("action");
		MyTool tool = new MyTool();
		if (action.equals("publish")) {
			try {
				int result = tool.UpdateCol("wj_object", "state", "1", "oid",
				id);
			} catch (Exception e) {
				 
				e.printStackTrace();
			}
			
		} else if (action.equals("unpublish")) {
			try {
				int result = tool.UpdateCol("wj_object", "state", "0", "oid",
				id);
			} catch (Exception e) {
				 
				e.printStackTrace();
			}
			
		} else if (action.equals("stop")) {
			try {
				int result = tool.UpdateCol("wj_object", "state", "2", "oid",
				id);
			} catch (Exception e) {
				 
				e.printStackTrace();
			}
			
		}
		
		List objList=ObjectBeanService.ListObjectBean();
	    request.setAttribute("objList", objList);
	    request.setAttribute("size", objList.size());
	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String contextPath = request.getContextPath();
	
		
		return "wjlistsuccess";
	}
}
