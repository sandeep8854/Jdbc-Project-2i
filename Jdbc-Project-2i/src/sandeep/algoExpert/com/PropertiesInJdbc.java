package sandeep.algoExpert.com;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesInJdbc 
{
	public static void main(String[] args)throws Exception
	{
		Properties p=new Properties();
		FileInputStream fis = new FileInputStream("db1.properties"); 
		p.load(fis);// to load all properties from properties file into java Properties object 
		String url=p.getProperty("url");
		String user=p.getProperty("user");
		String pwd=p.getProperty("pwd");
		
		Connection con=DriverManager.getConnection(url,user,pwd);
		Statement st =con.createStatement();
		ResultSet rs=st.executeQuery("select * from employees");
		System.out.println("EmpNo\tEname\tEsal\tEaddr");
		System.out.println("*************************************************");
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		con.close();	
	}
}
	