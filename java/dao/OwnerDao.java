package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.Owner;
import model.Traveler;

public class OwnerDao {

	public static void insertowner(Owner o) {

		try {

			Connection conn = DBConnection.createConnection();
			String sql = "insert into owner (name,email,password,contact) values (?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, o.getName());
			pst.setString(2, o.getEmail());
			pst.setString(3, o.getPassword());
			pst.setLong(4, o.getContact());
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
			String sql = "select * from owner where email=?";
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

	public static Owner ownerlogin(String email, String password) {

		Owner o = null;

		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from owner where email = ? and password = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {

				o = new Owner();
				o.setOwnerId(rs.getInt("ownerId"));
				o.setName(rs.getString("name"));
				o.setEmail(rs.getString("email"));
				o.setPassword(rs.getString("password"));
				o.setContact(rs.getLong("contact"));

				System.out.println(o);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}

	public static Traveler getTravelerByEmail(String email) {
		Traveler t = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "SELECT * FROM traveler WHERE email = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				t = new Traveler();
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setEmail(rs.getString("email"));
				t.setPassword(rs.getString("password"));
				t.setContact(rs.getLong("contact"));
				t.setPayment(rs.getString("payment"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

}
