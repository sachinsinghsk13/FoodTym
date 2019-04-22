<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<tags:bootstrapinclude />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/foodtym-style.css">
<title>Restaurants</title>
</head>
<body>
	<tags:foodtymheader location="${customerinfobean.location.locality}"
		loginStatus="${customerinfobean.customerLoggedIn}"
		customerName="${customerinfobean.customer.name}"
		cartItems="${customerinfobean.cart.totalItems}" />
	<div class="container p-2">
		<p class="heading">Restaurants Near You</p>
	</div>
	<div
		class="container my-3 d-flex flex-wrap flex-column justify-content-center">
		<c:choose>
			<c:when test="${fn:length(restaurants) gt 0 }">
				<c:forEach var="restaurant" items="${requestScope.restaurants}">
					<div class="row shadow m-2 p-2">
						<div class="col-sm-2">
							<img
								src="/FoodTymAdmin/Restaurants/Banners?restaurantId=${restaurant.id}"
								alt="" class="restaurant-img">
						</div>
						<div class="col-sm-8 offset-sm-1">
							<div class="row">
								<div class="col-sm-6">
									<h4 class="text-dark">${restaurant.name}</h4>
								</div>
								<div class="col-sm-4 offset-sm-1">
									<p class="text-muted">${restaurant.openTime}-
										${restaurant.closeTime}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<p>${restaurant.location.locality}|
										${restaurant.location.region}</p>
								</div>
								<div class="col-sm-4 offset-sm-1">
									<a href="${pageContext.request.contextPath}/ViewRestaurant?restaurantId=${restaurant.id}" class="btn btn-success btn-sm">View
										Menu</a>
								</div>
							</div>
						</div>
					</div>

				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="row p-3">
					<p class="display-4">Sorry! We don't have any registered
						restaurant in your area</p>
					<a href="${pageContext.request.contextPath}/" class="btn btn-primary">Choose Other Location</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>