<%-- <%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="check.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.vote.service.*"%>
<%@page import="com.vote.bean.*"%>
<%
			String id = request.getParameter("oid");
			String qseq = request.getParameter("seq");
			int oid = Integer.parseInt(id);
			int seq = Integer.parseInt(qseq);
			MyTool tool = new MyTool();
			QuestionService qs=new QuestionService();
			UploadService us=new UploadService();
			SelecterService ss=new SelecterService();
			Question ques=qs.getQuesBySeq(seq,oid);
			ObjectBean ob = ObjectBeanService.findObjectBeanByID(oid);
			List selList=ss.listSelecterBySeq(seq,oid);
			int state = ob.getState();
			if (state == 1 || state == 2) {
			    //清空回复表中的数据
			    ReplayService.delReplay(oid);
			    //修改问卷状态为草稿
			    tool.UpdateCol("wj_object", "state", "0", "oid", id);
			}
%>
<html>
	<head>
		<title>问卷管理系统</title>
		<link type="text/css" rel="stylesheet" href="/vote/view/css/main.css" />
		<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
		<script type="text/javascript">
		var qvalue=0;
	function getSelect(){
		var qvalue = document.myForm.qtype.value;
		var addbutton=document.getElementById("add");
		 if(qvalue!=3){
		 	//alert("你选的是"+qvalue);
			//window.location.reload();
			addbutton.removeAttribute("disabled");
		}else if(qvalue==3)
		{

			//alert("你选的是文本类");
			addbutton.setAttribute("disabled","false");
		}
	 }
function addTextBox(form, afterElement) {
	var myTable = document.getElementById("myTable");
	var rowCnt = myTable.rows.length;
	var textNumber = (rowCnt-3);
	var sEle;
textNumber++;
var label = document.createElement("label");
	label.setAttribute("class", "m_left");
label.appendChild(document.createTextNode("选项"+" "+textNumber+": "));
	var nextRow = myTable.insertRow(rowCnt - 1);
	var cellTitle = nextRow.insertCell(0);
	var cellText = nextRow.insertCell(1);
	cellTitle.className = "m_left";
	cellTitle.setAttribute("valign", "top");
	cellTitle.appendChild(label);
	var txtName = "txt_" + textNumber;
	var txtId = "txt_" + textNumber;
	//alert(txtName);
	cellText.innerHTML = "<input type='text' name='" + txtName + "' id='" + txtId + "' value='"+"' style=\"width:260px;\"/><input type='button' value='添加附件' onclick='addadj("+textNumber+")'> ";
	var label1 = document.createElement("label1");
	label1.setAttribute("class", "m_left");
	label1.appendChild(document.createTextNode("分值"+" "+textNumber+"："));
	var myTable = document.getElementById("myTable");
	var rowCnt = myTable.rows.length;
	var nextRow = myTable.insertRow(rowCnt - 1);
	var cellTitle = nextRow.insertCell(0);
	var cellText = nextRow.insertCell(1);
	cellTitle.className = "m_left";
	cellTitle.setAttribute("valign", "top");
	cellTitle.appendChild(label1);
	var scoreName = "score_" + textNumber;
	var scoreId = "score_" + textNumber;
	//alert(scoreName);
	cellText.innerHTML = "<input type='text' name='" + scoreName + "' id='" + scoreId + "' value='"+"' style=\"width:100px;\"/> ";
}

function removeTextBox(form) {
	var textNumber = (rowCnt-3);
	var myTable = document.getElementById("myTable");
	var rowCnt = myTable.rows.length;
	myTable.deleteRow(rowCnt-2);
	textNumber--;
	if (textNumber < 4) {
		alert("至少得有一个选项!");
}
}

	//提交
	function submit(){
 		if(document.myForm.content.value.length==0)	{
 			alert("输入域 题目 不能为空");
 			document.myForm.content.focus();
 			return false;
 		}else{
 				var listCnt = document.getElementById("listCnt");
 				var myTable = document.getElementById("myTable");
 				var textNumber = myTable.rows.length;
 				listCnt.value = textNumber-3;
 		  	 	document.myForm.action="./updateQuesAction.jsp";
 		  	    document.myForm.submit();
 				return true;
		}
	}
	
	//返回
	function back() {
		window.location.href="./quesList.jsp?oid=<%=oid%>";
	}
	function addadj(selseq){
		var oid= window.document.getElementById("oid").value;
		var qseq= window.document.getElementById("seq").value;
		var arry=new Array(oid,qseq,selseq);
		var reValue=window.showModalDialog('./upload.jsp',arry);
		if(reValue){
			location.replace(location.href);
		}
	}
