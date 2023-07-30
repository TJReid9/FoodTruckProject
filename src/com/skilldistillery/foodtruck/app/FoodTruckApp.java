package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;
import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();

	}

	public void run() {

		FoodTruck[] foodTrucks = new FoodTruck[5];

		Scanner sc = new Scanner(System.in);
		int i = 0;
		int choice = 0;
		boolean continueFlag = true;
		while (continueFlag && i < 5) {

			System.out.print("Enter a truck name");
			String name = sc.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				continueFlag = false;
				break;
			}
			System.out.print("Enter a food type");
			String type = sc.nextLine();

			System.out.print("Enter a rating");
			int rating = sc.nextInt();
			sc.nextLine();

			foodTrucks[i++] = new FoodTruck(name, type, rating);
		}

		while (choice != 4) {
			choice = nextMenu(sc);
			switch (choice) {
			case 1:
				displayTrucks(foodTrucks);
				break;
			case 2:
				averageRating(foodTrucks);
				break;
			case 3:
				highestRating(foodTrucks);
				break;
			case 4:
				System.out.println("Thank you for using the FoodTruck App, Good Bye.");
				break;

			default:
				System.err.println("Error! Please choose again.");
				break;
			}

		}

	}

	public int nextMenu(Scanner sc) {

		int choice = 0;
		System.out.println("|======================================|");
		System.out.println("| Choose one of the following options: |");
		System.out.println("| 1. List All Trucks                   |");
		System.out.println("| 2. Average Rating                    |");
		System.out.println("| 3. Highest Rated Truck               |");
		System.out.println("| 4. Quit                              |");
		System.out.println("|======================================|");
		choice = sc.nextInt();
		return choice;
	}

	public void displayTrucks(FoodTruck[] trucks) {
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				System.out.println(foodTruck);
			}
		}

	}

	public void averageRating(FoodTruck[] trucks) {
		int counter = 0;
		double avgRatings = 0;
		double countRatings = 0;
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				countRatings = countRatings + foodTruck.getRating();
				counter++;
			}
		}
		avgRatings = countRatings / counter;
		System.out.print("The average food truck rating is: ");
		System.out.printf("%.2f\n", avgRatings);

	}

	public void highestRating(FoodTruck[] trucks) {
		FoodTruck bestTruck = null;
		int highestRating = 0;
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				if (highestRating < foodTruck.getRating()) {
					highestRating = foodTruck.getRating();
					bestTruck = foodTruck;
				}
			}
		}
		if (bestTruck != null) {
			System.out.println("The Winning FoodTruck Is!: " + bestTruck);
		}

		else {
			System.out.println("No trucks defined.");
		}
	}
}
