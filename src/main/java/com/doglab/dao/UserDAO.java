package com.doglab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.doglab.factory.ConnectionFactory;
import com.doglab.users.User;

public class UserDAO {

	public static void createUser(User user) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String query = "INSERT INTO users (name, surname, email, password, adress, country) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getSurname());
			pstm.setString(3, user.getEmail());
			pstm.setString(4, user.getPassword());
			pstm.setString(5, user.getAdress());
			pstm.setString(6, user.getCountry());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static List<User> readUsers() {
		Connection conn = null;
		Statement stm = null;
		List<User> users = new ArrayList<User>();
		try {
			conn = ConnectionFactory.getConnection();
			String query = "SELECT * FROM users";
			stm = conn.createStatement();
			ResultSet rset = stm.executeQuery(query);
			while(rset.next()) {
				User user = new User();
				user.setId(rset.getInt("id"));
				user.setName(rset.getString("name"));
				user.setSurname(rset.getString("surname"));
				user.setEmail(rset.getString("email"));
				user.setPassword(rset.getString("password"));
				user.setAdress(rset.getString("adress"));
				user.setCountry(rset.getString("country"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public static User readUniqueUser(User user) {
		Connection conn = null;
		PreparedStatement pstm = null;
		User newUser = null;
		try {
			conn = ConnectionFactory.getConnection();
			String query = "SELECT * FROM users WHERE email = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, user.getEmail());
			ResultSet rset = pstm.executeQuery();
			while(rset.next()) {
				newUser = new User();
				newUser.setId(rset.getInt("id"));
				newUser.setName(rset.getString("name"));
				newUser.setSurname(rset.getString("surname"));
				newUser.setEmail(rset.getString("email"));
				newUser.setPassword(rset.getString("password"));
				newUser.setAdress(rset.getString("adress"));
				newUser.setCountry(rset.getString("country"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newUser;
	}
	
}
