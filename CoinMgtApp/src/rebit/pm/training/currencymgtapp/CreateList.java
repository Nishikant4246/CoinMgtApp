package rebit.pm.training.currencymgtapp;

import java.util.Scanner;
import java.util.Set;

public class CreateList {
	static Scanner scanner = new Scanner(System.in);

	public static void countryList(Set<Coin> coins) {
		String countryChoice = getSelectedCountry(coins);

		for (Coin coin : coins) {
			if (coin.getCountry().equals(countryChoice)) {
				System.out.println(coin.toString());
			}
		}

	}

	private static String getSelectedCountry(Set<Coin> coins) {
		int count = 0;
		System.out.println("-------------");
		System.out.println("Available Countries:");
		for (Coin coin : coins) {
			count++;
			System.out.println(count + "  " + coin.getCountry());
		}
		System.out.println("-------------");

		Integer choice = 0;

		while (true) {
			System.out.print("Enter the number of the country: ");
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				if (choice >= 1 && choice <= count) {
					break;
				} else {
					System.out.println("Invalid choice. Please enter a number from 1 to " + count + ".");
				}
			} else {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next();
			}
		}

		// Find the selected country based on the user choice
		count = 0;
		for (Coin coin : coins) {
			count++;
			if (count == choice) {
				return coin.getCountry();
			}
		}
		return null;
	}

	public static void yearOfMiningList(Set<Coin> coins) {
		Integer yearOfMinting = getYearOfMinting(coins);
		for (Coin coin : coins) {
			if (coin.getYearOfMinting().equals(yearOfMinting)) {
				System.out.println(coin.toString());
			}
		}

	}

	private static Integer getYearOfMinting(Set<Coin> coins) {
		Integer count = 0;
		System.out.println("-------------");
		System.out.println("Available Years of Minting:");
		for (Coin coin : coins) {
			count++;
			System.out.println(count + "  " + coin.getYearOfMinting());
		}
		System.out.println("-------------");

		Integer choice = 0;

		while (true) {
			System.out.print("Enter the number of the Minting year: ");
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				if (choice >= 1 && choice <= count) {
					break;
				} else {
					System.out.println("Invalid choice. Please enter a number from 1 to " + count + ".");
				}
			} else {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next();
			}
		}

		// Find the selected country based on the user choice
		count = 0;
		for (Coin coin : coins) {
			count++;
			if (count == choice) {
				return coin.getYearOfMinting();
			}
		}
		return null;
	}

	public static void currentValueList(Set<Coin> coins) {
		Integer currentValue = getCurrentValue(coins);
		for (Coin coin : coins) {
			if (coin.getCurrentValue().equals(currentValue)) {
				System.out.println(coin.toString());
			}
		}

	}

	private static Integer getCurrentValue(Set<Coin> coins) {
		Integer count = 0;
		System.out.println("-------------");
		System.out.println("Available Current Values Of Coin:");
		for (Coin coin : coins) {
			count++;
			System.out.println(count + "  " + coin.getCurrentValue());
		}
		System.out.println("-------------");

		Integer choice = 0;

		while (true) {
			System.out.print("Enter the number of the Current value: ");
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				if (choice >= 1 && choice <= count) {
					break;
				} else {
					System.out.println("Invalid choice. Please enter a number from 1 to " + count + ".");
				}
			} else {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next();
			}
		}

		// Find the selected country based on the user choice
		count = 0;
		for (Coin coin : coins) {
			count++;
			if (count == choice) {
				return coin.getCurrentValue();
			}
		}
		return null;
	}

}