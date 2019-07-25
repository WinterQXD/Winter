package com.vote.bean;

import java.sql.Timestamp;

public class ReplayItem {
	private int replayId; //回复ID
	private String replayCode;//回复者代码
	
	private int oid;//主题Id
	private Timestamp replayTime;//回复时间
	private String replayTest;//是否愿意
	private String replayItem;//参加项目
	public int getReplayId() {
		return replayId;
	}
	public void setReplayId(int replayId) {
		this.replayId = replayId;
	}
	public String getReplayCode() {
		return replayCode;
	}
	public void setReplayCode(String replayCode) {
		this.replayCode = replayCode;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Timestamp getReplayTime() {
		return replayTime;
	}
	public void setReplayTime(Timestamp replayTime) {
		this.replayTime = replayTime;
	}
	public String getReplayTest() {
		return replayTest;
	}
	public void setReplayTest(String replayTest) {
		this.replayTest = replayTest;
	}
	public String getReplayItem() {
		return replayItem;
	}
	public void setReplayItem(String replayItem) {
		this.replayItem = replayItem;
	}
}
