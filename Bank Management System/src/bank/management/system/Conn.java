package bank.management.system;

import java.sql.*;
public class Conn {
	
	Connection c;
	Statement s;
	public Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement","root","XXX");//creating the connection
			s=c.createStatement();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
//1)Register the Driver
//2)Create Connection
//3)Create Statement
//4)Execute query
//5)Close Connection
//we will not run this code it is used for setting up connection and being called as an object ..