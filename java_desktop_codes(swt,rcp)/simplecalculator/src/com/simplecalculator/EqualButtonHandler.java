package com.simplecalculator;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EqualButtonHandler implements ActionListener {

	Button equalButton;
	TextField inputTextField;
	public int finalValue = 0;

	public EqualButtonHandler(TextField inputTextField, Button equalButton) {
		// TODO Auto-generated constructor stub

		this.equalButton = equalButton;
		this.inputTextField = inputTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (equalButton.getLabel().equals("=")) {

			String secondValue = inputTextField.getText();

			if (ArithmaticButtonHandler.select == 1) {

				finalValue = Integer.parseInt(ArithmaticButtonHandler.firstVlaue) + Integer.parseInt(secondValue);
				inputTextField.setText(String.valueOf(finalValue));

			} else if (ArithmaticButtonHandler.select == 2) {

				finalValue = Integer.parseInt(ArithmaticButtonHandler.firstVlaue) - Integer.parseInt(secondValue);
				inputTextField.setText(String.valueOf(finalValue));

			} else if (ArithmaticButtonHandler.select == 3) {

				try {

					if (Integer.parseInt(secondValue) != 0) {
						finalValue = Integer.parseInt(ArithmaticButtonHandler.firstVlaue)
								/ Integer.parseInt(secondValue);
						inputTextField.setText(String.valueOf(finalValue));
					} else
						inputTextField.setText("infinite");

				} catch (Exception i) {
				}
			} else if (ArithmaticButtonHandler.select == 4) {

				finalValue = Integer.parseInt(ArithmaticButtonHandler.firstVlaue) * Integer.parseInt(secondValue);
				inputTextField.setText(String.valueOf(finalValue));

			}
		}
	}
}
