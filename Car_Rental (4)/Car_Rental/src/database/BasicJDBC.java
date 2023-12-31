package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class BasicJDBC {
	static Connection conn=null;
	public static Connection doConnection()throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/carrental","root","");
		return conn;
	}
	
	public static void main(String[] args)
	{
		try {
			System.out.println(BasicJDBC.doConnection());
			System.out.println("Success");
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	};
}
