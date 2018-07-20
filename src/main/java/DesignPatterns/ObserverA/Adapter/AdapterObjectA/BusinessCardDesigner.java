package DesignPatterns.ObserverA.Adapter.AdapterObjectA;

/**
 * Client code which requires Customer interface.
 */
public class BusinessCardDesigner {

	public String designCard2(Customer sust) {
		String crd = "";
		crd += sust.getName();
		crd += "\n" + sust.getDest();
		crd += "\n" + sust.getAddr();
		return crd;
	}
}
