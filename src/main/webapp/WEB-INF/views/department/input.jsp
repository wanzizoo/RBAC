<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Insert title here</title>
</head>
<body>
<h3>部门编辑</h3>
<form action="/department/saveOrUpdate.do" method="post">
        <input type="hidden" name="id" value="${department.id}"/>
    名称:<input type="text" name="name" value="${department.name}"/><br/>
    编码:<input type="text" name="sn" value="${department.sn}"/><br/>
    <input type="submit" name="提交" />
</form>
</body>
