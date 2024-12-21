package com.edubridge.kettle;

import java.util.List;
import java.util.Scanner;

import com.edubridge.kettle.db.DBConnection;
import com.edubridge.kettle.dto.Kettle;
import com.edubridge.kettle.service.KettleService;
import com.edubridge.kettle.service.KettleServiceI;

public class App {
	private static KettleServiceI service = new KettleService();

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			int choice;

			System.out.println("Kettle Management System");
			System.out.println("========================");

			while (true) {
				System.out.println("\nMenu");
				System.out.println("====");
				System.out.println("1. Add kettle");
				System.out.println("2. Retrieve kettle");
				System.out.println("3. Retrieve kettle by id");
				System.out.println("4. Update kettle");
				System.out.println("5. Delete kettle");
				System.out.println("0. Quit");

				System.out.println("Enter your choice");

				choice = in.nextInt();

				int id = 0, status = 0;
				String brand = null, material = null, storage = null;
				float capacity = 0;
				double price = 0.0;

				switch (choice) {
				case 1:
					System.out.println("Enter kettle id");
					id = in.nextInt();
					System.out.println("Enter kettle brand");
					in.nextLine();
					brand = in.nextLine();
					System.out.println("Enter kettle capacity");
					capacity = in.nextFloat();
					System.out.println("Enter kettle material");
					in.nextLine();
					material = in.nextLine();
					System.out.println("Enter kettle storage");
					storage = in.nextLine();
					System.out.println("Enter kettle price");
					price = in.nextDouble();

					status = service.addKettle(new Kettle(id, brand, material, storage, capacity, price));

					if (status >= 1) {
						System.out.println("Kettle added successfully!");
					} else {
						System.out.println("Failed!");
					}
					break;
				case 2:
					List<Kettle> kettles = service.retrieveKettle();

					if (kettles.size() != 0) {
						kettles.forEach(kettle -> {
							System.out.println(kettle);
						});
					} else {
						System.out.println("No kettles available");
					}
					break;
				case 3:
					System.out.println("Enter kettle id");
					id = in.nextInt();

					Kettle kettle = service.retrieveKettle(id);

					if (kettle != null) {
						System.out.println(kettle);
					} else {
						System.out.println("Invalid kettle id");
					}
					break;
				case 4:
					System.out.println("Enter kettle id");
					id = in.nextInt();
					System.out.println("Enter updated capacity");
					capacity = in.nextFloat();
					System.out.println("Enter updated price");
					price = in.nextDouble();

					status = service.updateKettle(capacity, price, id);

					if (status >= 1) {
						System.out.println("Kettle updated successfully!");
					} else {
						System.out.println("Failed!");
					}
					break;
				case 5:
					System.out.println("Enter kettle id");
					id = in.nextInt();

					status = service.deleteKettle(id);

					if (status >= 1) {
						System.out.println("Deleted kettle successfully!");
					} else {
						System.out.println("Failed");
					}
					break;
				case 0:
					System.out.println("Quiting!");
					in.close();
					DBConnection.closeConnection();
					System.exit(0);
				default:
					System.out.println("Invalid choice");
				}
			}
		} catch (Exception e) {
			System.out.println("Please provide valid input");
		}
	}
}
