
package com.biz.util;

import com.biz.entity.Student;

public class Util {
	public static  Student spiltResult(String content){
		
		 Student student = new Student();
		  String[] arr = content.split(",");

		  student.setId(arr[0]);
		  student.setName(arr[1]);
		  student.setBirthday(arr[2]);
		  student.setDescription(arr[3]);
		return student;
		
		
	}
}
