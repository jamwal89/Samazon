<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>

	<center>
	
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>ProductPurchased</th>
					<th>ProductDetail</th>
					<th>ProductPrice</th>
					<th>Date</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="history" items="${history}">
					<tr>
						<td><c:out value="${history.samazonproduct.productname}" /></td>
							<td><c:out value="${history.samazonproduct.productdetails}" /></td>
								<td><c:out value="${history.samazonproduct.productprice}" /></td>
							<td><c:out value="${history.ondate}" /></td>
						<td>
							
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

</center>
	
	
	
</body>

</html>