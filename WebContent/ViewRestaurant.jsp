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
<title>${restaurant.name}</title>
</head>
<body>
	<tags:foodtymheader location="${customerinfobean.location.locality}"
		loginStatus="${customerinfobean.customerLoggedIn}"
		customerName="${customerinfobean.customer.name}"
		cartItems="${customerinfobean.cart.totalItems}" />

	<div class="container-fluid p-2 shadow">
		<div class="row">
			<div class="col-md-2">
				<img
					src="/FoodTymAdmin/Restaurants/Banners?restaurantId=${rt.id}"
					alt="" class="img-thumbnail restaurant-logo">
			</div>
			<div class="col-md-10">
				<div class="row">
					<div class="col-sm-7">
						<p class="text-dark h3">${rt.name}</p>
					</div>
					<div class="col-sm-5">
						<p class="text-muted">${rt.openTime}-
							${rt.closeTime}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<p class="text-muted">${rt.address}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<p class="text-dark h6">M: ${rt.mobileNumber}</p>
					</div>
					<div class="col-sm-6">
						<p class="text-dark h6">Email: ${rt.emailAddress}</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid d-flex flex-column bg-light m-2">
		<c:choose>
			<c:when test="${fn:length(fooditems) gt 0 }">
				<c:forEach var="fooditem" items="${fooditems}">
					<div class="row border m-2 p-3">
						<img src="download.png" alt="" class="food-img float-left mx-3">
						<div class="col mx-3">
							<div class="row">
								<div class="col-sm-4">
									<h5>${fooditem.title}</h5>
								</div>
								<div class="col-sm-4 offset-sm-4">
									<p class="text-dark h4">&#8377; ${fooditem.price} /-</p>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									<p class="badge badge-primary">${fooditem.category}</p>
								</div>
								<div class="col-sm-4">
									<p class="badge badge-danger">${fooditem.subcategory}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									<p class="text-success h6">${fooditem.type}</p>
								</div>
								<div class="col-sm-4">
									<p class="text-dark h6">${fooditem.priceType}</p>
								</div>
								<div class="col-sm-4">
									<button class="btn btn-success btn-sm">Add to Cart</button>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p class="display-4">This Restauant Not Serving any Food Item Now</p>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>