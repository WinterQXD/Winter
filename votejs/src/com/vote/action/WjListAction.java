package com.vote.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.vote.dao.ObjectBeanDao;
import com.vote.service.ObjectBeanService;

public class WjListAction {
	
   private ObjectBeanDao objectBeanDao;
	
	public ObjectBeanDao getObjectBeanDao() {
		return objectBeanDao;
	}

	public void setObjectBeanDao(ObjectBeanDao objectBeanDao) {
		this.objectBeanDao = objectBeanDao;
	}
	
  public String execute(){
	  
	    HttpServletRequest request = ServletActionContext.getRequest();
	  
	    List objList=objectBeanDao.ListObjectBean();
	    request.setAttribute("objList", objList);
	    request.setAttribute("size", objList.size());
	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String contextPath = request.getContextPath();
		
		return "wjlistsuccess";
  }
}
