package swt.eventlistener;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Application {

	Shell shell;
	Display display;

	private Application() {

		display = new Display();
		shell = new Shell(display);

	}

	public static final Application instance = new Application();

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public void center() {
		center(shell);
	}

// window will display in center
	public void center(Shell shell) {
		// TODO Auto-generated method stub
		// find size of display
		Rectangle screenArea = display.getBounds();
		Rectangle window = shell.getBounds();
		System.out.println(screenArea.width + "x" + screenArea.height);

		int x = (screenArea.width - window.width) / 2;
		int y = (screenArea.height - window.height) / 2;

		shell.setLocation(x, y);
	}

	public void run() {
		shell.setVisible(true);
		while (!shell.isDisposed()) { // as long as my window is not closed.
			// read message from queue and dispatch to listners
			if (!display.readAndDispatch()) // if no message found
				display.sleep(); // wait till next message arrives.
		}
	}

}
