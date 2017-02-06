package com.wmc.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wmc.pojo.Student;
import com.wmc.service.StudentService;
import com.wmc.service.impl.PhotoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations="classpath:applicationContext-*.xml")
@ContextConfiguration("classpath:applicationContext.xml")
public class MonogDBTest {
	
	@Autowired
	private StudentService  studentService;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private PhotoServiceImpl photoServiceImpl;
	
	

	@Test
	public void testAdd() throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
		String d = sdf.format(date);
		String randomUUID = d+UUID.randomUUID().toString().replaceAll("\\-", "");
		Student student = new Student();
		student.setId(randomUUID);
		student.setName("李明");
		student.setSex(1);
		mongoTemplate.insert(student);
		//201701072345034537050a4448fa64e19858274c54686c66d
		System.out.println("****************"+randomUUID+"***********");
		
	//	MongodbClientTemplate.getInstance().save(student);
	}


	@Test
	public void testGET() throws Exception {
		String id = mongoTemplate.getCollectionName(Student.class);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
		String d = sdf.format(date);
		String randomUUID = d+UUID.randomUUID().toString().replaceAll("\\-", "");
		System.out.println("**********"+d+"**********");
		System.out.println("**********"+randomUUID+"**********");
	//	MongodbClientTemplate.getInstance().save(student);
	}

	@Test
	public void testGET2() throws Exception {
		String id = "201701072345034537050a4448fa64e19858274c54686c66d";
		Student s = mongoTemplate.findById(id, Student.class);		
		
		System.out.println("**************"+s+"**************");
	}
	
	@Test
	public void testGET3() throws Exception {
		
		boolean flag = photoServiceImpl.deleteFile("17e9b76ca5b640dca2f26cce8142dab8");
		System.out.println("***************"+flag);
	}
	
}
