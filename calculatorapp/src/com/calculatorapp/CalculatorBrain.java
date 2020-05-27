package com.calculatorapp;

import com.calculatorapp.models.CalculatorDigitClickListener;
import com.calculatorapp.models.CalculatorOperatorClickListener;
import com.calculatorapp.models.DisplayChangeListener;

public class CalculatorBrain implements CalculatorDigitClickListener, CalculatorOperatorClickListener {

	DisplayChangeListener displayChangeListener;

	private double result;
	private double second;
	boolean isFirst = true;
	boolean isDecimalAdded = false;

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public double getSecond() {
		return second;
	}

	public void setSecond(double second) {
		this.second = second;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public boolean isDecimalAdded() {
		return isDecimalAdded;
	}

	public void setDecimalAdded(boolean isDecimalAdded) {
		this.isDecimalAdded = isDecimalAdded;
	}

	public DisplayChangeListener getDisplayChangeListener() {
		return displayChangeListener;
	}

	public void setDisplayChangeListener(DisplayChangeListener displayChangeListener) {
		this.displayChangeListener = displayChangeListener;
	}

	@Override
	public void operatorClick(String digit) {
		// TODO Auto-generated method stub
		System.out.println("Recieved :" + digit);
		if (displayChangeListener != null) {
			displayChangeListener.updateDisplay("digital:" + digit);
		}
	}

	@Override
	public void digitClick(String digit) {
		// TODO Auto-generated method stub
		System.out.println("Operator :" + digit);
	}

}
