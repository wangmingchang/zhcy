package com.wmc.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.Mongo;
import com.wmc.mapping.StudentMapper;
import com.wmc.pojo.Student;
import com.wmc.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private MongoTemplate mongoTemplate; 
	@Autowired
	private PhotoServiceImpl photoServiceImpl;

	@Override
	@Transactional
	public String addStudent(Student student) {
		 int rows = studentMapper.addStudent(student);
		 System.out.println("*******************************");
		 System.out.println("*******************************"); 
		 System.out.println("*******************************");
		 System.out.println("*****************"+rows+"*****************");
		 System.out.println("*******************************");
		 
		 System.out.println("*******************************"); 
		 System.out.println("*******************************");
		// System.out.println(1%0);
		 if(rows == 1){
			 return student.getId();
		 }else{
			 return null;
		 }
	}
	
	@Override
	public Student getStudent(String name){
		return studentMapper.getStudent(name);
	}
	
	public static void main(String[] args) {
		StudentService studentService = new StudentServiceImpl();
		Student student = new Student();
		student.setName("aaa");
		student.setSex(1);
		studentService.addStudent(student);
	}

	@Override
	public String uploadImage(String	path) {
        //连接服务器  
        Mongo mongo = null;
        String id = null;
		try {

			File file = new File(path);
			 id = photoServiceImpl.saveFile(file);
			
			
			System.out.println("****************"+id+"***************");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return id;
	}
	@Override
	public String showImg(String	path) {
	
		return path;
		
	}
}
