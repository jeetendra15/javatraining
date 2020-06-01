package awt.multiplelayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class AppUiBuilder {
	Shell shell;

	public AppUiBuilder(Shell parent) {
		this.shell = parent;
	}

	public void build(Composite parent, Display display) {

//		parent.setLayout(new FillLayout(SWT.VERTICAL)); // splits screen two parts upper , lower
//
//		Composite upperPanel = new Composite(parent, 0);
//		GridLayout labelLayout = new GridLayout(4, true);
//		labelLayout.horizontalSpacing = 10;
//		upperPanel.setLayout(labelLayout); // by default horizontal layout
//
//		Label label = new Label(upperPanel, SWT.RIGHT);
//		label.setText("Button");
//		label.setLayoutData(new GridData(100, 100));
//		label.setBackground(new Color(display, new RGB(220, 220, 220)));
//
//		Composite lowerPanel = new Composite(parent, 0);
//		GridLayout gridLayout = new GridLayout(4, true);
//		gridLayout.horizontalSpacing = 10;
//		lowerPanel.setLayout(gridLayout);
//
//		extractPanel(lowerPanel);

		parent.setLayout(new GridLayout(4, true));
		
		Label label = new Label(parent, SWT.RIGHT);
		label.setText("Button");
		label.setLayoutData(new GridData(100, 50));
		label.setBackground(new Color(display, new RGB(220, 220, 220)));
		

//		Composite lowerLeftPanel = new Composite(lowerPanel, 0);
//		RowLayout lowerLeftPanelLayout = new RowLayout(SWT.HORIZONTAL);
//
//		lowerLeftPanelLayout.justify = true;
//
//		lowerLeftPanel.setLayout(lowerLeftPanelLayout);
//		extractPanel(lowerLeftPanel);
//
//		Composite lowerRightPanel = new Composite(lowerPanel, 0);
//		lowerRightPanel.setLayout(new RowLayout(SWT.VERTICAL));
//		extractPanel(lowerRightPanel);

		// Grid layout Code

//		GridLayout layGridLayout = new GridLayout();
//
//		layGridLayout.numColumns = 5;
//		layGridLayout.horizontalSpacing = 20;
//		layGridLayout.verticalSpacing = 10;
//
//		// layGridLayout.makeColumnsEqualWidth = true;
//
//		parent.setLayout(layGridLayout);
//		
//		Button button = new Button(parent, SWT.PUSH);
//		button.setText("My Button");
//		GridData buttonGridData = new GridData();
//		
//		buttonGridData.horizontalAlignment = SWT.FILL;
//		
//		button.setLayoutData(buttonGridData);
//	
//
//		extractPanel(parent);

	}

	private void extractPanel(Composite parentPanel) {
		for (int i = 1; i <= 15; i++) {
			Button button = new Button(parentPanel, SWT.PUSH);
			button.setText("Button " + i);
		}
	}

}
