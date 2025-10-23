<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Outstation Rides | CarPooling</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        font-family: 'DM Sans', sans-serif;
        background-color: #121212;
        color: #fff;
    }

    .page-header {
        text-align: center;
        margin: 50px 0 30px 0;
        color: #ffc107;
    }

    .description {
        text-align: center;
        font-size: 1.1rem;
        margin-bottom: 50px;
        color: #ddd;
    }

    .feature-card {
        background: #1c1c1c;
        border-radius: 10px;
        padding: 25px;
        margin: 15px 0;
        text-align: center;
        transition: transform 0.3s, box-shadow 0.3s;
        cursor: pointer;
        border: 1px solid #333;
    }

    .feature-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 10px 20px rgba(255, 193, 7, 0.4);
    }

    .feature-card i {
        font-size: 2rem;
        color: #ffc107;
        margin-bottom: 15px;
    }

    .feature-card h4 {
        color: #ffc107;
        margin-bottom: 15px;
    }

    .feature-card p {
        color: #ddd;
        font-size: 0.95rem;
    }

    .cta-btn {
        background-color: #ffc107;
        color: #000;
        font-weight: bold;
        border: none;
        padding: 12px 25px;
        border-radius: 8px;
        transition: background-color 0.3s;
        margin-top: 20px;
    }

    .cta-btn:hover {
        background-color: #e0a800;
        color: #000;
    }
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>

<div class="container">
    <h1 class="page-header">Outstation Rides</h1>
    <p class="description">Perfect for long-distance travel to other cities or states. Comfortable, safe, and flexible rides for your outstation journeys.</p>

    <div class="row">
        <div class="col-md-6">
            <div class="feature-card" onclick="location.href='book-outstation.jsp'">
                <i class="fas fa-road"></i>
                <h4>Book a Ride</h4>
                <p>Find available outstation rides and book your seat for a hassle-free journey.</p>
                <button class="cta-btn">Book Now</button>
            </div>
        </div>
    </div>

    <h3 style="margin-top:50px; color:#ffc107;">Key Features</h3>
    <ul style="list-style-type:none; padding-left:0; font-size:1rem; margin-top:20px;">
        <li>• Comfortable long-distance rides</li>
        <li>• Trusted car owners with verified vehicles</li>
        <li>• Flexible scheduling</li>
        <li>• Option to share rides with other travelers to reduce costs</li>
    </ul>

    <h3 style="margin-top:50px; color:#ffc107;">How It Works</h3>
    <ol style="margin-top:20px; font-size:1rem; color:#ddd;">
        <li>Register as a traveler.</li>
        <li>Select your outstation route and travel date.</li>
        <li>Match with available rides or car owners.</li>
        <li>Book your ride and pay via your preferred payment method.</li>
    </ol>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
