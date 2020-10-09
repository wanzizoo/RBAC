<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Insert title here</title>
</head>
<body>
<h3>部门列表</h3>
<a href="/department/input.do">新增</a>
<table width="70%" cellpadding="5" cellspacing="0" border="1">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>编码</th>
        <th>编辑</th>
    </tr>
    <c:forEach items="${list}" var="d">
        <tr align="center">
            <td>${d.id}</td>
            <td>${d.name}</td>
            <td>${d.sn}</td>
            <td>
                <a href="/department/delete.do?id=${d.id}">删除</a>
                <a href="/department/input.do?id=${d.id}">编辑</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
