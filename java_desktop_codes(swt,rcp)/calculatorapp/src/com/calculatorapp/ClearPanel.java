package com.calculatorapp;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.calculatorapp.models.ClearDisplayListener;

public class ClearPanel extends Panel {

	ClearDisplayListener clearDisplayListener;

	public ClearPanel() {
		this.setLayout(new GridLayout(1, 3));

		String[] values = { "C", "AC", "<-" };

		for (String value : values) {
			Button button = new Button(value);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (clearDisplayListener != null) {
						clearDisplayListener.clearDisplay(e.getActionCommand());
					}

				}
			});

			this.add(button);
		}
	}

	public ClearDisplayListener getClearDisplayListener() {
		return clearDisplayListener;
	}

	public void setClearDisplayListener(ClearDisplayListener clearDisplayListener) {
		this.clearDisplayListener = clearDisplayListener;
	}

}
