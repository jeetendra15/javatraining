package in.conceptarchitect.taskmanager.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
	
	int id;
	String title;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	String description;
	String imageUrl;
	TaskStatus status;
	Date startDate;
	Date expectedFinishDate;
	Date actualFinishDate;
	String tags;
	Task parent;
	
	
	public Task getParent() {
		return parent;
	}

	public void setParent(Task parent) {
		this.parent = parent;
	}

	List<Task> subTasks=new ArrayList<>();
	List<Note> notes=new ArrayList<Note>();

	public Task(String title) {
		super();
		this.title = title;
		this.description=title;
		this.status=TaskStatus.Pending;
		this.startDate=new Date();		
		this.tags=title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpectedFinishDate() {
		return expectedFinishDate;
	}

	public void setExpectedFinishDate(Date expectedFinishDate) {
		this.expectedFinishDate = expectedFinishDate;
	}

	public Date getActualFinishDate() {
		return actualFinishDate;
	}

	public void setActualFinishDate(Date actualFinishDate) {
		this.actualFinishDate = actualFinishDate;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public List<Task> getSubTasks() {
		return subTasks;
	}

	public void setSubTasks(List<Task> subTasks) {
		this.subTasks = subTasks;
	}

	public void addSubTask(Task task) {
		// TODO Auto-generated method stub
		if(task.id>0) {
			
			task.parent=this;
			subTasks.add(task);
			
		}
	}
	
	
	
	
	
	
	
}
