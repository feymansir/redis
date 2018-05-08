
package com.biz.services;

import java.util.List;
import java.util.Set;

import com.biz.entity.Student;

public interface StudentService {
	
	//获得redis连接
	public void getRedisConnecion();
	//增加学生
	public Set<String> addStudent(Student student,Double score, String member);
	//查询学生
	public List<Student> selectStudent(Student student);
	//删除学生
	public void deleteStudent(String member);
	
	
}
