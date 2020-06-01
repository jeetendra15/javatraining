package swt.calculatorapp;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;



public class AppUiBuilder implements UIBuilder {

	ControlBuilder builder;
	
	
	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub
		GridLayout layout=new GridLayout();		
		layout.numColumns=4;		
		//layout.makeColumnsEqualWidth=true;
		parent.setLayout(layout);
		
		builder=new ControlBuilder(parent);
		
		
//		
//		builder
//			.button("My Button 1")
//			.background(255, 0, 0)
//			.foreground(255, 255, 255);
		
		
		builder
			.button("My Button2")
			.setLayoutData(
				Grid
					.data().stretch().hgrab().vspan(3).size(100, 50)
					.get()
			);
		
//		
//		Button button3= builder.button("My Button 3").get(Button.class);
//		Grid.data().hspan(2).stretch().applyTo(button3);
		
		
//		addButtons(parent, 10, "AutoButtons");
		
		builder.button("My Button 4")
			.setLayoutData(
					Grid.data().stretch().hspan(4).vgrab()
					.get()
					);
		
		
		
		Button button = new Button(parent, 0);
		button.setText("1");
		button.setLayoutData(new GridData(100, 100));
		
		//parent.pack(); //trim to the required size
				
		
	}

	private void addButtons(Composite parentPanel, int buttonCount, String nameBase) {
		for(int i=1;i<=buttonCount;i++) {
			Button button=new Button(parentPanel,SWT.PUSH);
			button.setText(nameBase+i);
			GridData data=new GridData();
			button.setLayoutData(data);
			
			button.addSelectionListener(new SelectionAdapter() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					Button btn=(Button) e.getSource();
					Application.instance.setTitle("Button "+btn.getText()+" clicked");
				}
			});
			
		}
	}

}
