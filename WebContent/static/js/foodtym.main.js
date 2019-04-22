/// <reference path="../bootstrap/jquery-3.3.1.js"/>

function localitySelectionSetup() {
	$.ajax({
		url:'/FoodTymAdmin/LocalityServlet?search_for=regions',
		method:'GET',
		success: (response) => {
			 $('#region').html(response).trigger('change');

		}
	});

	$('#region').on('change',(evt)=> {
		var regionid = $(evt.target).val();
		$.ajax({
			url:`/FoodTymAdmin/LocalityServlet?search_for=locality&regionid=${regionid}`,
			method:'GET',
			success: (response) => {
				$('#locality').html(response);
			}
		});
	});
}

function setup() {
	$('#login-btn').click(function () {
		$('#login-modal').modal('show');
	});

	$('#register-btn').click(function () {
		$('#registration-modal').modal('show');
	});

	$('#logout-btn').click(function () {
		window.location = "/FoodTym/CustomerLogout";
	});

	// Login Process
	$('#login-submit-btn').click(() => {
		var mobileNo = $('#login-mobile-input').val();
		var password = $('#login-password-input').val();
		if (!mobileNo || !password) {
			alert("Please Fill The Login Form");
			return;
		}
		else {
			$.ajax({
				url: '/FoodTym/CustomerLogin',
				method: 'POST',
				beforeSend: () => {
					$('#login-loader').show();
				},
				data: $.param({ "mobileno": mobileNo, "password": password }),
				processData: true,
				complete: () => {
					$('#login-loader').hide();
				},
				success: (res) => {
					var obj = JSON.parse(res);
					if (obj.code == 1) {
						window.location.reload();
					}
					else {
						alert('Login Failed');
					}
				}
			});
		}
	});

	// Register Process
	$('#register-submit-btn').click(() => {
		var fullname = $('#register-fullname-input').val();
		var mobileno = $('#register-mobile-input').val();
		var password = $('#register-password-input').val();
		var con_password = $('#register-confirm-password-input').val();

		if (!fullname || !mobileno || !password || !con_password) {
			alert("Please fill the registration form");
			return;
		}
		else if (password !== con_password) {
			alert('Password not matched');
			return;
		}
		else {
			$.ajax({
				url: '/FoodTym/CustomerRegistration',
				method: 'POST',
				beforeSend: () => {
					$('#register-loader').show();
				},
				data: $.param({ "mobileno": mobileno, "fullname": fullname, "password": password }),
				processData: true,
				complete: () => {
					$('#register-loader').hide();
				},
				success: (res) => {
					var obj = JSON.parse(res);
					if (obj.code == 1) {
						$('#registration-modal').modal('hide');
						alert("Registration Successful. You Can Login Now");
					}
					else {
						alert('This Mobile No is already registered.');
						$('#register-mobile-input').addClass('is-invalid');
					}
				}
			});
		}

	});

}




$(document).ready(function () {
	setup();
	localitySelectionSetup();
});