</script>
	</head>
	<body topmargin="2">
		<table cellspacing="0" cellpadding="0" width="500" align="center" class="tab">
			<tbody>
				<tr>
					<td height="30"></td>
				</tr>
				<tr>
					<td class="dl_bt" align="center">
						修改题目
						<br>
						<br>
					</td>
				</tr>
				<tr>
					<td align="left">
						<button type="button" class="btn" class="btn" onclick="submit();"> 保     存 </button>
						<button type="button" class="btn" class="btn" onclick="back();"> 返     回 </button>
					</td>
				</tr>
			</tbody>
		</table>
		<form action="" name="myForm" method="post" >
			<table width="800" border="0" align="center" cellpadding="2" cellspacing="1" class="tab" id="myTable">
				<tr>
					<td width="60px">
						题目：
					</td>
					<td >
						<input type="text" name="content"
							value="<%=ques.getContent()%>" style="width:320px;"/><!-- <input type="button" value="添加附件" onclick="addadj()"> -->
					</td>
				</tr>
				<tr>
					<td valign="top">
						类型：
					</td>
					<%	int qtype=ques.getQtype(); %>
					<td>
						<select name="qtype" onchange=getSelect() style="width:120px;">
							<option value="0" <% if(qtype==0)out.println("selected");%>>
								单选题
							</option>
							<option value="1"<% if(qtype==1)out.println("selected");%>>
								多选题
							</option>
							<option value="2"<% if(qtype==2)out.println("selected");%>>
								是非题
							</option>
						</select>
						
					分值：<input type="text" name="score"  style="width:100px;" value="<%=ques.getScore()%>" />	
					正确选项 <input type="text" name="rightvalue"  style="width:100px;" value="<%=ques.getRightvalue()%>"/>
					</td>	
				</tr>
					<%
					if(selList!=null&&selList.size()>0){
					for(int i=1;i<=selList.size();i++){
					Selecter sel=(Selecter)selList.get(i-1);
					String txtname = "txt_"+(i);
					String scorename = "score_"+(i);
					//System.out.print(scorename);
					%>
				<tr>
					<td valign="top">
						<label>
							选项
							<%= i%>:
						</label>
					</td>
					<td>
						<input type="text" name="<%= txtname %>" id="<%= txtname %>"
							value="<%=sel.getContent()%>" style="width:260px;"/><input type="button" value="添加附件" onclick="addadj(<%=i %>)">
							<br />
					<%
					Pic pic=us.findPic(oid,sel.getQseq(),sel.getSelseq());
					if(pic!=null){
					%>
					<img  alt="" src="<%=pic.getPath()%>">
					<%
					}
					%>
					</td>
					<br/>
					<td valign="top">
						<label1>
							分值
							<%= i%>：
						</label1>
					</td>
					<td>
						<input type="text" name="<%= scorename %>" id="<%= scorename %>" value="<%=sel.getScore()%>" style="width:100px;" />
					</td>
				</tr>
					<%
					}}
					%>
				<tr>
					<td >
					<input type="hidden" name="listCnt" id="listCnt" value="" />
					<input type="hidden" name="oid" id="oid" value="<%=oid %>" />
					<input type="hidden" name="seq" id="seq" value="<%=seq %>" />
					</td>
					<td id="td1">
						<input type="button" value="添加选项" name="add"
							onclick="addTextBox(this.form,this.parentNode)" class="btn"/>
						<input type="button" value="删除选项"
							onclick="removeTextBox(this.form)" class="btn"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html> --%>

<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="check.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.vote.service.*"%>
<%@page import="com.vote.bean.*"%>
<%
			String id = request.getParameter("oid");
			String qseq = request.getParameter("seq");
			int oid = Integer.parseInt(id);
			int seq = Integer.parseInt(qseq);
			MyTool tool = new MyTool();
			QuestionService qs=new QuestionService();
			UploadService us=new UploadService();
			SelecterService ss=new SelecterService();
			Question ques=qs.getQuesBySeq(seq,oid);
			ObjectBean ob = ObjectBeanService.findObjectBeanByID(oid);
			List selList=ss.listSelecterBySeq(seq,oid);
			int state = ob.getState();
			if (state == 1 || state == 2) {
			    //清空回复表中的数据
			    ReplayService.delReplay(oid);
			    //修改问卷状态为草稿
			    tool.UpdateCol("wj_object", "state", "0", "oid", id);
			}
