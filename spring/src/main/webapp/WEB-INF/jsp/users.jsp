<%@ page import="com.jj.demo.springmvc.db.entity.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<ol>
   <%for (UsersEntity e:(List<UsersEntity>)request.getAttribute("users")){%>
       <li>名字：<%out.print(e.getName());%>，年龄:<%out.print(e.getAge());%></li>
   <%}%>
</ol>

<a href="/addUser">添加用户</a>
</body>
</html>