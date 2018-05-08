package com.biz.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.entity.Student;
import com.biz.service.impl.StudentServiceImpl;
import com.biz.services.StudentService;
import com.biz.util.Util;

/**
 * 添加学生的servlet
 */
public class AddStudetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private StudentService studentService = new StudentServiceImpl();
	 private Util util;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求字符集编
		request.setCharacterEncoding("UTF-8");
		//接收客户端的参数
		//将String型转换为int
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		
		String birthday = request.getParameter("birthday");
		
		String description = request.getParameter("description");
		
		//将avgscore变为score
		String avgscore = request.getParameter("avgscore");
		
		//将获取的客户端数据进行封装
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setBirthday(birthday);
		student.setDescription(description);
		
		//将其数据拼接起来
		String member = id+","+name+","+birthday+","+description;
		
		//添加学生
		Set<String> addStudent = studentService.addStudent(student, Double.parseDouble(avgscore), member);
		 //查询全部学生
		List<Student> selectStudent = studentService.selectStudent(student);
		 
		 
		//响应字符集编�?
		response.setCharacterEncoding("UTF-8");
		//httpsession使用
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("selectStudent", selectStudent);
		
		//重定向到student.jsp
		 response.sendRedirect("SelectStudentServlet");
	}

}
