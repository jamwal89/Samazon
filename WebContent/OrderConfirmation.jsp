<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="Header.jsp"></jsp:include>
</head>
<body>
			<center>
					<h1> Your order has been confirmed</h1>
					<p1> A confirmation email has been sent at <c:out value="${email}" />  </p1>
					<br><p1> Hope you enjoyed shopping</p1>
			</center>
</body>
</html>

<jsp:include page="Footer.jsp"></jsp:include>