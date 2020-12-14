package sandeep.algoExpert.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchUpdateSimpleStatement
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
		st.addBatch("insert into employees values(700,'Rahul',80000,'Gazipur')");
		st.addBatch("update employees set esal=30000 where EmpNo=300");
		st.addBatch("delete from employees where EmpNo=500");
		int[] count=st.executeBatch();
		int updateCount=0;
		for(int x :count)
		{
			updateCount=updateCount+x;
		}
		System.out.println("Number Of Row Updated "+updateCount);
		con.close();
	}
}
