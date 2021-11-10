package com.doglab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.doglab.factory.ConnectionFactory;
import com.doglab.users.User;

public class UserDAO {

	public static void createUserRegistry(User user) {
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

}
