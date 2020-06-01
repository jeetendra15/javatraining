package swt.todoappmanager.model;

public class DummyProjectSource {

	Project project;
	ProjectManager projectManager;

	public void addTasks(ProjectManager manager) {

		project = manager.getProject();
		this.projectManager = manager;

		Task learnDesktopApp = createTask("Learn Deskopt Application In Java"); // Main Task
		Task learnSwt = createSubTask("Learning SWT Framework", learnDesktopApp); // Sub Task
		learnSwt.setStatus(TaskStatus.Completed);
		createSubTask("Learn JFace", learnDesktopApp);
		Task learnRcp = createSubTask("Learn RCP", learnDesktopApp);
		learnRcp.setStatus(TaskStatus.Started);
		createSubTask("Learn Osgi", learnRcp);
		createSubTask("Learn Eclipse Model", learnRcp);
		createSubTask("Learn Eclipse RCP Architecture", learnRcp);

		Task learnAdvancedJava = createTask("Learn Advanced Java");
		learnAdvancedJava.setStatus(TaskStatus.Started);
		createSubTask("Learn Streams", learnAdvancedJava);
		Task learnDatabase = createSubTask("Learn Database Connectivity", learnAdvancedJava);
		createSubTask("Learn ORM", learnDatabase);
		Task learnReflection = createSubTask("Learn Reflection", learnAdvancedJava);
		learnReflection.setStatus(TaskStatus.Canceled);
		createSubTask("Learn Annotation", learnReflection);

		Task learnWeb = createTask("Learn Web Development");
		createSubTask("Learn Servlets", learnWeb);
		createSubTask("Learn JEE", learnWeb);
		createSubTask("Learn Spring Web", learnWeb);
		createSubTask("Learn Web API", learnWeb);

		project.addTask(learnDesktopApp);
		project.addTask(learnAdvancedJava);

	}

	Task createTask(String title) {
		return createTask(title, title, TaskStatus.Pending, null, "Simple Note 1", "Simple Note 2", "Simple Note 3");

	}

	Task createSubTask(String title, Task parent) {
		return createTask(title, title, TaskStatus.Pending, parent, "Simple Note1", "Simple Note2", "Simple Note3");
	}

	Task createTask(String title, String description, TaskStatus status, Task parentTask, String... notes) {
		Task task = project.createTask(title);
		task.setStatus(status);
		task.setDescription(description);
		if (parentTask != null)
			parentTask.addSubTask(task);
		else
			project.addTask(task);

		for (String note : notes) {
			Note n = new Note(note);
			task.getNotes().add(n);
		}

		return task;
	}
}
