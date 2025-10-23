<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>CarRent | Traveler</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" rel="stylesheet">

<style>
body {
    font-family: 'DM Sans', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #121212;
}

/* Header Styling */
header.site-navbar {
    background: linear-gradient(90deg, #6a1b9a, #9c27b0);
    padding: 15px 0;
    color: #fff;
    box-shadow: 0 4px 15px rgba(0,0,0,0.3);
    position: sticky;
    top: 0;
    z-index: 999;
    transition: all 0.3s ease-in-out;
}

header.site-navbar:hover {
    box-shadow: 0 6px 25px rgba(255, 193, 7, 0.6);
}

.site-logo a {
    font-size: 28px;
    font-weight: 700;
    text-decoration: none;
    color: #fff;
    letter-spacing: 1px;
    transition: all 0.3s ease-in-out;
}

.site-logo a:hover {
    color: #ffc107;
    text-shadow: 0 0 10px #ffc107, 0 0 20px #ffc107;
}

/* Navigation Menu */
.site-navigation .site-menu {
    list-style: none;
    margin: 0;
    padding: 0;
    display: flex;
    gap: 30px;
    align-items: center;
}

.site-navigation .site-menu li {
    position: relative;
}

.site-navigation .site-menu li a {
    text-decoration: none;
    color: #fff;
    font-weight: 500;
    transition: all 0.3s ease-in-out;
}

.site-navigation .site-menu li a:hover {
    color: #ffc107;
    text-shadow: 0 0 10px #ffc107, 0 0 20px #ffc107;
}

/* Dropdown (if needed) */
.site-navigation .site-menu li ul {
    display: none;
    position: absolute;
    top: 110%;
    left: 0;
    background: #6a1b9a;
    padding: 10px 0;
    min-width: 180px;
    border-radius: 0 0 8px 8px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.3);
    z-index: 100;
    transition: all 0.3s ease;
}

.site-navigation .site-menu li:hover ul {
    display: block;
}

.site-navigation .site-menu li ul li a {
    display: block;
    padding: 12px 20px;
    color: #fff;
    font-weight: 400;
}

.site-navigation .site-menu li ul li a:hover {
    background: #ffc107;
    color: #000;
    transform: scale(1.05);
}

/* Responsive Menu */
@media (max-width: 768px) {
    .site-navigation .site-menu {
        flex-direction: column;
        gap: 15px;
        background: #6a1b9a;
        position: absolute;
        top: 100%;
        left: 0;
        width: 100%;
        display: none;
        padding: 20px 0;
    }
    .site-navigation .site-menu.show {
        display: flex;
    }
    .menu-toggle {
        display: block;
        font-size: 24px;
        cursor: pointer;
        color: #fff;
    }
}
</style>
</head>

<body>
<header class="site-navbar">
    <div class="container d-flex justify-content-between align-items-center">
        <!-- Logo -->
        <div class="site-logo">
            <a href="traveler-dashboard.jsp">CarRent</a>
        </div>

        <!-- Navigation -->
        <nav class="site-navigation">
            <ul class="site-menu d-flex align-items-center">
                <li><a href="services.jsp">Book Ride</a></li>
                <li><a href="my-bookings.jsp">My Bookings</a></li>
                <li><a href="traveler-profile.jsp">Profile</a></li>
                <li><a href="offers.jsp">Offers</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
    </div>
</header>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
