package com.vote.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.vote.bean.Pic;

public class UploadDaoImpl extends JdbcDaoSupport implements UploadDao{


	@Override
	public int addPic(int oid, int qseq, int selseq, String path) {

		String sql = "insert into wj_pic(oid,qseq,selseq,path) values(?,?,?,?)";

		int i =this.getJdbcTemplate().update(sql, new Object[]{oid,qseq,selseq,path});

		return i;

	}


	@Override
	public Pic findPic(int oid, int qseq, int selseq) {

		Pic pic=null;
		String sql = "select oid,qseq,selseq,path from wj_pic where oid = ? and qseq = ? and selseq = ? ";

		List list= this.getJdbcTemplate().queryForList(sql,new Object[]{oid,qseq,selseq});
		Iterator it=list.iterator();

		while(it.hasNext()){

			Map map=(Map)it.next();

			pic=new Pic();
			pic.setOid((Integer)(map.get("oid")));
			pic.setQseq((Integer)(map.get("qseq")));
			pic.setSelseq((Integer)(map.get("selseq")));
			pic.setPath((String)map.get("path"));

		}

		return pic;

	}


	@Override
	public Pic findPic(int oid, int qseq, int selseq, String path) {

		Pic pic=null;
		String sql = "select oid,qseq,selseq,path from wj_pic where oid = ? and qseq = ? and selseq = ? ";

		List list= this.getJdbcTemplate().queryForList(sql,new Object[]{oid,qseq,selseq});
		Iterator it=list.iterator();

		while(it.hasNext()){

			Map map=(Map)it.next();

			pic=new Pic();
			pic.setOid((Integer)(map.get("oid")));
			pic.setQseq((Integer)(map.get("qseq")));
			pic.setSelseq((Integer)(map.get("selseq")));
			pic.setPath((String)map.get("path"));

		}

		return pic;
	}


	@Override
	public List<Pic> findPicList(int oid, int qseq) {


		List<Pic> piclist=new ArrayList<Pic>();

		String sql = "select oid,qseq,selseq,path from wj_pic where oid = ? and qseq = ? ";

		List list= this.getJdbcTemplate().queryForList(sql,new Object[]{oid,qseq});
		Iterator it=list.iterator();

		while(it.hasNext()){

			Map map=(Map)it.next();

			Pic pic=new Pic();
			pic.setOid((Integer)(map.get("oid")));
			pic.setQseq((Integer)(map.get("qseq")));
			pic.setSelseq((Integer)(map.get("selseq")));
			pic.setPath((String)map.get("path"));

			piclist.add(pic);
		}


		return piclist;

	}


	@Override
	public int updatePic(int oid, int qseq, int selseq, String path) {

		String sql = "update wj_pic set path=? where oid = ? and qseq = ? and selseq = ?";

		int i = this.getJdbcTemplate().update(sql, new Object []{path,oid,qseq,selseq});

		return i;
	}

	@Override
	public void savaorUpdate(int oid, int qseq, int selseq, String path){
		if(findPic(oid,qseq,selseq,path)!=null){
			updatePic(oid,qseq,selseq,path);
		}else{
			addPic(oid,qseq,selseq,path);
		}
	}
}
