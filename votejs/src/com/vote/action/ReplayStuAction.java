package com.vote.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.vote.bean.Replay;
import com.vote.dao.QuestionDao;
import com.vote.dao.ReplayDao;

public class ReplayStuAction {

  private ReplayDao replayDao;	
  private List<Replay> replist;
  
  private QuestionDao questionDao;
  
  public QuestionDao getQuestionDao() {
	return questionDao;
}

public void setQuestionDao(QuestionDao questionDao) {
	this.questionDao = questionDao;
}

public List<Replay> getReplist() {
	return replist;
}

public void setReplist(List<Replay> replist) {
	this.replist = replist;
}

public ReplayDao getReplayDao() {
	return replayDao;
}

public void setReplayDao(ReplayDao replayDao) {
	this.replayDao = replayDao;
}

public String selectRep(){
	  

	  HttpServletRequest request = ServletActionContext.getRequest();
	
	  Replay bean=new Replay();
	  String oid=request.getParameter("oid");
	  System.out.println("oid---"+oid);
	  bean.setoId(Integer.valueOf(oid));
	  if(null!=request.getParameter("xxdm")){
		  bean.setXxdm(request.getParameter("xxdm"));
	  }else{
		 // bean.setXxdm("3101160004");
	  }
	  
	  
	  replist=replayDao.getReplayList(bean);  
	
	  int size=replist.size();
	  request.setAttribute("size", size);
	  request.setAttribute("replist", replist);
	  
	  int maxscore=questionDao.getMaxScoreByOid(Integer.valueOf(oid)); //修改查询分值方法为wj_selecter表
	  
	  Map map=getCountScore(replist,maxscore);
	  
	  request.setAttribute("map", map);
	  
	  return "success";
  }	
	
	
  public Map getCountScore(List<Replay> replist, int maxscore){
	  Map map=new HashMap();
	  int stusize=replist.size();
	  
	  int s_59=59;
	  int s_60=60;
	  int s_75=75;
	  int s_90=90;
	  
	  int n_59=0;
	  int n_60=0;
	  int n_75=0;
	  int n_90=0;
	 
	  for(int i=0;i<replist.size();i++){
		  Replay repbean=replist.get(i);
		  int recore=repbean.getReplayScore();
		  double tempscore=(recore*100/maxscore);
		  long levelscore= Math.round(tempscore);
		//  System.out.println(repbean.getXm()+" "+levelscore+" "+repbean.getReplayScore());
		  if(levelscore<=s_59){
			  n_59++;
		  }
		  else if(s_60<=levelscore && levelscore<s_75){
			  n_60++;
		  }else if(s_75<=levelscore && levelscore<s_90){
			  n_75++;
		  }else if(s_90<=levelscore){
			  n_90++;
		  }
		  
	  }
	  System.out.println("maxscore "+maxscore);
	  System.out.println(" "+n_59+" "+n_60+" "+" "+n_75+" "+n_90);
	  if(stusize==0){
		  stusize=1;
	  }
	 
	  map.put("level_4", n_90*100/stusize);
	  map.put("level_3", n_75*100/stusize);
	  map.put("level_2", n_60*100/stusize);
	  map.put("level_1", n_59*100/stusize);
	  return map;
  }
}
