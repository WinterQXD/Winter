package com.vote.bean;

public class Pic {
	private  int oid;
	private int qseq;
	private int selseq;
	private String path;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getQseq() {
		return qseq;
	}
	public void setQseq(int qseq) {
		this.qseq = qseq;
	}
	public int getSelseq() {
		return selseq;
	}
	public void setSelseq(int selseq) {
		this.selseq = selseq;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Pic(int oid, int qseq, int selseq, String path) {
		super();
		this.oid = oid;
		this.qseq = qseq;
		this.selseq = selseq;
		this.path = path;
	}
	public Pic() {
		super();
	}


}
