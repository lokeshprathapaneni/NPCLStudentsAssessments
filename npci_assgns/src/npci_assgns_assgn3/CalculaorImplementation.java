package npci_assgns_assgn3;

public class CalculaorImplementation implements CalculatorAdd, CalculatorSub {

	@Override
	public void add(int x, int y) {
		System.out.println("Sum is =" + (x + y));

	}

	@Override
	public void addition() {

		CalculatorAdd.super.addition();
	}

	@Override
	public void sub(int x, int y) {
		System.out.println("Sub is = " + (x - y));

	}

	@Override
	public void subtraction() {

		CalculatorSub.super.subtraction();
	}

	public static void main(String[] args) {

		CalculaorImplementation calImpl = new CalculaorImplementation();
		calImpl.addition();
		calImpl.add(10, 50);
		
		calImpl.subtraction();
		calImpl.sub(47, 10);

	}

}
