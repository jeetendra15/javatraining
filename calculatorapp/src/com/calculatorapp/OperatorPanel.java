package com.calculatorapp;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.calculatorapp.models.CalculatorOperatorClickListener;

public class OperatorPanel extends Panel implements ActionListener {

	CalculatorOperatorClickListener operatorClickListener;

	public OperatorPanel() {

		this.setLayout(new GridLayout(5, 1));
		String[] values = { "%", "*", "-", "+", "=" };
		String space = "       ";

		for (String value : values) {
			if (value == null)
				this.add(new Label("?")); // just add an empty label
			else {
				Button button = new Button(space + value + space);
				button.setSize(60, 40);
				this.add(button);
				button.addActionListener(this);
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String value = e.getActionCommand().trim();
		// System.out.println("Operator:" + value);
		operatorClickListener.operatorClick(value);
	}

	public CalculatorOperatorClickListener getOperatorClickListener() {
		return operatorClickListener;
	}

	public void setOperatorClickListener(CalculatorOperatorClickListener operatorClickListener) {
		this.operatorClickListener = operatorClickListener;
	}

}
