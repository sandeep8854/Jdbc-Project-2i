package sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class ConnectionPooling
{
	public static void main(String[] args)throws Exception
	{
		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setURL("jdbc:mysql://localhost:3306/employees");
		ds.setUser("root"); 
		ds.setPassword("root");
		Connection con=ds.getConnection();
		Statement st=con.createStatement();
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
/*
 * EmpNo	Ename	Esal	Eaddr
*************************************************
100	Sandeep	10000.0	UttarPradesh
200	ShriKant	20000.0	AndhraPradesh
400	YashWardhan	40000.0	Bihar
600	Harsh	70000.0	Agra
300	Pradeep	30000.0	Agra
700	Rajan	50000.0	Bangalore
 */
