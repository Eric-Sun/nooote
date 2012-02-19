package com.b13.nooote.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.b13.nooote.core.BaseDAO;

@Repository
public class NoteDAOImpl extends BaseDAO implements NoteDAO {


	@Resource(name="noooteJdbcTemplate")
	JdbcTemplate j;
	
	public long insert( final long userId,final String noteTitle,  final String noteContent) {

		final String insert = "insert note(user_id,note_title,note_content,note_createtime) values(?,?,?,now())";
		KeyHolder holder = new GeneratedKeyHolder() ;
		j.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(insert);
				pstmt.setLong(1, userId);
				pstmt.setString(2, noteTitle);
				pstmt.setString(3, noteContent);
				return pstmt;
			}
		}, holder);
		return holder.getKey().longValue();
	}

	public List<Object[]> getNoteTitles(long userId, int pageNum,
			int sizePerPage) {
		
		String sql = "select note_id,note_title,note_createtime,user_id from note where user_id=? order by note_id desc ";
		sql += " limit "+ (pageNum-1)*sizePerPage+","+sizePerPage;

		return j.query(sql,new Object[]{userId},
				new RowMapper() {

					public Object[] mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Object[] o = new Object[4];
						o[0] = rs.getLong(1);
						o[1] = rs.getString(2);
						o[2] = new Date(rs.getTimestamp(3).getTime());
						o[3] = rs.getLong(4);
						return o;
					}
				});
	}

	public List<Object[]> getNoteById(long noteId) {
		
		String sql = "select note_id,note_title,note_content,note_createtime,user_id from note where note_id=? ";

		return j.query(sql,new Object[]{noteId},
				new RowMapper() {

					public Object[] mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Object[] o = new Object[5];
						o[0] = rs.getLong(1);
						o[1] = rs.getString(2);
						o[2] = rs.getString(3);
						o[3] = new Date(rs.getDate(4).getTime());
						o[4] = rs.getLong(5);
						return o;
					}
				});
	}
	


	public int getNoteSize(long userId) {
		
		String sql = "select count(1) from note where user_id=? ";

		List<Object[]> l = j.query(sql,new Object[]{userId},
				new RowMapper() {

					public Object[] mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Object[] o = new Object[1];
						o[0] = rs.getInt(1);
						return o;
					}
				});
		 return (l==null || l.size()==0)?0:(Integer)l.get(0)[0];
	}
	
	public void modifyNote(long noteId,String noteTitle,String noteContent){
		StringBuilder sb  = new StringBuilder();
		sb.append("update note set ");
		createUpdateSqlAfterSet(sb,"note_title","note_content");
		sb.append( " where note_id=?");
		String sql = sb.toString();
		
		j.update(sql, new Object[]{noteTitle,noteContent,noteId});
	}


}
