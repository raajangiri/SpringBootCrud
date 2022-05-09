package com.raajangiri.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.raajangiri.Entity.Employee;

@Repository
public class MyRepository {
	
	
	public static Connection con;
//	MyRepository myRepository=new MyRepository();
	public String save(Employee employee) {
		int i=0;

		try {

//			Class.forName("com.mysql.jdbc.Driver");
			// connect
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO tbl_employees(id,NAME,location,department) values(?,?,?,?)");
			stmt.setLong(1, employee.getId());
			stmt.setString(2, employee.getName());
			stmt.setString(3, employee.getLocation());
			stmt.setString(4, employee.getDepartment());

			 i = stmt.executeUpdate();
			System.out.println(" records updated");
		} catch (Exception e) {
			System.out.println(e);
		}
		String str=i  +" records Saved Successfully";
		return str;
	}

	public  String update(Employee employee, long id) {
		int i=0;
		try {

//			Class.forName("com.mysql.jdbc.Driver");
			// connect
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

			PreparedStatement stmt = con
					.prepareStatement("update tbl_employees  set name=?, location=?, department=? where id=?");
			stmt.setLong(4, id);
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getLocation());
			stmt.setString(3, employee.getDepartment());
			

			 i = stmt.executeUpdate();
			System.out.println(" records updated");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		String str=i  +" records updated Successfully";
		return str;

	}

	public  String deleteById(long id) {
		int i=0;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			// connect
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			 

			PreparedStatement stmt = con.prepareStatement("delete from tbl_employees where id=?");

			stmt.setLong(1, id);

			i = stmt.executeUpdate();
			System.out.println(" records deleted Successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
		String str=i  +" records deleted Successfully";
		return str;
		
	}

	public List<Employee> findAll() throws ClassNotFoundException {

//		Connection con = MyRepository.getCon();
		List <Employee> list =new ArrayList<>();

		try {
			
//			Class.forName("com.mysql.jdbc.Driver");
			// connect
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			PreparedStatement stmt = con.prepareStatement("select *from tbl_employees ");
			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				System.out
//						.println(rs.getLong(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
//				
//			}
			while (rs.next()) {
				list.add(new Employee(rs.getLong(1),rs.getString(2), rs.getString(2), rs.getString(2)));
			}
//			Employee emp=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
//			list.add(emp);
			
			

		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println(list);
		return list;
		
		

	}

	public List<Employee> findById(long id) {
		List <Employee> list =new ArrayList<>();
		
		try {

//			Class.forName("com.mysql.jdbc.Driver");
			// connect
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

			PreparedStatement stmt = con.prepareStatement("select *from tbl_employees where id=?");

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				System.out
//						.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
//			}
			while (rs.next()) {
				list.add(new Employee(rs.getLong(1),rs.getString(2), rs.getString(2), rs.getString(2)));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

		

}
