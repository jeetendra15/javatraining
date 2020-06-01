package swt.todoappmanager;

import swt.todoappmanager.model.DummyProjectSource;
import swt.todoappmanager.model.ProjectManager;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Application
			.instance
			.addService("project-manager", new ProjectManager())
			.addService("dummy-project-source",new DummyProjectSource())
			.setTitle("Task Manager")
			.build(new TaskManagerMainScreen())
			//.center()
			.run();
	}

}
