<%@page import="com.vote.bean.TblStudentEntity"%>
<%@page import="com.vote.service.StudentService"%>
<%@page import="com.vote.bean.AdminBean"%>
<%@page import="com.vote.service.AdminService"%>
<%@page import="com.vote.util.*"%>
<%@page import="com.vote.dao.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String xh = request.getParameter("xh");
	String xm = request.getParameter("xm");
	String bjdm=request.getParameter("bjdm");
	String njdm=request.getParameter("njdm");
	String xxdm = request.getParameter("xxdm");
	StudentDao as = (StudentDao) BeansFactory.get("studentDao");
	//StudentService as= new StudentService(); 
	TblStudentEntity ab=as.findStu(xh,xm,bjdm,njdm,xxdm);
	
	if(ab!=null){
		String njmc=as.findGrade(ab.getNjdm());
	String str="{\"id\":\""+ab.getId()+"\","
				+"\"xjh\":\""+ab.getXjh()+"\","
				+"\"xm\": \""+ab.getXm()+"\","
				+"\"xxmc\":\""+ab.getXxmc()+"\","
				+"\"njdm\":\""+njmc+"\","
				+"\"bjdm\":\""+ab.getBjdm() +"\","
				+"\"rtn\":\"true\"}";
	response.getWriter().print(str);
	}else{
		response.getWriter().print("{\"rtn\":\"false\"}");
	}
	
%>
