package com.b13.nooote.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Resource(name="noooteJdbcTemplate")
	JdbcTemplate jdbcTemplate;

	public long exist(String userMail, String userPwd) {
		
		String sql = "select user_id from user where user_mail=? and user_password=?";
		
		List<Object[]> list = jdbcTemplate.query(sql, new Object[]{userMail,userPwd},  
				new RowMapper() {

					public Object[] mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Object[] o = new Object[1];
						o[0] = rs.getLong(1);
						return o;
					}
				});
		return (list==null || list.size()==0)?-1:(Long)list.get(0)[0];
	}

}
