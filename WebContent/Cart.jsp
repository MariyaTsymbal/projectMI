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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>

<link media="screen, print" title="cse4413" type="text/css"	href="css/Food.css" rel="StyleSheet" />

</head>
<body>
	
		<nav class="top-nav">	
	<div class="top">
	<div class="logo">
		<a href="home.jsp"> FOODS R US</a>
	</div>
	
	<div class="links">
	<ul>
	<li>
	<a href="${pageContext.request.contextPath}/Admin" > Sign In</a>
	</li>
	<li>
	<a href="Cart.jsp"> <i class="fa fa-shopping-cart">Checkout</i></a>
	</li>
	<li>
	Search: <input type="text" id="searchBar" name="searchBar" value="search for products..."/>
	<button type="submit" name="searchButton" id="searchButton"> <i class="fa fa-search"> .</i>
	</button>
	</li>
	<li>
	<a href="catalogue.jsp">Browse</a>
	</li>
	
	</ul>
	</div>
	</div>
	</nav>
	
	
	<div>
	<h1>Shopping Bag</h1><hr/>
	<c:if test="not empty ${itemList}">
	<c:forEach var="i" items="${itemList }">
		<div><c:out value="${i}">  </c:out></div>
	
	</c:forEach>
	</c:if>
	<input type="button" class="but" name="shopMore" id="shopMore" value="Continue Shopping"/>
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
		<c:when test="${PriceTotal} ge 100">
		<td>Free!</td>
		</c:when>
		<c:otherwise>
		<td>$5.00</td>
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
	
	<input type="button" class="but" name="checkout" id="checkout" value="Checkout"/>
	
	</div>
	
</body>
</html>
</jsp:root>