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
	if (request.getAttribute("client") == null) {
		Client client = new Client();
		request.setAttribute("client", client);
	}
%>
<html>
<head>
<base href="<%=basePath%>" />
<title>员工档案</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script language="javascript" src="script/main.js"></script>
<script language="javascript" src="script/calendar5.js"></script>
<script type="text/javascript">
    var c = new Calendar("c");                     
    document.write(c);
</script>  
</head>
<body>

	<p><font style="font-size:10pt">档案管理→员工档案→新增</font></p>
<%--@elvariable id="client" type="com.cg.slms.domain.Client"--%>
<form:form action="addClientAction" method="post" modelAttribute="client">
	<table border="0" cellpadding="1" cellspacing="1" width="95%">
		<tr>
			<td align="right" width="10%" nowrap="nowrap">客户编号</td>
			<td width="20%">
				<form:input path="code" cssClass="TextInput"/><br></br>
				<form:errors path="code" ></form:errors>
			</td>
			<td align="right" width="10%" nowrap="nowrap">客户名称</td>
			<td width="20%">
				<form:input path="name" cssClass="TextInput"/>
				<br></br><form:errors path="name" ></form:errors>
			</td>
			<td align="right" width="10%" nowrap="nowrap">地址</td>
			<td width="20%">
				<form:input path="address" cssClass="TextInput"/>
				<br></br><form:errors path="address" ></form:errors>
			</td>
			<td align="right" width="10%" nowrap="nowrap">电话</td>
			<td width="20%">
				<form:input path="telephone" cssClass="TextInput"/>
				<br></br><form:errors path="telephone" ></form:errors>
			</td>
			<td align="right" width="10%" nowrap="nowrap">邮箱</td>
			<td width="20%">
				<form:input path="email" cssClass="TextInput"/>
				<br></br><form:errors path="email" ></form:errors>
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