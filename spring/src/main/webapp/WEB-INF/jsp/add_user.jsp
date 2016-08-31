<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<%--<form action="/jj/result" method="post">
    名字：<input type="text" name="name"><br/>
    年龄：<input type="number" name="age"><br/>
    <input type="submit" value="提交">
</form>--%>
<form:form action="result" method="post" modelAttribute="user">
    名字：<form:input path="name"/><br/>
    年龄：<form:input path="age"/><br/>
    <input type="submit">
</form:form>
</body>
</html>