package jface.decorators;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Spinner;

public class DecoratorWindow {

	protected Shell shell;
	private Text text;
	private Button btnValidate;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DecoratorWindow window = new DecoratorWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		RowLayout rl_shell = new RowLayout(SWT.HORIZONTAL);
		rl_shell.justify = true;
		shell.setLayout(rl_shell);

		text = new Text(shell, SWT.BORDER);

		ControlDecoration controlDecoration = new ControlDecoration(text, SWT.LEFT | SWT.TOP);

		LocalResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources(), shell);

		ImageDescriptor imageDescriptor = ImageDescriptor.createFromFile(getClass(), "/images/check.png");

		Image image = resourceManager.createImage(imageDescriptor);

		Image requiredImage = FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED).getImage();

		Image warningImage = FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_WARNING).getImage();

		controlDecoration.setDescriptionText("This Field is Mandatory");
		controlDecoration.setImage(requiredImage);

		btnValidate = new Button(shell, SWT.NONE);
		btnValidate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String value = text.getText();
				if (value.equals("") || value == null) {

//					MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING);
//					messageBox.setText("Warning");
//					messageBox.setMessage("Field is mendatory");
//					messageBox.open();

					controlDecoration.setImage(warningImage);

				} else {
					controlDecoration.setImage(image);
				}

			}
		});

		btnValidate.setText("Validate");

	}

}
