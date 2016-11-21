<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Checkout</title>
</head>
<body>
	
	<div>
	<h1>Shopping Bag</h1><hr/>
	<c:if test="not empty ${itemList}">
	<c:forEach var="i" items="${itemList }">
		<div><c:out value="${i}">  </c:out></div>
	
	</c:forEach>
	</c:if>
	<input type="button" name="shopMore" id="shopMore" value="Continue Shopping"/>
	</div>
	
	<div>
	<h1>Order summary</h1><hr/>
	<table>
	<tr>
		<td> Total Items</td>
		<td>${itemCount }</td>
	</tr>
	<tr>
		<td>Total Price</td>
		<td>$${PriceTotal }</td>
	</tr>
	<tr>
		<td>Taxes</td>
		<td>$${TaxApplied }</td>
	</tr>
	<tr>
		<td>Shipping</td>
		<c:choose>
		<c:when test="${PriceTotal} lt 100">
		<td>$5.00</td>
		</c:when>
		<c:otherwise>
		<td>Free!</td>
		</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<td>Discount</td>
		<td>$${Discount }</td>
	</tr>
	<hr/>
	<tr>
		<td>Total</td>
		<td>${Sum }</td>
	</tr>
	
	</table>
	<input type="button" name="checkout" id="checkout" value="Checkout"/>
	</div>
	
</body>
</html>
</jsp:root>