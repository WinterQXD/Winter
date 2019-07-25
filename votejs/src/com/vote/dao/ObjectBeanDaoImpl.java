package com.vote.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.vote.bean.ObjectBean;

public class ObjectBeanDaoImpl extends JdbcDaoSupport implements  ObjectBeanDao {

	@Override
	public List ListObjectBeans(){

		String sql = "select oid,title,createtime,state from wj_object where state in(1,2) order by oid desc";
		List list= this.getJdbcTemplate().queryForList(sql);
		Iterator it=list.iterator();

		List objList=new ArrayList();

		while(it.hasNext()){

			Map map=(Map)it.next();
			ObjectBean ob=new ObjectBean();
			int oid=(Integer)map.get("oid");
			String title=(String)map.get("title");
			java.sql.Timestamp createtime=(Timestamp)map.get("createtime");
			int state=(Integer)map.get("state");

			ob.setOid(oid);
			ob.setTitle(title);
			ob.setCreateTime(createtime);
			ob.setState(state);

			objList.add(ob);

		}

		return objList;
	}
	@Override
	public List ListObjectBean() {


		String sql = "select oid,title,createtime,state from wj_object order by oid desc";

		List list= this.getJdbcTemplate().queryForList(sql);
		Iterator it=list.iterator();

		List objList=new ArrayList();

		while(it.hasNext()){

			Map map=(Map)it.next();
			ObjectBean ob=new ObjectBean();
			int oid=(Integer)map.get("oid");
			String title=(String)map.get("title");
			java.sql.Timestamp createtime=(Timestamp)map.get("createtime");
			int state=(Integer)map.get("state");

			ob.setOid(oid);
			ob.setTitle(title);
			ob.setCreateTime(createtime);
			ob.setState(state);

			objList.add(ob);

		}

		return objList;
	}


	@Override
	public boolean delObjectBean(int oid) throws Exception {


		String sql1 = "delete from wj_object where oid=? ";
		String sql2 = "delete from wj_question where oid=? ";
		String sql3 = "delete from wj_replay where oid=? ";
		String sql4 = "delete from wj_answer where oid=? ";
		String sql5 = "delete from wj_selecter where oid=? ";

		this.getJdbcTemplate().update(sql1,new Object[]{oid});
		this.getJdbcTemplate().update(sql2,new Object[]{oid});
		this.getJdbcTemplate().update(sql3,new Object[]{oid});
		this.getJdbcTemplate().update(sql4,new Object[]{oid});
		this.getJdbcTemplate().update(sql5,new Object[]{oid});


		return true;
	}


	@Override
	public ObjectBean findObjectBeanByID(int ID) {



		String sql = "select oid,title,discribe,state,anonymousFlag from wj_object where oid=? ";

		List list= this.getJdbcTemplate().queryForList(sql,new Object [] {ID});
		Iterator it=list.iterator();
		ObjectBean ob=new ObjectBean();
		while(it.hasNext()){
			Map map=(Map)it.next();
			int oid =(Integer) map.get("oid");
			String title = (String)map.get("title");
			String discribe =(String) map.get("discribe");
			String anonymousFlag = (String)map.get("anonymousFlag");
			int state=(Integer)map.get("state");


			ob.setOid(oid);
			ob.setState(state);
			ob.setTitle(title);
			ob.setDiscribe(discribe);
			ob.setAnonymousFlag(anonymousFlag);
		}



		return ob;
	}


	@Override
	public ObjectBean findPublishedObjectBeanByID(int ID) {


		String sql = "select oid,title,discribe,state,anonymousFlag from wj_object where oid=? and state in(1,2)";
		//	System.out.println("查询发布后的主题： "+sql);

		List list= this.getJdbcTemplate().queryForList(sql,new Object []{ID});
		Iterator it=list.iterator();
		ObjectBean ob=new ObjectBean();
		while(it.hasNext()){
			Map map=(Map)it.next();
			int oid =(Integer) map.get("oid");
			String title = (String)map.get("title");
			String discribe =(String) map.get("discribe");
			String anonymousFlag = (String)map.get("anonymousFlag");
			int state=(Integer)map.get("state");


			ob.setOid(oid);
			ob.setState(state);
			ob.setTitle(title);
			ob.setDiscribe(discribe);
			ob.setAnonymousFlag(anonymousFlag);
		}

		return ob;
	}


	@Override
	public int getCount(int oid) {

		int count=0;
		String sql = "select count(*) from wj_question where oid = ? ";

		count=this.getJdbcTemplate().queryForInt(sql,new Object []{oid});

		return count;
	}


	@Override
	public ObjectBean getObjectBean(int oid) {

		String sql = " select * from wj_object where oid=? ";
		//	System.out.println(sql);
		ObjectBean ob = null;
		List list= this.getJdbcTemplate().queryForList(sql,new Object []{oid});
		Iterator it=list.iterator();
		while (it.hasNext()) {
			Map map=(Map)it.next();
			String title =(String) map.get("title");
			ob = new ObjectBean();
			ob.setOid(oid);
			ob.setTitle(title);
		}

		return ob;
	}


	@Override
	public int intsertObjectBean(ObjectBean bean) throws Exception {

		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		String sql = "insert into wj_object(title,discribe,createtime,state,remark,anonymousFlag) values(?,?,?,?,?,?)";
		//	System.out.println(sql);

		this.getJdbcTemplate().update(sql, new Object[]{bean.getTitle(),bean.getDiscribe(),currentTime,bean.getState(),bean.getRemark(),bean.getAnonymousFlag()});


		return 1;
	}


	@Override
	public int updateObjectBean(ObjectBean bean) {


		String sql1 = "update wj_object set title = ?,discribe = ?,anonymousFlag = ? " +
				" where oid=? ";

		int i =  this.getJdbcTemplate().update(sql1, new Object[] {bean.getTitle(),bean.getDiscribe(),bean.getAnonymousFlag(),bean.getOid()});
		return i;

	}



}