%>
<html>
	<head>
		<title>问卷管理系统</title>
		<link type="text/css" rel="stylesheet" href="/vote/view/css/main.css" />
		<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
		<script type="text/javascript">
		
		var qvalue=0;
	function getSelect(){
		var qvalue = document.myForm.qtype.value;
		var addbutton=document.getElementById("add");
		 if(qvalue!=3){
		 	//alert("你选的是"+qvalue);
			//window.location.reload();
			addbutton.removeAttribute("disabled");
		}else if(qvalue==3)
		{

			//alert("你选的是文本类");
			addbutton.setAttribute("disabled","false");
		}
	 }
	/* function getText(){
		var myTable = document.getElementById("myTable");
		var rowCnt = myTable.rows.length;
		var textNumber = (rowCnt-3);
		var sEle;
		return textNumber;
	} */
function addTextBox(form, afterElement) {
	/* var textNumber =getText();
	textNumber++;
	alert(textNumber);
var label = document.createElement("label");
	label.setAttribute("class", "m_left");
	label.appendChild(document.createTextNode("选项"+" "+textNumber+": "));
	var myTable = document.getElementById("myTable");
	var rowCnt = myTable.rows.length;
	var nextRow = myTable.insertRow(rowCnt - 1);
	var cellTitle = nextRow.insertCell(0);
	var cellText = nextRow.insertCell(1);
	cellTitle.className = "m_left";
	cellTitle.setAttribute("valign", "top");
	cellTitle.appendChild(label);
	var txtName = "txt_" + textNumber;
	var txtId = "txt_" + textNumber;
	//alert(txtName);
	cellText.innerHTML = "<input type='text' name='" + txtName + "' id='" + txtId + "' value='"+"' style=\"width:260px;\"/><input type='button' value='添加附件' onclick='addadj("+textNumber+")'> ";
	
	var label1 = document.createElement("label1");
	label1.setAttribute("class", "m_left");
	label1.appendChild(document.createTextNode("分值"+" "+textNumber+"："));
	var myTable = document.getElementById("myTable");
	var rowCnt = myTable.rows.length;
	var nextRow = myTable.insertRow(rowCnt - 1);
	var cellTitle = nextRow.insertCell(0);
	var cellText = nextRow.insertCell(1);
	cellTitle.className = "m_left";
	cellTitle.setAttribute("valign", "top");
	cellTitle.appendChild(label1);
	var scoreName = "score_" + textNumber;
	var scoreId = "score_" + textNumber;
	//alert(scoreName);
	cellText.innerHTML = "<input type='text' name='" + scoreName + "' id='" + scoreId + "' value='"+"' style=\"width:100px;\"/> "; */
	var table = document.getElementById("myTable");
	var rowIndex = table.rows.length;
	var textNumber = (rowIndex-3);
	textNumber++;
	var objRow=table.insertRow(rowIndex-1); //每次在最后一行之前插入 传入行号 参数是最后一行的角标
	objRow.className="list";
	var objCell; 
 	objCell=objRow.insertCell(0); // 插入之后是第几列 在0之前插入  特殊的位置 用插入实现追加的效果 下一个位置上插入  实际上是追加
 	objCell.valign="valign";
 	objCell.align="top";
 	objCell.className="m_left";
 	var indexs = rowIndex - 1; 
 	var txtName = "txt_" + textNumber;
	var txtId = "txt_" + textNumber;
	var scoreName = "score_" + textNumber;
	var scoreId = "score_" + textNumber;
 	/* objCell=objRow.insertCell(1); 
	objCell.innerHTML = "<input type='text' name='fclauses' value='"+indexs+"' class='line' style='width:100%'/>"; */
	objCell=objRow.insertCell(0);
	//objCell.innerHTML = "<input type='text' name='" + scoreName + "' id='" + scoreId + "' value='"+"' style=\"width:100px;\"/> ";
	objCell.innerText="选项"+" "+textNumber+"：";
	objCell=objRow.insertCell(1); 
	objCell.innerHTML = "<input type='text' name='" + txtName + "' id='" + txtId + "' value='"+"' style=\"width:260px;\"/><input type='button' value='添加附件' onclick='addadj("+textNumber+")'> ";
	objCell=objRow.insertCell(2);
	objCell.innerText="分值"+" "+textNumber+"：";
	objCell=objRow.insertCell(3);
	objCell.innerHTML = "<input type='text' name='" + scoreName + "' id='" + scoreId + "' value='"+"' style=\"width:100px;\"/> ";
   /*  $("#selffeedback tr td.seqnumber").each(function(i){
    	var n = i+1;
		$(this).text(n+""); 
		
	});*/
	
}

