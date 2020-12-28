package com.dao;

import com.bean.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

public class QueDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		
		this.template=template;
	}
	
	public  int save(Que q)
	{
		String sql="insert into question (que,op1,op2,op3,op4,c_ans ) values ('"+q.getQue()+"','"+q.getOp1()+"','"+q.getOp2()+"','"+q.getOp3()+"','"+q.getOp4()+"','"+q.getC_ans()+"')";
		System.out.println(sql);
		return template.update(sql);
	}
	
	public List<Que> getQuestion()
	{
		return template.query("select * from question", new RowMapper<Que>() {

			@Override
			public Que mapRow(ResultSet rs, int row) throws SQLException {
				Que e =new Que();
				e.setId(rs.getInt(1));
				e.setQue(rs.getString(2));
				e.setOp1(rs.getString(3));
				e.setOp2(rs.getString(4));
				e.setOp3(rs.getString(5));
				e.setOp4(rs.getString(6));
				
				
				return e;
			}
		});
	}
	public Que getElementById(int id)
	{
		String sql="select * from question where id=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Que>(Que.class));
	}
}
