package com.b13.nooote.dtos;

import java.util.Date;

public class NoteDTO {
	
	private long noteId;
	private String noteTitle;
	private long userId;
	private String userName;
	private String noteContent;
	private Date noteCreatetime;
	public long getNoteId() {
		return noteId;
	}
	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public Date getNoteCreatetime() {
		return noteCreatetime;
	}
	public void setNoteCreatetime(Date noteCreatetime) {
		this.noteCreatetime = noteCreatetime;
	}

}
