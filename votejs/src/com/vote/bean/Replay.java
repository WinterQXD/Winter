package com.vote.bean;

import java.sql.Timestamp;

public class Replay {

	private int replayId; //回复ID
	private String replayCode;//回复者代码
	private String replayIp;//回复者IP
	private int oId;//主题Id
	private Timestamp replayTime;//回复时间
	private String remark;//备注
	private int replayScore;
	
	private String xm;
	private String xxmc;
	private String njdm;
	private String bjdm;
	private String title;
	private String xxdm;
	private String xh;
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getXxdm() {
		return xxdm;
	}
	public void setXxdm(String xxdm) {
		this.xxdm = xxdm;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXxmc() {
		return xxmc;
	}
	public void setXxmc(String xxmc) {
		this.xxmc = xxmc;
	}
	public String getNjdm() {
		return njdm;
	}
	public void setNjdm(String njdm) {
		this.njdm = njdm;
	}
	public String getBjdm() {
		return bjdm;
	}
	public void setBjdm(String bjdm) {
		this.bjdm = bjdm;
	}

	
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
	public String getReplayIp() {
		return replayIp;
	}
	public void setReplayIp(String replayIp) {
		this.replayIp = replayIp;
	}
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public Timestamp getReplayTime() {
		return replayTime;
	}
	public void setReplayTime(Timestamp replayTime) {
		this.replayTime = replayTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getReplayScore() {
		return replayScore;
	}
	public void setReplayScore(int replayScore) {
		this.replayScore = replayScore;
	}

}
