package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private String name;
	private String type;
	private int truckNum, rating;
	private static int nextTruckId = 1;

	public FoodTruck() {

	}

	public FoodTruck(String name, String type, int rating) {
		this.truckNum = nextTruckId++;
		this.name = name;
		this.type = type;
		this.rating = rating;
	}

	public int getTruckNum() {
		return truckNum;
	}

	public void setTruckNum() {
//		this.truckNum = truckNum;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;

	}

	@Override
	public String toString() {
		return "FoodTruck #: " + truckNum + ", Truck Name: " + name + ", Food Type: " + type + ", Truck Rating: " + rating;
	}

}
