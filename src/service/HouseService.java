package service;

import domain.House;

public class HouseService {
	
	private House[] houses;
	private int houseNums;
	private int idCounter;
	
	public HouseService(int size) {
		
		houses = new House[size];
		
		houses[0] = new House(1, "Jack", "613-630-0911", "ON", 2000, "UnRented");
		houseNums = 1;
		idCounter = 1;
	}
	
	public boolean del(int delId) {
		int index = -1;
		for(int i = 0; i < houseNums; i++) {
			if(delId == houses[i].getId()) {
				index = i;
			}
		}
		if(index == -1) {
			return false;
		}
		for(int i = index; i < houseNums - 1; i++) {
			houses[i] = houses[i+1];
		}
		houses[houseNums - 1] = null;
		houseNums --;
		return true;
	}	
	
	public House findById(int findId) {
		for(int i = 0; i < houseNums; i++) {
			if(findId == houses[i].getId()) {
				return houses[i];
			}
		}
			return null;
	}
	
	
	
	public boolean add(House newHouse) {
		if(houseNums>= houses.length) {
			System.out.println("Full");
			return false;
		}
		//把newHouse对象加入到数组的最后
		idCounter++;
		newHouse.setId(idCounter);
		houses [houseNums] = newHouse;
		houseNums++;
		return true;
	}
	
	public House[] list(){
		
		return houses;
	}
	
}
