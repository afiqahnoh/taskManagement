package tsm.model;

public class Subject {
	public String subject_Code;
	public String subject_Name;
	public int subject_Id;
	
	public Subject() {
		
	}

	public Subject(String subject_Code, String subject_Name, int subject_Id) {
		super();
		this.subject_Code = subject_Code;
		this.subject_Name = subject_Name;
		this.subject_Id = subject_Id;
	}

	public String getSubject_Code() {
		return subject_Code;
	}

	public void setSubject_Code(String subject_Code) {
		this.subject_Code = subject_Code;
	}

	public String getSubject_Name() {
		return subject_Name;
	}

	public void setSubject_Name(String subject_Name) {
		this.subject_Name = subject_Name;
	}

	public int getSubject_Id() {
		return subject_Id;
	}

	public void setSubject_Id(int subject_Id) {
		this.subject_Id = subject_Id;
	}



	
	
}
