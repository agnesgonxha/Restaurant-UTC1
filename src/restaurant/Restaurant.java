package restaurant;

import java.util.ArrayList;

import main.Food;
import people.Chef;
import people.Visitor;

public class Restaurant {
	private String name;
	
	private ArrayList<Menu> menus = new ArrayList<Menu>();
	private ArrayList<Chef> chefs = new ArrayList<Chef>();
	
	private int totalIncome = 0;

	public Restaurant(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void addMenu(Menu category) {
		menus.add(category);
	}
	
	public void addChef(Chef chef) {
		chefs.add(chef);
	}

	public void showMenu() {
		System.out.println("Menus : ");
		menus.forEach((m) -> {
			System.out.println("- " + m.getCategory());
			
			m.getFoods().forEach((f) -> {
				System.out.println("  - " + f.getName() + " : " + f.getPrice());
			});
		});
	
	}
	
	public void showChef() {
		System.out.println("Chef :");
		chefs.forEach((c) -> {
			System.out.println("- " + c.getName());
		});
	}

	public void order(Chef chef, Visitor visitor, String foodName, int ammount) {
		String message = "Chef "+chef.getName()+" is preparing "+foodName+" for "+visitor.getName()+". Total ammount: "+ammount+".";
//		System.out.println(message);
		
		int totalPrice = 0;
		int found = 1;
		for (int i = 0; i < menus.size(); i++) {
			for (int j = 0; j < menus.get(i).getFoods().size(); j++) {
				if (menus.get(i).getFoods().get(j).getName() == foodName) {
					//menus[i].foods[j].price
					
					totalPrice = menus.get(i).getFoods().get(j).getPrice() * ammount;
					found = 0;
					break;
				}
			}
			if (found == 0) {
				break;
			}
		}
		totalIncome += totalPrice;
		visitor.setTotalPrice(totalPrice);
		chef.addHitory(message);
	}

	public void showTotalIncome() {
		System.out.println("Total Income : " + totalIncome);
	}

	

}
