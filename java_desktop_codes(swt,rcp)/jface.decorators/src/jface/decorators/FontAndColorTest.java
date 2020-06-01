package jface.decorators;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import swing2swt.layout.FlowLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;

public class FontAndColorTest {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FontAndColorTest window = new FontAndColorTest();
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
		shell.setSize(769, 371);
		shell.setText("SWT Application");
		FillLayout fl_shell = new FillLayout(SWT.VERTICAL);
		fl_shell.marginWidth = 40;
		fl_shell.marginHeight = 40;
		fl_shell.spacing = 20;
		shell.setLayout(fl_shell);

		Button swtButton = new Button(shell, SWT.NONE);
		swtButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION);
				messageBox.setMessage("SWT Button using Window Builder.\nVersion 1.0");
				messageBox.setText("Welcome to Window Builder");
				messageBox.open();
			}
		});

		swtButton.setToolTipText("");
		swtButton.setImage(SWTResourceManager.getImage(FontAndColorTest.class, "/images/add-icon.jpg"));
		swtButton.setFont(SWTResourceManager.getFont("Courier New", 15, SWT.BOLD));
		swtButton.setForeground(SWTResourceManager.getColor(240, 255, 240));
		swtButton.setBackground(SWTResourceManager.getColor(95, 158, 160));
		swtButton.setText("SWT Button\r\n");

		// JFace has built in resource manager class

		LocalResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources(), shell);

		Button jFaceButton = new Button(shell, SWT.NONE);
		jFaceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION);
				messageBox.setMessage("JFace Button using Window Builder.\nVersion 1.0");
				messageBox.setText("Welcome to Window Builder");
				messageBox.open();
			}
		});

		FontDescriptor fontDescriptor = FontDescriptor.createFrom("Courier New", 15, SWT.BOLD | SWT.ITALIC);
		Font font = resourceManager.createFont(fontDescriptor);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromFile(getClass(), "/images/check.png");
		Image image = resourceManager.createImage(imageDescriptor);
		jFaceButton.setImage(image);
		jFaceButton.setFont(font);
		jFaceButton.setForeground(new Color(resourceManager.getDevice(), new RGB(240, 255, 240)));
		jFaceButton.setBackground(new Color(resourceManager.getDevice(), new RGB(95, 158, 160)));
		jFaceButton.setText("JFace Button");

	}
}
