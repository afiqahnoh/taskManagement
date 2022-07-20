package tsm.model;

import java.util.Date;

public class task{

	int task_ID;
	String task_Name;
	Date due_Date;
	String task_State;
	
	public task() {
		
	}
	
	public task(int task_ID, String task_Name, Date due_Date, String task_State) {
		this.task_ID = task_ID;
		this.task_Name = task_Name;
		this.due_Date = due_Date;
		this.task_State = task_State;
	}
	public int getTask_ID() {
		return task_ID;
	}
	public void setTask_ID(int task_ID) {
		this.task_ID = task_ID;
	}
	public String getTask_Name() {
		return task_Name;
	}
	public void setTask_Name(String task_Name) {
		this.task_Name = task_Name;
	}
	public Date getDue_Date() {
		return due_Date;
	}
	public void setDue_Date(Date due_Date) {
		this.due_Date = due_Date;
	}
	public String getTask_State() {
		return task_State;
	}
	public void setTask_State(String task_State) {
		this.task_State = task_State;
	}
	
	
	
}
