package com.vote.bean;

public class Question {
	private int oid;
	private int seq;
	private int qtype;
	private String content;
	private String remark;
	private int score;
	private String rightvalue;//正确选项

	public String getRightvalue() {
		return rightvalue;
	}
	public void setRightvalue(String rightvalue) {
		this.rightvalue = rightvalue;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getQtype() {
		return qtype;
	}
	public void setQtype(int qtype) {
		this.qtype = qtype;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
