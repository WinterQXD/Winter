package com.vote.dao;

import java.util.List;

import com.vote.bean.Pic;

public interface UploadDao {
	public int addPic(int oid, int qseq, int selseq,String path) ;

	public int updatePic(int oid, int qseq, int selseq,String path);

	public List<Pic> findPicList(int oid, int qseq);

	public Pic findPic(int oid, int qseq, int selseq) ;

	public Pic findPic(int oid, int qseq, int selseq,String path);

	public void savaorUpdate(int oid, int qseq, int selseq, String string);
}
