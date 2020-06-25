package rcp.wizarddemo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.data.IColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ReflectiveColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultColumnHeaderDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.CompositeLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import rcp.wizarddemo.model.WellInformation;
import rcp.wizarddemo.wellwizard.WellSelectionWizard;

import org.eclipse.swt.widgets.Label;

public class MainWindow {

	public static List<WellInformation> list;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

//		List<Person> list1 = new ArrayList<Person>();
//
//		Person person = new Person();
//		person.setFirstName("jeetendra");
//		person.setLastName("mishra");
//
//		list1.add(person);
//		
//		System.out.println(list1);

		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(1000, 271);
		shell.setText("Well Information Application");
		shell.setLayout(new GridLayout());

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem window = new MenuItem(menu, SWT.CASCADE);
		window.setText("&Window");

		Menu windowMenu = new Menu(shell, SWT.DROP_DOWN);

		MenuItem windowWellSelectionWizard = new MenuItem(windowMenu, SWT.CASCADE);
		windowWellSelectionWizard.setText("&Well Selection Wizard");

		window.setMenu(windowMenu);

		shell.setLayout(new GridLayout());

		// property names of the Person class
//		String[] propertyNames = { "wellName", "easting", "northing", "azimuth", "field", "reservoir", "type" };

		String[] propertyNames = { "firstName", "lastName" };

		// List<WellInformation> listOfSelectedWells;

		List<Person> list1 = new ArrayList<Person>();

		Person person = new Person();
		person.setFirstName("jeetendra");
		person.setLastName("mishra");

		list1.add(person);

		// mapping from property to label, needed for column header labels
//		Map<String, String> propertyToLabelMap = new HashMap<String, String>();
//		propertyToLabelMap.put("wellName", "WellName");
//		propertyToLabelMap.put("easting", "Easting");
//		propertyToLabelMap.put("northing", "Northing");
//		propertyToLabelMap.put("azimuth", "Azimuth");
//		propertyToLabelMap.put("field", "Field");
//		propertyToLabelMap.put("reservoir", "Reservoir");
//		propertyToLabelMap.put("type", "Type");

		Map<String, String> propertyToLabelMap = new HashMap<String, String>();
		propertyToLabelMap.put("firstName", "WellName");
		propertyToLabelMap.put("lastName", "Easting");

		// create the data provider
		IColumnPropertyAccessor<Person> columnPropertyAccessor = new ReflectiveColumnPropertyAccessor<Person>(
				propertyNames);
		IDataProvider bodyDataProvider = new ListDataProvider<Person>(list1, columnPropertyAccessor);

		final DataLayer bodyDataLayer = new DataLayer(bodyDataProvider);
		SelectionLayer selectionLayer = new SelectionLayer(bodyDataLayer);
		ViewportLayer viewportLayer = new ViewportLayer(selectionLayer);

		// build the column header layer stack
		IDataProvider headerDataProvider = new DefaultColumnHeaderDataProvider(propertyNames, propertyToLabelMap);
		DataLayer headerDataLayer = new DataLayer(headerDataProvider);
		ILayer columnHeaderLayer = new ColumnHeaderLayer(headerDataLayer, viewportLayer, selectionLayer);

		// create the composition
		// set the region labels to make default configurations work, e.g. selection
		CompositeLayer compositeLayer = new CompositeLayer(1, 2);
		compositeLayer.setChildLayer(GridRegion.COLUMN_HEADER, columnHeaderLayer, 0, 0);
		compositeLayer.setChildLayer(GridRegion.BODY, viewportLayer, 0, 1);

		// use different style bits to avoid rendering of inactive scrollbars for small
		// table
		// Note: The enabling/disabling and showing of the scrollbars is handled by the
		// ViewportLayer. Without the ViewportLayer the scrollbars will always be
		// visible with the default style bits of NatTable.
		final NatTable natTable = new NatTable(shell.getShells()[0], compositeLayer);

		System.out.println(natTable);

		GridDataFactory.fillDefaults().grab(true, true).applyTo(natTable);

		windowWellSelectionWizard.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				WizardDialog wizardDialog = new WizardDialog(shell, new WellSelectionWizard());
				if (wizardDialog.open() == Window.OK) {
					// lblNewLabel.setText(list.toString());

					System.out.println(list);
					System.out.println("Ok");
				} else {
					System.out.println("Cancel");
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
