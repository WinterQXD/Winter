/*package com.vote.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vote.bean.Answer;
import com.vote.bean.ObjectBean;
import com.vote.bean.Question;
import com.vote.bean.Replay;
import com.vote.dao.ObjectBeanDao;
import com.vote.dao.QuestionDao;
import com.vote.dao.ReplayDao;
import com.vote.service.Func;
import com.vote.util.BeansFactory;

public class VoteSuccess extends ActionSupport{
	private ReplayDao rd;
	private QuestionDao qs;
	public ReplayDao getRd() {
		return rd;
	}
	public void setRd(ReplayDao rd) {
		this.rd = rd;
	}
	public QuestionDao getQs() {
		return qs;
	}
	public void setQs(QuestionDao qs) {
		this.qs = qs;
	}
	public ObjectBeanDao getObjd() {
		return objd;
	}
	public void setObjd(ObjectBeanDao objd) {
		this.objd = objd;
	}
	private ObjectBeanDao objd;
	private String stuId;

	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	@Override
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		QuestionDao qs=(QuestionDao)BeansFactory.get("questionDao");//QuestionService qs=new QuestionService();
		ReplayDao rd=(ReplayDao)BeansFactory.get("replayDao");
		String errMsg="";
		String replayCode = "";
		String replayIp = Func.getIpAddr(request);
		System.out.println("replayIp "+replayIp);
		String id = request.getParameter("oid");//主题Id
		int oid = Integer.parseInt(id);
		ObjectBeanDao objd=(ObjectBeanDao)BeansFactory.get("objectBeanDao");
		ObjectBean ob = objd.findObjectBeanByID(oid);
		//response.setCharacterEncoding("UTF-8");
		replayCode=stuId;
		if(replayCode==null||"".equals(replayCode)){
			errMsg = "提交失败,未填写学生信息,请填写完整学生信息后再提交问卷！";
			//response.getWriter().print("error");
			request.getSession().setAttribute("errMsg", errMsg);
			return "fail";
		}
		int status = ob.getState();
		System.out.println("问卷状态: "+status);
		if(status==2)
		{
			errMsg = "该问卷已终止评议，不能提交!";
			//response.getWriter().print("error");
			request.getSession().setAttribute("errMsg", errMsg);
			return "fail";
		}
		if(rd.exit(oid,replayIp,replayCode))
		{
			errMsg = "您的答案已提交，不能重复提交!";
			//response.getWriter().print("error");;
			request.getSession().setAttribute("errMsg", errMsg);
			return "fail";
		}

		Enumeration e = request.getParameterNames();
		List lname = new LinkedList();
		List<Answer> answers = new ArrayList<Answer>();
		Map map = new HashMap();
		while (e.hasMoreElements()) {//取得所有参数名
			String key = (String) e.nextElement();
			if (key.startsWith("sub") || key.startsWith("oid"))
				key = (String) e.nextElement();
			String ln2 = key.substring(key.length() - 2);//截取参数的后两个字符，以利于参数的正确排序
			map.put(ln2, key);
			// 获取题目的序号和题目的类型     题目序号, 题目类型
			lname.add(ln2);
			Collections.sort(lname);
		}

		//回复信息

		Replay replay = new Replay();
		replay.setReplayCode(replayCode);
		replay.setReplayIp(replayIp);
		replay.setoId(oid);
		replay.setRemark("");
		int replayScore=0;
		int rigSorevalue =0;
		//取得参数的值
		for (int i = 0; i < lname.size(); i++) {

			String name = (String) map.get(lname.get(i));
			//System.out.println("name:" + name);

			//判断是否为复选框
			if (name.startsWith("check")) {
				String checkbox[] = request.getParameterValues(name);
				Question ques=null;
				if (checkbox != null) {
					int size = checkbox.length;
					String s = "";

					for (int j = 0; j < size; j++) {
						Answer answer = new Answer();
						answer.setOid(oid);
						int qseq=Integer.parseInt(name.substring(name.lastIndexOf("_")+1));
						answer.setqSeq(qseq);
						ques= qs.getQuesBySeq(qseq, oid);
						//正确答案的分值
						rigSorevalue =ques.getScore();
						
						String cValue = checkbox[j];
						//System.out.println(checkbox[j] +cValue);
						s+=cValue;
						int seSeq = Integer.parseInt(cValue);
						answer.setSeSeq(seSeq);
						answer.setSeValue(cValue);
						answers.add(answer);
					}
					char [] right=ques.getRightvalue().toCharArray();
					char [] ss=s.toCharArray();
					Arrays.sort(right);
					Arrays.sort(ss);
					if(Arrays.equals(right, ss)){
						replayScore=replayScore+rigSorevalue;
					}
                    //多项题判分
				}
			} else if(name.startsWith("radio") || name.startsWith("select")) {
				Answer answer = new Answer();
				answer.setOid(oid);
				int qseq=Integer.parseInt(name.substring(name.lastIndexOf("_")+1));
				answer.setqSeq(qseq);
				Question ques= qs.getQuesBySeq(qseq, oid);
				//正确答案的分值
				rigSorevalue =ques.getScore();
				
				String value = request.getParameter(name);
				if(ques.getRightvalue().equals(value)){
					replayScore=replayScore+rigSorevalue;
				}
				int seSeq = Integer.parseInt(value);
				answer.setSeSeq(seSeq);
				answer.setSeValue(value);
				answers.add(answer);
			}else if(name.startsWith("txt")) {
				Answer answer = new Answer();
				answer.setOid(oid);
				answer.setqSeq(Integer.parseInt(name.substring(name.lastIndexOf("_")+1)));
				String value = request.getParameter(name);
				//System.out.println(value);
				answer.setSeSeq(1);
				answer.setSeValue(value);
				answers.add(answer);
			}
		}
		replay.setReplayScore(replayScore);

		boolean falg = rd.save(replay,answers);

		if(falg) {errMsg="提交答案成功！";request.setAttribute("errMsg", "提交答案成功！");System.out.println("提交答案成功！");}
		//response.getWriter().print("success");
		request.getSession().setAttribute("errMsg", errMsg);
		return "success";
	}
}
*/
package com.vote.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.vote.bean.Answer;
import com.vote.bean.ObjectBean;
import com.vote.bean.Question;
import com.vote.bean.Replay;
import com.vote.bean.ReplayItem;
import com.vote.bean.Selecter;
import com.vote.dao.ObjectBeanDao;
import com.vote.dao.QuestionDao;
import com.vote.dao.ReplayDao;
import com.vote.dao.ReplayItemDao;
import com.vote.dao.SelecterDao;
import com.vote.service.Func;
import com.vote.util.BeansFactory;

