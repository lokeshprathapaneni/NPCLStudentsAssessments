package npci_assgns_assgn1;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestBank {

	public static void uniqueBanks(HashSet<Bank> bankSet) {
		System.out.println(bankSet);
	}

	Set<Bank> bankSet = new HashSet<>();

	public void addBanks(Bank bank) throws AndhraPradeshIsNotYetFunctionalException {
		if (bank.getBranchName().equals("Karnataka")) {
			throw new BanksIsTemporarlyClosedExceptom("This Branch Bank is temporarily closed");
		}
		if (bank.getBranchName().equals("AndhraPradesh ")) {
			throw new AndhraPradeshIsNotYetFunctionalException("This Branch is not yet functional");
		}

		bankSet.add(bank);

	}

	public void retiveBranchName() {
		bankSet.stream().map(k -> k.getBranchName()).forEach(k -> System.out.println(k));
	}

	public void reverseBankName() {
		bankSet.stream().sorted((s1, s2) -> -s1.getfName().compareTo(s2.getfName()))
				.forEach(s -> System.out.println(s));
	}

	public void uniqueBanks() {
		bankSet.stream().map(k -> k.getfName()).collect(Collectors.toSet()).forEach(s -> System.out.println(s));
	}

	public static void main(String[] args) throws AndhraPradeshIsNotYetFunctionalException {

		TestBank testBank = new TestBank();
		testBank.addBanks(new Bank(10101, "SBI", "India", "Mumbai", "Bandra East"));
		testBank.addBanks(new Bank(10102, "HDFC", "India", "Madhyapradesh", "Mangoli"));
		testBank.addBanks(new Bank(10103, "ICICI", "India", "Hyderabad", "CharMinar"));
		testBank.addBanks(new Bank(10104, "PNB", "India", "Chennai", "Thiru"));
		testBank.addBanks(new Bank(10105, "FEDERAL", "India", "UttarPradesh", "Lucknow"));
		testBank.addBanks(new Bank(10101, "AXIS", "India", "Delhi", "NP park"));
		testBank.addBanks(new Bank(10107, "HDFC", "India", "Punjab", "Chattisgarh"));

		testBank.uniqueBanks();
//		testBank.retiveBranchName();
//		testBank.reverseBankName();
//		

	}

}
