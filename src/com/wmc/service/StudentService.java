package com.wmc.service;

import com.wmc.pojo.Student;

public interface StudentService {
	
	String addStudent(Student student);

	Student getStudent(String name);

	/**
	 * 将图上保存到mongodb中
	 * @param path
	 */
	String uploadImage(String path);

	String showImg(String path);   
	
}
