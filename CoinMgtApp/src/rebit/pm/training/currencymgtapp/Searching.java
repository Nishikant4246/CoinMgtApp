package rebit.pm.training.currencymgtapp;

import java.util.Scanner;
import java.util.Set;

public class Searching {
	static Scanner scan = new Scanner(System.in);

	public static void countryAndDenomination(Set<Coin> coins) {
		System.out.println("Enter Country");
		String country = scan.next();
		System.out.println("Enter Denominator");
		String denomination = scan.next();
		System.out.println("-------------");
		for (Coin coin : coins) {
			if (coin.getCountry().equals(country) && coin.getDenomination().equals(denomination)) {
				System.out.println(coin.toString());
			}
		}
		System.out.println("-------------");

	}

	public static void countryAndYearOfMinting(Set<Coin> coins) {
		System.out.println("Enter Country");
		String country = scan.next();
		System.out.println("Enter Year of Minting");
		Integer getYearOfMinting = scan.nextInt();
		System.out.println("-------------------------------------------------------------------------------------");
		for (Coin coin : coins) {
			if (coin.getCountry().equals(country) && coin.getYearOfMinting().equals(getYearOfMinting)) {
				System.out.println(coin.toString());
			}
		}
		System.out.println("-------------------------------------------------------------------------------------");

	}

	public static void countryAndDenominationAndYearOfMinting(Set<Coin> coins) {
		System.out.println("Enter Country");
		String country = scan.next();
		System.out.println("Enter Denominator");
		String denomination = scan.next();
		System.out.println("Enter Year of Minting");
		Integer getYearOfMinting = scan.nextInt();
		System.out.println("-------------------------------------------------------------------------------------");
		for (Coin coin : coins) {
			if (coin.getCountry().equals(country) && coin.getDenomination().equals(denomination)
					&& coin.getYearOfMinting().equals(getYearOfMinting)) {
				System.out.println(coin.toString());
			}
		}
		System.out.println("-------------------------------------------------------------------------------------");

	}

	public static void countryAndAcquiredDate(Set<Coin> coins) {
		System.out.println("Enter Country");
		String country = scan.next();
		System.out.println("Enter Acquired date");
		String denomination = scan.next();

		System.out.println("-------------------------------------------------------------------------------------");
		for (Coin coin : coins) {
			if (coin.getCountry().equals(country) && coin.getDenomination().equals(denomination)) {
				System.out.println(coin.toString());
			}
		}
		System.out.println("-------------------------------------------------------------------------------------");

	}

}