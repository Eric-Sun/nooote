package com.b13.nooote.note.services;

import java.util.List;

import com.b13.nooote.dtos.NoteDTO;

public interface NoteService {

	/**
	 * 创建一个note
	 * @param userId 发布者ID
	 * @param noteTitle
	 * @param noteContent
	 * @return
	 */
	public long create(long userId,String noteTitle,String noteContent);
	
	/**
	 * 根据noteid获得note的内容
	 * @param noteId
	 * @return
	 */
	public NoteDTO getNoteById(long noteId);
	
	
	/**
	 * 获得note的标题的列表
	 * @param userId
	 * @param pageNum 页数
	 * @param sizePerPage 每页的条数
	 * @return
	 */
	public List<NoteDTO> getNoteTitleList(long userId,int pageNum, int sizePerPage);
	
	/**
	 * 获得note的总数
	 * @param userId
	 * @return
	 */
	public int getNoteListSize(long userId);
}
