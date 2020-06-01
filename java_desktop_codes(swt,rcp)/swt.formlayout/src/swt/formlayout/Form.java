package swt.formlayout;

import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Control;

public class Form {

	FormData formData;

	public static Form data() {
		Form form = new Form();
		form.formData = new FormData();
		return form;

	}

	public static Form data(int width, int height) {
		Form form = new Form();
		form.formData = new FormData();
		form.formData.width = width;
		form.formData.height = height;
		return form;

	}

	public Form left(int percent) {
		formData.left = new FormAttachment(percent);
		return this;
	}

	public Form left(Control control, int percent) {
		formData.left = new FormAttachment(control, percent);
		return this;
	}

	public Form left(Control control, int percent, int alignment) {
		formData.left = new FormAttachment(control, percent, alignment);
		return this;
	}

	public Form top(int percent) {
		formData.top = new FormAttachment(percent);
		return this;
	}

	public Form top(Control control, int percent) {
		formData.top = new FormAttachment(control, percent);
		return this;
	}

	public Form top(Control control, int percent, int alignment) {
		formData.top = new FormAttachment(control, percent, alignment);
		return this;
	}

	public Form bottom(int percent) {
		formData.bottom = new FormAttachment(percent);
		return this;
	}

	public Form bottom(Control control, int percent) {
		formData.bottom = new FormAttachment(control, percent);
		return this;
	}

	public Form bottom(Control control, int percent, int alignment) {
		formData.bottom = new FormAttachment(control, percent, alignment);
		return this;
	}

	public Form right(int percent) {
		formData.right = new FormAttachment(percent);
		return this;
	}

	public Form right(Control control, int percent) {
		formData.right = new FormAttachment(control, percent);
		return this;
	}

	public Form right(Control control, int percent, int alignment) {
		formData.right = new FormAttachment(control, percent, alignment);
		return this;
	}

	public Form applyTo(Control control) {
		control.setLayoutData(formData);
		return this;
	}
}
