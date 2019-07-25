<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="check.jsp"%>
<%@page import="com.vote.service.*"%>
<%@page import="com.vote.util.*"%>
<%@page import="com.vote.dao.*"%>
<%
	String getid = request.getParameter("oid");
	int oid = Integer.parseInt(getid.trim());
	ObjectBeanDao objdao=(ObjectBeanDao)BeansFactory.get("objectBeanDao");
	boolean flag = objdao.delObjectBean(oid);
    response.sendRedirect("wjList.jsp");
%>