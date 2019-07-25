package com.vote.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vote.bean.ObjectBean;
import com.vote.dao.ObjectBeanDao;
import com.vote.service.ObjectBeanService;

public class WjUpdateAction extends ActionSupport{
	
    private ObjectBeanDao objectBeanDao;
	
	public ObjectBeanDao getObjectBeanDao() {
		return objectBeanDao;
	}

	public void setObjectBeanDao(ObjectBeanDao objectBeanDao) {
		this.objectBeanDao = objectBeanDao;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		//ObjectBeanService obs=new ObjectBeanService();
		ObjectBean bean = new ObjectBean();
		String getid = request.getParameter("oid");
		int oid = Integer.parseInt(getid.trim());
		String title = request.getParameter("title");
		String discribe = request.getParameter("discribe");
		String anonymousFlag = request.getParameter("anonymousFlag");
		String remark = request.getParameter("remark");
		bean.setOid(oid);
		bean.setTitle(title);
		bean.setDiscribe(discribe);
		bean.setAnonymousFlag(anonymousFlag);
		bean.setRemark(remark);
		
		int i = objectBeanDao.updateObjectBean(bean);
			
			List objList=objectBeanDao.ListObjectBean();
		    request.setAttribute("objList", objList);
		    request.setAttribute("size", objList.size());
		    
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String contextPath = request.getContextPath();
			
			return "wjlistsuccess";
		
	}
	
	
	public String toupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		String oid2 = request.getParameter("oid");
		int id = Integer.parseInt(oid2);
		ObjectBean ob = ObjectBeanService.findObjectBeanByID(id);
		
		request.setAttribute("ob", ob);
		return "wjupdatesuccess";
		
	}
	
}
