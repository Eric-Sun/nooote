
//////////////////////////////////
// 静态变量
//////////////////////////////////
var defaultPageNum = 1;
var sizePerPage = 10;

/**
 * 登录的方法
 * @return
 */
function login(){
	var userMail = $('#userMail').val();
	var userPwd= $('#userPwd').val();
	$.ajax({
		type: "GET",
		url: "user/login.h",
		data: "userMail="+userMail+"&userPwd="+userPwd,
		dataType :"json",
		success: function(json){
			var url;
			if( json.result == 0 ){
				url="note/list.jsp";
			}else{
				alert("buok");
			}
			window.location.href=url;
		}
		});
}

/**
 * 获得note的列表
 * @return
 */
function loadNoteList(){
	
	var table = "<thead><tr><td class=\"title\">" +
			"标题&nbsp;</td><td class=\"date\">更新时间&nbsp;</td><td class=\"control\">操作&nbsp;</td>"+
					"</tr></thead><tbody>";
	$.ajax({
		type: "GET",
		url: "note/list.h",
		data: "pageNum="+defaultPageNum+"&sizePerPage="+sizePerPage,
		dataType :"json",
		success: function(rs){
			for( var i=0;i<rs.length;i++){
				table += "<tr>"+
						"<td class=\"title\"><a href=\"n/"+rs[i].noteId+".html\">"+rs[i].noteTitle+"</a>&nbsp;</td>"+
						"<td class=\"date\">"+new Date(rs[i].noteCreatetime).show()+"</td>"+
						"<td class=\"control\"><a href=\"#\">修改</a>&nbsp;</td>"+
					"</tr>";
			}
			table +="</tbody>";
			$("#noteList").html(table);
		},
		beforeSend : function(){
			$("#noteList").html("正在加载请稍后");
		}
		});
}
Date.prototype.show= function(){
	return this.getFullYear()+"-"+(this.getMonth()+1)+"-"+this.getDate()+" "+this.getHours()+":"+this.getMinutes()+":"+this.getSeconds();
}
/**
 * 上传note
 * @return
 */
function postNote(){
	var title = $('#noteTitle').val();
	var noteContent = editor.getData();
	$.ajax({
		type: "GET",
		url: "note/post.h",
		data: "noteTitle="+title+"&noteContent="+noteContent,
		dataType :"json",
		success: function(rs){
			if( rs.result == 0 ){
				// 上传成功了去列表页面
				window.location.href="note/list.jsp";
			}else{
				alert("post unsuccessfully");
			}
		},
		beforeSend : function(){
			$("#noteList").html("正在加载请稍后");
		}
		});
}


/**
 * 加载note
 * @return
 */
function loadNote4Modify(){
	var noteId = 7;
	$.ajax({
		type: "GET",
		url: "note/getNote.h",
		data: "noteId="+noteId,
		dataType :"json",
		success: function(rs){
			if( rs.result == 0 ){
				// 上传成功了去列表页面
				$("#noteTitle").html(rs.noteTitle);
				editor.setData(rs.noteContent);
			}
		},
		beforeSend : function(){
			$("#note").html("正在加载请稍后");
		}
		});
}

var editor ;
function loadEditor(){
	var html = '';
	var config = {};
	 editor = CKEDITOR.appendTo( 'editor', config, html );
}