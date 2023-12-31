package controller;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.BasicJDBC;
import model.Admin;
import model.Car;
import view.AdminMenu;
public class AdminController {
	public int insertAdmin(Admin admin)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="insert into admin(adminID,adminFullName,adminUsername,adminPassword,adminPhoneNo,adminAddress) values (?,?,?,?,?,?)";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=(PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, admin.getId());
		preparedStatement.setString(2, admin.getAdminName());
		preparedStatement.setString(3, admin.getAdminUsername());
		preparedStatement.setString(4, admin.getAdminPassword());
		preparedStatement.setString(5, admin.getAdminPhoneNo());
		preparedStatement.setString(6, admin.getAdminAddress());
		success=preparedStatement.executeUpdate();
		conn.close();
		return success;
	}
	public String checkAdmin(Admin admin)throws ClassNotFoundException,SQLException
	{
		String sql="select max(adminID)from admin";
		Connection conn=(Connection) BasicJDBC.doConnection();
		java.sql.PreparedStatement preparedStatement=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			JOptionPane.showMessageDialog(null,"Success");
			AdminMenu frame=new AdminMenu();
			frame.setVisible(true);
		}
		return null;
	}
	
	public String doLoginAdmin(Admin admin) throws ClassNotFoundException, SQLException
	{
		
		String level="-1";
		String sql="select adminUsername,adminPassword from admin where adminUsername=? and adminPassword=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=(PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, admin.getAdminUsername());
		preparedStatement.setString(2, admin.getAdminPassword());
		
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			level=resultSet.getString(1);
		}
		conn.close();
		return level;
	}
	
}
