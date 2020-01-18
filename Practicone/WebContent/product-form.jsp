<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>
	<style>
     <%@ include file="css/style.css"%>
	</style>
</head>
<body>

		<h2 align="center">Isil Practice - Product Management</h2>

    <div align="center">
		<c:if test="${product != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${product == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${product != null}">
            			Edit Product
            		</c:if>
            		<c:if test="${product == null}">
            			Add New Product
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${product != null}">
        			<input type="hidden" name="id" value="<c:out value='${product.id}' />" />
        		</c:if>            
            <tr>
                <th>Product Name: </th>
                <td>
                	<input type="text" name="nameproduct" size="45"
                			value="<c:out value='${product.nameproduct}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Name Provider: </th>
                <td>
                	<input type="text" name="nameprov" size="45"
                			value="<c:out value='${product.nameprov}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Type: </th>
                <td>
                	<input type="text" name="producttype" size="15"
                			value="<c:out value='${product.producttype}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
        <h3 align="center">
        	<a href="new">Add New Product</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Product</a>
        	
        </h3>
</body>
</html>