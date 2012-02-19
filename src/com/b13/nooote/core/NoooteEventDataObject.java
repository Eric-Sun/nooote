package com.b13.nooote.core;

import java.util.Map;

import com.b13.nooote.dtos.NoteDTO;

public class NoooteEventDataObject {
	
	private Map<String, String> valueMap;
	private NoteDTO note;
	public Map<String, String> getValueMap() {
		return valueMap;
	}
	public void setValueMap(Map<String, String> valueMap) {
		this.valueMap = valueMap;
	}
	public NoteDTO getNote() {
		return note;
	}
	public void setNote(NoteDTO note) {
		this.note = note;
	}

}
