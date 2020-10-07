package com.myGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LearningGUI {
	
	public LearningGUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		panel.setLayout(new GridLayout(0, 1));
		
		//add panel to the frame, 
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.setTitle("Epic GUI");
		frame.pack(); 
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new LearningGUI();
	}

}
