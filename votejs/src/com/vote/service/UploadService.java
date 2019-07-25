package com.vote.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vote.bean.Pic;

public class UploadService {
	public int addPic(int oid, int qseq, int selseq,String path) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql = "insert into wj_pic(oid,qseq,selseq,path) values(?,?,?,?)";
		try {
			dbcon=new DBConnection();
			con=dbcon.getConnection();
			ps=con.prepareStatement(sql);
			ps.setObject(1, oid);
			ps.setObject(2, qseq);
			ps.setObject(3, selseq);
			ps.setObject(4, path);
			int i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			dbcon.closeAll(con,stm,rs);
		}
	}

	public int updatePic(int oid, int qseq, int selseq,String path) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql = "update wj_pic set path=? where oid = ? and qseq = ? and selseq = ?";
		try {
			dbcon=new DBConnection();
			con=dbcon.getConnection();
			ps=con.prepareStatement(sql);
			ps.setObject(1, path);
			ps.setObject(2, oid);
			ps.setObject(3, qseq);
			ps.setObject(4, selseq);
			int i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			dbcon.closeAll(con, stm, rs);
		}
	}

	public List<Pic> findPicList(int oid, int qseq) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		List<Pic> piclist=new ArrayList<Pic>();

		String sql = "select oid,qseq,selseq,path from wj_pic where oid = '"+ oid + "' and qseq = '" + qseq+"'";
		try {
			dbcon=new DBConnection();
			con=dbcon.getConnection();
			stm=con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				piclist.add(new Pic(rs.getInt("oid"),rs.getInt("qseq"),rs.getInt("selseq"),	rs.getString("path")));
			}
			return piclist;
		} catch (Exception e) {
			e.printStackTrace();
			return piclist;
		} finally {
			dbcon.closeAll(con,stm,rs);
		}
	}

	public Pic findPic(int oid, int qseq, int selseq) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		Pic pic=null;
		String sql = "select oid,qseq,selseq,path from wj_pic where oid = '"+ oid + "' and qseq = '" + qseq + "' and selseq = '" + selseq + "'";
		try {
			dbcon=new DBConnection();
			con=dbcon.getConnection();
			stm=con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				pic=new Pic(	rs.getInt("oid"),rs.getInt("qseq"),rs.getInt("selseq"),	rs.getString("path"));
			}
			return pic;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbcon.closeAll(con,stm,rs);
		}
	}
	public Pic findPic(int oid, int qseq, int selseq,String path) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		Pic pic=null;
		String sql = "select oid,qseq,selseq,path from wj_pic where oid = '"+ oid + "' and qseq = '" + qseq + "' and selseq = '" + selseq + "'";
		try {
			dbcon=new DBConnection();
			con=dbcon.getConnection();
			stm=con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				pic=new Pic(	rs.getInt("oid"),rs.getInt("qseq"),rs.getInt("selseq"),	rs.getString("path"));
			}
			return pic;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbcon.closeAll(con,stm,rs);
		}
	}
	public void saveOrUpdate(int oid, int qseq, int selseq,String path){
		if(findPic(oid, qseq, selseq)!=null){
			updatePic(oid, qseq, selseq, path);
		}else{
			addPic(oid, qseq, selseq, path);
		}

	}
}
