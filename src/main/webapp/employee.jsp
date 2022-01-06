<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.cg.slms.domain.*" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
%>
<%	if(request.getAttribute("employee")==null){
		Employee employee=new Employee();
	request.setAttribute("employee",employee);}%>

<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>员工档案</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script language="javascript" src="script/main.js"></script>
</head>
<body>

<p><font style="font-size: 10pt;">档案管理->员工档案</font></p>
<%--@elvariable id="employee" type="com.cg.slms.domain.Employee"--%>
<form:form action="employeeAction" method="post" modelAttribute="employee">
	<table border="0" cellpadding="1" cellspacing="1" width="95%">
		<tr>
			<td align="right" width="10%" >员工编号</td>
			<td width="20%"><form:input path="code" Class="TextInput"></form:input></td>
			<td align="right" width="10%" >员工名称</td>
			<td width="20%"><form:input path="name"
				cssClass="TextInput"></form:input></td>
			<td width="40%">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" width="10%" >&nbsp;</td>
			<td width="20%">&nbsp;</td>
			<td width="70%" colspan="5">&nbsp;</td>
		</tr>
	</table>

	<p></p>
	<div style="margin-left: 30px; margin-right: 0px">
	<table border="0" cellpadding="0" cellspacing="0" width="95%">
		<tr>
			<td width="10%"><input type="submit" value="查找" Class="BtnAction"/>
			</td>
			<td width="10%"><input type="button" class="BtnAction" value="新增" onClick="location='http://localhost:8080/moduls/archive/addEmployee.jsp'"></td>
			<td width="10%"><input type="button" onClick="" value="删除" class="BtnAction" />
           </td>
           <td width="10%"><input type="reset" value="重置" class="BtnAction" /></td>
			<td width="60%">&nbsp;</td>
		</tr>
	</table>
	</div>
	<p></p>
	<div style="margin-left: 30px; margin-right: 0px">
	<table width="90%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td width="5%" class="td_title">选择</td>
			<td width="5%" class="td_title">修改</td>
			<td width="10%" class="td_title">员工编号</td>
			<td width="15%" class="td_title">员工名称</td>
			<td width="15%" class="td_title">出生年月日</td>
			<td width="8%" class="td_title">员工性别</td>
			<td width="19%" class="td_title">员工电话</td>
			<td width="15%" class="td_title">员工Email</td>
		</tr>
		<!-- 显示的内容待定 -->

		<c:if test="${!empty requestScope.employees}">
			<c:forEach items="${requestScope.employees}" var="emp">
				<tr>
					<td class="td_border">待定</td>
					<td class="td_border">待定</td>
					<td class="td_border">${emp.code}</td>
					<td class="td_border">${emp.name}</td>
					<td class="td_border">${emp.birthday}</td>
					<td class="td_border">
						<c:if test="${emp.sex}">男</c:if>
						<c:if test="${!emp.sex}">女 </c:if>
					</td>
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