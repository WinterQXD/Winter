package com.vote.dao;

import java.sql.Timestamp;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.vote.bean.ReplayItem;

public class ReplayItemDaoImpl extends JdbcDaoSupport implements ReplayItemDao {
	
	
	public void addReplayItem(ReplayItem bean) {
		 
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		String sql = "insert into  wj_replayitem (replaycode,oid,replayTime,replayTest,replayItem) VALUES (?,?,?,?,?)";
		System.out.println(sql);
	
		this.getJdbcTemplate().update(sql, new Object[]{bean.getReplayCode(),bean.getOid(),currentTime,bean.getReplayTest(),bean.getReplayItem()});
	}
	
}
