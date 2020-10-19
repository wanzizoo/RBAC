<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>首页</title>
    <%@include file="/WEB-INF/views/common/link.jsp" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/navbar.jsp" %>
    <!--菜单回显-->
    <c:set var="currentMenu" value="index"/>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>
    <div class="content-wrapper">
        <section class="content-header">
            <h4 STYLE="color: #0d6aad">欢迎使用客户管理系统~！</h4>
        </section>
        <section class="content">
            <div class="box">
                <p style="width: 100%;height: 45px;display: block;line-height: 45px;text-align: center;">
                    如您在使用中遇见任何问题，概不负责！</p>
            </div>

        </section>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</div>


</body>
</html>
