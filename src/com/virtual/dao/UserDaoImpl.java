package com.virtual.dao;

import com.virtual.bean.User;
import com.virtual.connection.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDaoImpl implements UserDao {

         @Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "Insert into tblUser values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setString(2, user.getFname());
			pstmt.setString(3, user.getLname());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPassword());			
			pstmt.setString(6, user.getContact());
			pstmt.setString(7, user.getAddress());
			
			int index = pstmt.executeUpdate();
			if(index>0){
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

         @Override
	public boolean isAlreadyAvailable(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql = "Select * from tblUser where emailid ='"+user.getEmail()+"'";
		try {
			Statement stmt = ConnectionUtils.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public User selectUser(String email, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		String sql = "Select * from tblUser where emailid ='"+email.toLowerCase()+"' and password='"+password+"'";
		try {
			Statement stmt = ConnectionUtils.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				user.setUserId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setContact(rs.getString(6));				
				user.setAddress(rs.getString(7));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}   

}
