/// <reference path="../bootstrap/jquery-3.3.1.js"/>

function autocompleteSetUp() {

	function NcrRegionAutocompletion() {
		var currentFocus;
		$('#region').on('input', () => {
			closeSuggestionList();
			var search = $('#region').val();
			if (!search)
				return false;
			var url = '/FoodTymAdmin/LSAG?search_for=ncr_region&search=' + search;

			$.getJSON(url, (resultArray) => {
				if (resultArray.length == 0)
					return false;
				currentFocus = -1;
				var autcompleteBox = $('#region').parent('.autocomplete-box');
				var suggestionList = $('<div>').attr('id', 'region-autocomplete-list').addClass('autocomplete-items');
				for (var i = 0; i < resultArray.length && i < 15; i++) { // maximum 15 suggestion only
					var regionName = resultArray[i].ncrRegionName;
					var suggestionDiv = $('<div>').text(regionName).append($('<input>').attr('type', 'hidden').val(regionName));
					suggestionDiv.on('click', (evt) => {
						var value = $(evt.target).children('input[type=hidden]').val();
						$('#region').val(value);
						closeSuggestionList();
					})
					suggestionList.append(suggestionDiv);
				}
				autcompleteBox.append(suggestionList);
			});
		});

		$('#region').keydown((evt) => {
			var x = $('#region-autocomplete-list').children('div');

			if (!x)
				return false;
			if (evt.keyCode == 40) {
				currentFocus++;
				addActive(x);
			}

			else if (evt.keyCode == 38) {
				currentFocus--;
				addActive(x);
			}

			else if (evt.keyCode == 13) {
				evt.preventDefault();
				if (currentFocus > -1) {
					if (x)
						x.filter(':eq(' + currentFocus + ')').click();
				}
			}
		});

		function addActive(x) {
			if (!x)
				return false;
			x.removeClass('activeSuggestion');

			if (currentFocus >= x.length)
				currentFocus = 0;
			if (currentFocus < 0)
				currentFocus = x.length - 1;

			x.filter(':eq(' + currentFocus + ')').addClass('activeSuggestion');
		}

		function closeSuggestionList() {
			$('#region-autocomplete-list').remove();
		}

		$(document).click(closeSuggestionList);

	}

	function LocalityAutocompletion() {
		var currentFocus;
		$('#locality').on('input', () => {
			closeSuggestionList();
			var search = $('#locality').val();
			if (!search)
				return false;

			var region = $('#region').val();
			var url;
			if (region)
				url = "/FoodTymAdmin/LSAG?search_for=locality&search=" + search + "&ncr_region=" + region;
			else
				url = "/FoodTymAdmin/LSAG?search_for=locality&search=" + search;
			$.getJSON(url, (resultArray) => {
				if (resultArray.length == 0)
					return false;
				currentFocus = -1;
				var autcompleteBox = $('#locality').parent('.autocomplete-box');
				var suggestionList = $('<div>').attr('id', 'locality-autocomplete-list').addClass('autocomplete-items');
				for (var i = 0; i < resultArray.length && i < 15; i++) { // maximum 15 suggestion only
					var localityName = resultArray[i].localityName;
					var suggestionDiv = $('<div>').text(localityName).append($('<input>').attr('type', 'hidden').val(localityName));
					suggestionDiv.on('click', (evt) => {
						var value = $(evt.target).children('input[type=hidden]').val();
						$('#locality').val(value);
						closeSuggestionList();
					})
					suggestionList.append(suggestionDiv);
				}
				autcompleteBox.append(suggestionList);
			});
		});

		$('#locality').keydown((evt) => {
			var x = $('#locality-autocomplete-list').children('div');

			if (!x)
				return false;
			if (evt.keyCode == 40) {
				currentFocus++;
				addActive(x);
			}

			else if (evt.keyCode == 38) {
				currentFocus--;
				addActive(x);
			}

			else if (evt.keyCode == 13) {
				evt.preventDefault();
				if (currentFocus > -1) {
					if (x)
						x.filter(':eq(' + currentFocus + ')').click();
				}
			}
		});

		function addActive(x) {
			if (!x)
				return false;
			x.removeClass('activeSuggestion');

			if (currentFocus >= x.length)
				currentFocus = 0;
			if (currentFocus < 0)
				currentFocus = x.length - 1;

			x.filter(':eq(' + currentFocus + ')').addClass('activeSuggestion');
		}

		function closeSuggestionList() {
			$('#locality-autocomplete-list').remove();
		}

		$(document).click(closeSuggestionList);
	}

	NcrRegionAutocompletion(); // call the setup funtion
	LocalityAutocompletion();
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
	autocompleteSetUp();
});