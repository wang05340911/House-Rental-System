package view;

import domain.House;
import service.HouseService;
import utils.Utility;

public class HouseView {
	private boolean loop = true;
	private char key = ' ';
	
	private HouseService houseService = new HouseService(10);
	
	public void exit() {
		char c = Utility.readConfirmSelection();
		if(c == 'Y') {
		loop = false;
		}
	}
	
	public void delHouse() {
		System.out.println("======Delete a house======");
		System.out.println("Type in the id of the house(-1 means quit): ");
		int delId = Utility.readInt();
		if(delId == -1) {
			System.out.println("======Sucess quit======");
			return;
		}
		
		char choice = Utility.readConfirmSelection();
		if(choice == 'Y') {
			if(houseService.del(delId)) {
				System.out.println("====Sucess Deleted====");
			}else {
				System.out.println("====Failed Deleted====");
			}
		}else {
			System.out.println("======Sucess quit======");
		}
		
	}
	
	public void findHouse() {
		System.out.println("=====Find a house info=====");
		System.out.println("Type in the id of the house: ");
		int findId = Utility.readInt();
		House house = houseService.findById(findId);
		if(house != null) {
		System.out.println(house);
		}else {
			System.out.println("====Can not find the house====");
		}
	}
	
	public void updateHouse() {
		System.out.println("=====Update a house info=====");
		System.out.println("Type in the id of the house: ");
		int findId = Utility.readInt();
		House house = houseService.findById(findId);
		if(house != null) {
			System.out.println("name(" + house.getName() + "): ");
			String name = Utility.readString(8);
			System.out.println("PhoneNumber(" + house.getPhone() + "): ");
			String phone = Utility.readString(12);
			System.out.println("Address(" + house.getAddress() + "): ");
			String address = Utility.readString(16);
			System.out.println("Rent(" + house.getRent() + "): ");
			int rent = Utility.readInt();
			System.out.println("State(" + house.getState() + "): ");
			String state = Utility.readString(8);
			house = null;
			House newHouse = new House(0, name, phone, address, rent, state);
			System.out.println(newHouse);
		}
	}
	
	public void addHouse() {
		System.out.println("======Add a house======");
		System.out.println("name: ");
		String name = Utility.readString(8);
		System.out.println("PhoneNumber: ");
		String phone = Utility.readString(12);
		System.out.println("Address: ");
		String address = Utility.readString(16);
		System.out.println("Rent: ");
		int rent = Utility.readInt();
		System.out.println("State: ");
		String state = Utility.readString(8);
		House newHouse = new House(0, name, phone, address, rent, state);
		if(houseService.add(newHouse)){
			System.out.println("===Sucess===");
		}else {
			System.out.println("===Failed===");
		}
	}
	
	public void listHouses() {
		System.out.println("======List of the Houses======");
		System.out.println("Id\tOwner\tPhoneNumber\tAddress\t"
				+ "Rent\tState(Rented/Unrented)");
		House[] houses = houseService.list();
		for(int i = 0; i < houses.length; i++) {
			if(houses[i] == null) {
				break;
			}
			System.out.println(houses[i]);
		}
		System.out.println("======All Done======");
	}
	
	public void mainMenu() {
		
		do {
			System.out.println("\n======House Rent System Menu======");
			System.out.println("\t\t\t1. Add a house");
			System.out.println("\t\t\t2. Search a house");
			System.out.println("\t\t\t3. Delete a house");
			System.out.println("\t\t\t4. Update a house");
			System.out.println("\t\t\t5. List of the Houses");
			System.out.println("\t\t\t6. Quit");
			System.out.println("please type in your choice: (1-6)");
			key = Utility.readChar();
			switch(key) {
			case '1':
				addHouse();
				break;
			case '2':
				findHouse();
				break;
			case '3':
				delHouse();
				break;
			case '4':
				updateHouse();
				break;
			case '5':
				listHouses();
				break;
			case '6':
				exit();
				break;
			}
		}while(loop);
		
		
	}



}
