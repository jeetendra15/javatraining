package set18.swt.taskmanager.ui;

import java.util.Collection;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import in.conceptarchitect.swt.Application;
import in.conceptarchitect.swt.MessageDialog;
import in.conceptarchitect.swt.UIBuilder;
import in.conceptarchitect.taskmanager.model.Task;

public class TaskListScreen implements UIBuilder{
	
	Collection<Task> tasks;
	

	public TaskListScreen(Collection<Task> tasks) {
		super();
		this.tasks = tasks;
	}


	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub
		parent.setLayout(new FillLayout());
		
		Table table=new Table(parent, SWT.BORDER|SWT.FULL_SELECTION);
		table.setHeaderVisible(true); //show table header row
		table.setLinesVisible(true);  //show intermediate lines
		
		table.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event e) {
				// TODO Auto-generated method stub
				//System.out.println(e.item.getData());
				Task task=(Task)e.item.getData();
				System.out.println(task.getTitle());
			}
		});
		
		table.addListener(SWT.DefaultSelection, new Listener() {
			
			@Override
			public void handleEvent(Event e) {
				// TODO Auto-generated method stub
				Task task=(Task)e.item.getData();
				List<Task> subTasks=task.getSubTasks();
				if(subTasks.size()>0)
					addTaskToTable(table,subTasks);
				else
					MessageDialog.warning("No Sub Tasks", "There is No Sub tasks available");
					
			}
		});
		
		
		String [] labels= {"Id","Task","Status","Subtasks","Notes"};
		int [] size= {50,250,100,100,100};
		
		
		
		for(int i=0;i<labels.length;i++) {
			TableColumn column= new TableColumn(table,0);
			column.setText(labels[i]); //set column heading
			column.setWidth(size[i]);
		}
		
		
		addTaskToTable(table,tasks);
	
		Menu menu=getTaskContextMenu();
		table.setMenu(menu);
		
		
		
	}
	

	private void addTaskToTable(Table table,Collection<Task> tasks) {
		table.removeAll();
		for(Task task : tasks) {
			
			TableItem tableItem=new TableItem(table, 0);
			tableItem.setText(0, ""+task.getId());
			tableItem.setText(1, task.getTitle());
			tableItem.setText(2, ""+task.getStatus());
			tableItem.setText(3, ""+task.getSubTasks().size());
			tableItem.setText(4, ""+task.getNotes().size());
			tableItem.setData(task);
			
			
		}
	}
	
	Menu getTaskContextMenu() {
		Menu menu=new Menu(Application.instance.getShell(), SWT.POP_UP);
		MenuItem deleteTask=new MenuItem(menu,SWT.PUSH);
		deleteTask.setText("Delete");
		
		MenuItem editTask=new MenuItem(menu,SWT.PUSH);
		editTask.setText("Edit");
		
		MenuItem markTask=new MenuItem(menu,SWT.CASCADE);
		markTask.setText("Change Status To");
		
		Menu status=new Menu(Application.instance.getShell(),SWT.DROP_DOWN);
		MenuItem markStarted=new MenuItem(status,SWT.PUSH);
		markStarted.setText("Started");
		MenuItem markCompleted=new MenuItem(status,SWT.PUSH);
		markCompleted.setText("Completed");
		MenuItem markCancled=new MenuItem(status,SWT.PUSH);
		markCancled.setText("Cancled");
				
		markTask.setMenu(status);
		return menu;
		
	}
	
	
	
	

}
