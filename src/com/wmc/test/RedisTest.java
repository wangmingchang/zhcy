package com.wmc.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wmc.redis.RedisClientTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations="classpath:applicationContext-*.xml")
@ContextConfiguration("classpath:applicationContext.xml")
public class RedisTest {


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
	
	@Test
	public void testRedis3(){
		Long expire = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//RedisClientTemplate.getInstance().set("name4", "ABC");
		//expire = RedisClientTemplate.getInstance().expire("name", 10);
		//RedisUtils redisUtils = new RedisUtils();
		//long time = new Date().getTime();
		//RedisClientTemplate.getInstance().expireAt("name4", time+100);
		long surplusTime = RedisClientTemplate.getInstance().ttl("name4");
        long lt = new Long(surplusTime);
        Date date = new Date(lt);
       String res = simpleDateFormat.format(date);
       System.out.println("**************"+simpleDateFormat.format(new Date())+"************");;
		System.out.println("**************"+res+"************");;
		System.out.println(RedisClientTemplate.getInstance().get("name4")+"*********************");
	}
	
	@Test
	public void testRedis4(){
		RedisClientTemplate.getInstance().lpush("myList", "2123");
		RedisClientTemplate.getInstance().lpush("myList", "abc");
		RedisClientTemplate.getInstance().lpush("myList", "msl234");
		System.out.println("**************"+RedisClientTemplate.getInstance().llen("myList")+"************");;
		System.out.println(RedisClientTemplate.getInstance().lrange("myList", 0, -1) +"*********************");
	}
	
	
	
	
	
}
