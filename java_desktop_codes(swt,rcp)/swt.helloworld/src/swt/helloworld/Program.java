package swt.helloworld;

import java.io.IOException;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Program {

	public static void main(String args[]) throws IOException {

		// Step 1: Controller of a SWT application & its window
		Display display = new Display();

		// Step 2: Create a shell(similar to AWT frame)
		Shell shell = new Shell(display);

		// Step 3: Display the shell
		shell.setVisible(true);

		System.in.read();
	}
}
