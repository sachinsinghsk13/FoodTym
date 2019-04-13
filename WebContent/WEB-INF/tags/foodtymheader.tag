<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="loginStatus" rtexprvalue="true" required="true"%>
<%@ attribute name="cartItems" rtexprvalue="true" required="true"%>
<%@ attribute name="location" rtexprvalue="true" required="true"%>
<%@ attribute name="customerName" rtexprvalue="true" required="true"%>
<%@ tag body-content="empty"%>
<nav
	class="navbar navbar-expand-md navbar-light bg-light shadow sticky-top"
	id="navbar">
	<a href="#" class="navbar-brand mb-0 h1"> <img
		src="static/images/logo/logo.png" alt="" width="60" height="60">
		FoodTym
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
					class="fas fa-map-marker-alt"></i> <c:choose>
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
					<li class="nav-item"><button
						class="btn btn-success btn-sm m-2" id="login-btn">Login</button></li>
					<li class="nav-item"><button
						class="btn btn-danger btn-sm m-2" id="register-btn">Register</button></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>

<%-- Login Model --%>
<div class="modal fade" tabindex="-1" role="dialog" id="login-modal">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content p-3">
			<div class="modal-body">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="text-center">FoodTym Login</h3>
				<div class="row">
					<div class="col-sm-12">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Mobile No." id="login-mobile-input">
						</div>
					</div>
					<div class="col-sm-12">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Password" id="login-password-input">
						</div>
					</div>
					<div class="col-sm-12">
						<div class="form-group">
							<button class="btn btn-primary btn-block btn-sm" id="login-submit-btn">
								Login
								<div class="spinner-border spinner-border-sm mx-2" role="status"
									id="login-loader" style="display:none">
									<span class="sr-only">Loading...</span>
								</div>
							</button>
						</div>
					</div>
					<hr>
					<div class="col-sm-12">
						<p class="text-muted">
							<a href="http://" class="btn-link">Forget Password?</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<%-- Registration Modal --%>
<div class="modal fade" id="registration-modal" role="dialog" tabindex="-1">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content p-3">
			<div class="modal-body">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="text-center">FoodTym Registration</h3>
				<div class="row">
					<div class="col-sm-12">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Full Name" id="register-fullname-input">
						</div>
					</div>
					<div class="col-sm-12">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Mobile No." id="register-mobile-input">
						</div>
					</div>
					<div class="col-sm-12">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Password" id="register-password-input">
						</div>
					</div>
					<div class="col-sm-12">
						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="Confirm Password" id="register-confirm-password-input">
						</div>
					</div>
					<div class="col-sm-12">
						<div class="form-group">
							<button class="btn btn-danger btn-block btn-sm" id="register-submit-btn">Register
								<div class="spinner-border spinner-border-sm mx-2" role="status"
									id="register-loader" style="display:none">
									<span class="sr-only">Loading...</span>
								</div>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>