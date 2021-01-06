package com.pbo.drawingtoolkit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pbo.drawingtoolkit.shapes.Circle;
import com.pbo.drawingtoolkit.shapes.DrawingObject;
import com.pbo.drawingtoolkit.shapes.Line;
import com.pbo.drawingtoolkit.shapes.Rectangle;

@SuppressWarnings("serial")
public class DrawingCanvas extends JPanel {
	
	private ArrayList<DrawingObject> myShapes;
	private int currentShapeType;
	private DrawingObject currentShapeObject;
	private Color currentShapeColor;
	
	private boolean isDrawing;
	private boolean isDragging;
	
	private double offsetX;
	private double offsetY;
	
	
	JLabel statusLabel;
	
	public DrawingCanvas(JLabel statusLabel) {
		this.statusLabel = statusLabel;
		
		myShapes = new ArrayList<DrawingObject>();
		currentShapeType = 0;
		currentShapeObject = null;
		currentShapeColor = Color.BLACK;
		
		setLayout(null);
		setBackground(Color.WHITE);
		add(statusLabel, BorderLayout.SOUTH);
		
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
		
		isDrawing = true;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = myShapes.size() - 1; i >= 0; i--) {
			myShapes.get(i).draw(g);
		}
		
		if (currentShapeObject != null) {
			currentShapeObject.draw(g);
		}
	}
	
	public void setCurrentShapeType(int type) {
		currentShapeType = type;
	}
	public void clearDrawing() {
		myShapes.clear();
		repaint();
	}
	
	private void selectDrawing(MouseEvent e) {
		double mx = e.getX();
		double my = e.getY();
		
		for (int i = 0; i < myShapes.size(); i++) {
			if (myShapes.get(i) != null) {
				if (mx > myShapes.get(i).getX1() && mx < myShapes.get(i).getX2() 
						&& my > myShapes.get(i).getY1() && my < myShapes.get(i).getY2()
						) {
					isDragging = true;
					offsetX = mx - myShapes.get(i).getX1();
					offsetY = my - myShapes.get(i).getY1();
					
					currentShapeObject = myShapes.get(i);
					myShapes.remove(i);
					return;
				}
			}
		}
	}

	public boolean getIsDrawing() {
		return isDrawing;
	}
	public void setIsDrawing(boolean isDrawing) {
		this.isDrawing = isDrawing;
	}
	
	private class MouseHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			if (isDrawing) {
				switch (currentShapeType) {
				case 0: 
					currentShapeObject = new Line(
													e.getX(), e.getY(),
													e.getX(), e.getY(),
													currentShapeColor
												);
					return;
				case 1:
					currentShapeObject = new Circle(
													e.getX(), e.getY(),
													e.getX(), e.getY(),
													currentShapeColor,
													false
												);
					return;
				case 2:
					currentShapeObject = new Rectangle(
													e.getX(), e.getY(),
													e.getX(), e.getY(),
													currentShapeColor,
													false
												);
					return;
				default:
				}
			}
			else {
				selectDrawing(e);
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if (isDrawing) {
				currentShapeObject.setX2(e.getX());
				currentShapeObject.setY2(e.getY());

				myShapes.add(currentShapeObject);
				
				currentShapeObject = null;
			}
			else {
				isDragging = false;
				
				myShapes.add(currentShapeObject);
				currentShapeObject = null;
			}
			repaint();

		}
		@Override
		public void mouseMoved(MouseEvent e) {
			statusLabel.setText(
						String.format(
								"MouseCoordinates X: %d Y: %d", 
								e.getX(), e.getY()
								)
					);
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			if (isDrawing) {
				currentShapeObject.setX2(e.getX());
				currentShapeObject.setY2(e.getY());
			}
			else if (isDragging) {
				double mx = e.getX();
				double my = e.getY();
				
				int x1 = (int)(mx - offsetX);
				int y1 = (int)(my - offsetY);
				int x2 = currentShapeObject.getX2() + x1;
				int y2 = currentShapeObject.getY2() + y1;
				
				currentShapeObject.setX1(x1);
				currentShapeObject.setY1(y1);
				currentShapeObject.setX2(x2);
				currentShapeObject.setY2(y2);
			}
			
			statusLabel.setText(
					String.format(
							"MouseCoordinates X: %d Y: %d", 
							e.getX(), e.getY()
							)
				);
			repaint();
		}
	}
}
