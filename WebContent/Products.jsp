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
	
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Product</th>
					<th>ProductDetail</th>
					<th>ProductPrice</th>
					<th>Purchase</th>
					<th>Delete</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="prods" items="${prods}">
					<tr>
						
						<td><c:out value="${prods.productname}" /></td>
						<td><c:out value="${prods.productdetails}" /></td>
						<td><c:out value="${prods.productprice}" />  </td> 
						<td> <form action="CartServlet" method="post"> 
							<input type="hidden" name="Productid" value="<c:out value="${prods.productid}"/>"> 
							<input type="hidden" name="action" value="Add">
							 <input type="submit" value="Add"> 
							 </form> </td>
							 <td> <form action="CartServlet" method="post"> 
							<input type="hidden" name="Productid" value="<c:out value="${prods.productid}"/>"> 
							<input type="hidden" name="action" value="Delete">
							 <input type="submit" value="Delete"> 
							 </form> </td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

</center>>
<h1> </h1>
</body>
<jsp:include page="Footer.jsp"></jsp:include>
</html>