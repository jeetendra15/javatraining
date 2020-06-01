package com.simplecalculatorwindowevent;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class MyWindow extends Frame {

	public MyWindow(String title) {
		super(title);

		createCalculator();

	}

	private void createCalculator() {
		Button quitButton, numberButton0, numberButton1, numberButton2, numberButton3, numberButton4, numberButton5,
				numberButton6, numberButton7, numberButton8, numberButton9;

		Button plusButton, minusButton, multiplyButton, divisionButton, equalButton;

		TextField inputTextField;

		Panel p;

		// you can add multiple handler. each handler gets a chance to handle the
		// request
		this.addWindowListener(new MyWindowListner());
		this.addWindowListener(new WindowDestroyer());
		this.setSize(500, 500);
		
		p = new Panel();

		this.setLayout(new BorderLayout());

		inputTextField = new TextField(35);

		plusButton = new Button("+");
		minusButton = new Button("-");
		multiplyButton = new Button("x");
		divisionButton = new Button("/");

		
		
		
		
		p.setLayout(new GridLayout(4, 1, 10, 5));
		
		plusButton.setSize(400,100);
	
		p.add(plusButton);
		p.add(multiplyButton);
		p.add(minusButton);
		p.add(divisionButton);

		this.add(inputTextField, BorderLayout.NORTH);
		this.add(p, BorderLayout.EAST);
	}
}
