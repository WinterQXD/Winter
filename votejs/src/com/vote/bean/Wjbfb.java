package com.vote.bean;

public class Wjbfb {
	 private String xxmc;
	  private String xjrs;
	  private String cprs;
	  private Double yxl;
	  private Double lhl;
	  private Double jgl;
	  private Double bjgl;
	  private String xxdm;
	  
   public String getXxmc() {
		return xxmc;
	}
	public void setXxmc(String xxmc) {
		this.xxmc = xxmc;
	}
	public String getXjrs() {
		return xjrs;
	}
	public void setXjrs(String xjrs) {
		this.xjrs = xjrs;
	}
	public String getCprs() {
		return cprs;
	}
	public void setCprs(String cprs) {
		this.cprs = cprs;
	}
	public Double getYxl() {
		if(null==yxl){
			yxl=0d;
		}
		return yxl;
	}
	public void setYxl(Double yxl) {
		this.yxl = yxl;
	}
	public Double getLhl() {
		if(null==lhl){
			lhl=0d;
		}
		return lhl;
	}
	public void setLhl(Double lhl) {
		this.lhl = lhl;
	}
	public Double getJgl() {
		if(null==jgl){
			jgl=0d;
		}
		return jgl;
	}
	public void setJgl(Double jgl) {
		this.jgl = jgl;
	}
	public Double getBjgl() {
		if(null==bjgl){
			bjgl=0d;
		}
		return bjgl;
	}
	public void setBjgl(Double bjgl) {
		this.bjgl = bjgl;
	}
	public String getXxdm() {
		return xxdm;
	}
	public void setXxdm(String xxdm) {
		this.xxdm = xxdm;
	}

}
