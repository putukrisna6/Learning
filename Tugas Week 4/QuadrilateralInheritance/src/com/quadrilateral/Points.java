package com.quadrilateral;

public class Points {
	private double x;
	private double y;
	
	public Points(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	protected void setX(double x) {
		this.x = x;
	}
	protected void setY(double y) {
		this.y = y;
	}
	protected double getX() {
		return this.x;
	}
	protected double getY() {
		return this.y;
	}
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
