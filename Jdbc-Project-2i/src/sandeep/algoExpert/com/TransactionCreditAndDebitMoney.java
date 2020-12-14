package sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionCreditAndDebitMoney 
{
	public static void main(String[] args) throws Exception 
	{
		String Driver="com.mysql.jdbc.Driver";
		String jdbc_url="jdbc:mysql://localhost:3306/Accounts"; 
		String user="root";
		String pwd="root"; 
		Class.forName(Driver);
		Connection con=DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st=con.createStatement();
		System.out.println("Data Before Transaction   ");
		System.out.println("******************************");
		ResultSet rs=st.executeQuery("select * from Accounts");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
		}
		System.out.println("Transaction Begin.....");
		con.setAutoCommit(false);
		st.executeUpdate("update accounts set Balance=Balance-10000 where name='Sandeep'");
		st.executeUpdate("update accounts set balance=balance+10000 where name='SunnyLeone'");
		System.out.println("Can You Please Confirm This Transaction Of 10000 [YES/NO]");
		Scanner sc=new Scanner(System.in);
		String option=sc.next();
		if(option.equalsIgnoreCase("YES"))
		{
			con.commit();
			System.out.println("Transaction Commited ..");
		}
		else
		{
			con.rollback();
			System.out.println("Transaction Rolled Back");
		}
		System.out.println("Data After Tranaction ...");
		System.out.println("***************************");
		ResultSet rs1=st.executeQuery("select * from Accounts");
		while(rs1.next())
		{
			System.out.println(rs1.getString(1)+"\t"+rs1.getInt(2));
		}
		con.close();
	}
}
