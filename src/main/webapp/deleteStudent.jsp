<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deleteStudent</title>
</head>
 <form action="/redis/DeleteStudentServlet" method="post">
                    <div class="form-group" align="center">
                        <input type="text" name="id" placeholder="学号"><br/>
                        <button type="submit" value="提交">提交</button>
                    </div>                   
                </form>
</html>