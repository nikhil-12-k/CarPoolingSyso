<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="owner-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"
	rel="stylesheet">
<style>
body {
	font-family: 'DM Sans', sans-serif;
	background-color: #121212;
	color: #fff;
}

.dashboard-container {
	max-width: 1200px;
	margin: 50px auto;
	text-align: center;
}

h1 {
	color: #ffc107;
	margin-bottom: 40px;
}

.card {
	background-color: #1c1c1c;
	border: none;
	border-radius: 10px;
	transition: transform 0.3s, box-shadow 0.3s;
	cursor: pointer;
	color: #fff;
}

.card:hover {
	transform: translateY(-5px);
	box-shadow: 0 8px 20px rgba(255, 193, 7, 0.5);
}

.card i {
	font-size: 50px;
	color: #ffc107;
	margin-bottom: 15px;
}

.card-title {
	font-size: 20px;
	font-weight: bold;
}

.card-text {
	color: #ccc;
}

.row {
	gap: 30px;
}
</style>
</head>
<body>
	<div class="container dashboard-container">
		<h1>Welcome</h1>
		<div
			class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4 justify-content-center">

			<!-- Register Car -->
			<div class="col">
				<a href="car-registration.jsp" style="text-decoration: none;">
					<div class="card p-4">
						<i class="bi bi-car-front"></i>
						<div class="card-body">
							<h5 class="card-title">Register Car</h5>
							<p class="card-text">Add your car for daily or rental
								services</p>
						</div>
					</div>
				</a>
			</div>

			<!-- View My Cars -->
			<div class="col">
				<a href="my-cars.jsp" style="text-decoration: none;">
					<div class="card p-4">
						<i class="bi bi-card-list"></i>
						<div class="card-body">
							<h5 class="card-title">My Cars</h5>
							<p class="card-text">View or update your listed cars</p>
						</div>
					</div>
				</a>
			</div>

			<!-- Manage Bookings -->
			<div class="col">
				<a href="owner-bookings.jsp" style="text-decoration: none;">
					<div class="card p-4">
						<i class="bi bi-journal-check"></i>
						<div class="card-body">
							<h5 class="card-title">Bookings</h5>
							<p class="card-text">Check or manage your ride bookings</p>
						</div>
					</div>
				</a>
			</div>

			<div class="col">
				<a href="profile-settings.jsp" style="text-decoration: none;">
					<div class="card p-4">
						<i class="bi bi-person-circle"></i>
						<div class="card-body">
							<h5 class="card-title">Profile Settings</h5>
							<p class="card-text">Update your personal info, email,
								password, and contact details</p>
						</div>
					</div>
				</a>
			</div>


			<!-- Logout -->
			<div class="col">
				<a href="logout.jsp" style="text-decoration: none;">
					<div class="card p-4">
						<i class="bi bi-box-arrow-right"></i>
						<div class="card-body">
							<h5 class="card-title">Logout</h5>
							<p class="card-text">Exit your dashboard securely</p>
						</div>
					</div>
				</a>
			</div>

		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
