package in.conceptarchitect.taskmanager.model;

import java.util.Collection;
import java.util.HashMap;

public class Project {
	
	String name;
	String password;
	int taskCount;
	HashMap<Integer, Task> tasks=new HashMap<Integer, Task>();

	public Collection<Task> getTasks() {
		return tasks.values();
	}

	
	public Project(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public boolean authenticate(String password) {
		return this.password.contentEquals(password);
	}


	
	
	public Task createTask(String description) {
		taskCount++;
		Task task=new Task(description);
		task.id=taskCount;
		
		return task;
		
	}


	public boolean addTask(Task task) {
		// TODO Auto-generated method stub
		if(task.id==0)
			return false;
		
		if(task.getParent()==null)
			tasks.put(task.id, task);
		
		return true;
		
	}
	

}
