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
		String pageNum1 = request.getParameter("pageNum");
		System.out.println(pageNum1);
		//判断当前页码是否为空
		int pageNum = 1;
		if(pageNum1 != null && !pageNum1.trim().equals("")){
			pageNum = Integer.parseInt(pageNum1);
		}
		List<Student> students = PageUtil.queryByPage(pageNum);
		//获得当前�?大页码数
		long maxPageNum = PageUtil.getPageNum();
		
		//获得页数
			request.setAttribute("current",pageNum);//当前�?
			System.out.println(pageNum);
			request.setAttribute("selectStudent", students);//集合
			request.setAttribute("maxPageNum", maxPageNum);//�?大页
			System.out.println(maxPageNum);
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
