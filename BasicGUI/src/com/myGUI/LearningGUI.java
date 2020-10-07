package com.myGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LearningGUI implements ActionListener{
	
	private int count = 0;
	private JLabel label;
	
	public LearningGUI() {
		JFrame frame = new JFrame();
		
		JButton button = new JButton("Click it!");
		button.addActionListener(this);
		
		label = new JLabel("Number of clicks: 0");
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
		panel.add(label);
		
		//add panel to the frame, make it exit on close, set the title, set the window to a certain size, set to make it visible
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Epic GUI");
		frame.pack(); 
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new LearningGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks: " + count);
	}

}
