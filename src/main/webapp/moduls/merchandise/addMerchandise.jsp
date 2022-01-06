<%--
  Created by IntelliJ IDEA.
  User: lsq_9
  Date: 2021/12/14
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.cg.slms.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%
    if (request.getAttribute("merchandise") == null) {
        Merchandise merchandise = new Merchandise();
        request.setAttribute("merchandise", merchandise);
    }
%>
<html>
<head>
    <base href="<%=basePath%>" />
    <title>商品档案</title>
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <script language="javascript" src="script/main.js"></script>
    <script language="javascript" src="script/calendar5.js"></script>
    <script type="text/javascript">
        var c = new Calendar("c");
        document.write(c);
    </script>
</head>
<body>

<p><font style="font-size:10pt">档案管理→商品档案→新增</font></p>
<%--@elvariable id="merchandise" type="com.cg.slms.domain.Merchandise"--%>
<form:form action="addMerchandiseAction" method="post" modelAttribute="merchandise">
    <table border="0" cellpadding="1" cellspacing="1" width="95%">
        <tr>
            <td align="right" width="10%" nowrap="nowrap">商品编号</td>
            <td width="20%">
                <form:input path="code" cssClass="TextInput"/><br></br>
                <form:errors path="code" ></form:errors>
            </td>
            <td align="right" width="10%" nowrap="nowrap">商品名称</td>
            <td width="20%">
                <form:input path="name" cssClass="TextInput"/>
                <br></br><form:errors path="name" ></form:errors>
            </td>
            <td align="right" width="10%" nowrap="nowrap">价格</td>
            <td width="20%">
                <form:input path="price" cssClass="TextInput"/>
                <br></br><form:errors path="price" ></form:errors>
            </td>
        </tr>
    </table>

    <p></p>
    <div style="margin-left: 30px; margin-right: 0px">
        <table border="0" cellpadding="0" cellspacing="0" width="95%">
            <tr>
                <td width="10%"><input type="submit" value="添加" class="BtnAction"/></td>
                <td width="10%"><input type="button" class="BtnAction" value="返回" onclick="history.go(-1);"/></td>
                <td width="80%">&nbsp;</td>
            </tr>
        </table>
    </div>
</form:form>
</body>
</html>
