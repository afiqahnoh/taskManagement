package tsm.dao;
import java.sql.*;

import java.util.*;

import tsm.model.Subject;
import tsm.db.ConnectionManager;
public class SubjectDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private String subject_Code,subject_Name;
	private int subject_Id;
	
	public void addSubject(Subject bean) {
		
		subject_Code = bean.getSubject_Code();
		subject_Name = bean.getSubject_Name();
		
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("INSERT INTO subject (subject_Code,subject_Name) values(?,?)");
			ps.setString(1, bean.getSubject_Code());
			ps.setString(2, bean.getSubject_Name());
			
			ps.executeUpdate();
			System.out.println("Successfully add subject");
			
			con.close();
		}catch (Exception e) {
	          e.printStackTrace();
	    }
	}
	
	
	public static List<Subject> getAllSubject(){
		List<Subject> subjects = new ArrayList<Subject>();
		
		try {
			con = ConnectionManager.getConnection();
			
			stmt = con.createStatement();
			String sql = "SELECT * FROM subject ORDER BY subject_Id";
			
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				Subject s = new Subject();
				s.setSubject_Id(rs.getInt("subject_Id"));
				s.setSubject_Code(rs.getString("subject_Code"));
				s.setSubject_Name(rs.getString("subject_Name"));
				subjects.add(s);
				
			}
			con.close();
		}catch (Exception e) {
	          e.printStackTrace();
	    }
		
		return subjects;
	}
	
	public static Subject getSubjectById(int subject_Id) {
		Subject s = new Subject();
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("SELECT * FROM subject WHERE subject_Id=?");
			ps.setInt(1,subject_Id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				s.setSubject_Id(rs.getInt("subject_Id"));
				s.setSubject_Code(rs.getString("subject_Code"));
				s.setSubject_Name(rs.getString("subject_Name"));
			}
			
			con.close();
			
		}catch (Exception e) {
	          e.printStackTrace();
	    }
		
		return s;
	}
	
	public void deleteSubject(String subject_Code) {
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("DELETE FROM subject WHERE subject_Code=?");
			ps.setString(1, subject_Code);
			ps.executeUpdate();
			
			con.close();
			
		}catch (Exception e) {
	          e.printStackTrace();
	    }
	}
	
	public void updateSubject(Subject bean) {
		subject_Id = bean.getSubject_Id();
		subject_Code= bean.getSubject_Code();
		subject_Name= bean.getSubject_Name();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("UPDATE subject SET subject_Code=?, subject_Name=? WHERE subject_Id=?");
			ps.setString(1, subject_Code);
			ps.setString(2, subject_Name);
			ps.setInt(3, subject_Id);
			
			
			ps.executeUpdate();
			
			System.out.println("Successfully updated");
			
			con.close();
			
		}catch (Exception e) {
	          e.printStackTrace();
	    }
	}

}
