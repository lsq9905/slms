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
<html>
<head>
<base href="<%=basePath%>" />
<title>客户档案</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script language="javascript" src="script/main.js"></script>
<script language="javascript" src="script/calendar5.js"></script>
<script type="text/javascript">
    var c = new Calendar("c");                     
    document.write(c);
</script>  
</head>
<body>

	<p><font style="font-size:10pt">档案管理→客户档案→修改</font></p>
<%--@elvariable id="client" type="com.cg.slms.domain.Client"--%>
<form:form action="updateClientAction" method="post" modelAttribute="client">
	<table border="0" cellpadding="1" cellspacing="1" width="95%">
		<tr>
			<td align="right" width="10%" nowrap="nowrap">客户编号</td>
			<td width="20%">
				<form:hidden path="id" />
				<form:input path="code" cssClass="TextInput"/><br></br>
				<form:errors path="code" ></form:errors>
			</td>
			<td align="right" width="10%" nowrap="nowrap">姓名</td>
			<td width="20%">
				<form:input path="name" cssClass="TextInput"/>
				<br></br><form:errors path="name" ></form:errors>
			</td>
			<td align="right" width="10%" nowrap="nowrap">地址</td>
			<td width="20%">
				<form:input path="address" cssClass="TextInput"/>
				<br></br><form:errors path="address" ></form:errors>
			</td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap="nowrap">电话</td>
			<td width="20%">
				<form:input path="telephone" cssClass="TextInput"/><br />
				<form:errors path="telephone" ></form:errors>
			</td>
			<td align="right" width="10%" nowrap="nowrap">Email</td>
			<td width="20%">
				<form:input path="email" cssClass="TextInput"/>
				<form:errors path="email" ></form:errors>
			</td>
			<td colspan="3">&nbsp;</td>
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