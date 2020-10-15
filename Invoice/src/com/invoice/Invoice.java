package com.invoice;

public class Invoice {
	//Attributes
	
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double price;
	
	//Constructor
	Invoice(String partNumber, String partDescription, int quantity, double price) {
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = checkQuantity(quantity);
		this.price = checkPrice(price);
	}
	
	//Getters
	public String getPartNumber() {
		return this.partNumber;
	}
	public String getPartDescription() {
		return this.partDescription;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public double getPrice() {
		return this.price;
	}
	
	//Setters
	public void setPartNumber (String newPartNumber) {
		this.partNumber = newPartNumber;
	}
	public void setPartDescription (String newPartDescription) {
		this.partDescription = newPartDescription;
	}
	public void setQuantity (int newQuantity) {
		this.quantity = checkQuantity(newQuantity);
	}
	public void setPrice (double newPrice) {
		this.price = checkPrice(newPrice);
	}
	
	//Check Values
	private int checkQuantity (int quantity) {
		return (quantity < 0) ? 0 : quantity;
	}
	private double checkPrice (double price) {
		return (price < 0.0F) ? 0.0F : price;
	}
	
	//Methods
	public double getInvoiceAmount() {
		return this.quantity * this.price;
	}
	
}
