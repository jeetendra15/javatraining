package thread;

public class Program implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		Thread thread = new Thread();
//		thread.setName("Jeetendra");
//		thread.setPriority(1);
//		thread.start();

		Program program = new Program();
		Thread thread = new Thread(program);

		Program program1 = new Program();
		Thread thread1 = new Thread(program1);
		
		thread.start();
		thread.join();
		thread1.start();
		

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

}
