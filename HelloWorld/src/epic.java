import java.text.NumberFormat;

public class epic {

	public static void main(String[] args) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String result = currency.format(1000.12);
		
		NumberFormat percentage = NumberFormat.getPercentInstance();
		String newRes = percentage.format(0.7);
		System.out.println(newRes);

	}

}
