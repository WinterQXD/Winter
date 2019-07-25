package com.vote.dao;

import java.util.List;

import com.vote.bean.TblStudentEntity;

public interface StudentDao {
	public TblStudentEntity findStu(String s,String s2,String bjdm,String njdm , String xxdm);

	public String findGrade(String njdm);
	public List findSchool();
}
