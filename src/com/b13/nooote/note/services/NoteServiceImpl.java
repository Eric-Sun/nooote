package com.b13.nooote.note.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b13.nooote.daos.NoteDAO;
import com.b13.nooote.dtos.NoteDTO;
import com.b13.nooote.utils.ObjectWrapper;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteDAO noteDAO;
	
	public long create(long userId,String noteTitle, String noteContent) {
		
		return noteDAO.insert(userId,noteTitle, noteContent);
		
	}
	
	public NoteDTO getNoteById(long noteId) {
		
		NoteDTO note = new NoteDTO();
		List<Object[]> noteList = noteDAO.getNoteById(noteId);
		Object[] noteObject = noteList.get(0);
		note.setNoteId(ObjectWrapper.cvt2Long(noteObject[0]));
		note.setNoteTitle(ObjectWrapper.cvt2String(noteObject[1]));
		note.setNoteContent(ObjectWrapper.cvt2String(noteObject[2]));
		note.setNoteCreatetime(ObjectWrapper.cvt2Date(noteObject[3]));
		note.setUserId(ObjectWrapper.cvt2Long(noteObject[4]));
		
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
			note.setNoteId(ObjectWrapper.cvt2Long(noteObject[0]));
			note.setNoteTitle(ObjectWrapper.cvt2String(noteObject[1]));
			note.setNoteCreatetime(ObjectWrapper.cvt2Date(noteObject[2]));
			note.setUserId(ObjectWrapper.cvt2Long(noteObject[3]));
			returnList.add(note);
		}
		return returnList;
	}

}
