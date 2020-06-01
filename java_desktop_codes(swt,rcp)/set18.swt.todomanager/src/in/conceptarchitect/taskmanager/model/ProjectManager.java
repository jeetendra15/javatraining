package in.conceptarchitect.taskmanager.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

public class ProjectManager {
	
	Project project=new Project("dummy","dummy");
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public boolean createProject(String name, String password, boolean ignoreExisting ) {
		if(project!=null && !ignoreExisting)
			return false; //can't create a new project till I close the current one
		
		project=new Project(name, password);
		return true;
	}
	
	public boolean openProject(String path,String password) {
		try {
			FileInputStream out=new FileInputStream(path);
			ObjectInputStream oos=new ObjectInputStream(out);
			project=(Project)oos.readObject();
			return project.authenticate(password);
		} catch(Exception ex) {
			return false;
		}
	}
	
	public boolean saveProject(String path) {
		
		try {
			FileOutputStream out=new FileOutputStream(path);
			ObjectOutputStream oos=new ObjectOutputStream(out);
			oos.writeObject(project);
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		
		return false;
	}
	
	public boolean addTask(Task task) {
		project.addTask(task);
			
		return true;
	}
	
	public boolean removeTask(Task task) {
		return false;
	}
	
	public Collection<Task> getTasks(){
		return project.getTasks();
	}
	
	public boolean updateTask(Task task) {
		return true;
	}
	
	

}
