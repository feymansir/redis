package com.biz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.entity.Student;
import com.biz.service.impl.StudentServiceImpl;
import com.biz.services.StudentService;
import com.biz.util.PageUtil;

/**
 * Servlet implementation class SelectStudentServlet
 */
public class SelectStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取pageNum参数
		String pageNum = request.getParameter("pageNum");
		System.out.println(pageNum);
		//判断当前页码是否为空
		int pageNum1 = 1;
		if(pageNum != null && !pageNum.trim().equals("")){
			pageNum1 = Integer.parseInt(pageNum);
		}
		
		//调用业务方法
		//调用服务类
		StudentService studentService  = new StudentServiceImpl();
		List<Student>  list = studentService.queryByPage(pageNum1);
		
		//获得当前大页码数
		long maxPageNum = PageUtil.getPageNum();
		//获得页数
			request.setAttribute("current",pageNum1);//当前页码
			System.out.println(pageNum);
			request.setAttribute("selectStudent", list);//集合
			request.setAttribute("maxPageNum", maxPageNum);//最大大页
			System.out.println(maxPageNum);
		//重新再查询
			/*Student student = new Student();
			List<Student> selectStudent1 = studentService.selectStudent(student);
			request.setAttribute("reSelect", selectStudent1);*/
			
			//request.setAttribute("selectStudent", students);
			//request.getRequestDispatcher("student.jsp").forward(request, response);
			
			//response.sendRedirect("student.jsp?pageNum="+pageNum);
			request.getRequestDispatcher("student.jsp").forward(request, response);
			//request.getRequestDispatcher("student.jsp?pageNum="+pageNum).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
