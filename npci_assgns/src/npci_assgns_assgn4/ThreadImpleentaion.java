package npci_assgns_assgn4;

public class ThreadImpleentaion {

	public static void main(String[] args) {
		ProdCons prdCon = new ProdCons();
		Thread thread1 = new Thread(() -> prdCon.producer(150));

		Thread thread2 = new Thread(() -> {
			try {
				prdCon.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		thread1.start();
		thread2.start();

	}

}
