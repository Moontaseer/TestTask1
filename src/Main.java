import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Main {
	
	
	private Connection dbConnection = null;
	
	Main() {
		try {
			dbConnection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	ResultSet executeQuery(String query) throws SQLException {
		return ((Statement)dbConnection.createStatement()).executeQuery(query);
	}
	
	
	public void headOfDep(int i) throws SQLException {
		ResultSet set = executeQuery("SELECT * FROM lectors where head = 1 and department = 'Department of Electronic Devices'");
		ResultSet set2 = executeQuery("SELECT * FROM lectors where head = 1 and department = 'Department of Applied Linguistics'");
		ResultSet set3 = executeQuery("SELECT * FROM lectors where head = 1 and department = 'Software Department'");
		if (i == 1) {
			if(set != null){
				while(set.next()) {				
						String a = set.getString(2);
						String b = set.getString(3);
						System.out.println("Head of Department of Electronic Devices is " + a + " " + b);
	
				}
			}
		} else if (i == 2) {
			if(set2 != null){
				while(set2.next()) {				
						String a = set2.getString(2);
						String b = set2.getString(3);
						System.out.println("Head of Department of Applied Linguistics is " + a + " " + b);
	
				}
			}
		} else if (i == 3) {
			if(set3 != null){
				while(set3.next()) {				
						String a = set3.getString(2);
						String b = set3.getString(3);
						System.out.println("Head of Software Department is " + a + " " + b);
	
				}
			}
		}
	}
	
	public void showStatistic() throws Exception {
		ResultSet set = executeQuery("SELECT department, degree, count(*) as count from lectors group by department, degree;");
		if(set != null){
			while(set.next()) {
				String a = set.getString(1);
				String s = set.getString(2);
				String b = set.getString(3);
				System.out.println(s + " " + a + ": " + b);
			}
		}
	}
	
	public void avarageSalary() throws SQLException {
		ResultSet set = executeQuery("SELECT department, avg(salary) FROM lectors group by department;");
		if(set != null){
			while(set.next()) {
				String a = set.getString(2);
				String s = set.getString(1);
				
				System.out.println("The average salary of " + s + " is " + a);
			}
		}
	}
	
	public void countOfEmployee() throws SQLException {
		ResultSet set = executeQuery("SELECT * from lectors where department = 'Department of Electronic Devices'");
		ResultSet set2 = executeQuery("SELECT * from lectors where department = 'Department of Applied Linguistics'");
		ResultSet set3 = executeQuery("SELECT * from lectors where department = 'Software Department'");
		if(set != null){
			int i = 0; String a = null;
			while(set.next()) {
				
				i++;
				a = set.getString(4);
				
			}
			System.out.println(a);
			System.out.println("employee count:" + i);
		}
		if(set2 != null){
			int j = 0; String b = null;
			while(set2.next()) {
				j++;
				b = set2.getString(4);
	
			}
			System.out.println(b);
			System.out.println("employee count:" + j);
		}
		if(set3 != null){
			int k = 0; String c = null;
			while(set3.next()) {
				k++;
				c = set3.getString(4);
				
				
			}
			System.out.println(c);
			System.out.println("employee count:" + k);
		}
	}
	
	public void globalSearch(String str) throws SQLException {
		ResultSet set = executeQuery("SELECT * from lectors where name like '%" + str + "%' or surname like '%" + str + "%'");
		if (set != null) {
			while(set.next()) {
				String s = set.getString(2);
				String b = set.getString(3);
				System.out.println(s + " " + b);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Main m = new Main();		
		
		System.out.println("Hello, please make your choice!");
		System.out.println("1.Who is head of department. \n"
				+ "2.Show statistic. \n"
				+ "3. Show the average salary for department. \n"
				+ "4. Show count of employee for departments. \n"
				+ "5. Global search.");
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		if (a == 1) {
			System.out.println("Please, enter department \n"
					+ "1. Department of Electronic Devices \n"
					+ "2. Department of Applied Linguistics \n"
					+ "3. Software Department");
			Scanner scn = new Scanner(System.in);
			int b = scn.nextInt();
			
			m.headOfDep(b);
			
		} else if(a == 2) {
			m.showStatistic();			
			
		} else if(a == 3) {
			m.avarageSalary();
				
		} else if(a == 4) {
			m.countOfEmployee();	
			
		}  else {
			if (a != 5)
			System.out.println("Please, enter a number from 1 to 5");
		}
		
		if(a == 5) {
			System.out.println("Enter search");
			Scanner scn = new Scanner(System.in);
			String b = scn.nextLine();
			System.out.println("Result:");
			
			m.globalSearch(b);
		}
			
	}		
}
