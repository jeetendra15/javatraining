package com.simplecalculator;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArithmaticButtonHandler implements ActionListener {

	Button operatorButton;
	TextField inputTextField;
	String currentValue, finalValue;
	public static int select = 0;
	public static String firstVlaue;

	public ArithmaticButtonHandler(TextField inputTextField, Button operatorButton) {
		// TODO Auto-generated constructor stub

		this.operatorButton = operatorButton;
		this.inputTextField = inputTextField;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (operatorButton.getLabel().equals("+")) {

			firstVlaue = inputTextField.getText();
			finalValue = "";
			inputTextField.setText(finalValue);
			select = 1;
		}

		if (operatorButton.getLabel().equals("-")) {

			firstVlaue = inputTextField.getText();
			finalValue = "";
			inputTextField.setText(finalValue);
			select = 2;
		}

		if (operatorButton.getLabel().equals("/")) {

			firstVlaue = inputTextField.getText();
			finalValue = "";
			inputTextField.setText(finalValue);
			select = 3;
		}

		if (operatorButton.getLabel().equals("x")) {

			firstVlaue = inputTextField.getText();
			finalValue = "";
			inputTextField.setText(finalValue);
			select = 4;
		}
	}

}
