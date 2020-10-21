package com.quadrilateral;

public class Quadrilateral {
	private Points p1;
	private Points p2;
	private Points p3;
	private Points p4;
	
	public Quadrilateral(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3) {
		p1 = new Points(x0, y0);
		p2 = new Points(x1, y1);
		p3 = new Points(x2, y2);
		p4 = new Points(x3, y3);
	}

	public Points getP1() {
		return p1;
	}
	public void setP1(Points p1) {
		this.p1 = p1;
	}
	public Points getP2() {
		return p2;
	}
	public void setP2(Points p2) {
		this.p2 = p2;
	}
	public Points getP3() {
		return p3;
	}
	public void setP3(Points p3) {
		this.p3 = p3;
	}
	public Points getP4() {
		return p4;
	}
	public void setP4(Points p4) {
		this.p4 = p4;
	}
	
	public double getArea() {
		return 0.0;
	}
	public String toString() {
		return p1 + ", " + p2 + ", " + p3 + ", " + p4;
	}
}
