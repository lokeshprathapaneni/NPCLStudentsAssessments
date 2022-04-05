package org.rp.assignment23;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Test {


	
	public void addToCollection(Bank ba) throws AndhraPradeshIsNotYetFunctionalException {
		if(ba.branchName.equals("Karnataka"))
			throw new BankIsTemporaryClosedException();
		if(ba.branchName.equals("Andhra Pradesh"))
			throw new AndhraPradeshIsNotYetFunctionalException();
		h.add(ba);
	}
	
	public void retrieveUniqueBank() {
		h.stream().forEach(t -> System.out.println(t));
	}
	public void retrieveBranchName() {
		List<String> l = h.stream().map(k -> k.getBranchName()).distinct().collect(Collectors.toList());
		System.out.println(l);
	}
	public void revBankName() {
		List<String> l = h.stream().map(k -> k.getBankName()).collect(Collectors.toList());
		Collections.sort(l, Collections.reverseOrder());
		System.out.println(l);
	}

	HashSet<Bank> h = new HashSet<>();
	
	
	public static void main(String[] args) throws AndhraPradeshIsNotYetFunctionalException{
	
		Bank b = new Bank(123456789, "Sensen", "Murry","Bank", "sdf", "Sovima");
		Bank b1 = new Bank(223456789, "Ryan", "Lewis","ABC", "California", "Cali");
		Bank b2 = new Bank(323456789, "Bebe", "Murry","PJM", "Andhra Pradesh", "Dolphin");
		Bank b3 = new Bank(423456789, "Jupon", "Murry","LKH", "Karnataka", "Sainik");
		Bank b4 = new Bank(423456789, "Jupon", "Murry","MNB", "Peren", "Sainik");
		
	
		
		
		Test t = new Test();
		t.addToCollection(b);
		t.addToCollection(b1);
		t.addToCollection(b2);
		t.addToCollection(b3);
		t.addToCollection(b4);
	
		
		t.retrieveUniqueBank();
		
		t.retrieveBranchName();
		
		t.revBankName();
		
	}
}
