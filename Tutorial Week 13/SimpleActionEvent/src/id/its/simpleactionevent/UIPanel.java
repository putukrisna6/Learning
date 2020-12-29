package id.its.simpleactionevent;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UIPanel extends JPanel implements ActionListener {
	
	public UIPanel(int width, int height) {
		this.setPreferredSize(
					new Dimension(width, height)
				);
		// add button to panel
		JButton button = new JButton("Click Me!");
		this.add(button);
		
		// bind event action
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(
					this, 
					"Anda telah mengaktifkan action event"
				);
	}
}
