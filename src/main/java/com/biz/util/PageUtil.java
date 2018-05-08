
package com.biz.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.biz.driver.RedisUtil;
import com.biz.entity.Student;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class PageUtil {
	
	/**
	 * 
	 * 根据页码查询学生
	 * */
	public static List<Student> queryByPage(int pageNum){
		
		List<Student> list=new ArrayList<Student>();
		Jedis jedis=RedisUtil.getJedis();
		Set<Tuple> set= jedis.zrevrangeWithScores("student", (pageNum-1)*10, pageNum*10-1);
		if(set!=null&&set.size()>0) {
			for(Tuple t:set) {
				 double score=t.getScore();
				   String member= t.getElement();
				   Student student2 = Util.spiltResult(member);
				   list.add(student2);
			   }
			   for(Student student1 : list)
			   {
				   System.out.println(student1);
				   
			   }
			  
		}
		return list;
	
	}
	
	/**
	 * 
	 * 获取总页数
	 * */
	public static long getPageNum() {
		Jedis jedis=RedisUtil.getJedis();
		long number=jedis.zcard("student");
		long p=0L;
		if(number%10==0) {
			p=number/10;
		}else {
			p=number/10+1;
		}
		return p;
	}

}
