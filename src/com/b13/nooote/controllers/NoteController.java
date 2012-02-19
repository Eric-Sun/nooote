package com.b13.nooote.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.multi.MultiFileChooserUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.b13.nooote.core.BaseControllerDTO;
import com.b13.nooote.dtos.NoteDTO;
import com.b13.nooote.note.services.NoteService;
import com.b13.nooote.utils.ResponseWritter;
import com.b13.nooote.utils.session.SessionUtil;

@Controller
@RequestMapping("/note")
public class NoteController  {
	@Autowired
	NoteService noteServ;
	
	/**
	 *  /note/post <p>
	 * 上传一个note<p>
	 * 请求：
	 * <pre>
	 * noteTitle	note的标题*
	 * noteContent	note的内容(fck)*
	 * userId		创建者用户id *
	 * </pre>
	 * 返回
	 * <pre>
	 * {
	 * 	"result":0	0成功1失败
	 * 	"noteId":3	note的id，用于主键索引
	 * }
	 * </pre>
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/post")
	public String post(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		String noteTitle = req.getParameter("noteTitle");
		String noteContent = req.getParameter("noteContent");
		long userId = (Long)new SessionUtil(req).get("userId");
		
		long noteId = noteServ.create(userId,noteTitle, noteContent);
		
		class NoteUDTO extends BaseControllerDTO{long noteId;

		public long getNoteId() {
			return noteId;
		}

		public void setNoteId(long noteId) {
			this.noteId = noteId;
		}}
		NoteUDTO d = new NoteUDTO();
		d.noteId = noteId;
		new ResponseWritter(resp).write(JSON.toJSONString(d)).end();
		return null;
	}
	
	/**
	 *  /note/getNote <p>
	 * 显示一个note的详细内容
	 * 请求：
	 * <pre>
	 * noteId	note的ID
	 * </pre>
	 * 返回:
	 * <pre>
	 * {
	 * 	"result":0	0成功1失败
	 * 	"noteContent":"b",	note的内容(fck)
	 * 	"noteCreatetime":1328630400000,	note的创建时间
	 * 	"noteId":2,	note的ID
	 * 	"noteTitle":"a", note的标题
	 * 	"userId":1	发布者ID
	 * }
	 * </pre>
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getNote")
	public String getNote(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		long noteId = new Long(req.getParameter("noteId"));
		NoteDTO n = noteServ.getNoteById(noteId);
		
		class NoteNDTO extends BaseControllerDTO{
			long noteId;
			String noteTitle;
			String noteContent;
			Date noteCreatetime;
			long userId;
			public long getUserId() {
				return userId;
			}
			public void setUserId(long userId) {
				this.userId = userId;
			}
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
		
		NoteNDTO ndto = new NoteNDTO();
		ndto.noteId = noteId;
		ndto.noteTitle = n.getNoteTitle();
		ndto.noteContent = n.getNoteContent();
		ndto.noteCreatetime = n.getNoteCreatetime();
		ndto.userId = n.getUserId();
		
		new ResponseWritter(resp).write(JSON.toJSONString(ndto)).end();
		return null;
	}
	
	/**
	 *  /note/list <p>
	 * 显示一个玩家发布的note的标题的列表
	 * 请求：
	 * <pre>
	 * userId	用户ID
	 * pageNum	页数
	 * sizePerPage	每页条数
	 * </pre>
	 * 返回
	 * <pre>
	 * [
	 * {
	 * 	"noteCreatetime":1328630400000,	note创建时间
	 * 	"noteId":1,	note的id
	 * 	"noteTitle":"a"},	note的标题
	 * 	{"noteCreatetime":1328630400000,"noteId":2,"noteTitle":"a"}
	 * ]
	 * </pre>
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		// 通过session获得userId
		// 限制必须是登录用户才可以获得
		long userId = (Long)new SessionUtil(req).get("userId");
		int pageNum = new Integer(req.getParameter("pageNum"));
		int sizePerPage = new Integer(req.getParameter("sizePerPage"));
		List<NoteDTO> nList = noteServ.getNoteTitleList(userId, pageNum, sizePerPage);
		class NoteLDTO{
			long noteId;
			String noteTitle;
			Date noteCreatetime;
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
			public Date getNoteCreatetime() {
				return noteCreatetime;
			}
			public void setNoteCreatetime(Date noteCreatetime) {
				this.noteCreatetime = noteCreatetime;
			}
		}
		
		List<NoteLDTO> returnList = new ArrayList<NoteLDTO>();
		for( NoteDTO noteDTO : nList ){
			NoteLDTO d = new NoteLDTO();
			d.noteCreatetime = noteDTO.getNoteCreatetime();
			d.noteId = noteDTO.getNoteId();
			d.noteTitle = noteDTO.getNoteTitle();
			returnList.add(d);
		}
		
		new ResponseWritter(resp).write(JSON.toJSONString(returnList)).end();
		return null;
	}
	
	/**
	 *  /note/listSize <p>
	 * 显示一个用户发布的note的总数
	 * 请求：
	 * <pre>
	 * userId	发布人的ID
	 * </pre>
	 * 返回:
	 * <pre>
	 * {
	 * 	"size":2	列表大小
	 * }
	 * </pre>
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listSize")
	public String listSize(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		long userId = new Long(req.getParameter("userId"));
		int size = noteServ.getNoteListSize(userId);
		class NoteListSizeDTO{
			long size;

			public long getSize() {
				return size;
			}

			public void setSize(long size) {
				this.size = size;
			}
		}
		NoteListSizeDTO d = new NoteListSizeDTO();
		d.size = size;
		new ResponseWritter(resp).write(JSON.toJSONString(d)).end();
		return null;
	}
	
	/**
	 * 上传文件
	 * 请求：
	 * <pre>
	 * fileName	文件内容
	 * file	form中的file类型的对象
	 * </pre>
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadFile")
	public String uploadFile(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		String fileName = req.getParameter("fileName");
		MultipartFile mpf = (MultipartFile)req.getAttribute("file");
		
		return null;
	}
	
	
	/**
	 *  /note/modify <p>
	 * 修改一个note
	 * 请求：
	 * <pre>
	 * noteId	note的id
	 * </pre>
	 * 返回:
	 * <pre>
	 * {
	 * 	"size":2	列表大小
	 * }
	 * </pre>
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	public String mofidy( HttpServletRequest req, HttpServletResponse resp ) throws Exception {
		
		long noteId = new Long(req.getParameter("noteId"));
		String noteTitle  = req.getParameter("noteTitle");
		String noteContent = req.getParameter("noteContent");
		noteServ.modifyNote(noteId, noteTitle, noteContent);
		class noteModifyDTO extends BaseControllerDTO{
		}
		noteModifyDTO d = new noteModifyDTO();
		new ResponseWritter(resp).write(JSON.toJSONString(d)).end();
		return null;
	}
}
