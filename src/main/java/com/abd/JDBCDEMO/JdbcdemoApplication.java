package com.abd.JDBCDEMO;

import com.abd.JDBCDEMO.model.Student;
import com.abd.JDBCDEMO.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class JdbcdemoApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(JdbcdemoApplication.class, args);
		Student student=context.getBean(Student.class);
		student.setMarks(20);
		student.setName("Abdulrehman");
		student.setRollNo(544);
		StudentService service=context.getBean(StudentService.class);
		service.addStudent(student);
		List<Student> s=service.getStudents();
		System.out.println("Students are"+s);
	}

}
