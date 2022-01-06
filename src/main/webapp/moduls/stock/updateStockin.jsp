<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/12/10
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.cg.slms.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>" />
    <title>进货管理</title>
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <script language="javascript" src="script/main.js"></script>
    <script language="javascript" src="script/calendar5.js"></script>
    <script type="text/javascript">
        var c = new Calendar("c");
        document.write(c);
    </script>
</head>
<body>

<p><font style="font-size:10pt">进货管理→修改</font></p>
<%--@elvariable id="stockin" type="com.cg.slms.domain.Stockin"--%>
<form:form action="updatestockinAction" method="post" modelAttribute="stockin">
    <table border="0" cellpadding="1" cellspacing="1" width="95%">
        <tr>
            <td align="right" width="10%" nowrap="nowrap">订单编号</td>
            <td width="20%">
                <form:input path="code" cssClass="TextInput"/><br></br>
                <form:errors path="code" ></form:errors>
            </td>
            <td align="right" width="10%" nowrap="nowrap">客户编号</td>
            <td width="20%">
                <form:input path="client.id" cssClass="TextInput"/><br></br>
                <form:errors path="client.id" ></form:errors>
            </td>
            <td align="right" width="10%" nowrap="nowrap">商品编号</td>
            <td width="20%">
                <form:input path="merchandise.id" cssClass="TextInput"/><br></br>
                <form:errors path="merchandise.id" ></form:errors>
            </td>
            <td align="right" width="10%" nowrap="nowrap">订货数量</td>
            <td width="20%">
                <form:input path="amount" cssClass="TextInput"/><br></br>
                <form:errors path="amount" ></form:errors>
            </td>
            <td align="right" width="10%" nowrap="nowrap">日期</td>
            <td width="20%">
                <form:input path="stockindate" cssClass="TextInput"/><br></br>
                <form:errors path="stockindate" ></form:errors>
            </td>
            <td align="right" width="10%" nowrap="nowrap">经手人</td>
            <td width="20%">
                <form:input path="employee.id" cssClass="TextInput"/><br></br>
                <form:errors path="employee.id" ></form:errors>
            </td>


        </tr>
    </table>

    <p></p>
    <div style="margin-left: 30px; margin-right: 0px">
        <table border="0" cellpadding="0" cellspacing="0" width="95%">
            <tr>
                <td width="10%"><input type="submit" value="保存" class="BtnAction"/></td>
                <td width="10%"><input type="button" class="BtnAction" value="返回" onclick="history.go(-1);"/></td>
                <td width="80%">&nbsp;</td>
            </tr>
        </table>
    </div>
</form:form>
</body>
</html>
