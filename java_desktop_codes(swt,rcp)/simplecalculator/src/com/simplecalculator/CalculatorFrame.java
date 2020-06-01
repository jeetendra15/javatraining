package com.simplecalculator;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class CalculatorFrame extends Frame {

	Button quitButton, numberButton0, numberButton1, numberButton2, numberButton3, numberButton4, numberButton5,
			numberButton6, numberButton7, numberButton8, numberButton9;

	Button plusButton, minusButton, multiplyButton, divisionButton, equalButton;

	TextField inputTextField;

	Panel p;

	public CalculatorFrame() {
		createCalculator();
	}

	private void createCalculator() {
		// TODO Auto-generated method stub

		this.setLayout(new FlowLayout());
		this.setTitle("Calulator");

		p = new Panel();

		quitButton = new Button("Quit");

		numberButton1 = new Button("1");
		numberButton2 = new Button("2");
		numberButton3 = new Button("3");
		numberButton4 = new Button("4");
		numberButton5 = new Button("5");
		numberButton6 = new Button("6");
		numberButton7 = new Button("7");
		numberButton8 = new Button("8");
		numberButton9 = new Button("9");
		numberButton0 = new Button("0");

		plusButton = new Button("+");
		minusButton = new Button("-");
		multiplyButton = new Button("x");
		divisionButton = new Button("/");

		equalButton = new Button("=");

		inputTextField = new TextField(35);

		quitButton.addActionListener(new QuitAppHandler());

		numberButton1.addActionListener(new NumericButtonHandler(inputTextField, numberButton1));
		numberButton2.addActionListener(new NumericButtonHandler(inputTextField, numberButton2));
		numberButton3.addActionListener(new NumericButtonHandler(inputTextField, numberButton3));
		numberButton4.addActionListener(new NumericButtonHandler(inputTextField, numberButton4));
		numberButton5.addActionListener(new NumericButtonHandler(inputTextField, numberButton5));
		numberButton6.addActionListener(new NumericButtonHandler(inputTextField, numberButton6));
		numberButton7.addActionListener(new NumericButtonHandler(inputTextField, numberButton7));
		numberButton8.addActionListener(new NumericButtonHandler(inputTextField, numberButton8));
		numberButton9.addActionListener(new NumericButtonHandler(inputTextField, numberButton9));
		numberButton0.addActionListener(new NumericButtonHandler(inputTextField, numberButton0));

		plusButton.addActionListener(new ArithmaticButtonHandler(inputTextField, plusButton));
		minusButton.addActionListener(new ArithmaticButtonHandler(inputTextField, minusButton));
		multiplyButton.addActionListener(new ArithmaticButtonHandler(inputTextField, multiplyButton));
		divisionButton.addActionListener(new ArithmaticButtonHandler(inputTextField, divisionButton));
		
		equalButton.addActionListener(new EqualButtonHandler(inputTextField, equalButton));

		add(quitButton);
		add(inputTextField);

		p.setLayout(new GridLayout(4, 4, 10, 20));

		p.add(numberButton1);
		p.add(numberButton2);
		p.add(numberButton3);

		p.add(divisionButton);

		p.add(numberButton4);
		p.add(numberButton5);
		p.add(numberButton6);

		p.add(multiplyButton);

		p.add(numberButton7);
		p.add(numberButton8);
		p.add(numberButton9);

		p.add(minusButton);

		p.add(numberButton0);

		p.add(equalButton);
		p.add(plusButton);

		add(p);
		this.setSize(300, 300);

	}

}
