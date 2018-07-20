package DesignPatterns.ObserverA.Adapter.AdapterObjectA;

/**
 * A class adapter, works as Two-way adapter
 */
public class EmployeeClassAdapter extends Employee implements Customer{

	@Override
	public String getName() {
		return this.getFullName();
	}

	@Override
	public String getDest() {
		return this.getJobTitle();
	}

	@Override
	public String getAddr() {
		return this.getOfficeLocation();
	}
	
}
