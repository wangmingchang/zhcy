package com.wmc.dao;

import java.util.List;

import com.wmc.pojo.Student;

public interface StudentMapper {
	
	int addStudent(Student student);

	Student getStudent(String name);

	int modifyStudent(Student student);

	int delStudent(String name);
	
	List<Student> list();
}
