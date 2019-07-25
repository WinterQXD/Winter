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
import com.vote.service.FileUtil;
import com.vote.service.ObjectBeanService;

public class WjNewAction extends ActionSupport{

	
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
		FileUtil fu=new FileUtil();
		ObjectBean ob = new ObjectBean();
		String title = request.getParameter("title");
		String discribe = request.getParameter("discribe");
		String anonymousFlag = request.getParameter("anonymousFlag");
		String remark = request.getParameter("remark");
		ob.setTitle(title);
		ob.setDiscribe(discribe);
		ob.setAnonymousFlag(anonymousFlag);
		ob.setRemark(remark);
		ob.setState(0);
		int id=0;
		try {
			id = objectBeanDao.intsertObjectBean(ob);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String pathinfo=request.getRealPath("");
		String from=pathinfo+"/view/diaocha.txt";
		String to=pathinfo+"/view/diaocha_"+id+".jsp";
		String wj="<% String id=\""+id+"\";"+"%"+">";
		try {
			fu.copyFile(from,null,to,"UTF-8",wj);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(pathinfo);
		if(id >0){
		//	response.sendRedirect("wjList.jsp");
			
			List objList=ObjectBeanService.ListObjectBean();
		    request.setAttribute("objList", objList);
		    request.setAttribute("size", objList.size());
		    
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String contextPath = request.getContextPath();
			
			
			return "wjlistsuccess";
		}else{
	
		//	response.sendRedirect("wjNew.jsp");
			return "wjnewsuccess";
		}
		
		
	}
	
	
}
