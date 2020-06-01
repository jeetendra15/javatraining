package swt.todoappmanager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class ToDoBuilder implements UIBuilder {

	ControlBuilder builder;

	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub

		builder = new ControlBuilder(parent);
		parent.setLayout(new RowLayout());
		parent.setSize(600, 400);

		buildMenu(parent);
		buildToolbarMenu(parent);
	}

	private void buildToolbarMenu(Composite parent) {
		// TODO Auto-generated method stub

		Display display = Display.getCurrent();

		Image image = new Image(display, "./../images/add-icon.jpg");
		Image image1 = new Image(display, "./../images/delete2.jpg");
		
		

		ToolBar toolBar = new ToolBar(parent, SWT.BORDER);

		ToolItem toolBarItemAdd = new ToolItem(toolBar, SWT.PUSH);
		// toolBarItemAdd.setText("+ Task");
		toolBarItemAdd.setImage(image);

		ToolItem toolBarItemRemove = new ToolItem(toolBar, SWT.PUSH);
		// toolBarItemRemove.setText("X Task");
		toolBarItemRemove.setImage(image1);

		toolBar.pack();
	}

	private void buildMenu(Composite parent) {
		// TODO Auto-generated method stub

		// step 1. create shell & associate with menu bar
		Shell shell = (Shell) parent;
		Menu menu = new Menu(shell, SWT.BAR);

		buildFileMenu(shell, menu);

		buildAboutMenu(shell, menu);

		shell.setMenuBar(menu);

	}

	private void buildFileMenu(Shell shell, Menu menu) {

		// step 2. create menu items to display in bar & should CASCADE design
		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText("&File");

		// step 3. create children of file menu
		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);

		MenuItem fileMenuNew = new MenuItem(fileMenu, SWT.CASCADE);
		fileMenuNew.setText("&New");

		// New has sub menu
		Menu fileMenuNewSubMenu = new Menu(shell, SWT.DROP_DOWN);
		MenuItem fileMenuNewSubMenuNewProject = new MenuItem(fileMenuNewSubMenu, SWT.PUSH);
		fileMenuNewSubMenuNewProject.setText("&Project");

		MenuItem fileMenuNewSubMenuNewTask = new MenuItem(fileMenuNewSubMenu, SWT.PUSH);
		fileMenuNewSubMenuNewTask.setText("&Task");

		fileMenuNew.setMenu(fileMenuNewSubMenu);

		MenuItem fileMenuOpen = new MenuItem(fileMenu, SWT.PUSH);
		fileMenuOpen.setText("&Open");

		new MenuItem(fileMenu, SWT.SEPARATOR);

		MenuItem fileMenuSave = new MenuItem(fileMenu, SWT.PUSH);
		fileMenuSave.setText("&Save");

		MenuItem fileMenuSaveAs = new MenuItem(fileMenu, SWT.PUSH);
		fileMenuSaveAs.setText("Save &As");

		MenuItem fileMenuAutoSave = new MenuItem(fileMenu, SWT.PUSH);
		fileMenuAutoSave.setText("&Auto Save");

		new MenuItem(fileMenu, SWT.SEPARATOR);

		MenuItem fileMenuExit = new MenuItem(fileMenu, SWT.PUSH);
		fileMenuExit.setText("E&xit");

		fileMenuExit.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub

				Application.instance.getShell().dispose();
			}
		});

		// step 4. Associate filemenuItems with main menu
		menuItem.setMenu(fileMenu);
	}

	private void buildAboutMenu(Shell shell, Menu menu) {
		MenuItem aboutItem = new MenuItem(menu, SWT.CASCADE);
		aboutItem.setText("&About");

		Menu aboutMenu = new Menu(shell, SWT.DROP_DOWN);

		MenuItem aboutMenuItemHelp = new MenuItem(aboutMenu, SWT.PUSH);
		aboutMenuItemHelp.setText("&Help");

		aboutMenuItemHelp.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub

				MessageDialog.info("TO-DO Manager", "It is TO-DO Application.\nVersion 1.0");

				// AboutScreen aboutScreen = new AboutScreen("TO-DO Application");
			}
		});

		aboutItem.setMenu(aboutMenu);

	}

}
