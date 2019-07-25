<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.vote.service.*"%>
<%@page import="com.vote.bean.*"%>
<%@page import="com.vote.util.*"%>
<%@page import="com.vote.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<%
	//从请求当中获取到ID，根据ID查询出题目和内容
	String id = request.getParameter("oid");
	int oid = Integer.parseInt(id);
	
	ObjectBeanDao objdao=(ObjectBeanDao)BeansFactory.get("objectBeanDao");
	ObjectBean ob = objdao.findPublishedObjectBeanByID(oid);//查找发布后的问卷
	//QuestionService qs = new QuestionService();
	//UploadService us=new UploadService();
	//SelecterService ss = new SelecterService();
	UploadDao us = (UploadDao)BeansFactory.get("uploadDao");
	QuestionDao qs=(QuestionDao)BeansFactory.get("questionDao");//QuestionService qs = new QuestionService();
	SelecterDao ss=(SelecterDao)BeansFactory.get("selecterDao");//SelecterService ss = new SelecterService();
	StudentDao sts=(StudentDao)BeansFactory.get("studentDao");
	List schlist=sts.findSchool();
	pageContext.setAttribute("schlist", schlist);
	List quesList = qs.litQuesByOid(oid);//查找题目
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<title>问卷管理系统</title>
<script type="text/javascript" src="./jquery/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function btnOK_onclick(myForm) {
		alert($("#repalyitem").val())
		myForm.action = "VoteAction.action?oid=" +<%=oid%>;
		if (validCheck(myForm)){
			myForm.submit();
		}	
		return false;
	}

	//校验
	function validCheck(myForm) {
		var i = 0;
		var subCnt = document.getElementById("subCnt").value;
		var subIndex = 0;
		var index = 0;
		var stuId = $("#stuId").val();
		for (i = 0; i < myForm.elements.length && subIndex < subCnt; i++) {
			var title = document.getElementById("title" + subIndex).innerHTML;
			subIndex++;
			var element = myForm.elements[i];
			var eType = element.type;
			//var eName = element.name;
			//var eValue = element.value;

			if (eType == "radio") {
				var v = "";
				var subs = document.getElementsByName("radio_" + subIndex);
				var j = 0;
				for (j = 0; j < subs.length; j++) {
					if (subs[j].checked == true) {
						v = subs[j].value;
					}
					i++;
				}
				if (subs.length > 0) {
					i--;
				}
				if (v == "") {
					alert("“" + title + "” 必须选择一个选项!");
					return false;
				}
			} else if (eType == "select-one") {
				var v = element.value;
				if (v == "-1") {
					alert("“" + title + "” 请选择下拉菜单的值！");
					return false;
				}
			} else if (eType == "checkbox") {
				var v = "";
				var chkName = document.getElementsByName("check_" + subIndex);
				var c = 0;
				for (c = 0; c < chkName.length; c++) {
					if (chkName[c].checked == true) {
						v = chkName[c].value;
					}
					i++;
				}
				if (chkName.length > 0) {
					i--;
				}
				if (v == "") {
					alert("“" + title + "” 复选框至少得选一个选项!");
					return false;
				}
			}
			else if (stuId == "") {
				alert("请进行信息确认");
				return false;
			}
		}

		return true;
	}
	function getitem(i){
		var i=$("#set").val();
		//var i=document.getElementById("set").value;
		//alert(i);
		if(i==1){
            document.getElementById("table2").style.display="";
		}else {
            document.getElementById("table2").style.display="none";
		}
		
	}

	function btnRest_onclick() {
		document.myForm.reset();
	}

	function btnBack_onclick() {
		document.forms[0].action = "./startTest.jsp";
		document.forms[0].submit();
	}
	$(function() {
		$(".stuinfo")
				.on(
						"blur",
						function() {
							var xxdm = $("#xxdm").val();
							var xh = $("#xh").val();
							var xm = $("#xm").val();
							var njdm = $("#njdm").val();
							var bjdm = $("#bjdm").val();
							if (xh != '' || xm != '') {
								$
										.post(
												"./ajaxAction.jsp",
												{
													"xh" : xh,
													"xm" : xm,
													"njdm" : njdm,
													"bjdm" : bjdm,
													"xxdm" : xxdm,
												},
												function(data) {
													if (data.rtn == "false") {
														$("#stuinfo_final")
																.html(
																		"请查看学校，年级，班级，学号和姓名是否输入正确！");
														$("#stuinfo_final")
																.css("display",
																		"block");
													} else {
														$("#idtemp").html(
																data.id);
														$("#stuinfo_final")
																.html(
																		"学校："
																				+ data.xxmc
																				+ "&nbsp;&nbsp;&nbsp;&nbsp;年级："
																				+ data.njdm
																				+ "&nbsp;&nbsp;&nbsp;&nbsp;班级："
																				+ data.bjdm
																				+ "&nbsp;&nbsp;&nbsp;&nbsp;学号："
																				+ data.xjh
																				+ "&nbsp;&nbsp;&nbsp;&nbsp;姓名："
																				+ data.xm
																				+ "&nbsp;&nbsp;&nbsp;&nbsp;<input id='confirm' type='button' value='信息确认' onclick='confirm()' />");
														$("#stuinfo_final")
																.css("display",
																		"block");
													}
												}, "json");
							}
						});
	});
	function confirm() {
		var aaa = $("#confirm").val();
		if (aaa == "信息确认") {
			$("#stuinfo_select").css("display", "none");
			$("#confirm").val("重新选择");
			var id = $("#idtemp").html();
			//alert(id);
			$("#stuId").val(id);
		} else if (aaa == "重新选择") {
			$("#stuinfo_final").css("display", "none");
			$("#stuinfo_select").css("display", "block");
		}
	}
