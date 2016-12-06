<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="true" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Catalogue</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link media="screen, print" title="cse4413" type="text/css"
	href="css/Food.css" rel="StyleSheet" />
</head>
<body>
	<nav class="top-nav">
		<div class="top">
			<div class="logo">
				<a href="${pageContext.request.contextPath}/home.jsp"> FOODS R US</a>
			</div>

			<div class="links">
				<ul>
					<li><a href="${pageContext.request.contextPath}/eFoods">Browse</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/Add"> <i
							class="fa fa-shopping-cart">Checkout</i></a></li>
					<li>Search: <input type="text" id="searchBar" name="searchBar"
						value="search for products..." />
						<button type="submit" name="searchButton" id="searchButton">
							<i class="fa fa-search"> .</i>
						</button>
					</li>

					<li><c:choose>
		<c:when test="${not empty sessionScope.Authorized}">
		<a href="${pageContext.request.contextPath}/Auth" > 
			Your Account </a>
		</c:when>
		<c:otherwise> 
		<a href="${pageContext.request.contextPath}/Admin"> Sign in </a>
		</c:otherwise>
	</c:choose></li>
				</ul>
			</div>
		</div>
	</nav>


	<div>
		<h1>Shopping Bag</h1>
		<hr />
		Helloo
		<div style="display:block">
		hii
			
				
			
		</div>

		<input type="button" class="but" name="shopMore" id="shopMore"
			value="Continue Shopping" />
</div>
<form method="POST" action="${pageContext.request.contextPath}/Add">			
	<c:if test="${not empty sessionScope.test}">
	<c:forEach var="item" items="${sessionScope.test}">
		${item.getName() } <br/>
		${item.getNumber() } <br/>
		${item.getPrice() } <br/>
		${item.getQty() } <br/>
		<input type="text" for="${item.number }" name="qty" value="1"></input>
		<input type="submit" name="${item.number}" id="${item.number }" value="Update"></input><br/>
		
	</c:forEach>
	</c:if>
</form>			
				

<form>
	<div>
		<h1>Order summary</h1>
		<hr />
		<table>
			<tr>
				<td>Total Items</td>
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
			<hr />
			<tr>
				<td>Total</td>
				<td>${Sum }</td>
			</tr>

		</table>

		<input type="button" class="but" name="checkout" id="checkout"
			value="Checkout" />

	</div>
</form>
</body>
	</html>
</jsp:root>