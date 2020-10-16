package com.invoice;

public class InvoiceTest {

	public static void main(String[] args) {
		Invoice myInvoice = new Invoice("IF184301", "It's a test product", -1, -0.1);
		
		//Showing invoice info
		System.out.println("Here's the detail on the invoice:");
		System.out.println(myInvoice.getPartNumber());
		System.out.println(myInvoice.getPartDescription());
		System.out.println(myInvoice.getPrice());
		System.out.println(myInvoice.getQuantity());
		System.out.println();
		
		//Setting invalid states
		myInvoice.setPrice(-2123.2);
		myInvoice.setQuantity(-9);
		
		//Showing that the price is now 0.0 and the quantity is 0
		System.out.println(myInvoice.getPrice());
		System.out.println(myInvoice.getQuantity());
		
		//Setting valid values
		myInvoice.setQuantity(1);
		myInvoice.setPrice(100.9);
		
		//Getting the invoice
		System.out.println("\nYour invoice is:");
		System.out.println(myInvoice.getInvoiceAmount());
		
	}

}
