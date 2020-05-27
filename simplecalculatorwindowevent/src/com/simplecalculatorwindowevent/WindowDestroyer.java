package com.simplecalculatorwindowevent;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowDestroyer extends WindowAdapter {

	int closeAttempt = 0;
	int attemptRequired = 5;

	public WindowDestroyer(int attemptRequired) {
		// TODO Auto-generated constructor stub
		this.attemptRequired = attemptRequired;
	}

	public WindowDestroyer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

//		closeAttempt++;
//		if(closeAttempt<attemptRequired)
//		{
//			System.out.println("You need to try "+(attemptRequired-closeAttempt)+" more times");
//		}
//		else {
//		System.out.println("Ok! You won!");
		Frame frame = (Frame) e.getSource();
		frame.dispose();
		// }

	}

}
