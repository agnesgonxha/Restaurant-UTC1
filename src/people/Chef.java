package people;

import java.util.ArrayList;

public class Chef {
	private String name;
	private ArrayList<String> historyOfOrder = new ArrayList<String>();

	public Chef(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addHitory(String message) {
		historyOfOrder.add(message);
	}

	public void showCookHistory() {
		historyOfOrder.forEach((h) -> {
			System.out.println(h);
		});
	}
	
	

}
