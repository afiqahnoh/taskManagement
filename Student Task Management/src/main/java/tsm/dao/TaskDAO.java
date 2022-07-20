package tsm.dao;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import tsm.model.task;
import tsm.db.ConnectionManager;

public class TaskDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private int task_ID;
	private String task_Name,task_State;
	private Date due_Date;
	
	public void addTask(task t) {
		
		task_Name = t.getTask_Name();
		due_Date = (Date)t.getDue_Date();
		task_State = t.getTask_State();
		
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("INSERT INTO task (task_Name, due_Date,task_State) values (?,?,?)");
			
			ps.setString(1, t.getTask_Name());
			ps.setDate(2, (java.sql.Date) t.getDue_Date());
			ps.setString(3, t.getTask_State());
			
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			con.close();
		}catch (Exception e) {
	          e.printStackTrace();
	    }
		
	}
	
	public static List<task> getAllTask(){
		List<task> tasks = new ArrayList<task>();
		
		try {
			con = ConnectionManager.getConnection();
			
			stmt = con.createStatement();
			String sql = "SELECT * FROM task ORDER BY task_ID";
			
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				task t = new task();
				t.setTask_ID(rs.getInt("task_ID"));
				t.setTask_Name(rs.getString("task_Name"));
				t.setDue_Date(rs.getDate("due_Date"));
				t.setTask_State(rs.getString("task_State"));
				
				tasks.add(t);

			}con.close();
		}catch (Exception e) {
	          e.printStackTrace();
	    }
		
		return tasks;
	}
	
	public static task getTaskById(int task_ID) {
		task t = new task();
		
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("SELECT * FROM task WHERE task_ID=?");
			ps.setInt(1,task_ID);
			
			rs = ps.executeQuery();
						
			if(rs.next()) {
				t.setTask_ID(rs.getInt("task_ID"));
				t.setTask_Name(rs.getString("task_Name"));
				t.setDue_Date(rs.getDate("due_Date"));
				t.setTask_State(rs.getString("task_State"));
			}
			
			con.close();
		}
		catch (Exception e) {
	          e.printStackTrace();
	    }
		
		return t;
	}
	
	public void updateTask(task bean) {
		
		task_ID = bean.getTask_ID();
		task_Name = bean.getTask_Name();
		due_Date = (Date) bean.getDue_Date();
		task_State = bean.getTask_State();
		
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("UPDATE task SET task_Name=?, due_Date=?, task_State=? WHERE task_ID=?");
			ps.setString(1,task_Name);
			ps.setDate(2,due_Date);
			ps.setString(3,task_State);
			ps.setInt(4,task_ID);
			
			
			ps.executeUpdate();
			
			System.out.println("Successfully updated");
			
			con.close();
		}catch (Exception e) {
	          e.printStackTrace();
	    }
		
	}
	
	public void deleteTask(int task_ID) {
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("DELETE FROM task WHERE task_ID=?");
			ps.setInt(1, task_ID);			
			ps.executeUpdate();
			
			con.close();
			
		}catch (Exception e) {
	          e.printStackTrace();
	    }

	}
}
