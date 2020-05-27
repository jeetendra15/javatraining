package com.calculatorapp;

import java.awt.BorderLayout;

public class CalculatorWindow {

	Window calculatorWindow;
	DisplayPanel displayPanel;
	DigitPanel digitPanel;
	OperatorPanel operatorPanel;
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
		calculatorWindow.add(displayPanel, BorderLayout.NORTH);

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
