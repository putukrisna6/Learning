package id.its.simplekeyboardevent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
			 JFrame frame = new JFrame("Simple Keyboard Event");

			 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 	frame.setContentPane(new KeyboardPanel(640, 480));
			 	frame.pack();
			 	frame.setVisible(true);
			 	frame.setResizable(false);
			 }
		});
	}

}
