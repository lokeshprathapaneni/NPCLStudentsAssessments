package npci_assgns_assgn3;

@FunctionalInterface
public interface CalculatorAdd {

	void add(int x, int y);

	default void addition() {
		System.out.println("Addition of Two Numbers");
	}

	static void commonadd() {
		System.out.println("Calculator Features to add");
	}

}
