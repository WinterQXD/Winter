package com.vote.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vote.bean.TblStudentEntity;

public class StudentService {
	public TblStudentEntity findStu(String s,String s2,String bjdm,String njdm){
		DBConnection dbcon = null;
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		TblStudentEntity stu=null;
		String sql = "select id,xxmc,xjh,njdm,bjdm,xm from tbl_student where xjh like ? and xm like ? and bjdm=? and njdm=?";
		System.out.println(sql);
		try {
			dbcon=new DBConnection();
			con=dbcon.getConnection();
			stm=con.prepareStatement(sql);
			stm.setString(1, "%"+s+"%");
			stm.setString(2, "%"+s2+"%");
			stm.setString(3, bjdm);
			stm.setString(4, njdm);
			rs=stm.executeQuery();

			while(rs.next()){
				stu=new TblStudentEntity();
				stu.setId(rs.getString("id"));
				stu.setXxmc(rs.getString("xxmc"));
				stu.setNjdm(rs.getString("njdm"));
				stu.setXjh(rs.getString("xjh"));
				stu.setBjdm(rs.getString("bjdm"));
				stu.setXm(rs.getString("xm"));
			}
			return stu;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbcon.closeAll(con,stm, rs);
		}
	}

	public String findGrade(String njdm){
		DBConnection dbcon = null;
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "select njdm,njmc from tbl_grade where njdm=?";
		System.out.println(sql);
		try {
			dbcon=new DBConnection();
			con=dbcon.getConnection();
			stm=con.prepareStatement(sql);
			stm.setString(1, njdm);
			rs=stm.executeQuery();
			String str=null;
			while(rs.next()){
				str=rs.getString("njmc");
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbcon.closeAll(con,stm, rs);
		}
	}
}
