package com.wmc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wmc.pojo.Student;
import com.wmc.redis.RedisClientTemplate;
import com.wmc.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations="classpath:applicationContext-*.xml")
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceTest {
	
	@Autowired
	private StudentService  studentService;
	
	

	@Test
	public void testAdd() throws Exception {
		Student student = new Student();
		student.setName("ccccc");
		student.setSex(1);
		student.setFatherName("cccccc");
		studentService.addStudent(student);
	}


	@Test
	public void testRedis(){
		Long expire = null;
		RedisClientTemplate.getInstance().set("name", "123123123");
		//expire = RedisClientTemplate.getInstance().expire("name", 10);
		//RedisUtils redisUtils = new RedisUtils();
		RedisClientTemplate.getInstance().del("name");
		System.out.println(RedisClientTemplate.getInstance().get("name")+"*********************");
	}
	@Test
	public void testRedis2(){
		ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		RedisClientTemplate redisUtils = (RedisClientTemplate) ac.getBean("redisClientTemplate");
		redisUtils.set("name3", "考敏123");
		System.out.println(redisUtils.get("name3")+"88888888888888888888888888");
		
	}
	
}
