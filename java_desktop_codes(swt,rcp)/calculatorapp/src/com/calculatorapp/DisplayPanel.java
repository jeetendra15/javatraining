package com.calculatorapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;

import com.calculatorapp.models.DisplayChangeListener;

public class DisplayPanel extends Panel implements DisplayChangeListener {

	Label screen;

	public DisplayPanel() {
		screen = new Label("0", Label.RIGHT); // align text to the right
		screen.setFont(new Font("Courier", Font.BOLD, 20));
		screen.setBackground(new Color(220, 220, 220));
		this.setLayout(new BorderLayout());
		this.add(screen);
	}

	@Override
	public void updateDisplay(String value) {
		// TODO Auto-generated method stub
		screen.setText(value);
	}

}
