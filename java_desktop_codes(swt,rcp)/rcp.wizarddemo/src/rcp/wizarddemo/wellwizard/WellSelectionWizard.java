package rcp.wizarddemo.wellwizard;

import org.eclipse.jface.wizard.Wizard;

public class WellSelectionWizard extends Wizard {

	protected UserSignIn userSignIn;
	protected WellSelection wellSelection;

	public WellSelectionWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public String getWindowTitle() {
		return "Well Selection Wizard";
	}

	@Override
	public void addPages() {
		userSignIn = new UserSignIn();
		wellSelection = new WellSelection();
		addPage(userSignIn);
		addPage(wellSelection);
	}

	@Override
	public boolean performFinish() {
		// Print the result to the console
		System.out.println(userSignIn.toString());
		return true;
	}

}
