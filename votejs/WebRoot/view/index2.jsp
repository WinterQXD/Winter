<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>内容管理系统</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" >&nbsp;成绩列表&nbsp;</td>
</tr>

<tr align="center" bgcolor="#FAFAF1" height="22">
  
		<td >学校名称</td>
	    <td >学籍数</td>
		<td >测评人数</td>
		<td >优秀率</td>
		<td >良好率</td>
		<td >及格率</td>
		<td >不及格率</td>
</tr>


<tr align="center" bgcolor="#FAFAF1" height="22">
  
  <c:forEach items="${scorelist }" var="obj">
		<td >${obj.xxmc}</td>
	    <td >${obj.xjrs}</td>
		<td >${obj.cprs}</td>
		<td >${obj.yxl}</td>
		<td >${obj.lhl}</td>
		<td >${obj.jgl}</td>
		<td >${obj.bjgl}</td>
   </c:forEach>
</tr>

</table>

</html>


