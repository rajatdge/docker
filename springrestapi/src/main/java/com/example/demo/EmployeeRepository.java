package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class EmployeeRepository {
	
	Connection con = null;
	public EmployeeRepository() {
		String url="jdbc:mysql://localhost:3306/employeedata";
		String username="root";
		String password="";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username, password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement st;
		try {
			st = con.createStatement();
			st.executeUpdate("create table employee(id int,name varchar(20),age int,PRIMARY KEY(id))");
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Employee> getemployees(){
		
		List<Employee> emps=new ArrayList<>();
		String sql="select * from employee";
		try {
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				Employee e =new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getInt(3));
				
				emps.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emps;
	}
	
public Employee getemployee(int id){
		
		String sql="select * from employee where id="+id;
		Employee em =new Employee();

		try {
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if(rs.next()) {
				em.setId(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setAge(rs.getInt(3));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return em;
	}

public void create(Employee e1) {
	String sql = "insert into employee values (?,?,?)";
	try {
		PreparedStatement st= con.prepareStatement(sql);
		st.setInt(1, e1.getId());
		st.setString(2, e1.getName());
		st.setInt(3, e1.getAge());
		st.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
}

public void update(Employee e1, int id) {
	String sql = "update employee set name=?, age=? where id="+id;
	try {
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, e1.getName());
		st.setInt(2, e1.getAge());
		st.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void delete(int id) {
	// TODO Auto-generated method stub
	String sql = "delete from employee where id="+id;
	try {
		PreparedStatement st = con.prepareStatement(sql);
		st.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}


	
}
