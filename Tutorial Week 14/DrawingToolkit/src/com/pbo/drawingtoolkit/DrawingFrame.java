package com.pbo.drawingtoolkit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawingFrame extends JFrame {
	
	public static final int LINE = 0;
	public static final int CIRCLE = 1;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	private JButton jbLine, jbCircle, clear;
	private JPanel toolboxPanel, toolboxPadding;
	public static DrawingCanvas canvas;
	
	public DrawingFrame() {
		super("Drawing Toolkit");
		JLabel statusLabel = new JLabel("");
		
		canvas = new DrawingCanvas(statusLabel);
		canvas.setBorder(
					BorderFactory.createLineBorder(
								Color.GRAY, 15
							)
				);
		
		clear = new JButton("Clear");
		jbCircle = new JButton("Circle");
		jbLine = new JButton("Line");
		
		toolboxPanel = new JPanel();
		toolboxPanel.setLayout(new GridLayout(1, 1, 1, 1));
		toolboxPadding = new JPanel();
		toolboxPadding.setLayout(
					new FlowLayout(
								FlowLayout.LEADING, 1, 1
							)
				);
		
		toolboxPanel.add(clear);
		toolboxPanel.add(jbCircle);
		toolboxPanel.add(jbLine);
		toolboxPadding.add(toolboxPanel);
		
		add(toolboxPadding, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		
		ButtonHandler buttonHandler = new ButtonHandler();
		clear.addActionListener(buttonHandler);
		jbLine.addActionListener(buttonHandler);
		jbCircle.addActionListener(buttonHandler);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyWindowAdapter myWindowAdapter = new MyWindowAdapter();
		addWindowListener(myWindowAdapter);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Clear")) {
				canvas.clearDrawing();
			}
			else if (e.getActionCommand().equals("Line")) {
				canvas.setCurrentShapeType(LINE);
			}
			else if (e.getActionCommand().equals("Circle")) {
				canvas.setCurrentShapeType(CIRCLE);
			}
		}
		
	}
	private class MyWindowAdapter extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			int choose = JOptionPane.showConfirmDialog(
						null, 
						"Do you really want to exit the application?",
						"Confirm Close", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE
					);
			
			if (choose == JOptionPane.YES_OPTION) {
				e.getWindow().dispose();
				System.out.println("Close");
			}
			else {
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		}
	}
 }
