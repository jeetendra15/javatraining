package swt.todoapp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class AboutScreen implements UIBuilder {

	Shell shell;
	
	public AboutScreen() {
		// TODO Auto-generated constructor stub
		
		shell = Display.getDefault().getActiveShell();

	}
	
	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub

		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		rowLayout.justify = true;
		parent.setLayout(rowLayout);
		ControlBuilder builder = new ControlBuilder(parent);

		builder
			.label("About TO-DO Manager")
			.label("Version 1.0")
			.button("OK")
			.get(Button.class)
			.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						// TODO Auto-generated method stub

						parent.dispose();
					}
				});

		parent.setSize(400, 200);
	}

}
