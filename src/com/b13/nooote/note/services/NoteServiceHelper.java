package com.b13.nooote.note.services;

import org.springframework.stereotype.Service;

import com.b13.nooote.core.NoooteEvent;
import com.b13.nooote.core.NoooteEventDataObject;
import com.b13.nooote.core.NoooteEventType;
import com.b13.nooote.dtos.NoteDTO;
import com.b13.nooote.html.HtmlValue;

@Service
public class NoteServiceHelper {
	
	/**
	 * 创建跟nooote相关的事件数据
	 * @param noteId
	 * @param noteTitle
	 * @param noteContent
	 * @return
	 */
	public NoooteEvent makeListenerEvent(long noteId,String noteTitle, String noteContent,String noooteEventType){
		NoooteEventDataObject data = new NoooteEventDataObject();
		HtmlValue v = new HtmlValue();
		v.put("noteTitle", noteTitle);
		v.put("noteContent", noteContent);
		data.setValueMap(v);
		NoteDTO note = new NoteDTO();
		note.setNoteId(noteId);
		data.setNote(note);
		NoooteEvent evt = new NoooteEvent(noteId,noooteEventType,data);
		return evt;
	}

}
