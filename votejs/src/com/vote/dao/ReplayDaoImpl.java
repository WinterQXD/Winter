package com.vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.vote.bean.Answer;
import com.vote.bean.Replay;
import com.vote.service.DBConnection;

public class ReplayDaoImpl extends JdbcDaoSupport implements ReplayDao{


	@Override
	public boolean delReplay(int oid) throws Exception {

		String sql1 = "delete from wj_replay where oid=? ";
		String sql2 = "delete from wj_answer where oid=? ";

		this.getJdbcTemplate().update(sql1, new Object[]{oid});
		this.getJdbcTemplate().update(sql2, new Object[]{oid});

		return true;
	}


	@Override
	public boolean exit(int oid, String replayIp, String replayCode) {

		String sql = "select count(*) from wj_replay r where oid=? ";
		if(replayIp!=null&&!replayIp.trim().equals("")){
			sql +=" and r.replayIp='"+replayIp+"'" ;
		}
		if(replayCode!=null&&!replayCode.trim().equals("")){
			sql +=" and r.replayCode='"+replayCode+"'";
		}
		int qcount=this.getJdbcTemplate().queryForInt(sql, new Object[]{oid});

		boolean	falg=false;

		if(qcount>0) {
			falg=true;
		}

		return falg;
	}


	@Override
	public Map<Integer, List<Map<Integer, Integer>>> getAllAnswer(int oid) {



		int qCount = 0;
		int sCount = 0;
		int qaCount = 0;
		int saCount = 0;
		Map<Integer,List<Map<Integer,Integer>>> map = new HashMap<Integer,List<Map<Integer,Integer>>>();
		try {

			qCount = getQuesCount(oid);
			for(int i=1;i<=qCount;i++)
			{
				List<Map<Integer,Integer>> list = new ArrayList<Map<Integer,Integer>>();
				qaCount = getAnswerCount(oid,i);
				sCount = getSelCount(oid,i);
				for(int j=0;j<=sCount;j++)
				{
					Map<Integer,Integer> m = new HashMap<Integer,Integer>();
					if(j==0){
						m.put(0, qaCount);
					}else{
						saCount = getAnswerCount(oid,i,j);
						m.put(j, saCount);
					}
					list.add(m);
				}
				map.put(i, list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}


	@Override
	public int getAnswerCount(int oid) {

		String sql = "select count(*) from wj_replay where oid =? " ;

		int i=this.getJdbcTemplate().update(sql, new Object[]{oid});

		return i;
	}


	@Override
	public int getAnswerCount( int oid, int qSeq) {

		String sql = "select count(*) from wj_answer where oid =? and qSeq= ? ";

		int i=this.getJdbcTemplate().update(sql, new Object[]{oid,qSeq});

		return i;
	}


	@Override
	public int getAnswerCount( int oid, int qSeq, int seSeq) {

		String sql = "select count(*) from wj_answer where oid =? and qSeq=? and seSeq=? ";

		int i=this.getJdbcTemplate().update(sql, new Object[]{oid,qSeq,seSeq});

		return i;
	}


	@Override
	public List<Answer> getAnswers(int oid, int qSeq) {

		List<Answer> answers = new LinkedList<Answer>();
		String sql = "select * from wj_answer where oid=? and qSeq=? order by answerId asc";

		List list= this.getJdbcTemplate().queryForList(sql,new Object[]{oid,qSeq});
		Iterator it=list.iterator();


		while(it.hasNext()){
			Map map=(Map)it.next();
			Answer answer = new Answer();
			int answerId =(Integer) map.get("answerId");
			int replayId =(Integer) map.get("replayId");
			int oidd =(Integer) map.get("oid");
			int qSeqq =(Integer) map.get("qSeq");
			int seSeq =(Integer) map.get("seSeq");
			String seValue =(String) map.get("seValue");
			String remark =(String) map.get("remark");

			answer.setAnswerId(answerId);
			answer.setReplayId(replayId);
			answer.setOid(oidd);
			answer.setqSeq(qSeqq);
			answer.setSeSeq(seSeq);
			answer.setSeValue(seValue);
			answer.setRemark(remark);

			answers.add(answer);
		}
		return answers;

	}


	@Override
	public int getQuesCount( int oid) {

		String sql = "select count(*) from wj_question where oid= ? " ;

		int i=this.getJdbcTemplate().queryForInt(sql, new Object[]{oid});

		return i;
	}

	@Override
	public boolean save(Replay r,List<Answer> answers) {
		DBConnection db = new DBConnection();
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql = "";
		int count = 0;
		int replayId = 0;
		boolean flag = false;
		boolean defaultAutoCommit = true;
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		try {
			con = db.getConnection();
			defaultAutoCommit = con.getAutoCommit();
			con.setAutoCommit(false);
			sql = "insert into wj_replay(replayCode,replayIp,oid,replayTime,replayScore,remark) values (?,?,?,?,?,?)";
			System.out.println(sql);
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, r.getReplayCode());
			stmt.setString(2, r.getReplayIp());
			stmt.setInt(3, r.getoId());
			stmt.setTimestamp(4, currentTime);
			stmt.setInt(5, r.getReplayScore());
			stmt.setString(6, r.getRemark());

			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if(rs.next()) replayId = rs.getInt(1);
			System.out.println("replayId: "+replayId);

			sql = "insert into wj_answer(replayId,oid,qSeq,seSeq,seValue,remark,score) values (?,?,?,?,?,?,?)";

			for(int i=0;i<answers.size();i++)
			{
				Answer a = answers.get(i);
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, replayId);
				stmt.setInt(2, a.getOid());
				stmt.setInt(3, a.getqSeq());
				stmt.setInt(4, a.getSeSeq());
				stmt.setString(5, a.getSeValue());
				stmt.setString(6, a.getRemark());
				stmt.setInt(7,a.getScore());
				stmt.executeUpdate();

				count++;
			}
			con.commit();
			con.setAutoCommit(defaultAutoCommit);
			flag = true;
			System.out.println("插入表[wj_answer] "+count+" 条记录");
		} catch (Exception e) {
			try {
				if(con!=null){
					con.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			db.closeAll(con, stmt, rs);
		}
		return flag;
	}

	@Override
	public int getSelCount( int oid, int qSeq) {

		String sql = "select count(*) from wj_selecter where oid=? and qseq =? ";

		int i=this.getJdbcTemplate().update(sql, new Object[]{oid,qSeq});

		return i;
	}
	
	
	public List<Replay> getReplayList(Replay bean){
		
		String aa=bean.getoId()+"";
		
		String sql="select  r.oid,xm,xxmc,njdm,bjdm,replayCode,replayScore,replayIp,wj.title,xxdm,xh from  wj_replay r "+
		 "left join tbl_student  s "+
		 "on  replayCode=id  "+
		 "LEFT JOIN   wj_object wj on wj.oid=r.oid "+
		"where replayCode is not null and s.xnm='2017' and r.oid=? ";
		
		if(null!=bean.getXxdm() && !"".equals(bean.getXxdm()) ){
			sql+=" and xxdm='"+bean.getXxdm()+"' ";
		}
		
		if(true){
			sql+=" order by  xxdm,njdm,bjdm ";
		}
		System.out.println(aa);
		System.out.println(sql);
		
		List list=this.getJdbcTemplate().queryForList(sql,new Object[]{aa});//,new Object[]{aa}
	    Iterator it=list.iterator();
		
	    List<Replay> alist=new ArrayList();
	    
		while(it.hasNext()){
			     Map map=(Map)it.next();
			     Replay rep=new Replay();
			      rep.setXm((String)map.get("xm"));
			      rep.setXxmc((String)map.get("xxmc")); 
			      rep.setNjdm((String)map.get("njdm"));
			      rep.setBjdm((String)map.get("bjdm") );
			      rep.setReplayScore((Integer)map.get("replayScore"));
			      rep.setTitle((String)map.get("title"));
			      rep.setReplayIp((String)map.get("replayIp"));
			      rep.setXxdm((String)map.get("xxdm"));
			      rep.setXh((String)map.get("xh"));
			      alist.add(rep);
		}
		
		return alist;
	}


}
