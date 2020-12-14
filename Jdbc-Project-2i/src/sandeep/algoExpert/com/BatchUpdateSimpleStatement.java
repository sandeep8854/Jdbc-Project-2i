package sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchUpdateSimpleStatement
{
	public static void main(String[] args) throws Exception 
	{
		String Driver="com.mysql.jdbc.Driver";
		String jdbc_url="jdbc:mysql://localhost:3306/movies"; 
		String user="root";
		String pwd="root"; 
		Class.forName(Driver);
		Connection con=DriverManager.getConnection("jdbc_url", "user", "pwd");
		Statement st=con.createStatement();
		
		
		
		
		
		
	}
	

}
