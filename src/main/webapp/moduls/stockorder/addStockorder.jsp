<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/12/10
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
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
    if (request.getAttribute("stockorder") == null) {
        Stockorder stockorder = new Stockorder();
        request.setAttribute("stockorder", stockorder);
        stockorder.setMerchandise(new Merchandise());
        stockorder.setClient(new Client());
        stockorder.setEmployee(new Employee());
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
<jsp:useBean id="command" class="com.cg.slms.domain.Stockorder" scope="request" ></jsp:useBean>
<p><font style="font-size:10pt">销售管理→订货</font></p>
<%--@elvariable id="stockorder" type="com.cg.slms.domain.Stockorder"--%>
<form:form action="addStockorderAction" method="post" modelAttribute="stockorder">
    <table border="0" cellpadding="1" cellspacing="1" width="95%">
        <tr>
            <td align="right" width="10%" nowrap="nowrap">订单编号</td>
            <td width="20%">
                <form:input path="code" cssClass="TextInput"  value=" "/><br></br>
                <form:errors path="code" ></form:errors>
            </td>
            <td align="right" width="10%" nowrap="nowrap">客户编号</td>
            <td width="20%">
                <form:input path="client.id" cssClass="TextInput"  value=" "/><br></br>
                <form:errors path="client.id" ></form:errors>
            </td>
            <td align="right" width="10%" nowrap="nowrap">商品编号</td>
            <td width="20%">
                <form:input path="merchandise.id" cssClass="TextInput"  value=" "/><br></br>
                <form:errors path="merchandise.id" ></form:errors>
            </td>
            <td align="right" width="10%" nowrap="nowrap">订货数量</td>
            <td width="20%">
                <form:input path="merchandisenumber" cssClass="TextInput"  value=" "/><br></br>
                <form:errors path="merchandisenumber" ></form:errors>
            </td>
        </tr>
        <tr>
            <td align="right" width="10%" nowrap="nowrap">日期</td>
            <td width="20%">
                <form:input path="orderdate" cssClass="TextInput"/><br></br>
                <form:errors path="orderdate" ></form:errors>
            </td>
            <td align="right" width="10%" nowrap="nowrap">经手人</td>
            <td width="20%">
                <form:input path="employee.id" cssClass="TextInput" value=" "/><br></br>
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