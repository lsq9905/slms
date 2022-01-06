<%--
  Created by IntelliJ IDEA.
  User: lsq_9
  Date: 2021/12/14
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.cg.slms.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%
    if (request.getAttribute("client") == null) {
        Client client = new Client();
        request.setAttribute("client", client);
    }
%>

<html>
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>员工档案</title>
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <script language="javascript" src="script/main.js"></script>
    <script language="javascript">
        function deleteRecord(url) {
            if (window.confirm("确定要删除选中的记录吗？")) {
                window.location=url;
            }
        }
    </script>
</head>
<body>

<p><font style="font-size: 10pt;">档案管理→客户档案</font></p>

<%--@elvariable id="client" type="com.cg.slms.domain.Client"--%>
<form:form action="clientAction" method="post" modelAttribute="client">
    <table border="0" cellpadding="1" cellspacing="1" width="95%">
        <tr>
            <td align="right" width="10%">客户编号</td>
            <td width="20%"><form:input path="code" cssClass="TextInput"></form:input></td>
            <td align="right" width="10%">客户姓名</td>
            <td width="20%"><form:input path="name" cssClass="TextInput"></form:input></td>
            <td width="40%">&nbsp;</td>
        </tr>
        <tr>
            <td align="right" width="10%">&nbsp;</td>
            <td width="20%">&nbsp;</td>
            <td width="70%" colspan="5">&nbsp;</td>
        </tr>
    </table>

    <p></p>
    <div style="margin-left: 30px; margin-right: 0px">
        <table border="0" cellpadding="0" cellspacing="0" width="95%">
            <tr>
                <td width="10%"><input type="submit" value="查找"
                                       Class="BtnAction" /></td>
                <td width="10%"><input type="button" class="BtnAction"
                                       value="新增" onClick="location='http://localhost:8080/moduls/client/addClient.jsp'"></td>
                <td width="10%"><input type="button" onClick="" value="删除"
                                       class="BtnAction" /></td>
                <td width="10%"><input type="reset" value="重置" class="BtnAction" /></td>
                <td width="60%">&nbsp;</td>
            </tr>
        </table>
    </div>

    <p></p>

    <div style="margin-left: 30px; margin-right: 0px">
        <table width="90%" border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td width="5%" class="td_title">删除</td>
                <td width="5%" class="td_title">修改</td>
                <td width="10%" class="td_title">客户编号</td>
                <td width="15%" class="td_title">客户姓名</td>
                <td width="15%" class="td_title">地址</td>
                <td width="19%" class="td_title">电话</td>
                <td width="15%" class="td_title">Email</td>
            </tr>
            <c:if test="${!empty requestScope.clients}">
                <c:forEach items="${requestScope.clients}" var="emp">
                    <tr>
                        <td class="td_border" align="center">
                            <a href="javascript:deleteRecord('deleteClientByIdAction?id=${emp.id}')">
                                <img src="image/wrong.gif" border="0"/>
                            </a>
                        </td>
                        <td class="td_border" align="center">
                            <a href="findClientByIdAction?id=${emp.id}">
                                <img src="image/edit.gif" border="0"/>
                            </a>
                        </td>
                        <td class="td_border">${emp.code}</td>
                        <td class="td_border">${emp.name}</td>
                        <td class="td_border">${emp.address}</td>
                        <td class="td_border">${emp.telephone}</td>
                        <td class="td_border">"${emp.email}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>

    </div>
</form:form>
</body>
</html>