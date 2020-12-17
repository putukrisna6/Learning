
public class CountingThread extends Thread{
	
	private String name;
	
	public CountingThread(String name) {
		this.name = name;
		System.out.println("Creating " + this.name);
	}
	
	public void run() {
		System.out.println("Running " + name);
		
		try {
			for (int i = 0; i < 100; i++) {
				System.out.println("thread " + name + ":" + i);
				Thread.sleep(50);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(name + " exiting");
	}
}
