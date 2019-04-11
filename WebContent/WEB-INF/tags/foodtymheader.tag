<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="loginStatus" rtexprvalue="true" required="true"%>
<%@ attribute name="cartItems" rtexprvalue="true" required="true"%>
<%@ attribute name="location" rtexprvalue="true" required="true"%>
<%@ attribute name="customerName" rtexprvalue="true" required="true"%>
<%@ tag body-content="empty" %>
<nav
	class="navbar navbar-expand-md navbar-light bg-light shadow sticky-top"
	id="navbar">
	<a href="#" class="navbar-brand mb-0 h1"> <img src="static/images/logo/logo.png"
		alt="" width="60" height="60"> FoodTym
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a href="#" class="nav-link">Restaurants</a>
			</li>
			<li class="nav-item"><a href="#" class="nav-link">Order Food</a>
			</li>
			<li class="nav-item"><a href="#" class="nav-link">My Orders</a>
			</li>

		</ul>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a href="#" class="nav-link"> <i
					class="fas fa-shopping-cart"></i> My Cart <span
					class="badge badge-primary badge-notify"> ${cartItems}</span></a></li>
			<li class="nav-item"><a href="#" class="nav-link"> <i
					class="fas fa-map-marker-alt"></i> 
					<c:choose>
						<c:when test="${location eq ''}">
							Choose Location
						</c:when>
						<c:otherwise>
							${location}
						</c:otherwise>
					</c:choose>
			</a></li>
			<c:choose>
				<c:when test="${loginStatus}">
					<li class="nav-item"><a href="#" class="nav-link"> <i
							class="fas fa-user"></i> ${customerName}
					</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a href="#"
						class="btn btn-success btn-sm m-2">Login</a></li>
					<li class="nav-item"><a href="#"
						class="btn btn-danger btn-sm m-2">Register</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>