function removeTextBox(form) {
	var textNumber = (rowCnt-3);
	var myTable = document.getElementById("myTable");
	var rowCnt = myTable.rows.length;
	myTable.deleteRow(rowCnt-2);
	textNumber--;
	if (textNumber < 4) {
		alert("至少得有一个选项!");
}
}

	//提交
	function submit(){
 		if(document.myForm.content.value.length==0)	{
 			alert("输入域 题目 不能为空");
 			document.myForm.content.focus();
 			return false;
 		}else{
 				var listCnt = document.getElementById("listCnt");
 				var myTable = document.getElementById("myTable");
 				var textNumber = myTable.rows.length;
 				listCnt.value = textNumber-3;
 		  	 	document.myForm.action="./updateQuesAction.jsp";
 		  	    document.myForm.submit();
 				return true;
		}
	}
	
	//返回
	function back() {
		window.location.href="./quesList.jsp?oid=<%=oid%>";
	}
	function addadj(selseq){
		var oid= window.document.getElementById("oid").value;
		var qseq= window.document.getElementById("seq").value;
		var arry=new Array(oid,qseq,selseq);
		var reValue=window.showModalDialog('./upload.jsp',arry);
		if(reValue){
			location.replace(location.href);
		}
	}
</script>
	</head>
	<body topmargin="2">
		<table cellspacing="0" cellpadding="0" width="500" align="center" class="tab">
			<tbody>
				<tr>
					<td height="30"></td>
				</tr>
				<tr>
					<td class="dl_bt" align="center">
						修改题目
						<br>
						<br>
					</td>
				</tr>
				<tr>
					<td align="left">
						<button type="button" class="btn" class="btn" onclick="submit();"> 保     存 </button>
						<button type="button" class="btn" class="btn" onclick="back();"> 返     回 </button>
					</td>
				</tr>
			</tbody>
		</table>
		<form action="" name="myForm" method="post" >
			<table width="800" border="0" align="center" cellpadding="2" cellspacing="1" class="tab" id="myTable">
				<tr>
					<td width="60px">
						题目：
					</td>
					<td >
						<input type="text" name="content"
							value="<%=ques.getContent()%>" style="width:320px;"/><!-- <input type="button" value="添加附件" onclick="addadj()"> -->
					</td>
				</tr>
				<tr>
					<td valign="top">
						类型：
					</td>
					<%	int qtype=ques.getQtype(); %>
					<td>
						<select name="qtype" onchange=getSelect() style="width:120px;">
							<option value="0" <% if(qtype==0)out.println("selected");%>>
								单选题
							</option>
							<option value="1"<% if(qtype==1)out.println("selected");%>>
								多选题
							</option>
							<option value="2"<% if(qtype==2)out.println("selected");%>>
								测评统计项目列表
							</option>
							<option value="3"<% if(qtype==3)out.println("selected");%>>
								测评统计
							</option>
						</select>
						
					<%-- 分值：<input type="text" name="score"  style="width:100px;" value="<%=ques.getScore()%>" />	
					正确选项 <input type="text" name="rightvalue"  style="width:100px;" value="<%=ques.getRightvalue()%>"/> --%>
					</td>	
				</tr>
					<%
					if(selList!=null&&selList.size()>0){
					for(int i=1;i<=selList.size();i++){
					Selecter sel=(Selecter)selList.get(i-1);
					String txtname = "txt_"+(i);
					String scorename = "score_"+(i);
					//System.out.print(scorename);
					%>
				<tr>
					<td valign="top">
						<label>
							选项
							<%= i%>:
						</label>
					</td>
					<td>
						<input type="text" name="<%= txtname %>" id="<%= txtname %>"
							value="<%=sel.getContent()%>" style="width:260px;"/><input type="button" value="添加附件" onclick="addadj(<%=i %>)">
							<br />
					<%
					Pic pic=us.findPic(oid,sel.getQseq(),sel.getSelseq());
					if(pic!=null){
					%>
					<img  alt="" src="<%=pic.getPath()%>">
					<%
					}
					%>
					</td>
					<td valign="top">
						<label1>
							分值
							<%= i%>：
						</label1>
					</td>
					<td>
						<input type="text" name="<%= scorename %>" id="<%= scorename %>" value="<%=sel.getScore()%>" style="width:100px;" />
					</td>
				</tr>
					<%
					}}
					%>
				<tr>
					<td >
					<input type="hidden" name="listCnt" id="listCnt" value="" />
					<input type="hidden" name="oid" id="oid" value="<%=oid %>" />
					<input type="hidden" name="seq" id="seq" value="<%=seq %>" />
					</td>
					<td id="td1">
						<input type="button" value="添加选项" name="add"
							onclick="addTextBox(this.form,this.parentNode)" class="btn"/>
						<input type="button" value="删除选项"
							onclick="removeTextBox(this.form)" class="btn"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html> 