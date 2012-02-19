package com.b13.nooote.html.listeners;

import java.io.File;
import java.util.Map;

import com.b13.nooote.core.NoooteEvent;
import com.b13.nooote.core.NoooteEventDataObject;
import com.b13.nooote.core.NoooteEventListener;
import com.b13.nooote.core.NoooteEventType;
import com.b13.nooote.core.SysConstant;
import com.b13.nooote.dtos.NoteDTO;
import com.b13.nooote.exceptions.HtmlGeneratorException;
import com.b13.nooote.exceptions.NoooteException;
import com.b13.nooote.html.HtmlGenerator;
import com.b13.nooote.html.HtmlGenreratorFactory;
import com.b13.nooote.utils.FileUtil;

/**
 * note的展示页面的监听器
 * <P>
 * 当修改或者添加的时候，需要重新生成
 * @author Eric
 *
 */
public class NotePageListener implements NoooteEventListener {
	
	private static String path = null;
	
	private HtmlGenerator gen;

	public void fire(NoooteEvent evt) throws NoooteException {
		gen =  HtmlGenreratorFactory.getGenerator();
		path =  SysConstant.templateFolder + File.separator + "show.html";
		String type = evt.getType();
		NoooteEventDataObject data = (NoooteEventDataObject)evt.getData();
		Map<String, String> valueMap = data.getValueMap();
		NoteDTO note = data.getNote();
		
		if( type.equals(NoooteEventType.CREATE_NOTE)  ){
			// 第一次创建note
			gen.gen(valueMap, path, SysConstant.noteHtmlFolder+File.separator+note.getNoteId()+".html");
		}else if( type.equals(NoooteEventType.MODIFY_NOTE) ){
			// 修改note
			// 删除源文件，重新生成
			FileUtil.delete(SysConstant.noteHtmlFolder+File.separator+note.getNoteId()+".html");
			gen.gen(valueMap, path, SysConstant.noteHtmlFolder+File.separator+note.getNoteId()+".html");
		}
	}

}
