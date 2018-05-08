
package com.biz.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.biz.driver.RedisUtil;
import com.biz.entity.Student;
import com.biz.services.StudentService;
import com.biz.util.Util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class StudentServiceImpl implements StudentService {
	private Jedis jedis;
	//获得连接
	public void getRedisConnecion() {
		
		jedis=RedisUtil.getJedis();
	}
	/*
	 * 
	 * 添加学生
	 * **/
	public Set<String> addStudent(Student student, Double score, String member) {
		//获取redis连接
				jedis = RedisUtil.getJedis();
				System.out.println("连接成功");
				
				//添加学生数据
				Long zadd = jedis.zadd("student", score, member);
				//返回这个set集合
				Set<String> zrange = jedis.zrange("student", 0, -1);
				
				return zrange;
	}
	
	/**
	 * 
	 * 查询学生
	 * */
	public List<Student> selectStudent(Student student) {

		//获取redis连接
		jedis = RedisUtil.getJedis();
		System.out.println("连接成功");
		
		//创建List来接受
		List<Student> list = new ArrayList<Student>();
		
		//遍历redis中的set集合，zrevrange返回有序集合中指定分数区域
		Set<String> set = jedis.zrevrange("student", 0, -1);
		int i = 0;
		for(Iterator iterator = set.iterator();iterator.hasNext();i++){
			
			String content = (String) iterator.next();
			Student spiltResult = Util.spiltResult(content);
			list.add(spiltResult);
			
		}
		for (Student student1 : list) {
			System.out.println(student1);
		}
		
		
		return list;
		
		
	}
	/**
	 * 
	 * 
	 * 删除学生
	 * */
	public void deleteStudent(String member) {
		jedis=RedisUtil.getJedis();
		 jedis.zrem("student", member);
		
	}
	
	/**
	 * 
	 * 根据页数查询学生
	 * */
	public List<Student> queryByPage(int pageNum) {
		
		 //建立list集合
		   List<Student> list = new ArrayList<Student>();
		   jedis = RedisUtil.getJedis();
		   Set<Tuple> set = jedis.zrevrangeWithScores("student", (pageNum-1)*10, pageNum*10-1);
		   int i=0;

		   for(Tuple t:set){
			   double score=t.getScore();
			   String member= t.getElement();
			   Student student2 = Util.spiltResult(member);
			   list.add(student2);
		   }
		   for(Student student1 : list)
		   {
			   System.out.println(student1);
			   
		   }
		   return list;
	}
		
	
}
