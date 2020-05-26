package com.simplecalculator;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumericButtonHandler implements ActionListener {

	Button numButton;
	TextField inputTextField;
	String currentValue, finalValue;

	public NumericButtonHandler(TextField inputTextField, Button numButton) {
		// TODO Auto-generated constructor stub

		this.numButton = numButton;
		this.inputTextField = inputTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (numButton.getLabel().equals("1")) {

			currentValue = "1";
			finalValue = inputTextField.getText() + currentValue;
			inputTextField.setText(finalValue);
		}

		if (numButton.getLabel().equals("2")) {

			currentValue = "2";
			finalValue = inputTextField.getText() + currentValue;
			inputTextField.setText(finalValue);
		}

		if (numButton.getLabel().equals("3")) {

			currentValue = "3";
			finalValue = inputTextField.getText() + currentValue;
			inputTextField.setText(finalValue);
		}

		if (numButton.getLabel().equals("4")) {

			currentValue = "4";
			finalValue = inputTextField.getText() + currentValue;
			inputTextField.setText(finalValue);
		}

		if (numButton.getLabel().equals("5")) {

			currentValue = "5";
			finalValue = inputTextField.getText() + currentValue;
			inputTextField.setText(finalValue);
		}

		if (numButton.getLabel().equals("6")) {

			currentValue = "6";
			finalValue = currentValue + inputTextField.getText();
			inputTextField.setText(finalValue);
		}

		if (numButton.getLabel().equals("7")) {

			currentValue = "7";
			finalValue = inputTextField.getText() + currentValue;
			inputTextField.setText(finalValue);
		}

		if (numButton.getLabel().equals("8")) {

			currentValue = "8";
			finalValue = inputTextField.getText() + currentValue;
			inputTextField.setText(finalValue);
		}

		if (numButton.getLabel().equals("9")) {

			currentValue = "9";
			finalValue = inputTextField.getText() + currentValue;
			inputTextField.setText(finalValue);
		}

		if (numButton.getLabel().equals("0")) {

			currentValue = "0";
			finalValue = inputTextField.getText() + currentValue;
			inputTextField.setText(finalValue);
		}

	}

}
