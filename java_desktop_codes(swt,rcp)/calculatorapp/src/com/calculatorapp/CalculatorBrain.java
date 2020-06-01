package com.calculatorapp;

import com.calculatorapp.models.CalculatorDigitClickListener;
import com.calculatorapp.models.CalculatorOperatorClickListener;
import com.calculatorapp.models.ClearDisplayListener;
import com.calculatorapp.models.DisplayChangeListener;

public class CalculatorBrain
		implements CalculatorDigitClickListener, CalculatorOperatorClickListener, ClearDisplayListener {

	DisplayChangeListener displayChangeListener;

	private String first = "0";
	private String second = "0";
	boolean isFirst = true;
	boolean isDecimalAdded = false;
	private String operator;

	public DisplayChangeListener getDisplayChangeListener() {
		return displayChangeListener;
	}

	public String getValue() {
		if (isFirst) {
			return first;
		} else
			return second;
	}

	public void setValue(String value) {
		if (isFirst)
			first = value;
		else
			second = value;
	}

	public void setDisplayChangeListener(DisplayChangeListener displayChangeListener) {
		this.displayChangeListener = displayChangeListener;
	}

	@Override
	public void digitClick(String digit) {
		// TODO Auto-generated method stub
//		System.out.println("Operator :" + digit);
//		if (displayChangeListener != null) {
//			displayChangeListener.updateDisplay("digit:" + digit);
//		}

		// This method will recieve 0-9, . and +/-
		// we will handle this in 3 parts

		// decimal point
		if (digit.equals("."))
			handleDot();

		else if (digit.equals("+/-"))
			handleNegation();

		else

			handleValue(digit);

		System.out.println(first + " " + second);
	}

	private void handleValue(String digit) {
		// TODO Auto-generated method stub
		String value = getValue(); // returns current value first/second
		if (value.equals("0"))
			value = digit;
		else
			value += digit;

		setValue(value); // update the first/second
		updateDisplay(value);
	}

	private void updateDisplay(String value) {
		// TODO Auto-generated method stub
		if (displayChangeListener != null)
			displayChangeListener.updateDisplay(value);
	}

	private void handleNegation() {
		// TODO Auto-generated method stub
		String value = getValue();
		if (value.contentEquals("0"))
			return; // ignore a 0 value

		if (value.startsWith("-"))
			value = value.substring(1); // take everything from char 1 i.e. after '-' i.e. remove the '-' sign
		else
			value = "-" + value;

		setValue(value);
		updateDisplay(value);
	}

	private void handleDot() {
		// TODO Auto-generated method stub
		String value = getValue();
		if (!value.contains(".")) {
			value += ".";
			setValue(value);
			updateDisplay(value);
		}
	}

	@Override
	public void operatorClick(String operator) {
		// TODO Auto-generated method stub
//		System.out.println("Recieved :" + operator);
//		if (displayChangeListener != null)
//			displayChangeListener.updateDisplay("operator:" + operator);
		String value = getValue();
		value += operator;
		isFirst = false;
		setValue(value);
		updateDisplay(value);

		if (operator.contentEquals("="))
			onEquals();
		else {
			onArithmeticOperator(operator);
		}
	}

	private void onArithmeticOperator(String operator) {
		// TODO Auto-generated method stub
		this.operator = operator;
		this.isFirst = false;
		System.out.println(operator);
	}

	private void onEquals() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearDisplay(String controlName) {
		// TODO Auto-generated method stub

		if(controlName.contentEquals("<-")) {
			
		}

	}

}
