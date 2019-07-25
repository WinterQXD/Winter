package com.vote.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.vote.bean.Question;

public class QuestionDaoImpl extends JdbcDaoSupport implements QuestionDao{


	@Override
	public int addQues(int oid, String content, int qtype, int seq, String rightvalue) {

		String sql = "insert into wj_question(oid,content,qtype,seq,rightvalue) values(?,?,?,?,?)";

		int i = this.getJdbcTemplate().update(sql,new Object[]{oid,content,qtype,seq,rightvalue});

		return i;
	}
	

	@Override
	public int deleteQues(int seq, int oid) {

		int count=0;
		String sql = "delete  from wj_question where oid=? and seq = ? ";
		count=this.getJdbcTemplate().update(sql, new Object[]{oid,seq});

		return count;
	}


	@Override
	public Question getQuesBySeq(int seq, int oid) {


		Question ques=new Question();
		String sql = "select content,qtype,rightvalue from wj_question where oid = ? and seq = ? ";


		List list= this.getJdbcTemplate().queryForList(sql,new Object [] {oid,seq});
		Iterator it=list.iterator();

		while(it.hasNext()){
			Map map=(Map)it.next();
			String content=(String)map.get("content");
			int qtype=(Integer)map.get("qtype");
			ques.setContent(content);
			ques.setQtype(qtype);
			//ques.setScore((Integer)map.get("score"));
			ques.setRightvalue((String)map.get("rightvalue"));

		}
		return ques;

	}


	@Override
	public int getQuesCount(int oid) {

		String sql = "select count(*) from wj_question where oid=? ";

		int i=this.getJdbcTemplate().queryForInt(sql,new Object[]{oid});

		return i;
	}


	@Override
	public List<Question> litQuesByOid(int oid) {

		List<Question> quesList=new LinkedList<Question>();
		String sql = "select seq,content,qtype from wj_question where oid=? order by seq asc";
		List list=this.getJdbcTemplate().queryForList(sql, new Object[]{oid} );


		Iterator it=list.iterator();
		while(it.hasNext()){
			Map map=(Map)it.next();
			Question ques=new Question();
			int seq=(Integer)map.get("seq");
			int qtype=(Integer)map.get("qtype");
			String content=(String)map.get("content");
			ques.setContent(content);
			ques.setSeq(seq);
			ques.setQtype(qtype);
			quesList.add(ques);

		}

		return quesList;
	}


	@Override
	public int updateQseq(int seq, int oid) {

		String sql = "update wj_question set seq=(seq-1) where oid = ? and seq > ?" ;
		//	System.out.println(sql);

		int i=this.getJdbcTemplate().update(sql, new Object[]{oid,seq});

		return i;
	}


	@Override
	public int updateQuesOrder(int oid, int seq) {

		String sql = "update wj_question set seq=(seq + 1) where oid = ?  and seq > ? ";

		int i= this.getJdbcTemplate().update(sql, new Object[]{oid,seq});

		return i;
	}

	
	public int getMaxScoreByOid(int oid) {
		String sql="select sum(score) from wj_selecter where oid=? ";
		return this.getJdbcTemplate().queryForInt(sql, new Object[]{oid});
	}


}
