package com.abd.JDBCDEMO.repo;

import com.abd.JDBCDEMO.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;
    private Student s;
    public void save(Student s){
        String sql="insert  into student (rollno,name,marks) values(?,?,?)";
        System.out.println("Students got for inserting"+s.getName()+s.getMarks()+s.getRollNo());
        int rows=jdbcTemplate.update(sql,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(rows+"Effected");
        System.out.println("Added");
    }

    public List<Student> findAll() {
         List<Student> s= new ArrayList<>();
        String sql="Select * from student";
        RowMapper<Student> mapper=new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s=new Student();
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }
        };
        return jdbcTemplate.query(sql,mapper);
    }
}
