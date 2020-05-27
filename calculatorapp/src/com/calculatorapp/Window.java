package com.calculatorapp;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends Frame {

	class WindowDestroyer extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			Window window = (Window) e.getSource();
			window.dispose();
			if (window.isMainWindow())
				System.exit(0);
		}
	}

	boolean mainWindow = false;

	public boolean isMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(boolean mainWindow) {
		this.mainWindow = mainWindow;
	}

	public Window() throws HeadlessException {
		this("");
		// TODO Auto-generated constructor stub
	}

	public Window(String title) throws HeadlessException {
		super(title);
		this.addWindowListener(new WindowDestroyer());
		this.setSize(600, 400);
	}

}
