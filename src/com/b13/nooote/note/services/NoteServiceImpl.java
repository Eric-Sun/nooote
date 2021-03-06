package com.b13.nooote.note.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b13.nooote.core.ListenerSupport;
import com.b13.nooote.core.NoooteEvent;
import com.b13.nooote.core.NoooteEventDataObject;
import com.b13.nooote.core.NoooteEventType;
import com.b13.nooote.daos.NoteDAO;
import com.b13.nooote.dtos.NoteDTO;
import com.b13.nooote.exceptions.NoooteException;
import com.b13.nooote.html.HtmlValue;
import com.b13.nooote.utils.ObjectCvtWrapper;

@Service
public class NoteServiceImpl  implements NoteService {

	@Autowired
	NoteDAO noteDAO;
	@Autowired
	ListenerSupport listenerSupport;
	@Autowired
	NoteServiceHelper helper;
	
	public long create(long userId,String noteTitle, String noteContent) throws NoooteException {
		
		long noteId = noteDAO.insert(userId,noteTitle, noteContent);
		
		NoooteEvent evt = helper.makeListenerEvent(noteId, noteTitle, noteContent,NoooteEventType.CREATE_NOTE);
		listenerSupport.fireAllListeners(evt);
		return noteId;
	}
	
	
	public NoteDTO getNoteById(long noteId) {
		
		NoteDTO note = new NoteDTO();
		List<Object[]> noteList = noteDAO.getNoteById(noteId);
		Object[] noteObject = noteList.get(0);
		note.setNoteId(ObjectCvtWrapper.cvt2Long(noteObject[0]));
		note.setNoteTitle(ObjectCvtWrapper.cvt2String(noteObject[1]));
		note.setNoteContent(ObjectCvtWrapper.cvt2String(noteObject[2]));
		note.setNoteCreatetime(ObjectCvtWrapper.cvt2Date(noteObject[3]));
		note.setUserId(ObjectCvtWrapper.cvt2Long(noteObject[4]));
		
		return note;
	}

	public int getNoteListSize(long userId) {
		
		return noteDAO.getNoteSize(userId);
	}

	public List<NoteDTO> getNoteTitleList(long userId, int pageNum,
			int sizePerPage) {
		List<NoteDTO> returnList = new ArrayList<NoteDTO>();
		List<Object[]> noteList = noteDAO.getNoteTitles(userId, pageNum, sizePerPage);
		for( Object[] noteObject : noteList ){
			NoteDTO note = new NoteDTO();
			note.setNoteId(ObjectCvtWrapper.cvt2Long(noteObject[0]));
			note.setNoteTitle(ObjectCvtWrapper.cvt2String(noteObject[1]));
			note.setNoteCreatetime(ObjectCvtWrapper.cvt2Date(noteObject[2]));
			note.setUserId(ObjectCvtWrapper.cvt2Long(noteObject[3]));
			returnList.add(note);
		}
		return returnList;
	}
	
	public void modifyNote(long noteId, String noteTitle, String noteContent) throws NoooteException {
		
		noteDAO.modifyNote(noteId, noteTitle, noteContent);
		
		NoooteEvent evt = helper.makeListenerEvent(noteId, noteTitle, noteContent,NoooteEventType.MODIFY_NOTE);
		
		listenerSupport.fireAllListeners(evt);
		
	}


}
