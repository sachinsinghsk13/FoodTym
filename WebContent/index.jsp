<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<tags:bootstrapinclude />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/foodtym-style.css">
<title>FoodTym</title>
</head>

<body>
	<tags:foodtymheader location="${customerinfobean.location.locality}" loginStatus="${customerinfobean.customerLoggedIn}"
		customerName="${customerinfobean.customer.name}"
		cartItems="${customerinfobean.cart.totalItems}" />

	<tags:imageslider interval="1500" />

	<div class="container p-3">
		<h3 class="text-center">Welcome! to FoodTym</h3>
		<p class="text-muted">Order food online from your home.Hundreds of
			Restaurants are delivering to your doorstep</p>
	</div>
	<div class="container p-3 shadow">
		<div class="row m-1">
			<h4 class="text-center">Search Restaurants Near You</h4>
		</div>
		<div class="row m-1">
			<div class="col-md-4">
				<div class="form-group">
					<div class="autocomplete-box">
						<input type="text" class="form-control" placeholder="NCR Region" id="region">
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<div class="autocomplete-box">
						<input type="text" class="form-control" placeholder="Locality" id="locality">
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<button class="btn btn-danger btn-block" id="search-btn">Search
						Restaurants</button>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid p-3 shadow">
		<div class="row p-3">
			<div class="col-md-6">
				<h5>About us</h5>
				<p>
					FoodTym is a online food ordering service <br> designed and
					developed by students of BCA Department of <br> <strong><i>Modern
							College of Professional Studies, Mohan Nagar , Ghaziabad</i></strong> <br>
				<ul>
					<li>Sachin Singh</li>
					<li>Akash Gaur</li>
					<li>Amit Sharma</li>
				</ul>

				</p>
			</div>
			<div class="col-md-6">
				<h5>Our aim</h5>
				<p>
					FoodTym is commited to provide you a quality food <br> at your
					doorstep. <br>
				</p>
			</div>
		</div>
	</div>
	<footer class="container-fluid shadow-sm m-3">
		<h5 class="text-center">FoodTym 2019</h5>
	</footer>

</body>

</html>