package npci_assgns_assgn2;

import java.util.Comparator;

import java.util.TreeSet;

public class TestEmployee {

	public static void main(String[] args) {

		// Using Comparable
		TreeSet<Employee> empListCompName = new TreeSet<>();
		empListCompName.add(new Employee(100, "Ashwin", "Mumbai", "Software"));
		empListCompName.add(new Employee(103, "Martin", "Nepal", "Database"));
		empListCompName.add(new Employee(102, "Bob", "Delhi", "Hardware"));
		empListCompName.add(new Employee(101, "Tom", "Chennai", "Linux"));
		empListCompName.add(new Employee(104, "Maxwell", "Bangalore", "Support"));

		// Using Comparator

		TreeSet<Employee> empListComp = new TreeSet<>(new EmployeeComparator());
		empListComp.add(new Employee(100, "Ashwin", "Mumbai", "Software"));
		empListComp.add(new Employee(103, "Martin", "Nepal", "Database"));
		empListComp.add(new Employee(102, "Bob", "Delhi", "Hardware"));
		empListComp.add(new Employee(101, "Tom", "Chennai", "Linux"));
		empListComp.add(new Employee(104, "Maxwell", "Bangalore", "Support"));

		// Using Anonymous Inner Class
		TreeSet<Employee> empListAic = new TreeSet<>(new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				Integer id1 = e1.getId();
				Integer id2 = e2.getId();
				return id1.compareTo(id2);
			}
		});
		empListAic.add(new Employee(100, "Ashwin", "Mumbai", "Software"));
		empListAic.add(new Employee(103, "Martin", "Nepal", "Database"));
		empListAic.add(new Employee(102, "Bob", "Delhi", "Hardware"));
		empListAic.add(new Employee(101, "Tom", "Chennai", "Linux"));
		empListAic.add(new Employee(104, "Maxwell", "Bangalore", "Support"));

		// Using Lambda Expressions
		TreeSet<Employee> empListLambda = new TreeSet<>((e1, e2) -> {
			Integer id1 = e1.getId();
			Integer id2 = e2.getId();
			return id1.compareTo(id2);

		});
		empListLambda.add(new Employee(100, "Ashwin", "Mumbai", "Software"));
		empListLambda.add(new Employee(103, "Martin", "Nepal", "Database"));
		empListLambda.add(new Employee(102, "Bob", "Delhi", "Hardware"));
		empListLambda.add(new Employee(101, "Tom", "Chennai", "Linux"));
		empListLambda.add(new Employee(104, "Maxwell", "Bangalore", "Support"));

		for (Employee e : empListCompName)
			System.out.println(e);

	}

}
