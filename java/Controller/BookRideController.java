package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RideDao;
import model.Ride;
import model.Traveler;
import utils.DistanceCalculator;

@WebServlet("/BookRide")
public class BookRideController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BookRideController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("book")) {

           
        	HttpSession session = request.getSession(false); 
        	Traveler traveler = (Traveler) session.getAttribute("data");

        	if (traveler == null) {
        	    response.sendRedirect("traveler-login.jsp");
        	    return;
        	}

            int userId = traveler.getId();

            
            Ride r = new Ride();
            r.setServiceType(request.getParameter("serviceType"));
            r.setPickupLocation(request.getParameter("pickupLocation"));
            r.setDropLocation(request.getParameter("dropLocation"));
            r.setCarType(request.getParameter("carType"));
            r.setSeats(Integer.parseInt(request.getParameter("seats")));
            r.setPaymentMethod(request.getParameter("paymentMethod"));
            r.setNotes(request.getParameter("notes"));
            r.setUserId(userId);

            // --- DAYS CHECKBOX (multiple values) ---
            String[] daysArr = request.getParameterValues("days");
            if (daysArr != null && daysArr.length > 0) {
                String daysStr = Arrays.stream(daysArr).collect(Collectors.joining(","));
                r.setDays(daysStr);
            } else {
                r.setDays("");
            }

            // --- TIME PARSING ---
            try {
                String pickupTimeRaw = request.getParameter("pickupTime");
                if (pickupTimeRaw != null && !pickupTimeRaw.isEmpty()) {
                    if (!pickupTimeRaw.contains(":")) pickupTimeRaw += ":00";
                    else if (pickupTimeRaw.matches("^\\d{1,2}:\\d{2}$")) pickupTimeRaw += ":00";
                    r.setPickupTime(Time.valueOf(pickupTimeRaw));
                }

                String returnTimeRaw = request.getParameter("returnTime");
                if (returnTimeRaw != null && !returnTimeRaw.isEmpty()) {
                    if (returnTimeRaw.matches("^\\d{1,2}:\\d{2}$")) returnTimeRaw += ":00";
                    r.setReturnTime(Time.valueOf(returnTimeRaw));
                }
            } catch (Exception e) {
                System.out.println("ERROR parsing time: " + e.getMessage());
            }

            // --- DATE PARSING ---
            try {
                String travelDate = request.getParameter("travelDate");
                if (travelDate != null && !travelDate.isEmpty()) {
                    r.setTravelDate(Date.valueOf(travelDate));
                } else {
                    r.setTravelDate(new Date(System.currentTimeMillis()));
                }
            } catch (Exception e) {
                r.setTravelDate(new Date(System.currentTimeMillis()));
            }

            // --- DISTANCE & FARE ---
            double distanceKm = DistanceCalculator.calculateDistance(r.getPickupLocation(), r.getDropLocation());
            r.setDistance(String.format("%.2f km", distanceKm));

            double perKmRate = 10; // default
            switch (r.getServiceType()) {
                case "daily_commute": perKmRate = 8; break;
                case "airport_transfer": perKmRate = 12; break;
                case "outstation": perKmRate = 15; break;
                case "rental": perKmRate = 10; break;
            }

            double fare = DistanceCalculator.calculateFare(distanceKm, perKmRate);
            r.setFare((int) fare);

            // --- INSERT INTO DB ---
            boolean inserted =RideDao.insertride(r);
            if (inserted) {
            	request.setAttribute("data", r);
                request.setAttribute("msg", "Ride booked successfully! Distance: " + r.getDistance() + ", Fare: ₹" + r.getFare());
                request.getRequestDispatcher("bookingConfirmation.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Error booking ride. Please try again.");
                request.getRequestDispatcher("traveler-home.jsp").forward(request, response);
            }
        }
    }
}
