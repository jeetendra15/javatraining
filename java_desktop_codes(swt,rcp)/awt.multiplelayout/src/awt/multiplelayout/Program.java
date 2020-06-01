package awt.multiplelayout;

import org.eclipse.swt.widgets.Shell;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Application app = Application.instance;
		Shell shell = app.getShell();

		new AppUiBuilder(shell).build(shell, app.getDisplay());

		app.center();

		app.run();
	}

}
