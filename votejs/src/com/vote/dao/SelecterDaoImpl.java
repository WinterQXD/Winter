package com.vote.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.vote.bean.Question;
import com.vote.bean.Selecter;
import com.vote.service.DBConnection;

public class SelecterDaoImpl extends JdbcDaoSupport implements SelecterDao{

	 
	public int addSelecter(int oid, int seq, String content, int seqSelecter,int score) {
		 
		
		String sql = "insert into wj_selecter(oid,qseq,content,selseq,score) values(?,?,?,?,?)";
	   // System.out.println(sql);
	
		int i = this.getJdbcTemplate().update(sql,new Object[]{oid,seq,content,seqSelecter,score});
		
		return 0;
	}

	 
	public int deleteSelecter(int seq, int oid) {
		 
		String sql = "delete from wj_selecter where oid=? and qseq= ? " ;
		int count=0;
	//	System.out.println(sql);
		count=this.getJdbcTemplate().update(sql, new Object[] {oid,seq});
		
		return count;
	}

	 
	public List listSelecterBySeq(int seq, int oid) {
		 
		List selList=new LinkedList();
		String sql = "select qseq,selseq,content,score from wj_selecter where qseq = ? and oid = ? order by selseq asc";
		// System.out.println(sql);
		 
		 List list= this.getJdbcTemplate().queryForList(sql,new Object[]{seq,oid});
		 Iterator it=list.iterator(); 
		 
			while(it.hasNext()){
				
				Map map=(Map)it.next();
				Selecter sel=new Selecter();
				int qseq=(Integer)map.get("qseq");
				int selseq=(Integer)map.get("selseq"); 
				String content=(String)map.get("content");
				int score=(Integer)map.get("score");
				//int score=(Integer)map.get("score");
				sel.setQseq(qseq);
				sel.setSelseq(selseq);
				sel.setContent(content);
				sel.setScore(score);
				selList.add(sel);
			}
			return selList;
		
	}

	 
	public int updateSelecterSeq(int oid, int qseq) {
		 
		String sql = "update wj_selecter set qseq=(qseq+1) where oid = ? and qseq > ? ";
	//	System.out.println(sql);
		
		int i = this.getJdbcTemplate().update(sql,new Object []{oid,qseq});
		return i;
		
	}

	 
	public int updateSseq(int seq, int oid) {
		 
		String sql = "update wj_selecter set qseq=(qseq-1) where oid = ? and qseq > ? " ;
      //  System.out.print(sql);
		
        int i=this.getJdbcTemplate().update(sql, new Object[]{oid,seq});
        
		return i;
	}
	@Override
	public Selecter getselscoreBySeq(int seq, int qseq,int oid) {


		Selecter sels=new Selecter();
		String sql = "select qseq,selseq,content,score from wj_selecter where selseq = ? and qseq=? and oid = ? ";


		List list= this.getJdbcTemplate().queryForList(sql,new Object [] {seq,qseq,oid});
		Iterator it=list.iterator();

		while(it.hasNext()){
			Map map=(Map)it.next();
			String content=(String)map.get("content");
			//int qtype=(Integer)map.get("qtype");
			sels.setContent(content);
			//selscore.setQtype(qtype);
			sels.setQseq((Integer)map.get("qseq"));
			sels.setSelseq((Integer)map.get("selseq"));
			sels.setScore((Integer)map.get("score"));
			//selscore.setRightvalue((String)map.get("rightvalue"));

		}
		return sels;

	}
}
