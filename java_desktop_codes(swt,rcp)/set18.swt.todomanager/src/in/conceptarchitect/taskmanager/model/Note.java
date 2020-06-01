package in.conceptarchitect.taskmanager.model;

import java.util.Date;

public class Note {
	Date date;
	String description;
	
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Note(String description) {
		super();
		this.description = description;
		date=new Date();
	}
	
}