</script>
</head>
<body>
	<table width="880" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td><br />
							<table class="table1">
								<tr>
									<td height="20"><font color="red" >注：填写答题人信息时，可以只选择学校名称，年级名称，输入姓名后，将鼠标移出文本框，系统会自动匹配信息，<br/>
									在文本框下方见到学籍信息后,点击信息确认完成填写。</font> </td>
								</tr>
								<tr>
									<td colspan="2">
										<div align="center">
											<strong><%=ob.getTitle()%></strong>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div id="stuinfo_select" style="display: block">
											学校:<select id="xxdm" style="width: 150px">
												<c:forEach items="${schlist }" var="sch">
													<option value="${sch['xxdm']}">${sch['xxjc']}</option>
												</c:forEach>

											</select> 年级：<select id="njdm">
												<option value="11">一年级</option>
												<option value="12">二年级</option>
												<option value="13">三年级</option>
												<option value="14">四年级</option>
												<option value="15">五年级</option>
												<option value="16">六年级</option>
												<option value="17">七年级</option>
												<option value="18">八年级</option>
												<option value="19">九年级</option>
												<option value="31">高一</option>
												<option value="32">高二</option>
												<option value="33">高三</option>
												<option value="35">高四</option>
											</select>班级：<select id="bjdm">
												<option value="1班">1班</option>
												<option value="2班">2班</option>
												<option value="3班">3班</option>
												<option value="4班">4班</option>
												<option value="5班">5班</option>
												<option value="6班">6班</option>
												<option value="7班">7班</option>
												<option value="8班">8班</option>
												<option value="9班">9班</option>
												<option value="10班">10班</option>
											</select>学号：<input id="xh" class="stuinfo" type="text"
												style="width: 150px" />姓名：<input id="xm" class="stuinfo"
												type="text" style="width: 150px" />
										</div> <span id="idtemp" style="display: none;"></span>
										<div id="stuinfo_final" style="display:none;"></div>
									</td>
								</tr>
								<tr>

								</tr>
								<tr>
									<td>
										<table>
											<tr>
												<td><%=ob.getDiscribe().replaceAll("\\n", "<br/>")%></td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td height="10"><br /></td>
								</tr>
								<tr>
									<td colspan="5">
										<form method="post" action="" name="myForm">

											<table class="table2">
												<%
													int subCnt = 0;
													if (quesList != null && quesList.size() > 0) {
														for (int i = 0; i < quesList.size(); i++) {
															Question ques = (Question) quesList.get(i);
															int qtype = ques.getQtype();
															int seq = ques.getSeq();
															subCnt++;
															List<Pic> piclist = us.findPicList(oid, seq);
												%>
												<tr>
													<td bgcolor="#CDE2FD" colspan=4><span id="title<%=i%>"><%if (qtype == 0){ %>(单选题)<%}else if (qtype == 1) { %>(多选题)<%}else if (qtype==3) {%>(测评统计)<%}%> <%=seq%>.<%=ques.getContent()%></span>
														<br /></td>
												</tr>
												<tr>
													<%
														List selList = ss.listSelecterBySeq(seq, oid);

																if (qtype == 0) {
													%>
													<td>
														<table>
															<%
																for (int j = 0; j < selList.size(); j++) {

																				Selecter sel = (Selecter) selList.get(j);
																				String radioName = "radio_" + sel.getQseq();
																				String src = null;
																				if (piclist.size() > 0) {
																					for (Pic pic : piclist) {
																						if (sel.getSelseq() == pic.getSelseq()) {
																							src = pic.getPath();
																						}
																					}
																				}
															%>
															<tr>
																<td width="25%" valign="top"><input type="radio"
																	id="<%=radioName%>" name="<%=radioName%>"
																	value="<%=sel.getSelseq()%>" />
																	<% 
																		if(sel.getSelseq()==1){
																			%>A.<%
																		}else if(sel.getSelseq()==2){
																			%>B.<%
																		}else if(sel.getSelseq()==3){
																			%>C.<%
																		}else if(sel.getSelseq()==4){
																			%>D.<%
																		}else if(sel.getSelseq()==5){
																			%>E.<%
																		}else if(sel.getSelseq()==6){
																			%>F.<%
																		}else if(sel.getSelseq()==7){
																			%>G.<%
																		}else if(sel.getSelseq()==8){
																			%>H.<%
																		}
																		%> <%=sel.getContent()%>
																	<%
																		if (src != null) {
																	%> <img src="<%=src%>" /> <%
 	}
 %></td>
																<%
																	if (j == 3) {
																%>
															</tr>
															<tr>
																<%
																	}
																				}
																%>
															</tr>
														</table>
													</td>
													<%
														} else if (qtype == 1) {
													%>
													<tr>
														<td>
															<table>
																<%
																	for (int j = 0; j < selList.size(); j++) {
																					Selecter sel = (Selecter) selList.get(j);
																					String cbxName = "check_" + sel.getQseq();
																					String src = null;
																					if (piclist.size() > 0) {
																						for (Pic pic : piclist) {
																							if (sel.getSelseq() == pic.getSelseq()) {
																								src = pic.getPath();
																							}
																						}
																					}
																%>
																<tr>
																	<td width="25%" style="word-break:break-all;"
																		valign="top"><input type="checkbox"
																		name="<%=cbxName%>" value="<%=sel.getSelseq()%>" />
																		 <% 
																		if(sel.getSelseq()==1){
																			%>A.<%
																		}else if(sel.getSelseq()==2){
																			%>B.<%
																		}else if(sel.getSelseq()==3){
																			%>C.<%
																		}else if(sel.getSelseq()==4){
																			%>D.<%
																		}else if(sel.getSelseq()==5){
																			%>E.<%
																		}else if(sel.getSelseq()==6){
																			%>F.<%
																		}else if(sel.getSelseq()==7){
																			%>G.<%
																		}else if(sel.getSelseq()==8){
																			%>H.<%
																		}
																		%><%=sel.getContent()%>
																		<br /> <%
 	if (src != null) {
 %><img src="<%=src%>" /> <%
 	}
 %></td>
																	<%
																		if (j == 3) {
																	%>
																</tr>
																<tr>
																	<%
																		}
																					}
																	%>
																</tr>
															</table>
														</td>
														<%
															} else if (qtype == 2) {
																		String selectname = "select_" + ques.getSeq();
														%>
														<td colspan=4><select name="<%=selectname%>">
																<option value="-1">请选择</option>
																<%
																	for (int j = 0; j < selList.size(); j++) {
																					Selecter sel = (Selecter) selList.get(j);
																%>
																<option value="<%=sel.getSelseq()%>">
																<% 
																		if(sel.getSelseq()==1){
																			%>A.<%
																		}else if(sel.getSelseq()==2){
																			%>B.<%
																		}else if(sel.getSelseq()==3){
																			%>C.<%
																		}else if(sel.getSelseq()==4){
																			%>D.<%
																		}else if(sel.getSelseq()==5){
																			%>E.<%
																		}else if(sel.getSelseq()==6){
																			%>F.<%
																		}else if(sel.getSelseq()==7){
																			%>G.<%
																		}else if(sel.getSelseq()==8){
																			%>H.<%
																		}
																		%>
																	<%=sel.getContent()%>
																</option>
																<%
																	}
																%>
														</select></td>
														<%
															} else if (qtype == 3) {
																%>
																<td>
																<table>
																	<%
																		for (int j = 0; j < selList.size(); j++) {

																						Selecter sel = (Selecter) selList.get(j);
																						String textname = "radio_" + sel.getQseq();
																	%>
																	<tr>
																		<td width="25%" valign="top"><input type="radio"
																			id="<%=textname%>" name="<%=textname%>"
																			value="<%=sel.getSelseq()%>" />
																			<% 
																				if(sel.getSelseq()==1){
																					%>A.<%
																				}else if(sel.getSelseq()==2){
																					%>B.<%
																				}else if(sel.getSelseq()==3){
																					%>C.<%
																				}else if(sel.getSelseq()==4){
																					%>D.<%
																				}else if(sel.getSelseq()==5){
																					%>E.<%
																				}else if(sel.getSelseq()==6){
																					%>F.<%
																				}else if(sel.getSelseq()==7){
																					%>G.<%
																				}else if(sel.getSelseq()==8){
																					%>H.<%
																				}
																				%> <%=sel.getContent()%>
																		</td>
																		<%
																			if (j == 3) {
																		%>
																	</tr>
																	<tr>
																		<%
																			}
																						}
																		%>
																	</tr>
																</table>
															</td>
														<%
															}
																}
															}
														%>

													</tr>
											</table>
											<% if (oid ==1)	{%>
											<table class="table2" id="table1">
											<tr>
											<td bgcolor="#CDE2FD" colspan=4>
											<span>是否愿意参加现场测评，必须是在测评中心认定的区级及以上艺术活动中获得二等奖及以上荣誉的学生，由测评小组统一安排现场测评</span>
											</td>
											</tr>
											<tr>
											<td>
											<select name="replaytest" id="set"	onchange="getitem(this.value)">
											<option value="-1">
											请选择
											</option>
											<option value="1">
											愿意
											</option>
											<option value="2">
											不愿意
											</option>
											</select>
											</td>
											</tr>
											</table>
											<table class="table2" id="table2" style="display: none">
											<tr>
											<td bgcolor="#CDE2FD" colspan=4>
											<span >认定项目，请打开下方所列项目</span>
											</td>
											</tr>
											<tr>
											<td>
											<select name="replayitem" id="replayitem">
											<option value="-1">
											请选择
											</option>
											<option value="十一届“金色北京”少年小提琴、中提琴艺术节比赛；">
											十一届“金色北京”少年小提琴、中提琴艺术节比赛；
											</option>
											<option value="2017—2018年上海市青少年特色乐队；">
											2017—2018年上海市青少年特色乐队；
											</option>
											<option value="2017—2018年上海市中小学生艺术单项比赛金山区比赛（市级、区级）；">
											2017—2018年上海市中小学生艺术单项比赛金山区比赛（市级、区级）；
											</option>
											<option value="2017—2018年上海市原创校园歌曲歌词金山区征集活动（市级、区级）；">
											2017—2018年上海市原创校园歌曲歌词金山区征集活动（市级、区级）；
											</option>
											<option value="2017—2018年青少年艺术节舞蹈项目金山区比赛（市级、区级）；">
											2017—2018年青少年艺术节舞蹈项目金山区比赛（市级、区级）；
											</option>
											<option value="2017—2018年青少年艺术节戏剧比赛金山区比赛（市级、区级）；">
											2017—2018年青少年艺术节戏剧比赛金山区比赛（市级、区级）；
											</option>
											<option value="2017-2018年中小学生合唱、表演唱、小组唱比赛（市级、区级）；">
											2017-2018年中小学生合唱、表演唱、小组唱比赛（市级、区级）；
											</option>
											<option value="2017-2018年中小学生器乐比赛（市级、区级）；">
											2017-2018年中小学生器乐比赛（市级、区级）；
											</option>
											</select>
											</td>
											</tr>
											</table>
											<%
											} %>
											<input type="hidden" name="stuId" id="stuId" />
										</form>
									</td>
								</tr>
								<tr>
									<td height="5"></td>
								</tr>
								<tr>
									<td height="5"></td>
								</tr>
								<tr>
									<td class="m_right"><br /> <input type="button"
										name="btnOK" value="   提  交   "
										onclick="btnOK_onclick(myForm);" /> &nbsp; <input
										type="button" name="btnRedo" value="   重  填   "
										onclick="btnRest_onclick();" /> &nbsp; <input type="button"
										name="btnRedo" value="   返 回   " onclick="btnBack_onclick();" />
										<br /></td>
								</tr>
							</table> <input type="hidden" name="subCnt" id="subCnt"
							value="<%=subCnt%>" /></td>
					</tr>
					<tr>
						<td height="20"></td>
					</tr>
				</table> <br />
			</td>
		</tr>
	</table>
</body>
</html>
