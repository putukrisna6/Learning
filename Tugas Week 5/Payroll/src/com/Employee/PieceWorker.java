package com.Employee;

public class PieceWorker extends Employee{
	private double wage;
	private int pieces;
	
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int pieces) {
		super(firstName, lastName, socialSecurityNumber);
		checkWage(wage);
		checkPieces(pieces);
		
		this.wage = wage;
		this.pieces = pieces;
	}
	
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		checkWage(wage);
		this.wage = wage;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		checkPieces(pieces);
		this.pieces = pieces;
	}

	@Override
	public double earnings() {
		return getPieces() * getWage();
	}
	@Override
    public String toString() {
        return String.format("piece-worker: %s%n%s: $%,.2f; %s: %,d", super.toString(), 
        		"wage-per-piece", getWage(), "number of pieces produced", getPieces());
    }
	
	private void checkWage(double wage) {
		if(wage < 0.0) {
			throw new IllegalArgumentException("Wage per piece must be >= 0.0");
		}
	}
	private void checkPieces(int pieces) {
		if(pieces < 0) {
			throw new IllegalArgumentException("Pieces produced must be >= 0");
		}
	}
}
