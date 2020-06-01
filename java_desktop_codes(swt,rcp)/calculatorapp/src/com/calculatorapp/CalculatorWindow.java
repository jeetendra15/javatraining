package com.calculatorapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

public class CalculatorWindow {

	Window calculatorWindow;
	DisplayPanel displayPanel;
	DigitPanel digitPanel;
	OperatorPanel operatorPanel;
	ClearPanel clearPanel;
	CalculatorBrain calculatorBrain;

	public CalculatorWindow(String title) {
		// TODO Auto-generated constructor stub

		buildUi(title);
	}

	private void buildUi(String title) {
		// TODO Auto-generated method stub
		calculatorWindow = new Window(title);
		calculatorWindow.setLayout(new BorderLayout());

		calculatorBrain = new CalculatorBrain();

		// Screen Settings
		displayPanel = new DisplayPanel();
		clearPanel = new ClearPanel();

		clearPanel.setClearDisplayListener(calculatorBrain);

		Panel panel = new Panel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(displayPanel);
		panel.add(clearPanel);
		calculatorWindow.add(panel, BorderLayout.NORTH);

		digitPanel = new DigitPanel();
		digitPanel.setDigitClickListener(calculatorBrain);
		calculatorWindow.add(digitPanel, BorderLayout.CENTER);

		operatorPanel = new OperatorPanel();
		operatorPanel.setOperatorClickListener(calculatorBrain);
		calculatorWindow.add(operatorPanel, BorderLayout.EAST);

		calculatorBrain.setDisplayChangeListener(displayPanel);
	}

	public void start() {
		// TODO Auto-generated method stub
		calculatorWindow.setSize(350, 350);
		calculatorWindow.setVisible(true);
	}

}
