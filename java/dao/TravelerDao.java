package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.Traveler;

public class TravelerDao {

	public static void insertowner(Traveler t) {

		try {

			Connection conn = DBConnection.createConnection();
			String sql = "insert into traveler (name,email,password,contact,payment) values (?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setString(2, t.getEmail());
			pst.setString(3, t.getPassword());
			pst.setLong(4, t.getContact());
			pst.setString(5, t.getPayment());
			pst.executeUpdate();

			System.out.println("Data inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkEmail(String email) {

		boolean flag = false;

		try {

			Connection conn = DBConnection.createConnection();
			String sql = "select * from traveler where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {

				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static Traveler travelerlogin(String email, String password) {

		Traveler t = null;

		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from traveler where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {

				t = new Traveler();
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setEmail(rs.getString("email"));
				t.setPassword(rs.getString("password"));
				t.setPayment(rs.getString("payment"));
				t.setContact(rs.getLong("contact"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
      return t;
	}

}
