package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.DBConnection;
import model.Ride;

public class RideDao {

	public static boolean insertride(Ride r) {

		boolean inserted = false;

		try {

			Connection conn = DBConnection.createConnection();
			String sql = "INSERT INTO rides (serviceType, userId, pickupLocation, dropLocation, pickupTime, returnTime, travelDate, days, carType, seats, paymentMethod, distance, fare, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, r.getServiceType());
			pst.setInt(2, r.getUserId());
			pst.setString(3, r.getPickupLocation());
			pst.setString(4, r.getDropLocation());
			pst.setTime(5, r.getPickupTime());
			pst.setTime(6, r.getReturnTime());
			pst.setDate(7, r.getTravelDate());
			pst.setString(8, r.getDays());
			pst.setString(9, r.getCarType());
			pst.setInt(10, r.getSeats());
			pst.setString(11, r.getPaymentMethod());
			pst.setString(12, r.getDistance());
			pst.setInt(13, r.getFare());
			pst.setString(14, r.getNotes());

			int rows = pst.executeUpdate();

			if (rows > 0) {
	            inserted = true; 
	            System.out.println("Ride data inserted successfully!");
	        }

			System.out.println("Rider data inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserted;
	}

}
