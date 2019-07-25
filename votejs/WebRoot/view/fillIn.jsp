<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.vote.service.*"%>
<%@page import="com.vote.bean.*"%>
<%@page import="com.sjedu.pojo.TRegist"%>
<%@page import="com.sjedu.util.BeansFactory"%>
<%@page import="com.sjedu.bean.userinfo.LoginSessionBean"%>
<%@page import="com.sjedu.util.parameter.SessionDefine"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	//从session中获得用户
	LoginSessionBean loginSessionBean=(LoginSessionBean)request.getSession().getAttribute(SessionDefine.LOGINSESSION);
	ObjectBeanService objectBeanService = (ObjectBeanService) BeansFactory.get("objectBeanService");
	ReplayService replayService = (ReplayService) BeansFactory.get("replayService");
	ObjectBean bean = new ObjectBean();
	bean.setType("3");
	bean.setWjfw("2");
	List<ObjectBean> objList=objectBeanService.ListPublishObjectBean(bean);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String replayCode = loginSessionBean.getPkuser();
	String type = "3";
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>填写教师问卷</title>
<link href="<%=request.getContextPath()%>/css/right.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/other2.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/scripts/jquery-1.3.2.min.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/scripts/right_list.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/scripts/util/util.js"></script>

<script type="text/javascript">
//预览
function preview(id){
	window.open("../view/wenjuan.jsp?type=<%=type%>&oid="+id);
}
function toview(id,teacherid){ 
	window.open("../view/view.jsp?type=<%=type%>&teacherid="+teacherid+"&oid="+id);
}
</script>
</head>

<body id="layout-main">
<form action="wjResult!searchWJResult.action"  id="formObject" name="formObject" method="post">
<div class="content" >
<input type="hidden" value="1" name="wjfw"/>
	<input type="hidden" value="${oid}" name="oid"/>
	<!--这是导航-->
	<div class="guide"><img src="<%=request.getContextPath()%>/images/wz.gif" />填写教师问卷</div>
	<!--这是查询-->
	
	<!--这是表格头-->
	<div class="list_top1">
	<div class="list_top2">
	<div class="list_top3 list_tab">
	<ul class="tab">
		<li class="show" ><a href="#"><span>填写教师问卷</span></a></li>
	</ul>
	</div>
	</div>
	</div>
	<!--这是表格内容-->
	<div class="list_cen1">
	<div class="list_cen2">
	<div class="list_cen3"><!--表格1-->
	  <table class="list_table ">
           <tr  class="list_tbj">
           <td width="8%">
				序号
			</td>
			<td width="25%">
				标题
			</td>
			<td width="10%">
				状态
			</td>
			<td width="15%">
				发布时间
			</td>
			<td width="10%">
				是否已评
			</td>
			<td width="10%">分数</td>
			<td width="15%">
				操作
			</td>
           </tr>
           <%
			if (objList.size() == 0) {
			%>
			<tr>
				<td>
					暂无评测&nbsp;
				</td>
			</tr>
			<%
				}
			%>
			<%
				if (objList.size() > 0) {
					for (int i = 0; i < objList.size(); i++) {
						ObjectBean ob = (ObjectBean) objList.get(i);
						String oid = ob.getOid();
						Long state = ob.getState();
						String stateAlias = "";
						if (state == 0)
							stateAlias = "草稿";
						if (state == 1)
							stateAlias = "评测中";
						if (state == 2)
							stateAlias = "已终止";
						//获得该问卷评分
						Replay replay = new Replay();
						replay.setOId(ob.getOid());
						replay.setReplayCode(replayCode);
						Long score=replayService.getReplayScoreByOid(replay);
			%>
			<tr>
				<td><%=(i + 1)%></td>
				<td align="left">
					<%=ob.getTitle()%>
				</td>
				<td><%=stateAlias%></td>
				<td><%=sdf.format(ob.getCreateTime())%></td>
				<%if(replayService.sfYp(oid,null,replayCode))
							{%>
							<td>
							已评	 
							</td>
							<td>
					<%if(score!=0){%><%=score%>分<%}%>
				</td>
							<td>
				<a href="#" onclick='toview("<%=oid %>","")'>
				已评
				</a>	 
				</td>
							<%}
							else{%>
				<td>
							未评
				</td>
				<td>
					<%if(score!=0){%><%=score%>分<%}%>
				</td>
							<td>
							<%if (state == 1){%>
					<a href="#" onclick='preview("<%=oid %>")'>参与评测</a>
				<%}if(state==2){ %>
				<a href="#" onclick='toview("<%=oid %>","")'>
				已终止
				</a>
				<%} %>
				</td>
							<%}%>
				
			</tr>
			<%
				}
				}
			%>
       
      </table>
</div>
</div>
</div>
<!--这是表格底-->
	<div class="list_bottom1"><div class="list_bottom2"><div class="list_bottom3"></div></div></div>
<div class="bottom"></div>
</div>

</form>
</body>
</html>

