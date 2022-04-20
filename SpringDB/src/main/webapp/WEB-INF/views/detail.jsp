<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.mycom.mybatis.dto.EmpDto" %>
    <%
    	EmpDto dto = (EmpDto)request.getAttribute("dto");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
Employee Detail
</h1>

<p><%=dto.getFirstName() %> </p>
<p>${dto.firstName }</p>
</body>
</html>