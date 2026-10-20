package jeet;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class empdao {
	public static int insert(emp_detail e)
	{
		int status = 0;
		try
		{
			Connection con = DBConection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into employee(name,email,department,salary) values (?,?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getEmail());
			ps.setString(3,e.getDepartment());
			ps.setFloat(4,e.getSalary());
			
			status = ps.executeUpdate();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	public static List<emp_detail> getAllEmployees()
	{
		List<emp_detail> list = new ArrayList<emp_detail>();
		try
		{
			Connection con = DBConection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from employee");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				emp_detail e = new emp_detail();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setDepartment(rs.getString("department"));
				e.setSalary(rs.getFloat("salary"));
				list.add(e);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}
	
	
	public static emp_detail getEmployeesById(int id)
	{
		emp_detail e = new emp_detail();
		try
		{
			Connection con = DBConection.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from employee where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setDepartment(rs.getString("department"));
				e.setSalary(rs.getFloat("salary"));
			}
			con.close();
		}
		catch(Exception ex1)
		{
			ex1.printStackTrace();
		}
		return e;
	}
	
	public static int update(emp_detail e)
	{
		int status = 0;
		try
		{
			Connection con = DBConection.getConnection();
			PreparedStatement ps =con.prepareStatement("update employee set name=? , email= ? , department= ?,salary= ? where id= ?");
			ps.setString(1,e.getName());
			ps.setString(2,e.getEmail());
			ps.setString(3,e.getDepartment());
			ps.setFloat(4,e.getSalary());
			ps.setInt(5,e.getId());
			status = ps.executeUpdate();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
	
	public static int delete(int id)
	{
		int status = 0;
		try
		{
			Connection con = DBConection.getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from employee where id = ?");
			ps.setInt(1,id);
			status = ps.executeUpdate();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
}
