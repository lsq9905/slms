<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.cg.slms.domain.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	if (request.getAttribute("stockin") == null) {
		Stockin stockin = new Stockin();
		stockin.setMerchandise(new Merchandise());
		stockin.setClient(new Client());
		stockin.setEmployee(new Employee());
		request.setAttribute("stockin", stockin);
	}
%>
<html>
<head>
<base href="<%=basePath%>" />
<title>进货单</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script language="javascript" src="script/main.js"></script>
<script language="javascript" src="script/calendar5.js"></script>
<script type="text/javascript">
    var c = new Calendar("c");                     
    document.write(c);
</script>  
<script language="javascript">
	function deleteRecord(url) {
		if (window.confirm("确定要删除选中的记录吗？")) {
			window.location=url;
		}
	}
</script>
</head>
<body>
<p><font style="font-size: 10pt;">进货管理→进货单</font></p>
<%--@elvariable id="stockin" type="com.cg.slms.domain.Stockin"--%>
<form:form action="stockinAction" method="post" modelAttribute="stockin">
	<table border="0" cellpadding="1" cellspacing="1" width="95%">
		<tr>
			<td align="right" width="10%" nowrap="nowrap">进货单编号</td>
			<td width="20%">
				<form:input path="code" cssClass="TextInput"></form:input>
			</td>
			<td align="right" width="10%" nowrap="nowrap">货物名称</td>
			<td width="20%">
				<form:select path="merchandise.name" items="${merchandises}" />
			</td>
			<td align="right" width="10%">供应商</td>
			<td width="20%">
				<form:select path="client.name" items="${clients}"/>
			</td>
			<td width="10%">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap="nowrap">进货日期</td>
			<td width="20%">
				<form:input path="stockindate" cssClass="TextInput" onclick="c.show(this);"/>
			</td>
			<td align="right" nowrap="nowrap">经手人</td>
			<td>
				<form:select path="employee.name" items="${employees}"/>
			</td>
			<td align="right">&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>

	<p></p>
	<div style="margin-left: 30px; margin-right: 0px">
	<table border="0" cellpadding="0" cellspacing="0" width="95%">
		<tr>
			<td width="10%">
				<input type="submit" value="查找" class="BtnAction" />
			</td>
			<td width="10%">
				<input type="button" class="BtnAction" value="新增" onclick="location='http://localhost:8080/moduls/stock/addStockin.jsp'"/>
			</td>
			<td width="80%">&nbsp;</td>
		</tr>
	</table>
	</div>
	<div style="margin-left: 30px; margin-right: 0px">
	<table width="90%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td width="3%" class="td_title">删除</td>
			<td width="3%" class="td_title">修改</td>
			<td width="10%" class="td_title">进货单编号</td>
			<td width="19%" class="td_title">供应商</td>
			<td width="9%" class="td_title">货物名称</td>
			<td width="8%" class="td_title">货物数量</td>
			<td width="13%" class="td_title">货物单价（元）</td>
			<td width="13%" class="td_title">货物金额（元）</td>
			<td width="12%" class="td_title">进货日期</td>
			<td width="10%" class="td_title">经手人</td>
		</tr>
		<c:if test="${!empty requestScope.stockins}">
			<c:forEach items="${requestScope.stockins}" var="sto">
				<tr>
					<td class="td_border" align="center">
						<a href="javascript:deleteRecord('deleteStockinByIdAction?id=${sto.id}')">
							<img src="image/wrong.gif" border="0"/>
						</a>
					</td>
					<td class="td_border" align="center">
						<a href="findStockinByIdAction?id=${sto.id}">
							<img src="image/edit.gif" border="0"/>
						</a>
					</td>
					<td class="td_border">${sto.code}</td>
					<td class="td_border">${sto.client.name}</td>
					<td class="td_border">${sto.merchandise.name}</td>
					<td class="td_border">${sto.amount}</td>
					<td class="td_border">${sto.price}</td>
					<td class="td_border">${sto.money}</td>
					<td class="td_border">${sto.stockindate}</td>
					<td class="td_border">${sto.employee.name}</td>
				</tr>
			</c:forEach>
		</c:if>

	</table>
	</div>
</form:form>
</body>
</html>