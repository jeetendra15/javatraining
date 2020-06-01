package in.conceptarchitect.taskmanager.model;

public class DummyProjectSource {

	
	
	public void addTasks(ProjectManager manager) {
		
		Project project=manager.getProject();
		
		Task learnSwt= project.createTask("Learn SWT");
		learnSwt.addSubTask(project.createTask("Learn UI Design"));
		learnSwt.addSubTask(project.createTask("Learn Business Modeling"));
		learnSwt.getNotes().add(new Note("We Need to check of toobar design"));
		learnSwt.getNotes().add(new Note("Toolbar Image issure resovled"));
		learnSwt.setStatus(TaskStatus.Started);
		
		
		
		Task learnAdvancedJava= project.createTask("Learn Advanced Java)");
		learnAdvancedJava.addSubTask(project.createTask("Learn Streams"));
		learnAdvancedJava.addSubTask(project.createTask("Learn Web"));
		learnAdvancedJava.setStatus(TaskStatus.Pending);
		
		project.addTask(learnSwt);
		project.addTask(learnAdvancedJava);
		
		
		
		
	}
	
}
