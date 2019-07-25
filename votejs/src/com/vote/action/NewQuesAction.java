/*package com.vote.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vote.service.ObjectBeanService;
import com.vote.service.QuestionService;
import com.vote.service.SelecterService;

public class NewQuesAction extends ActionSupport{

	
	public String execute(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String id = request.getParameter("oid");
		//System.out.println("id="+id);
		int oid = Integer.parseInt(id);
		QuestionService qs = new QuestionService();
		SelecterService ss = new SelecterService();
		int count = ObjectBeanService.getCount(oid);
		int seq = 1;
		String content = request.getParameter("content");
		if(content!=null&&content.trim().length()>0){
			//content=new String(content.getBytes("iso8859-1"),"UTF-8");
			}
		String selCount = request.getParameter("listCnt");
		int listCnt = Integer.parseInt(selCount);
		String type=request.getParameter("qtype");
		int qtype = Integer.parseInt(type);
		
		String stscore = request.getParameter("score");
		int score =Integer.parseInt(stscore);
		
		String rightvalue = request.getParameter("rightvalue");
		
		if (count == 0) {
			//往题目表中插入题目
			int insertQues = qs.addQues(oid, content, qtype, seq,score,rightvalue);
			if (insertQues > 0) {
				//插入选项数据
				for (int i = 1; i <= listCnt; i++) {
					String name = String.valueOf("txt" + i);
					String value = request.getParameter(name);
					//value=new String(value.getBytes("iso8859-1"),"UTF-8");
					ss.addSelecter(oid, seq, value, i);
				}
			}
		} else {
			//往题目表中插入题目
			int addQues = qs.addQues(oid, content, qtype, (count + 1),score,rightvalue);
			if (addQues > 0) {
				//插入选项数据
				for (int i = 1; i <= listCnt; i++) {
			String name = String.valueOf("txt" + i);
			String value = request.getParameter(name);
			//value=new String(value.getBytes("iso8859-1"),"UTF-8");
			ss.addSelecter(oid, (count + 1), value, i);
				}
			}
		}
		request.setAttribute("oid", oid);
		//response.sendRedirect("quesList.jsp?oid=" + oid);
		
		return "questlistsuccess";
	}
	
}
*/
package com.vote.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vote.service.ObjectBeanService;
import com.vote.service.QuestionService;
import com.vote.service.SelecterService;

public class NewQuesAction extends ActionSupport{

	
	public String execute(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String id = request.getParameter("oid");
		//System.out.println("id="+id);
		int oid = Integer.parseInt(id);
		QuestionService qs = new QuestionService();
		SelecterService ss = new SelecterService();
		int count = ObjectBeanService.getCount(oid);
		int seq = 1;
		String content = request.getParameter("content");
		if(content!=null&&content.trim().length()>0){
			//content=new String(content.getBytes("iso8859-1"),"UTF-8");
			}
		String selCount = request.getParameter("listCnt");
		int listCnt = Integer.parseInt(selCount);
		String type=request.getParameter("qtype");
		int qtype = Integer.parseInt(type);
		
		/*String stscore = request.getParameter("score");
		int score =Integer.parseInt(stscore);*/
		
		String rightvalue = request.getParameter("rightvalue");
		
		if (count == 0) {
			//往题目表中插入题目
			int insertQues = qs.addQues(oid, content, qtype, seq,rightvalue);
			if (insertQues > 0) {
				//插入选项数据
				for (int i = 1; i <= listCnt; i++) {
					String name = String.valueOf("txt" + i);
					String value = request.getParameter(name);
					String stscore = request.getParameter("score"+i);
					int score =Integer.parseInt(stscore);
					//value=new String(value.getBytes("iso8859-1"),"UTF-8");
					ss.addSelecter(oid, seq, value, i,score);
				}
			}
		} else {
			//往题目表中插入题目
			int addQues = qs.addQues(oid, content, qtype, (count + 1),rightvalue);
			if (addQues > 0) {
				//插入选项数据
				for (int i = 1; i <= listCnt; i++) {
			String name = String.valueOf("txt" + i);
			String value = request.getParameter(name);
			String stscore = request.getParameter("score"+i);
			int score =Integer.parseInt(stscore);
			//value=new String(value.getBytes("iso8859-1"),"UTF-8");
			ss.addSelecter(oid, (count + 1), value, i,score);
				}
			}
		}
		request.setAttribute("oid", oid);
		//response.sendRedirect("quesList.jsp?oid=" + oid);
		
		return "questlistsuccess";
	}
	
}
