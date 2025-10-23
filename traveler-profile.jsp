<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Traveler Profile | CarPooling</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">

<style>
body {
    font-family: 'DM Sans', sans-serif;
    background-color: #121212;
    color: #fff;
}

.profile-container {
    max-width: 800px;
    margin: 50px auto;
    text-align: center;
}

h1 {
    color: #ffc107;
    margin-bottom: 40px;
}

.profile-card {
    background-color: #1c1c1c;
    border-radius: 12px;
    padding: 40px 30px;
    margin-bottom: 30px;
    box-shadow: 0 0 15px rgba(255, 193, 7, 0.2);
}

.profile-card h2 {
    font-size: 24px;
    font-weight: 600;
    margin-bottom: 20px;
    color: #ffc107;
}

.profile-buttons {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 25px;
}

.profile-btn {
    flex: 1 1 200px;
    max-width: 250px;
    padding: 20px;
    border-radius: 10px;
    background-color: #2a2a2a;
    color: #ffc107;
    font-weight: 500;
    font-size: 18px;
    text-decoration: none;
    display: flex;
    flex-direction: column;
    align-items: center;
    transition: transform 0.3s, box-shadow 0.3s;
}

.profile-btn i {
    font-size: 36px;
    margin-bottom: 10px;
}

.profile-btn:hover {
    transform: translateY(-5px);
    box-shadow: 0 8px 20px rgba(255, 193, 7, 0.5);
    background-color: #333;
    color: #fff;
}
</style>
</head>
<body>

<div class="container profile-container">
    <h1>Traveler Profile</h1>

    <div class="profile-card">
        <h2>Manage Your Profile</h2>
        <div class="profile-buttons">

            <!-- Personal Info -->
            <a href="personal-info.jsp" class="profile-btn">
                <i class="bi bi-person-lines-fill"></i>
                Personal Info
            </a>

            <!-- Change Password -->
            <a href="change-password.jsp" class="profile-btn">
                <i class="bi bi-lock-fill"></i>
                Change Password
            </a>

            <!-- My Offers -->
            <a href="my-offers.jsp" class="profile-btn">
                <i class="bi bi-gift-fill"></i>
                My Offers
            </a>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
