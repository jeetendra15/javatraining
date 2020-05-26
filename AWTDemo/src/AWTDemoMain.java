import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseListener;

public class AWTDemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Frame frame = new Frame("Java AWT Window");

		Button button = new Button("Click Me");

		// button.setSize(100, 100);
		// button.setBounds(50, 100, 80, 30);

		frame.add(button);

		frame.setSize(600, 600);

		// setting the flow layout to window
		frame.setLayout(new FlowLayout());

		// setting the background color to window
		frame.setBackground(new Color(100, 130, 165));

		frame.setVisible(true);

	}

}
