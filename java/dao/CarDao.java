package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.DBConnection;
import model.Car;

public class CarDao {

	public static void insercar(Car c) {

		try {

			Connection conn = DBConnection.createConnection();
			String sql = "INSERT INTO cars(ownerId, model, number, registrationDate, age, seats, image, amount) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getOwnerId());
			pst.setString(2, c.getModel());
			pst.setString(3, c.getNumber());
			pst.setDate(4, c.getRegistrationDate());
			pst.setInt(5, c.getAge());
			pst.setInt(6, c.getSeats());
			pst.setString(7, c.getImage());
			pst.setDouble(8, c.getAmount());

			pst.executeUpdate();

			System.out.println("New car inserted");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
