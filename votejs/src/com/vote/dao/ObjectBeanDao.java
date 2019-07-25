package com.vote.dao;

import java.util.List;

import com.vote.bean.ObjectBean;

public interface ObjectBeanDao {
	// 新建问卷
	public  int intsertObjectBean(ObjectBean bean) throws Exception ;

	// 修改问卷
	public  int updateObjectBean(ObjectBean bean);

	// 删除问卷
	public  boolean delObjectBean(int oid) throws Exception ;


	public  ObjectBean getObjectBean(int oid);


	//	 查看问卷;
	public  List ListObjectBean();

	public List ListObjectBeans();
	// 根据编号查找标题和内容
	public ObjectBean findObjectBeanByID(int ID);

	/**
	 * 查找发布后的问卷
	 * @param ID
	 * @return
	 */
	public  ObjectBean findPublishedObjectBeanByID(int ID);

	//查找问卷一共几条数据
	public  int getCount(int oid);
}
