package sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class BatchUpdateWithPreparedStatement
{
	public static void main(String[] args) throws Exception 
	{
		String Driver="com.mysql.jdbc.Driver";
		String jdbc_url="jdbc:mysql://localhost:3306/employees"; 
		String user="root";
		String pwd="root"; 
		Class.forName(Driver);
		Connection con=DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st=con.createStatement();
		
		PreparedStatement pst=con.prepareStatement("insert into employees values(?,?,?,?)");
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter Employees Number ? ");
			int empno=sc.nextInt();
			System.out.println("Enter Employees Ename ?");
			String ename=sc.next();
			System.out.println("Enter Employees Esal ?");
			Double esal=sc.nextDouble();
			System.out.println("Enter Employees Eaddr ?");
			String eaddr=sc.next();
			pst.setInt(1,empno);
			pst.setString(2,ename);
			pst.setDouble(3,esal); 
			pst.setString(4,eaddr); 
			pst.addBatch();

			System.out.println("Do You Want To Insert One More Record [YES/NO]");
			String option=sc.next();
			if(option.equalsIgnoreCase("NO"))
			{
				break;
			}	
		}
		pst.executeBatch();
		System.out.println("Record Insert Successfully.....");
		con.close();	
	}
}
