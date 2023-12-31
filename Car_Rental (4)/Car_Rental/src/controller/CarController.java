package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.AdminMenu;
import database.BasicJDBC;
import model.Admin;
import model.Car;

import java.sql.*;
import java.io.*;
import org.jfree.ui.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;


public class CarController {

	public int insertCar(Car car)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		//Car car=new Car();
		String status="AVAILABLE";
		String sql="insert into Car(carID,carBrand,carModel,carTransmission,hourlyRate,statusCar) values (?,?,?,?,?,'"+status+"')";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=(PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, car.getCarID());
		preparedStatement.setString(2, car.getCarBrand());
		preparedStatement.setString(3, car.getCarModel());
		preparedStatement.setString(4, car.getCarTransmission());
		preparedStatement.setDouble(5, car.getHourlyRate());
		success=preparedStatement.executeUpdate();
		
		conn.close();
		return success;
	}
	public int edit(Car car)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String id;
		String sql="update car set carBrand,carModel,carTransmission,hourlyRate,status from car where carID=?";
		Connection conn=(Connection) BasicJDBC.doConnection();
		java.sql.PreparedStatement preparedStatement=conn.prepareStatement(sql);
		preparedStatement.setString(2, car.getCarBrand());
		preparedStatement.setString(3, car.getCarModel());
		preparedStatement.setString(4, car.getCarTransmission());
		preparedStatement.setDouble(5, car.getHourlyRate());
		ResultSet resultSet=preparedStatement.executeQuery();
		conn.close();
		return success;
	}
	public Car showCar(Car car)throws ClassNotFoundException,SQLException
	{
		String sql="select * from car where carID=?";
		Connection conn=(Connection) BasicJDBC.doConnection();
		PreparedStatement preparedStatement=(PreparedStatement) conn.prepareStatement(sql);
		preparedStatement.setString(1, car.getCarID());
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			Car car1=new Car();
			String car3;
			car1.setCarID(resultSet.getString(1));
			car1.setCarBrand(resultSet.getString(2));
			car1.setCarModel(resultSet.getString(3));
			car1.setCarTransmission(resultSet.getString(4));
			car1.setHourlyRate(resultSet.getDouble(5));
			car1.setStatus(resultSet.getString(6));
			return car1;
		
		}
		conn.close();
		return car;
	}
	public int editCarBrand(Car car)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="update car set carBrand=? where carID=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
		
		preparedStatement.setString(1,car.getCarBrand());
		preparedStatement.setString(2, car.getCarID());
		success=preparedStatement.executeUpdate();
		conn.close();
		return success;
	}
	public int editCarModel(Car car)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="update car set carModel=? where  carID=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
		
		preparedStatement.setString(1,car.getCarModel());
		preparedStatement.setString(2, car.getCarID());
		success=preparedStatement.executeUpdate();
		conn.close();
		return success;
	}
	public int editCarTransmission(Car car)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="update car set carTransmission=? where  carID=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
		
		preparedStatement.setString(1,car.getCarTransmission());
		preparedStatement.setString(2, car.getCarID());
		success=preparedStatement.executeUpdate();
		conn.close();
		return success;
	}
	public int editHourlyRate(Car car)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="update car set hourlyRate=? where  carID=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
		
		preparedStatement.setDouble(1,car.getHourlyRate());
		preparedStatement.setString(2, car.getCarID());
		success=preparedStatement.executeUpdate();
		conn.close();
		return success;
	}
	public int editCarStatus(Car car)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="update car set statusCar=? where  carID=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
		
		preparedStatement.setString(1,car.getStatus());
		preparedStatement.setString(2, car.getCarID());
		success=preparedStatement.executeUpdate();
		conn.close();
		return success;
	}
	//car searching
	public Car SearchCarByID(Car car)throws ClassNotFoundException,SQLException
	{
		Car car1=null;
		String sql="select carID,carBrand,carModel,carTransmission,hourlyRate,statusCar from car where carID=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
		preparedStatement.setString(1, car.getCarID());
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			car1=new Car();
			car1.setCarID(resultSet.getString(1));
			car1.setCarBrand(resultSet.getString(2));
			car1.setCarModel(resultSet.getString(3));
			car1.setCarTransmission(resultSet.getString(4));
			car1.setHourlyRate(resultSet.getDouble(5));
			car1.setStatus(resultSet.getString(6));
			
		}
		conn.close();
		return car1;
	}
	public int deleteCar(Car car)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="update car set statusCar='DELETED' where carID=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
	
		preparedStatement.setString(1, car.getCarID());
		success=preparedStatement.executeUpdate();
		conn.close();
		return success;
	}
	public int loanCar(Car car)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="update car set statusCar='NOTAVAILABLE' where carID=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
	
		preparedStatement.setString(1, car.getCarID());
		success=preparedStatement.executeUpdate();
		conn.close();
		return success;
	}
	public Car SearchCarByBrand(Car car)throws ClassNotFoundException,SQLException
	{
		Car car1=null;
		String sql="select * from car where carBrand=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
		preparedStatement.setString(1, car.getCarBrand());
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			car1=new Car();
			car1.setCarID(resultSet.getString(1));
			car1.setCarBrand(resultSet.getString(2));
			car1.setCarModel(resultSet.getString(3));
			car1.setCarTransmission(resultSet.getString(4));
			car1.setHourlyRate(resultSet.getDouble(5));
			car1.setStatus(resultSet.getString(6));
			
		}
		conn.close();
		return car1;
	}
	public ArrayList<Car> viewCar() throws ClassNotFoundException,SQLException
	{
		ArrayList<Car> car = new ArrayList<Car>();
		String sql="Select carID,carBrand,carModel,carTransmission,hourlyRate,statusCar from car where statusCar='AVAILABLE'";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement= conn.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()) 
		{
			Car car1=new Car();
			car1.setCarID(resultSet.getString(1));
			car1.setCarBrand(resultSet.getString(2));
			car1.setCarModel(resultSet.getString(3));
			car1.setCarTransmission(resultSet.getString(4));
			car1.setHourlyRate(resultSet.getDouble(5));
			car1.setStatus(resultSet.getString(6));
			car.add(car1);
			
		}
		conn.close();
		return car;
	}
	
	
	public ArrayList<Car> viewAllCar() throws ClassNotFoundException,SQLException
	{
		ArrayList<Car> car = new ArrayList<Car>();
		String sql="Select carID,carBrand,carModel,carTransmission,hourlyRate,statusCar from car";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement= conn.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()) 
		{
			Car car1=new Car();
			car1.setCarID(resultSet.getString(1));
			car1.setCarBrand(resultSet.getString(2));
			car1.setCarModel(resultSet.getString(3));
			car1.setCarTransmission(resultSet.getString(4));
			car1.setHourlyRate(resultSet.getDouble(5));
			car1.setStatus(resultSet.getString(6));
			car.add(car1);
			
		}
		conn.close();
		return car;
	}

	public int returnCar(Car car)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="update car set statusCar='AVAILABLE' where carID=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
	
		preparedStatement.setString(1, car.getCarID());
		
		conn.close();
		return success;
	}
	
	public int returnCar1(Car car)throws ClassNotFoundException,SQLException
	{
		int success=-1;
		String sql="update car set statusCar='AVAILABLE' where carID=?";
		Connection conn=BasicJDBC.doConnection();
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
	
		preparedStatement.setString(1, car.getCarID());
		
		conn.close();
		return success;
	}
	
	public void pieChart(Car car) throws ClassNotFoundException,SQLException
	{
			
          Connection conn = BasicJDBC.doConnection();
          DefaultPieDataset my_pie_chart_dataset = new DefaultPieDataset();
          Statement stmt = conn.createStatement();
          /* Populate data from table to JFreeChart */
          try {
                  ResultSet query_set = stmt.executeQuery("select * from car where statusCar like '%AVAILABLE%'");
                  while (query_set.next()) {
                          String state = query_set.getString("statusCar");
                          Number success_rate = query_set.getDouble("hourlyRate");
                          my_pie_chart_dataset.setValue(state, success_rate); //Convert data source from table to Pie Chart Data Source                               
                          }
          /* Create Logical Chart */
          JFreeChart PieChartObject=ChartFactory.createPieChart(" StatusCar ",my_pie_chart_dataset,true,true,false);
          /* Close JDBC specific objects */
          query_set.close();
          stmt.close(); 
          conn.close();
          /* Specify dimensions and quality factor for Pie Chart */
          int width=640; 
          int height=480;   
          float quality=1; /* Quality factor */
          /* Write Pie Chart as a JPEG file */
          File BarChart=new File("SQL2PieChart.png");              
          ChartUtilities.saveChartAsJPEG(BarChart, quality, PieChartObject,width,height); 
          }
           catch (Exception i)
           {
                   System.out.println(i);
           }

		
	}
}

