<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.vote.service.*"%>
<%@page import="com.vote.bean.*"%>
<%@page import="com.vote.util.*"%>
<%@page import="com.vote.dao.*"%>
<%
	ObjectBeanDao obs = (ObjectBeanDao) BeansFactory
			.get("objectBeanDao"); //ObjectBeanService obs=new ObjectBeanService();
	List objlist = obs.ListObjectBeans();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>选择测试</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26">
				<table width="98%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="center"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<!--  内容列表   -->
	<form name="fm" action="" method="post">
		<input type="hidden" name="doType" value="" />
		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top:8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="10">&nbsp;内容列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="10%">序号</td>
				<td width="80%">标题</td>
                <td width="10%">操作</td>
			</tr>

			<%
				for (int i = 0; i < objlist.size(); i++) {
					ObjectBean obj = (ObjectBean) objlist.get(i);
					String title = obj.getTitle();
					int oid = obj.getOid();
			%>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='#FCFDEE';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td><%=i + 1%></td>
				<td align="center"><%=title%>
				</td>
				<td>
				   <a href="./previews.jsp?oid=<%=oid%>">开始答题</a>
				</td>
			</tr>
			<%
				}
			%>


			<tr bgcolor="#FAFAF1">
				<td height="28" colspan="10"></td>
			</tr>
			<tr align="right" bgcolor="#EEF4EA">
				<td height="36" colspan="10" align="center">
					<!--翻页代码 -->
				</td>
			</tr>
		</table>
	</form>

</body>
</html>


