package com.abd.JDBCDEMO.service;

import com.abd.JDBCDEMO.model.Student;
import com.abd.JDBCDEMO.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public StudentRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    private StudentRepo repo;
public void addStudent(Student student){
    repo.save(student);
}
public List<Student> getStudents(){
    return repo.findAll();
    }
}