public class VoteSuccess extends ActionSupport{
	private ReplayDao rd;
	private QuestionDao qs;
	private ReplayItemDao rid;
	public ReplayItemDao getRid() {
		return rid;
	}
	public void setRid(ReplayItemDao rid) {
		this.rid = rid;
	}
	public ReplayDao getRd() {
		return rd;
	}
	public void setRd(ReplayDao rd) {
		this.rd = rd;
	}
	public QuestionDao getQs() {
		return qs;
	}
	public void setQs(QuestionDao qs) {
		this.qs = qs;
	}
	public ObjectBeanDao getObjd() {
		return objd;
	}
	public void setObjd(ObjectBeanDao objd) {
		this.objd = objd;
	}
	private ObjectBeanDao objd;
	private String stuId;

	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	@Override
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		QuestionDao qs=(QuestionDao)BeansFactory.get("questionDao");//QuestionService qs=new QuestionService();
		ReplayDao rd=(ReplayDao)BeansFactory.get("replayDao");
		SelecterDao sel = (SelecterDao)BeansFactory.get("selecterDao");
		String errMsg="";
		String replayCode = "";
		String replayIp = Func.getIpAddr(request);
		//System.out.println("replayIp "+replayIp);
		String id = request.getParameter("oid");//主题Id
		int oid = Integer.parseInt(id);
		/*String score1 = request.getParameter("score");//选项分数score
		int score=Integer.parseInt(score1);*/
		ObjectBeanDao objd=(ObjectBeanDao)BeansFactory.get("objectBeanDao");
		ObjectBean ob = objd.findObjectBeanByID(oid);
		//response.setCharacterEncoding("UTF-8");
		replayCode=stuId;
		if(replayCode==null||"".equals(replayCode)){
			errMsg = "提交失败,未填写学生信息,请填写完整学生信息后再提交问卷！";
			//response.getWriter().print("error");
			request.getSession().setAttribute("errMsg", errMsg);
			return "fail";
		}
		int status = ob.getState();
		System.out.println("问卷状态: "+status);
		if(status==2)
		{
			errMsg = "该问卷已终止评议，不能提交!";
			//response.getWriter().print("error");
			request.getSession().setAttribute("errMsg", errMsg);
			return "fail";
		}
		if(rd.exit(oid,replayIp,replayCode))
		{
			errMsg = "您的答案已提交，不能重复提交!";
			//response.getWriter().print("error");;
			request.getSession().setAttribute("errMsg", errMsg);
			return "fail";
		}

		Enumeration e = request.getParameterNames();
		List lname = new LinkedList();
		List<Answer> answers = new ArrayList<Answer>();
		Map map = new HashMap();
		while (e.hasMoreElements()) {//取得所有参数名
			String key = (String) e.nextElement();
			if (key.startsWith("sub") || key.startsWith("oid"))
				key = (String) e.nextElement();
			String ln2 = key.substring(key.length() - 2);//截取参数的后两个字符，以利于参数的正确排序
			map.put(ln2, key);
			// 获取题目的序号和题目的类型     题目序号, 题目类型
			lname.add(ln2);
			Collections.sort(lname);
		}

		//回复信息

