package rcp.wizarddemo.wellwizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class UserSignIn extends WizardPage {

	private Text userName;
	private Text password;
	private Composite composite;

	public UserSignIn() {
		// TODO Auto-generated constructor stub
		super("User Page");
		setTitle("User");
		setDescription("User authentication");
	}

	public String getUserName() {
		return userName.getText();
	}

	public String getPassword() {
		return password.getText();
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

		composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		layout.numColumns = 2;

		Label userLabel = new Label(composite, SWT.NONE);
		userLabel.setText("User Name :   ");

		userName = new Text(composite, SWT.BORDER | SWT.SINGLE);
		userName.setText("");

		Label passwordLabel = new Label(composite, SWT.NONE);
		passwordLabel.setText("Password :   ");

		password = new Text(composite, SWT.BORDER | SWT.SINGLE | SWT.PASSWORD);
		password.setText("");

		userName.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (!userLabel.getText().isEmpty()) {
					setPageComplete(true);
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		GridData userNameGridData = new GridData(GridData.FILL_HORIZONTAL);
		userName.setLayoutData(userNameGridData);

		GridData passwordGridData = new GridData(GridData.FILL_HORIZONTAL);
		password.setLayoutData(passwordGridData);

		setControl(composite);
		setPageComplete(false);
	}

	@Override
	public String toString() {
		return "userName: " + getUserName() + "  " + "password: " + getPassword();
	}

}
