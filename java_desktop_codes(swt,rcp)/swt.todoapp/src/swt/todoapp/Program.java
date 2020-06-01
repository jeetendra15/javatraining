package swt.todoapp;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Application
			.instance
			.setTitle("To-Do App")
			.build(new ToDoBuilder())
			.center()
			.run();
	}

}
