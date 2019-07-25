package com.vote.dao;

import java.util.List;
import java.util.Map;

import com.vote.bean.Answer;
import com.vote.bean.Replay;

public interface ReplayDao {
	/**
	 * 获取所有问题回答情况
	 * @param oid 主题ID
	 * @return
	 */
	public   Map<Integer,List<Map<Integer,Integer>>> getAllAnswer(int oid) ;
	public  boolean save(Replay r,List<Answer> answers);
	public   List<Answer> getAnswers(int oid,int qSeq) ;

	/**
	 * 得到问题总数
	 * @param con
	 * @param oid
	 * @return
	 */
	public   int getQuesCount(  int oid);

	/**
	 * 得到选项总数
	 * @param con
	 * @param oid
	 * @return
	 */
	public   int getSelCount(  int oid, int qSeq);

	/**
	 * 根据主题ID查询回复总数
	 * @param oid 主题ID
	 * @return
	 */
	public   int getAnswerCount(int oid);

	/**
	 * 根据主题Id和题目序号查询该问题的回答数
	 * @param con 数据库连接
	 * @param oid 主题Id
	 * @param qSeq 题目序号
	 * @return 回答数
	 */
	public   int getAnswerCount(  int oid,int qSeq) ;

	/**
	 * 根据主题Id和题目序号和选项序号查询该问题选项的回答数
	 * @param con 数据库连接
	 * @param oid 主题Id
	 * @param qSeq 题目序号
	 * @param seSeq 选项序号
	 * @return 问题选项的回答数
	 */
	public   int getAnswerCount(  int oid,int qSeq,int seSeq) ;

	// 删除问卷回复情况
	public   boolean delReplay(int oid) throws Exception;

	/**
	 * 判断是否存在回复
	 * @param oid
	 * @param code
	 * @return
	 */
	public   boolean exit(int oid,String replayIp,String replayCode);
	
	
	public List<Replay> getReplayList(Replay bean);
}
