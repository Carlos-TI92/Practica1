<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Product Management Application</title>
	<style>
     <%@ include file="css/style.css"%>
	</style>
</head>
<body>
	
		<h2 align="center">[Isil Practice] Product Management</h2>

    <div align="center">
        <table  border="1" cellpadding="5">
            <caption><h2>List of Products</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name Product</th>
                <th>Name Provider</th>
                <th>Product Type</th>
            </tr>
            <c:forEach var="product" items="${listProduct}">
                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td><c:out value="${product.nameproduct}" /></td>
                    <td><c:out value="${product.nameprov}" /></td>
                    <td><c:out value="${product.producttype}" /></td>
           
                    <td>
                    	<a href="edit?id=<c:out value='${product.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${product.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
            <h3 align="center">
        	<a href="new">Add New Product</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Product</a>
        	
        </h3>
</body>
</html>
