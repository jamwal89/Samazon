<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title></title>
<jsp:include page="Header.jsp"></jsp:include>
</head>
<body>
<center>
	
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Product</th>
					<th>ProductDetail</th>
					<th>ProductPrice</th>
					<th>Delete</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${orders}">
					<tr>
						
						
						<td><c:out value="${order.samazonproduct.productname}" /></td>
						<td><c:out value="${order.samazonproduct.productdetails}" /></td>
						<td>$<c:out value="${order.samazonproduct.productprice}" /></td>
						<td> <form action="CartServlet" method="post"> 
							<input type="hidden" name="Productid" value="<c:out value="${order.samazonproduct.productid}"/>"> 
							<input type="hidden" name="action" value="Delete">
							 <input type="submit" value="Delete"> 
							 </form> </td>
							
						
					</tr>
				</c:forEach>
				<tr>
				<td>TotalAmount:</td>
				
				<td></td>
				<td>$<c:out value="${price}" /></td>
				<td> <form action="OrderConfirmation.jsp" method="post">
						<input type="submit" name="Checkout" value="Purchase">
								<input type="hidden" name="action" value="Purchase">
							</form> </td>
				<tr>
			</tbody>
		</table>

</center>


<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>