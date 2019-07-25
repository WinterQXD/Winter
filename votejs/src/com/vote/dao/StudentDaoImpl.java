package com.vote.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.vote.bean.TblStudentEntity;

public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {

	@Override
	public TblStudentEntity findStu(String s, String s2, String bjdm,
			String njdm , String xxdm) {
		TblStudentEntity stu = null;
		String xjh="";
		s.length();
		int size=19;
		/*for (int i=0;i<size-s.length();i++){
			xjh+="_";
		}*/
		xjh="%"+s+"%";
		System.out.println(xjh);
		String sql = "select id,xxmc,xjh,njdm,bjdm,xm from tbl_student where  xm='"+s2+"' "+
				"and bjdm='"+bjdm+"' and njdm='"+njdm+"' and xxdm='"+xxdm+"' and xnm='2017' ";
		System.out.println(sql);
		List list = this.getJdbcTemplate().queryForList(sql,
				new Object[] { });
		Iterator it = list.iterator();

		while (it.hasNext()) {

			Map map = (Map) it.next();

			stu = new TblStudentEntity();
			stu.setId((String) map.get("id"));
			stu.setXxmc((String) map.get("xxmc"));
			stu.setNjdm((String) map.get("njdm"));
			stu.setXjh((String) map.get("xjh"));
			stu.setBjdm((String) map.get("bjdm"));
			stu.setXm((String) map.get("xm"));
		}

		return stu;
	}

	@Override
	public String findGrade(String njdm) {
		String str = null;
		String sql = "select njmc from tbl_grade where njdm=? ";
		//System.out.println(sql);

		List list = this.getJdbcTemplate().queryForList(sql,
				new Object[] { njdm });
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Map map = (Map) it.next();
			str = (String) map.get("njmc");
		}
		return str;
	}

	@Override
	public List findSchool() {
		List schlist =new ArrayList();
		String sql = "select xxmc,xxdm,xxjc from tbl_schoolinfo where xxlbm not in (11,111,91,81) ";
		//System.out.println(sql);
		List list = this.getJdbcTemplate().queryForList(sql);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Map map = (Map) it.next();
			schlist.add(map);
		}
		return schlist;
	}

}
