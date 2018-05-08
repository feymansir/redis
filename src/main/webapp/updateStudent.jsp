<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateStudent</title>
</head>
<body>
	 <form action="/redis/AddStudetServlet" method="post">
                    <div class="form-group" align="center" >
                       
                        <input type="text" name="id" placeholder="修改学号"><br/>
                        
                        <input type="text" name="name" placeholder="修改姓名"><br/>
                        <input type="text" name="birthday" placeholder="修改年龄"><br/>
                        <input type="text" name="description" placeholder="修改备注"><br/>
                       
                        <input type="text" name="avgscore" placeholder="修改平均分"><br/>
                        <button type="submit" value="提交">提交</button>
                    </div>
             
                    
                </form>
</body>
</html>