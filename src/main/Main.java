package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	public static void showMenu() {

		System.out.println("Choose one of this options:");

		System.out.println("Product list:");

		System.out.println("1. Load data from file and display");

		System.out.println("2. Input & add to the end.");

		System.out.println("3. Display data");

		System.out.println("4. Save product list to file.");

		System.out.println("5. Search by ID");

		System.out.println("6. Delete by ID");

		System.out.println("7. Sort by ID.");

		System.out.println("8. Convert to Binary");

		System.out.println("9. Load to stack and display");

		System.out.println("10. Load to queue and display.");

		System.out.println("0. Exit");

	}

	public static void main(String[] args) throws FileNotFoundException {

		MyList<Product> list = new MyList<>();
		MyQueue<Product> queue = new MyQueue<>();
		MyStack<Product> stack = new MyStack<>();

		Scanner sc = new Scanner(System.in);

		int choice;

		do {

			showMenu();

			System.out.print("Input choice:");
			choice = Integer.parseInt(sc.nextLine());
			System.out.println("Choice= " + choice);

			switch (choice) {
			case 1:
				System.out.println("ID |  Title   | Quantity | price");
				System.out.println("--------------------------------");

				OperationToProduct.getAllItemsFromFile("data.txt", list);

				break;
			case 2:
				OperationToProduct.addLast(list);

				break;
			case 3:

				OperationToProduct.displayAll(list);

				break;
			case 4:
				OperationToProduct.writeAllItemsToFile("data.txt", list);

				break;
			case 5:
				OperationToProduct.searchByCode(list);

				break;
			case 6:
				OperationToProduct.deleteByCode(list);

				break;
			case 7:
				OperationToProduct.sortByCode(list);

				break;
			case 8:
				OperationToProduct.convertToBinary(list);

				break;
			case 9:
				System.out.println("ID |  Title   | Quantity | price");
				System.out.println("--------------------------------");
				OperationToProduct.getAllItemsFromFile("data.txt", stack);

				break;
			case 10:
				System.out.println("ID |  Title   | Quantity | price");
				System.out.println("--------------------------------");
				OperationToProduct.getAllItemsFromFile("data.txt", queue);

				break;

			case 0:
				System.out.println("Goodbye!");
				break;
			}

		} while (choice != 0);

	}

}
