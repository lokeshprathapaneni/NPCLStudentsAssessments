package npci_assgns_assgn4;

public class ProdCons {

	int x = 0;
	boolean isConsCalled = true;

	public synchronized void producer(int val) {
		System.out.println(Thread.currentThread().getName());
		x = val;
		
		notify();
	}

	public synchronized void consumer() throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		wait();
		System.out.println(x);
	}

}
