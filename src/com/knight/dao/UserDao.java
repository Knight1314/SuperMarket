package com.knight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.knight.beans.User;
import com.knight.utils.DBUtils;

public class UserDao {
	public void add(User user) {

	}

	public void delete(User user) {

	}

	public User findUserById(int id) {
		User user = null;
		try {
			String sql = "select * from t_user where id=?";
			Connection connection = DBUtils.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(id));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Test
	public void testFindUserById() {
		int id = 1;
		User user = findUserById(id);
		System.out.println(user.toString());
	}
}
