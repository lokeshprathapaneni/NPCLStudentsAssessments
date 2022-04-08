package npci_assgns_assgn2;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		Integer id1 = e1.getId();
		Integer id2 = e2.getId();
		return id1.compareTo(id2);
	}

}
