package com.vote.dao;

import java.util.List;

import com.vote.bean.Question;

public interface QuestionDao {

	//根据问卷的编号查找该属于该问卷的题目
	public List<Question> litQuesByOid(int oid) ;
	
	public int addQues(int oid, String content, int qtype, int seq,String rightvalue) ;
	
//	 插入题目前先修改题目表的题目顺序号
	public int updateQuesOrder(int oid, int seq);
	
//	 编辑题目的时候 先的到它的题目TITLE ,选项类型,选项内容
	public Question getQuesBySeq(int seq, int oid) ;
	
//	 根据传进来的问卷编号和试题的顺序号 删除题目
	public int deleteQues(int seq, int oid) ;
	
//	 根据传进来的问卷编号和题目的序号 修改题目表中题目的顺序
	public int updateQseq(int seq, int oid);
	
	// 得到问题的总数
	public int getQuesCount(int oid);
	
	//获取问卷的满分分值
	public int getMaxScoreByOid(int oid) ;
}
