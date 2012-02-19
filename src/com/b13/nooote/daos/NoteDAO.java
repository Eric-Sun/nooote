package com.b13.nooote.daos;

import java.util.List;

public interface NoteDAO {
	
	/**
	 * 插入一个note
	 * @param noteTitle
	 * @param noteContent
	 * @return
	 */
	public long insert(long userId,String noteTitle,String noteContent);
	
	/**
	 * 获得一个note的详细信息
	 * @param noteId
	 * @return note_title,note_content,note_createtime,userId
	 */
	public List<Object[]> getNoteById(long noteId);
	
	
	/**
	 * 获得一个用户发布的所有的note的列表 分页
	 * @param pageNum 页码
	 * @param sizePerPage 每页的条数
	 * @return note_id,note_title,note_createtime,userId
	 */
	public List<Object[]> getNoteTitles(long userId,int pageNum,int sizePerPage);
	
	
	/**
	 * 获得一个用户发布的所有的note的总条数
	 * @param userId
	 * @return
	 */
	public int getNoteSize(long userId);
	
	
	/**
	 * 修改一个note
	 * @param noteId 主键用于更新
	 * @param noteTitle 如果传入为null，则不更新
	 * @param noteContent 如果传入为null，则不更新
	 */
	public void modifyNote(long noteId,String noteTitle,String noteContent);
	
	
}
