package swt.todoapp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;

public class ToDoBuilder implements UIBuilder {

	ControlBuilder builder;

	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub

		builder = new ControlBuilder(parent);
		parent.setLayout(new RowLayout());

		builder.button("Greet").get(Button.class).addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub

//				MessageBox messageBox = new MessageBox(Application.instance.getShell(), SWT.ICON_INFORMATION);
//				messageBox.setMessage("Welcome to TO-DO Manager");
//				messageBox.setText("Hello World");
//				int value = messageBox.open();

				MessageDialog.info("Hello World", "Welcome to TO-DO Manager");

			}
		});

		builder.button("Ask").get(Button.class).addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub

				MessageBox messageBox = new MessageBox(Application.instance.getShell(),
						SWT.ICON_QUESTION | SWT.YES | SWT.NO);
				messageBox.setMessage("Do you like SWT?");
				messageBox.setText("Quick Survey");
				int value = messageBox.open();

				if (value == SWT.YES)
					System.out.println("Thank you!!!!");
				else
					System.out.println("Sorry!!!!");

			}
		});

		builder.button("About").get(Button.class).addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub

		
			}
		});

		builder.button("Quit").get(Button.class).addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub

				System.exit(0);
			}
		});
		
		
		
		parent.pack();
	}

}
