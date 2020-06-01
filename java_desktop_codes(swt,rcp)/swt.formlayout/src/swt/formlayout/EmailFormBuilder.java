package swt.formlayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

public class EmailFormBuilder implements UIBuilder {

	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub

		boolean isSave = false;

		System.out.println("Building the Email Form..." + parent);

		FormLayout layout = new FormLayout();
		parent.setLayout(layout);

		ControlBuilder builder = new ControlBuilder(parent);

		Label fromLabel = builder.label("From").get(Label.class);
		Text fromTextBox = builder.text().get(Text.class);

		Label toLabel = builder.label("To").get(Label.class);
		Text toTextBox = builder.text().get(Text.class);

		Label subjectLabel = builder.label("Subject").get(Label.class);
		Text subjectTextBox = builder.text().get(Text.class);

		Label messageLabel = builder.label("Message").get(Label.class);
		Text messageTextBox = builder.text().get(Text.class);

		Button sendCopyCheckBox = builder.checkBox("Send Me A Copy").get(Button.class);
		sendCopyCheckBox.setSelection(true);

		Button sendButton = builder.button("Send").get(Button.class);

//		Let us arrange the control in FormLayout

//		FormData fromLabelData = new FormData();
//		fromLabelData.left = new FormAttachment(5); // 10% from left border
//		fromLabelData.top = new FormAttachment(5); // 5% from top border
//		fromLabel.setLayoutData(fromLabelData);

		Form.data().left(5).top(5).applyTo(fromLabel);

//		FormData fromTextBoxData = new FormData(200, 20);
//		fromTextBoxData.left = new FormAttachment(fromLabel, 55); // a gap of 10% between label end and textbox start
//		fromTextBoxData.top = new FormAttachment(5);
//		fromTextBoxData.right = new FormAttachment(50); // 60% gap
//		fromTextBox.setLayoutData(fromTextBoxData);

		Form.data(200, 20).left(fromLabel, 55).top(5).right(50).applyTo(fromTextBox);

//		FormData toLabelData = new FormData();
//		toLabelData.left = new FormAttachment(5);
//		toLabelData.top = new FormAttachment(15);
//		toLabel.setLayoutData(toLabelData);

		Form.data().left(5).top(15).applyTo(toLabel);

//		FormData toTextBoxData = new FormData(200, 20);
//		toTextBoxData.left = new FormAttachment(toLabel, 70);
//		toTextBoxData.top = new FormAttachment(15);
//		toTextBoxData.right = new FormAttachment(50);
//		toTextBox.setLayoutData(toTextBoxData);

		Form.data(200, 20).left(toLabel, 70).top(15).right(50).applyTo(toTextBox);

//		FormData subjectLabelData = new FormData();
//		subjectLabelData.left = new FormAttachment(5);
//		subjectLabelData.top = new FormAttachment(25);
//		subjectLabel.setLayoutData(subjectLabelData);

		Form.data().left(5).top(25).applyTo(subjectLabel);

//		FormData subjeTextBoxData = new FormData(200, 20);
//		subjeTextBoxData.left = new FormAttachment(subjectLabel, 44);
//		subjeTextBoxData.top = new FormAttachment(25);
//		subjeTextBoxData.right = new FormAttachment(50);
//		subjectTextBox.setLayoutData(subjeTextBoxData);

		Form.data(200, 20).left(subjectLabel, 44).top(25).right(50).applyTo(subjectTextBox);

//		FormData messageLabelData = new FormData();
//		messageLabelData.left = new FormAttachment(5);
//		messageLabelData.top = new FormAttachment(35);
//		messageLabel.setLayoutData(messageLabelData);

		Form.data().left(5).top(35).applyTo(messageLabel);

//		FormData messageTextBoxData = new FormData(200, 200);
//		messageTextBoxData.left = new FormAttachment(messageLabel, 37);
//		messageTextBoxData.top = new FormAttachment(35);
//		messageTextBoxData.right = new FormAttachment(70);
//		messageTextBox.setLayoutData(messageTextBoxData);

		Form.data(200, 200).left(messageLabel, 37).top(35).right(80).applyTo(messageTextBox);

//		FormData sendCopyCheckBoxData = new FormData();
//		sendCopyCheckBoxData.left = new FormAttachment(5);
//		sendCopyCheckBoxData.bottom = new FormAttachment(90);
//		sendCopyCheckBox.setLayoutData(sendCopyCheckBoxData);

		Form.data().left(5).top(messageTextBox, 20).applyTo(sendCopyCheckBox);

//		FormData sendButtonData = new FormData(250, 50);
//		sendButtonData.right = new FormAttachment(98);
//		sendButtonData.bottom = new FormAttachment(98);
//		sendButton.setLayoutData(sendButtonData);

		Form.data(250, 50).right(messageTextBox, 0, SWT.RIGHT).top(messageTextBox, 20).bottom(98).applyTo(sendButton);

//		fromTextBox.addModifyListener(new ModifyListener() {
//
//			@Override
//			public void modifyText(ModifyEvent arg0) {
//				// TODO Auto-generated method stub
//				Text source = (Text) arg0.getSource();
//				System.out.println("data :" + source.getText());
//				messageTextBox.setText(source.getText());
//			}
//		});

		parent.addListener(SWT.Close, new Listener() {

			int answer = 0;

			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub

				answer = showConfirmationBox();
				if (answer == SWT.YES) {

					System.out.println("saving....");
				}
			}

			private int showConfirmationBox() {
				// TODO Auto-generated method stub
				MessageBox messageBox = new MessageBox(Application.instance.getShell(),
						SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
				messageBox.setMessage("You have unsaved data. Save It Now?");
				messageBox.setText("Unsaved Data Warning");
				return messageBox.open();
			}
		});

		sendCopyCheckBox.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				fromTextBox.setEnabled(sendCopyCheckBox.getSelection());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		sendButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub

				String from = fromTextBox.getText();
				String to = toTextBox.getText();
				String subject = subjectTextBox.getText();
				String message = messageTextBox.getText();

				boolean isSelected = sendCopyCheckBox.getSelection();

				System.out.println(from);
				System.out.println(to);
				System.out.println(subject);
				System.out.println(message);
				System.out.println(isSelected);

			}
		});

	}

}