		Replay replay = new Replay();
		replay.setReplayCode(replayCode);
		replay.setReplayIp(replayIp);
		replay.setoId(oid);
		replay.setRemark("");
		int replayScore=0;
		int rigSorevalue =0;
		int SelScore=0;
		int replyCheckScore=0;
		int replayRadioScore=0;
		//取得参数的值
		for (int i = 0; i < lname.size(); i++) {

			String name = (String) map.get(lname.get(i));

			//判断是否为复选框
			if (name.startsWith("check")) {
				String checkbox[] = request.getParameterValues(name);
				Question ques=null;
				//Selecter sels=null;
				if (checkbox != null) {
					int size = checkbox.length;
					String s = "";

					for (int j = 0; j < size; j++) {
						Answer answer = new Answer();
						answer.setOid(oid);
						int qseq=Integer.parseInt(name.substring(name.lastIndexOf("_")+1));
						answer.setqSeq(qseq);
						String cValue = checkbox[j];
						//System.out.println(checkbox[j] +cValue);
						s+=cValue;
						int seSeq = Integer.parseInt(cValue);
						//System.err.println("seSeq="+seSeq);
						ques= qs.getQuesBySeq(qseq, oid);
						Selecter sels=sel.getselscoreBySeq(seSeq,qseq, oid);
						//正确答案的分值
						//rigSorevalue =ques.getScore();
						SelScore=sels.getScore();
						//System.err.println("SelScore="+SelScore);
						//String cValue = checkbox[j];
						//System.out.println(checkbox[j] +cValue);
						//s+=cValue;
						//int seSeq = Integer.parseInt(cValue);
						answer.setSeSeq(seSeq);
						answer.setSeValue(cValue);
						answer.setScore(SelScore);
						answers.add(answer);
						rigSorevalue+=SelScore;
						//rigSorevalue+=forScore;
						//System.err.println("rigSorevalue="+j+rigSorevalue);
					}
					/*char [] right=ques.getRightvalue().toCharArray();
					char [] ss=s.toCharArray();
					Arrays.sort(right);
					Arrays.sort(ss);
					if(Arrays.equals(right, ss)){
						replayScore=replayScore+rigSorevalue;
					}*/
					replyCheckScore=rigSorevalue;
					//System.err.println("replycheck="+replyCheckScore);
					//System.err.println("replayScore="+replayScore);
                    //多项题判分
				}
			} else if(name.startsWith("radio") || name.startsWith("select")) {
				Answer answer = new Answer();
				String value = request.getParameter(name);
				answer.setOid(oid);
				int seSeq = Integer.parseInt(value);
				int qseq=Integer.parseInt(name.substring(name.lastIndexOf("_")+1));
				//int seSeq1=Integer.parseInt(name.substring(name.lastIndexOf("_")+1));
				Selecter sels=sel.getselscoreBySeq(seSeq,qseq, oid);
				//正确答案的分值
				//System.err.println("seSeq="+seSeq);
				//System.err.println("qseq="+qseq);
				SelScore=sels.getScore();
				//System.err.println("SelScore="+SelScore);
				replayRadioScore=replayRadioScore+SelScore;
				//System.err.println("replyradio="+replayRadioScore);
				answer.setqSeq(qseq);
				answer.setSeSeq(seSeq);
				answer.setSeValue(value);
				answer.setScore(SelScore);
				answers.add(answer);
			}else if(name.startsWith("txt")) {
				Answer answer = new Answer();
				answer.setOid(oid);
				answer.setqSeq(Integer.parseInt(name.substring(name.lastIndexOf("_")+1)));
				String value = request.getParameter(name);
				//System.out.println("value="+value);
				answer.setSeSeq(1);
				answer.setSeValue(value);
				//Selecter sels=sel.getselscoreBySeq(answer.getSeSeq(),qseq oid);
				//answer.setScore(score);
				answers.add(answer);
			}
			else if (name.startsWith("txt")) {
				
			}
			replayScore=(replayRadioScore+replyCheckScore)/2;
			
			
		}
		String valuetest1 = request.getParameter("replaytest");
		String valuetest2 = request.getParameter("replayitem");
		System.err.println("valuetest1="+valuetest1);
		System.err.println("valuetest2="+valuetest2);
		ReplayItem item = new ReplayItem();
		item.setOid(oid);
		item.setReplayCode(replayCode);
		//item.setReplayId(replayId);//自动递增
		//item.setReplayTime();//时间戳
		item.setReplayTest(valuetest1);
		item.setReplayItem(valuetest2);
		rid.addReplayItem(item);
		
		replay.setReplayScore(replayScore);

		boolean falg = rd.save(replay,answers);

		if(falg) {errMsg="提交答案成功！";request.setAttribute("errMsg", "提交答案成功！");System.out.println("提交答案成功！");}
		//response.getWriter().print("success");
		request.getSession().setAttribute("errMsg", errMsg);
		return "success";
	}
}
