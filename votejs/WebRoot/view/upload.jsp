<%@ page language="java" 
 pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD><TITLE>粘贴附件</TITLE>

<LINK href="/css/css.css" rel=stylesheet>

<SCRIPT language=javascript src="/script/wm.js"></SCRIPT>
<script language="javascript" src="/script/common.js"></script>
<script>
function closeWin(vars)
{	
	var mainobj2 = opener.document.getElementById("getAttIds");
	mainobj2.value = vars;
	window.close();
}
function getValue(fm){
	var arry=window.dialogArguments;
    fm.action = fm.action + "?oid=" + arry[0]+"&qseq="+arry[1]+"&selseq="+arry[2];
    window.returnValue =true;
}
</script>

<BODY bgColor=#ffffff leftMargin=0 topMargin=0 MARGINHEIGHT="0" MARGINWIDTH="0" >
<FORM name=form1 method="post" action="upload2.action" onsubmit="return getValue(this)" enctype="multipart/form-data">
  <table cellspacing=1 cellpadding=2 width=50% height="50%" border="0">
    <tbody> 
    <tr bgcolor=#d8d8d8> 
      <td  colspan=4 height="32" bgcolor="#446DAB"><font color="#FFFFFF">第一步：选择需要发送的文件； 
        <br>
        下面的文件框允许同时上载1个附件，您可以点击&quot;浏览(Browse)&quot;选择需要发送的文件，也可以直接填入文件路径。<br>
        注意：文件大小总和不要超过 10 MB </font> 
    <tr bgColor=#eeeeee> 
      <td height="16">文件选择<b>&nbsp; 
        <input name="fileUpload" type="file" size="50">
        </b></td>
    </tr>
    <tr bgcolor=#d8d8d8> 
      <td  colspan=4 height="31" bgcolor="#446DAB"><font color="#FFFFFF">第二步：上传需要发送的文件； 
        <br>
        确定所选择文件无误后, 点击&quot;上传文件&quot;按钮执行上传操作。</font> <br>
        <br>
        <input type="submit" name="Submit" value="上传">
    <tr > 
      <td height="16"><b>&nbsp; </b></td>
    </tr>
  <%--   <tr bgcolor=#dddddd> 
      <td height="18" bgcolor="#446DAB"><font color="#FFFFFF">第三步：检查已上传文件； <br>
        如果您需要上传更多的文件，请重复前两步操作。如果错误的上传了文件，请在列表中删除。 </font></td>
    </tr>
    <tr > 
      <td height="16" align="center"> 
        <table id="attList"   width="100%" border="0" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC">
          <tr bgcolor="#CCCCCC"> 
            <td align="center">文件名</td>
            <td align="center">大小(byte)</td>
            <td align="center">操作</td>
          </tr>
          <s:set name="totalSize" value="0"/>
          <s:iterator value="#request.filelist" > 
         <s:set name="totalSize" value="#totalSize+filesize"/>
          <tr bgColor=#eeeeee>
            <td align="center"><a href="uploadfile!downFile.action?filepath=${filepath}&fileName=${filename}.${fileext }&fileoldName=${fileoldname}">${fileoldname }</a></td>
            <td align="center">${filesize }</td>
            <td align="center"><a href="uploadfile!delFile.action?fileId=${pkFileidH }&refId=${refId }&attIds=${attIds }&filepath=${filepath}&fileName=${filename}.${fileext }">删除</a></td> 
          </tr>
          </s:iterator>
          <tr bgColor=#eeeeee>
            <td align=center>总计：</td>            
            <td colspan="2" align=center><s:property value="#totalSize"/></td>
          </tr>
        </table>
        <b>&nbsp; </b></td>
    </tr>
    <tr bgcolor=#dddddd> 
      <td bgcolor="#446DAB"><font color="#FFFFFF">第四步：确认。 <br>
        检查无误后，请点击&quot;确认&quot;。</font><br>
        <b> <br>
        <input type="button" name="Submit2" value="确认" onclick="closeWin('${attIds}');">
		
        &nbsp; </b></td>
    </tr>
	    <tr > 
      <td height="16"><b>&nbsp; </b></td>
    </tr> --%>
    </tbody> 
  </table>
</FORM>



<script language="JavaScript">
 var  attlistIds="${attIds}";
 window.opener.document.getElementById("getAttIds").value=attlistIds;
 var mainobj=opener.document.getElementById("uploadAttList");
 
 var obj=document.getElementById("attList");
 var strTemp=obj.outerHTML;


var  strMain="<table id='attList' width='700px' border='0' cellpadding='1' cellspacing='1' bordercolor='#CCCCCC'><tr bgcolor='#CCCCCC'> <td align='center'>文件名</td><td align='center'>大小(byte)</td></tr>";
var  strEnd="</tr></table>";
var begin=strMain.length
var end=strMain.length+25;
var temp=strTemp.substring(end,strTemp.length);
 
var trABegin="uploadfile!delFile.action"; 
var trAEnd="删除</A></TD>";
while(temp.indexOf(trAEnd)!=-1){ 
   var  len=temp.length;
   var  bi=temp.indexOf(trABegin)-26; 
   var  t1=temp.substring(0,bi);     
   var  ei=temp.indexOf(trAEnd)+16;           
   var  t2=temp.substring(ei,len);   
   temp=t1+t2;     
}

strMain=strMain.concat(temp);

var lastTok="<TD></TD>";
var  li=strMain.indexOf(lastTok)+9; 
strMain=strMain.substring(0,li)+strMain.substring(li+11,strMain.length); 

var strDelete="<TD>&nbsp;</TD></TR>";
var dsi=strMain.indexOf(strDelete);

//strMain=strMain.substring(0,dsi); 
strMain=strMain+strEnd;
mainobj.innerHTML=strMain;
</script>

</BODY></HTML>
<SCRIPT LANGUAGE="JavaScript">
<!--
	function checkInput()
	{
		if(notNull("上传文件",this.form1.fileUpload))
		{		
		   this.document.form1.submit();
			return true;
		}
		else 
		{
			return false;
		}
		
	}

	function notNull(fieldname,string)
	{
		if(string.value == "")
		{
			alert(fieldname + "不能为空");
			string.focus();
			return false; 
		}
		else 
		{
			return true;
		}
	}
//-->
</SCRIPT>
