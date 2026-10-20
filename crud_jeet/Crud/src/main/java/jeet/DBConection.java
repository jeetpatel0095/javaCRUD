package jeet;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConection {
	public static Connection getConnection()
	{
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/java";
		String username = "root";
		String password = "1234";
	
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
	}
}