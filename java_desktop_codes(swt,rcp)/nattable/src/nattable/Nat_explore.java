package nattable;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.AbstractRegistryConfiguration;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.ConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.DefaultNatTableStyleConfiguration;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultColumnHeaderDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultCornerDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultRowHeaderDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.data.DummyBodyDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.CornerLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.RowHeaderLayer;
import org.eclipse.nebula.widgets.nattable.hideshow.ColumnHideShowLayer;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.cell.IConfigLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.reorder.ColumnReorderLayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.style.CellStyleAttributes;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.style.Style;
import org.eclipse.nebula.widgets.nattable.util.GUIHelper;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Nat_explore {

	private BodyLayerStack bodyLayer;
	private int statusColumn;
	private int statusRejected;
	private int statusInProgress;
	private boolean check = false;
	private NatTable nattable;
	private String[] properties;
	private static final String FOO_LABEL = "FOO";
	private static final String CELL_LABEL = "Cell_LABEL";

	public static void main(String[] args) {
		new Nat_explore();
	}

	public Nat_explore() {

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		properties = new String[3];

		for (int i = 0; i < properties.length; i++) {

			properties[i] = "Column" + i;
		}

		// Setting the data layout layer
		GridData gridData = new GridData();
		gridData.heightHint = (int) 24;
		gridData.widthHint = (int) 110;

		IConfigRegistry configRegistry = new ConfigRegistry();

		// Body Data Provider
		IDataProvider dataProvider = new DataProvider(properties.length, 1);
		bodyLayer = new BodyLayerStack(dataProvider);
		// datalayer.addConfiguration(new

		// Column Data Provider
		DefaultColumnHeaderDataProvider columnData = new DefaultColumnHeaderDataProvider(properties);
		ColumnHeaderLayerStack columnlayer = new ColumnHeaderLayerStack(columnData);

		// Row Data Provider
		DefaultRowHeaderDataProvider rowdata = new DefaultRowHeaderDataProvider(dataProvider);
		RowHeaderLayerStack rowlayer = new RowHeaderLayerStack(rowdata);

		// Corner Data Provider
		DefaultCornerDataProvider cornerdata = new DefaultCornerDataProvider(columnData, rowdata);
		DataLayer cornerDataLayer = new DataLayer(cornerdata);
		CornerLayer cornerLayer = new CornerLayer(cornerDataLayer, rowlayer, columnlayer);

		GridLayer gridlayer = new GridLayer(bodyLayer, columnlayer, rowlayer, cornerLayer);
		nattable = new NatTable(shell, gridlayer, false);

		// Change for paint
		IConfigLabelAccumulator cellLabelAccumulator = new IConfigLabelAccumulator() {
			// @Override
			public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition) {

				int columnIndex = bodyLayer.getColumnIndexByPosition(columnPosition);
				int rowIndex = bodyLayer.getRowIndexByPosition(rowPosition);
//				if (columnIndex == 2 && rowIndex == 45) {
//					configLabels.addLabel(FOO_LABEL);
//				} else if ((columnIndex == statusColumn) && (rowIndex == statusRejected) && (check == true)) {
//					configLabels.addLabel(CELL_LABEL);
//				}
			}
		};
		bodyLayer.setConfigLabelAccumulator(cellLabelAccumulator);

		nattable.addConfiguration(new DefaultNatTableStyleConfiguration());
		nattable.addConfiguration(new AbstractRegistryConfiguration() {
			// @Override
			public void configureRegistry(IConfigRegistry configRegistry) {
				Style cellStyle = new Style();
				cellStyle.setAttributeValue(CellStyleAttributes.BACKGROUND_COLOR, GUIHelper.COLOR_YELLOW);
				configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, cellStyle, DisplayMode.NORMAL,
						FOO_LABEL);

				cellStyle = new Style();
				cellStyle.setAttributeValue(CellStyleAttributes.BACKGROUND_COLOR, GUIHelper.COLOR_RED);
				configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, cellStyle, DisplayMode.NORMAL,
						CELL_LABEL);
			}
		});

		nattable.setLayoutData(gridData);
		nattable.setConfigRegistry(configRegistry);
		nattable.configure();

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

	public class DataProvider extends DummyBodyDataProvider {

		public DataProvider(int columnCount, int rowCount) {
			super(columnCount, rowCount);
		}

		@Override
		public int getColumnCount() {
			return properties.length;
		}

		@Override
		public Object getDataValue(int columnIndex, int rowIndex) {

			return new String("");

		}

		@Override
		public int getRowCount() {
			return 1;
		}

		@Override
		public void setDataValue(int arg0, int arg1, Object arg2) {

		}
	}

	public class BodyLayerStack extends AbstractLayerTransform {

		private SelectionLayer selectionLayer;

		public BodyLayerStack(IDataProvider dataProvider) {
			DataLayer bodyDataLayer = new DataLayer(dataProvider);
			ColumnReorderLayer columnReorderLayer = new ColumnReorderLayer(bodyDataLayer);
			ColumnHideShowLayer columnHideShowLayer = new ColumnHideShowLayer(columnReorderLayer);
			this.selectionLayer = new SelectionLayer(columnHideShowLayer);
			ViewportLayer viewportLayer = new ViewportLayer(this.selectionLayer);
			setUnderlyingLayer(viewportLayer);
		}

		public SelectionLayer getSelectionLayer() {
			return this.selectionLayer;
		}
	}

	public class ColumnHeaderLayerStack extends AbstractLayerTransform {

		public ColumnHeaderLayerStack(IDataProvider dataProvider) {
			DataLayer dataLayer = new DataLayer(dataProvider);
			ColumnHeaderLayer colHeaderLayer = new ColumnHeaderLayer(dataLayer, Nat_explore.this.bodyLayer,
					Nat_explore.this.bodyLayer.getSelectionLayer());
			setUnderlyingLayer(colHeaderLayer);
		}
	}

	public class RowHeaderLayerStack extends AbstractLayerTransform {

		public RowHeaderLayerStack(IDataProvider dataProvider) {
			DataLayer dataLayer = new DataLayer(dataProvider, 50, 20);
			RowHeaderLayer rowHeaderLayer = new RowHeaderLayer(dataLayer, Nat_explore.this.bodyLayer,
					Nat_explore.this.bodyLayer.getSelectionLayer());
			setUnderlyingLayer(rowHeaderLayer);
		}
	}
}