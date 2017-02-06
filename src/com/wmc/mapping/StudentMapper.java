package com.wmc.mapping;

import org.springframework.stereotype.Repository;

import com.wmc.pojo.Student;
@Repository
public interface StudentMapper {
	
	int addStudent(Student student);

	Student getStudent(String name);

	int modifyStudent(Student student);

	int delStudent(String name);
}
