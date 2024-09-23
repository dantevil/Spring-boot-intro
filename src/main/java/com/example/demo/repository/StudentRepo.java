package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public class StudentRepo {

public JdbcTemplate getJdbc() {
		return jdbc;
	}

	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

private JdbcTemplate jdbc;

	public void save(Student st) {
		String sql = "insert into student (rollno,name,marks) values (?,?,?)";
		int rows = jdbc.update(sql,st.getRoll_no(),st.getName(),st.getMarks());
		System.out.println("print rows affected" + rows);
		
	}
	
	public List<Student> findAll() {
			String sql = "select * from student";
			
			RowMapper<Student> mapper = new RowMapper<Student>() {

				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					
					Student s = new Student();
					s.setRoll_no(rs.getInt("rollno"));
					s.setName(rs.getString("name"));
					s.setMarks(rs.getInt("marks"));
					
					return s;
				}
					};
			return jdbc.query(sql,mapper);
	}
}
