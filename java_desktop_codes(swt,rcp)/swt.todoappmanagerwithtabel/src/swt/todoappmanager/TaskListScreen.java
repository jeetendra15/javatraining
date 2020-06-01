package swt.todoappmanager;

import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import swt.todoappmanager.model.Task;

public class TaskListScreen implements UIBuilder {

	Collection<Task> tasks;

	public TaskListScreen(Collection<Task> tasks) {
		super();
		this.tasks = tasks;
	}

	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub
		parent.setLayout(new FillLayout());

		Table table = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true); // show table header row
		table.setLinesVisible(true); // show intermediate lines

		String[] labels = { "Id", "Task", "Status", "Subtasks", "Notes" };
		int[] size = { 50, 250, 100, 100, 100 };

		for (int i = 0; i < labels.length; i++) {
			TableColumn column = new TableColumn(table, 0);
			column.setText(labels[i]); // set column heading
			column.setWidth(size[i]);
		}

		for (Task task : tasks) {

			TableItem tableItem = new TableItem(table, 0);
			tableItem.setText(0, "" + task.getId());
			tableItem.setText(1, task.getTitle());
			tableItem.setText(2, "" + task.getStatus());
			tableItem.setText(3, "" + task.getSubTasks().size());
			tableItem.setText(4, "" + task.getNotes().size());

			tableItem.addListener(SWT.Selection, new Listener() {

				@Override
				public void handleEvent(Event arg0) {
					// TODO Auto-generated method stub
					System.out.println(arg0.data);
				}
			});
		}

//		table.addSelectionListener(new SelectionListener() {
//
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				// TODO Auto-generated method stub
//
//				Table table = (Table) e.getSource();
//				System.out.println(table);
//			}
//
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//		});

	}

}
