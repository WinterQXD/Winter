<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="check.jsp"%>
<%@page import="com.vote.service.*"%>
<%@page import="com.vote.bean.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问卷管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->

  
<!--  内容列表   -->
<form name="fm" action="" method="post">
<input type="hidden" name="doType" value="" />


<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" >&nbsp;成绩列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
    <td width="20%">优秀率:${map["level_4"]}%</td>
	<td width="20%">良好率:${map["level_3"] }%</td>
	<td width="20%">合格率:${map["level_2"]}%</td>
	<td width="20%">不合格率:${map["level_1"] }%</td>
</tr>

</table>

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" >&nbsp;成绩列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
    <td width="5%">序号</td>
	<td width="15%">问卷名称</td>
	<td width="10%">姓名</td>
	<td width="15%">学校名称</td>
	<td width="10%">学校代码</td>
	<td width="10%">年级</td>
	<td width="10%">班级</td><td width="10%">学号</td>
	<td width="10%">分数</td>
	
</tr>



<c:choose>
    <c:when test="${size <= 0}">
       
		<tr align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
		<td height="24" colspan="10" >no data&nbsp;</td>
		</tr>
		
    </c:when>
    <c:when test="${size > 0}">
    <c:forEach var="obj"  items="${replist}"  varStatus="countnum" >        
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
			<td>${countnum.count }</td>
			<td>${obj.title }</td>
			<td>${obj.xm }</td>  
			<td>${obj.xxmc }</td>
			<td>${obj.xxdm }</td>  
			<td>
			    <c:choose>
			        <c:when test="${obj.njdm =='15'}">五年级</c:when>
			        <c:when test="${obj.njdm =='17'}">七年级</c:when>
			        <c:when test="${obj.njdm =='18'}">八年级</c:when>
			        <c:when test="${obj.njdm =='32'}">高二年级</c:when>
			    </c:choose>
			</td> 
			<td>${obj.bjdm }</td> <td width="10%">${obj.xh }</td>
			<td>${obj.replayScore }</td>
			
		</tr>
	</c:forEach>  
    
    </c:when>
    <c:otherwise>
    </c:otherwise>
    
</c:choose>





<tr bgcolor="#FAFAF1">
<td height="28" colspan="10">
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="10" align="center"><!--翻页代码 --></td>
</tr>
</table>
</form>
</body>
</html>