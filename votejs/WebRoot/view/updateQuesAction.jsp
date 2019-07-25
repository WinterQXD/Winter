<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="check.jsp"%>
<%@page import="java.sql.*"%>
<%@page import="com.vote.service.*"%>
<%@page import="com.vote.util.*"%>
<%@page import="com.vote.dao.*"%>
<%
	String id = request.getParameter("oid");
	System.out.println("id="+id);
	int oid = Integer.parseInt(id);
	String qseq = request.getParameter("seq");
	int seq = Integer.parseInt(qseq);
	QuestionDao qs=(QuestionDao)BeansFactory.get("questionDao");//QuestionService qs = new QuestionService();
	SelecterDao ss=(SelecterDao)BeansFactory.get("selecterDao");//SelecterService ss = new SelecterService();
	int delSel = ss.deleteSelecter(seq, oid);
	String rightvalue = request.getParameter("rightvalue");
	try{
	if (delSel > 0) {
		int deleteQues = qs.deleteQues(seq, oid);
		if (deleteQues > 0) {
			String content = request.getParameter("content");
			
			/* String stscore = request.getParameter("score");
			int score=Integer.parseInt(stscore);  */
			
			//content=new String(content.getBytes("iso8859-1"),"UTF-8");
			int qtype = Integer.parseInt(request.getParameter("qtype"));
			int addQues = qs.addQues(oid, content, qtype, seq,rightvalue);
			System.out.println(addQues);
			
			if (addQues > 0) {
		//插入选项数据
		int listCnt = Integer.parseInt(request
				.getParameter("listCnt"));
		System.out.println("listCnt="
				+ request.getParameter("listCnt"));
		for (int i = 1; i <= listCnt; i++) {
			String name = String.valueOf("txt_" + i);
			String value = request.getParameter(name);
			String stscore = request.getParameter("score_" + i);
			System.out.print("stscore="+i+stscore);
			int score =Integer.parseInt(stscore); 
			//value=new String(value.getBytes("iso8859-1"),"UTF-8");
			ss.addSelecter(oid, seq, value, i,score);
		}
		System.out.println("listCnt=" + listCnt);
			}
		}
	}}catch(Exception e){
		
	}
	response.sendRedirect("quesList.jsp?oid=" + oid);
%>
