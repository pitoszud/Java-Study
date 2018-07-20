package DesignPatterns.ObserverA.Adapter.AdapterClassA;

public class Main {

	public static void main(String[] args) {
		/** Using Class/Two-way adapt **/
		EmployeeClassAdapter adapt  = new EmployeeClassAdapter();
		getEmployeeData(adapt);
		BusinessCardDesigner designer = new BusinessCardDesigner();
		String card  = designer.designCard(adapt);
		System.out.println(card);
		
		System.out.println("************************************************************");
		/** Using Object Adapter **/
		Employee empl = new Employee();
		getEmployeeData(empl);
		EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(empl);
		card = designer.designCard(objectAdapter);
		System.out.println(card);
	}

	private static void getEmployeeData(Employee employee) {
		employee.setFullName("Elliot Alderson");
		employee.setJobTitle("Security Engineer");
		employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
	}
}
