<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.*"  %>
 <%@page import="com.biz.entity.Student" %>
 <%@page import="javax.servlet.http.HttpSession" %>
 <%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#first").click(function(){
	
		 var currPage=$("#currPage").val();
		
		if(currPage==1){
			alert("已经是第一页了");
		} else{
			
			$("#first").attr("href","SelectStudentServlet?pageNum=1");
			
		}
			
	}); 
	
	
	$("#before").click(function(){
		
		var currPage=$("#currPage").val();
		
		if(currPage<=1||currPage==null)
		{
			alert("已经是第一页了");
			}else{
				currPage--;
				$("#before").attr("href","SelectStudentServlet?pageNum="+currPage);
			}
	});
	
	
	$("#after").click(function(){
		var currPage=$("#currPage").val();
		var maxPage = $("#sumPage").val();
		
		if(currPage>=maxPage||currPage==null){
			alert("已经最后一页");
		}else{
			alert(currPage);
			currPage++;
			alert(currPage);
			/* window.location.href="/SelectStudentServlet?pageNum="+currPage;
 */			$("#after").attr("href","SelectStudentServlet?pageNum="+currPage);
		}
	});
	
	$("#choose").click(function(){
		var mychoose = document.getElementById("input").value;
		alert(mychoose);
	});
});
</script>
</head>
<body>		
		<table border="1px" align="center" width="80%" cellspacing="0">
						
					 <tr>
					 	<td colspan="8"><h1 align="center">学生管理系统</h1></td>
					 </tr>
				        <tr >
				        	<td >id</td>
				            <td >name</td>
				            <td >birthday</td>
				            <td >description</td>
				            <td >avgscore</td>
				            <td><input type="button" value="添加" onclick="window.location.href='addStudent.jsp'" /></td>
				            <td><input type="submit" value="修改" /></td>
				            <td><a href="#">删除</a></td>
				        </tr>
				      

		<%
			List<Student> list = (List<Student>)session.getAttribute("selectStudent");
			Integer currentPage =(Integer)request.getAttribute("current");
			Long maxPage =(Long) request.getAttribute("maxPageNum");
			
			//判断是否为空
			if(list != null){
				for(int i = 0 ; i < list.size() ; i++){
					 Student student = list.get(i);
			%>
					 
					 
				        <tr >
				        	<td><%=student.getId() %></td>
				            <td ><%= student.getName() %></td>
				            <td ><%= student.getBirthday() %></td>
				            <td ><%= student.getDescription() %></td>
				            <td ><%= student.getAvgscore() %></td>
				            <td><input type="button" value="添加" onclick="window.location.href='addStudent.jsp'" /></td>
				            <td><input type="button" value="修改" onclick="window.location.href='UpdateStudentServlet?id=<%=student.getId() %>&name=<%= student.getName() %>&birthday=<%= student.getBirthday() %>&description=<%= student.getDescription() %>' " /></td>
				            <td><a href="DeleteStudentServlet?id=<%=student.getId() %>&name=<%= student.getName() %>&birthday=<%= student.getBirthday() %>&description=<%= student.getDescription() %>">删除</a></td>
				        </tr>
				        
				       
				   
			<%
			}
		}
			%>
			
			 			<tr>
				 			<td ><a id="first" href="">首页</a>&nbsp;</td>
				 			<td ><a id="before" href="">上一页</a>&nbsp;</td>
				 			<td ><a id="after" href="">下一页</a>&nbsp;</td>
				 			<td ><a id="last" href="">尾页</a>&nbsp;</td>
				        <td><a href="" id="last">尾页</a></td>
  						<td>
  						总页数：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="sumPage" readonly value="<%=maxPage %>"/></br>
  						当前页数：<input type="text" id="currPage"  readonly="value" value="<%=currentPage %>"/>
  						</td>
  						<td><input type ="text" id="input" placeholder="请输入您想跳转的界面" ></td>
  						<td><a href="" id="choose">跳转</a></td>
  						</tr>
			
			 </table>
			
</body>
</html>