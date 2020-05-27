package com.calculatorapp;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.calculatorapp.models.CalculatorDigitClickListener;

public class DigitPanel extends Panel implements ActionListener {

	CalculatorDigitClickListener digitClickListener;

	public DigitPanel() {
		this.setLayout(new GridLayout(4, 3));

		String[] values = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "+/-", "0", "." };

		for (String value : values) {
			Button button = new Button(value);
			this.add(button);
			button.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button button = (Button) e.getSource();
		String value = button.getLabel();
		// System.out.println("Digit Pressed:" + value);

		digitClickListener.digitClick(value);
	}

	public CalculatorDigitClickListener getDigitClickListener() {
		return digitClickListener;
	}

	public void setDigitClickListener(CalculatorDigitClickListener digitClickListener) {
		this.digitClickListener = digitClickListener;
	}

}
