package controller;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.BasicJDBC;
import model.User;
import model.Admin;
import model.Car;

public class UserController {
	private int totalPayment;
	public int insertUser(User user)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="insert into user(userID,userFullName,userUsername,userPassword,userPhoneNo,userAddress) values (?,?,?,?,?,?)";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=(PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, user.getId());
		preparedStatement.setString(2, user.getUserFullName());
		preparedStatement.setString(3, user.getUsername());
		preparedStatement.setString(4, user.getUserPassword());
		preparedStatement.setString(5, user.getUserPhoneNo());
		preparedStatement.setString(6, user.getUserAddress());
		success=preparedStatement.executeUpdate();
		conn.close();
		return success;
	}
	
	public int userLoan(User user)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String status="RENT";
		checkCar(user);//to check the availability
		String sql="insert into customer(customerID,carID,duration,totalPayment,statusItem) values(?,?,?,?,?)";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
		double duration=0;
		preparedStatement.setString(1, user.getId());
		preparedStatement.setString(2, user.getCarID());
		preparedStatement.setDouble(3, user.getDuration());
		preparedStatement.setDouble(4, user.getTotalPayment());
		preparedStatement.setString(5, status);
		success=preparedStatement.executeUpdate();
		conn.close();
		return success;
		
	}
	
	public String checkCar(User user) throws ClassNotFoundException, SQLException
	{
		String level="-1";
		String sql="select statusCar from car where carID=? and statusCar='AVAILABLE'";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=(PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, user.getCarID());
		//preparedStatement.setString(2, user.getStatus());
		
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			level=resultSet.getString(1);
		}
		conn.close();
		return level;
	}
	
	public double hourlyRate(User user) throws ClassNotFoundException,SQLException
	{
		String sql="select hourlyRate from car where carID='"+user.getCarID()+"'";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=(PreparedStatement) conn.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();

	        User p = new User();

	       if (resultSet.next())
	        {
	            p.hourlyRate = resultSet.getDouble(1);
	        }
	      
	
		conn.close();
		return p.hourlyRate;
	}
	public ArrayList<User> viewCustomer() throws ClassNotFoundException,SQLException
	{
		ArrayList<User> user = new ArrayList<User>();
		String sql="Select customerID,carID,duration,totalPayment,statusItem from customer where statusItem='RENT'";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement= conn.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()) 
		{
			User user1=new User();
			user1.setId(resultSet.getString(1));
			user1.setCarID(resultSet.getString(2));
			user1.setDuration(resultSet.getDouble(3));
			user1.setTotalPaymemt(resultSet.getDouble(4));
			user1.setStatusItem(resultSet.getString(5));
			user.add(user1);
			
		}
		conn.close();
		return user;
		
	}
	
	public int returnCar(User user)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="update customer set statusItem='RETURNED' where customerID=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
	
		preparedStatement.setString(1, user.getId());
		success=preparedStatement.executeUpdate();
		conn.close();
		return success;
	
	}
	

}
