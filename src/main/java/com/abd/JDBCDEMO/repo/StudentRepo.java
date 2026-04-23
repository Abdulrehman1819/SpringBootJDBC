package com.abd.JDBCDEMO.repo;

import com.abd.JDBCDEMO.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        int rows=jdbcTemplate.update(sql,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(rows+"Effected");
        System.out.println("Added");
    }

    public List<Student> findAll() {
         List<Student> s= new ArrayList<>();
        System.out.println("These are the students");
        return s;
    }
}
