<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="true"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login</title>
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
	<a href="${pageContext.request.contextPath}/eFoods">Browse</a>
	</li>
	<li>
	<a href="${pageContext.request.contextPath}/Cart.jsp"> <i class="fa fa-shopping-cart">Checkout</i></a>
	</li>
	<li>
	Search: <input type="text" id="searchBar" name="searchBar" value="search for products..."/>
	<button type="submit" name="searchButton" id="searchButton"> <i class="fa fa-search"> .</i>
	</button>
	</li>
	
	<li>
	<c:choose>
		<c:when test="${not empty sessionScope.Authorized}">
		<a href="${pageContext.request.contextPath}/Auth" > 
			Your Account </a>
		</c:when>
		<c:otherwise> 
		<a href="${pageContext.request.contextPath}/Admin"> Sign in </a>
		</c:otherwise>
	</c:choose>
	</li>
	</ul>
	</div>
	</div>
	</nav>
	
	<form action="" method="POST">
	
		<div><h1>Sign in</h1>
		<hr/>
		Login <br/> <input type="text" id ="name" name="name" value="name"/><br/>
		<br/>
		Password <br/> <input type="password" id="pass" name="pass" value="password"/><br/>
		<input type="submit" class="but" id="login" name="login" value="Login"/>
	
		</div>
	
	</form>
	
	
</body>
</html>
</jsp:root>