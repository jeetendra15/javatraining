package swt.todoapp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class MessageDialog {

	public static int show(String heading, String message, int style) {

		Shell shell = Display.getCurrent().getShells()[0];
		MessageBox messageBox = new MessageBox(shell, style);
		messageBox.setMessage(message);
		messageBox.setText(heading);
		return messageBox.open();

	}

	public static int info(String heading, String message) {

		return show(heading, message, SWT.ICON_INFORMATION);
	}

	public static int error(String heading, String message) {

		return show(heading, message, SWT.ICON_ERROR);
	}

	public static int warrning(String heading, String message) {

		return show(heading, message, SWT.ICON_WARNING);
	}

	public static int yesNo(String heading, String message) {

		return show(heading, message, SWT.ICON_QUESTION);
	}
}
