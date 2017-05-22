package com.knight.serviceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.knight.beans.User;
import com.knight.service.LoginService;
import com.knight.utils.DBUtils;

public class LoginImp implements LoginService {

	@Override
	public boolean checkLogin(User user) {
		try {
			String sql = "select * from t_user where username=? and password=?";
			Connection connection = DBUtils.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	@Test
	public void testCheckLogin(){
		User user= new User();
		user.setUserName("123455");
		user.setPassword("123456");
		System.out.println(checkLogin(user));
	}

}
