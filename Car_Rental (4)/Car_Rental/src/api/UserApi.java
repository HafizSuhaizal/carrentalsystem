/*package api;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import database.BasicJDBC;

public class UserApi {

	public UserApi()
	{
		
	}
	public int insertUser(User user)throws Exception
	public ArrayList<User> getUsers()throws Exception
	{
		ArrayList<User> listusers=new ArrayList<User>();
		BasicJDBC db=new BasicJDBC();
		Connection con=db.getConnection();
		String sql="select userID,userName,userPassword,userPhone from user=?";
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			User user=new User();
			user.setID(rs.getString(1);
			user.setName(rs.getString(2);
			user.setName(rs.getString(3);
			user.setPassword(rs.getString(4);
			user.setPhone(rs.getString(5);
		}
		ps.close();con.close();
		return listusers;
		}
	}
	public User findUser(String name)throws Exception
	
	public static void main(String[] args)
	{
		try {
			UserApi api=new UserApi();
			User user=new User();
			user.setName("chong");
			user.setIC("3333");
			api.insertUser(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}*/
