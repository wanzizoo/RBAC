<%--
  Created by IntelliJ IDEA.
  User: liufan
  Date: 2020/10/9
  Time: 10:30 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Insert title here</title>
</head>
<body>
<span style="color: red">${errorMsg}</span>
<form action="login.do" method="post">
    账号:<input type="text" name="username"/><br/>
    密码:<input type="password" name="password"/><br/>
    <input type="submit" value="登录">
</form>

</body>
</html>
