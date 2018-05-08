
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
	 * 分页
	 * */
	public static List<Student> queryByPage(int pageNum){
		
		List<Student> list=new ArrayList<Student>();
		Jedis jedis=RedisUtil.getJedis();
		Set<Tuple> set= jedis.zrevrangeWithScores("student", (pageNum-1)*10, pageNum*10-1);
		if(set!=null&&set.size()>0) {
			for(Tuple t:set) {
				double score=t.getScore();
				int avgscore=(int)score;
				String value=t.getElement();
				
				String[] values=value.split(",");
				
				
				Student student=new Student();
				student.setAvgscore(avgscore);
				student.setId(values[0]);
				student.setName(values[1]);
				student.setBirthday(values[2]);
				student.setDescription(values[3]);
				list.add(student);
			}
		}
		
		
		return list;
	}
	
	/**
	 * 
	 * 获取总页�?
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
