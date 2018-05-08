package com.biz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.entity.Student;
import com.biz.service.impl.StudentServiceImpl;
import com.biz.services.StudentService;

/**
 * 更新学生信息
 */
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService = new StudentServiceImpl();
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求字符集编�?
		request.setCharacterEncoding("UTF-8");
		//接收客户端的参数
		//将String型转换为int
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		
		String name = request.getParameter("name");
		//将时间类型进行转�?
		String birthday = request.getParameter("birthday");
		
		String description = request.getParameter("description");
		
		//将获取的客户端数据进行封�?
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setBirthday(birthday);
		student.setDescription(description);

		//将其数据拼接起来
		String member = id+","+name+","+birthday+","+description;
		
		//调用业务
		StudentServiceImpl studentService = new StudentServiceImpl();
		studentService.deleteStudent(member);
		response.sendRedirect("updateStudent.jsp");
		
	}

}
