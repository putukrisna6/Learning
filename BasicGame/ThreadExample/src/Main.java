
public class Main {
	public static void main(String[] args) {
		CountingThread myT = new CountingThread("myT");
		myT.start();
		
//		try {
//			myT.join();
//		}
//		catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		CountingThread myT2 = new CountingThread("myT2");
		myT2.start();
	}
}
