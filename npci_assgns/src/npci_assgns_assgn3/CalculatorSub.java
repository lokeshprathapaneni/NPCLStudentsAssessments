package npci_assgns_assgn3;

@FunctionalInterface
public interface CalculatorSub {

	void sub(int x, int y);

	default void subtraction() {
		System.out.println("Subtraction of two Numbers");
	}

	static void commonsub() {
		System.out.println("Calculator Features to subtract");
	}

}
