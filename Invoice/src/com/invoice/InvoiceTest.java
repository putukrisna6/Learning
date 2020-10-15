package com.invoice;

public class InvoiceTest {

	public static void main(String[] args) {
		Invoice myInvoice = new Invoice("IF184301", "It's a test product", -1, -0.1);
		
		System.out.println(myInvoice.getPrice());
		System.out.println(myInvoice.getQuantity());
		
		myInvoice.setPrice(-2123.2);
		myInvoice.setQuantity(-9);
		
		System.out.println(myInvoice.getPrice());
		System.out.println(myInvoice.getQuantity());
		
		myInvoice.setQuantity(1);
		myInvoice.setPrice(100.9);
		
		System.out.println(myInvoice.getInvoiceAmount());
		
	}

}
