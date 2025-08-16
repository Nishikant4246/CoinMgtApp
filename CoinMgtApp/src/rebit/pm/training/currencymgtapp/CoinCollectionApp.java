package rebit.pm.training.currencymgtapp;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoinCollectionApp {
	public static Scanner scan = new Scanner(System.in);
	static Integer FinalRowNumber;

	public static Integer mainMenu(){
		Integer a=0;
		System.out.println("1 : Retrive & Load Data From Databse To the Collection");
		System.out.println("2 : Insert Data from File to The Database");
		System.out.println("3 : Show All Available Coins Within Collection");
		System.out.println("4 : Add New Coin To the Collection");
		System.out.println("5 : Save only newly added data to the collection");
		System.out.println("6 : Show only newly added data to the collection");
		System.out.println("7 : Create List On ");
		System.out.println("8 : Searching ");
		System.out.println("0 : Exit Application");
		
	   
		a=validateUserInput();
		
		if(a==0) {
			System.out.println("\nInvalid Input\n");
			main(null);
		}
		
	
		
		return a;
	}

	public static Set<Coin> addNewCoinToTheCollection(Set<Coin> coins, Set<Coin> dummyCoins) throws ParseException {
		System.out.println("Enter The Country");
		String country = scan.next();
		System.out.println("Enter The denomination");
		String denomination = scan.next();
		System.out.println("Enter The yearOfMinting in YYYY-mm-DD");
		Integer yearOfMinting = scan.nextInt();
		System.out.println("Enter The currentValue");
		Integer currentValue = scan.nextInt();
		System.out.println("Enter Currency");
		String currency = scan.next();
		System.out.print("Enter a date (e.g., yyyy-MM-dd): ");
		String userInput = scan.next();
		SimpleDateFormat dateForma = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsedDate;
		java.sql.Date sqlDate = null;

		parsedDate = dateForma.parse(userInput);
		sqlDate = new java.sql.Date(parsedDate.getTime());

		System.out.println("You entered: " + sqlDate);

		Coin coin = new Coin(country, denomination, yearOfMinting, currentValue, currency, sqlDate);
		if (coin != null) {
			coins.add(coin);
			dummyCoins.add(coin);
			System.out.println("Coin Added Successfully to the Collection");
		}
		return dummyCoins;

	}

	public static void main(String[] args) {
		DatabaseOperations databaseOperations = new DatabaseOperations();
		Set<Coin> coins = null;
		Set<Coin> dummyCoins = new HashSet<>();
		boolean flag;
		int choice = 0;

		do {
			try {
				switch (choice) {
				case 1:
					coins = databaseOperations.getCoins();
					if (coins != null) {
						FinalRowNumber = coins.size();
						System.out.println("Final Row number " + coins.size());
						System.out.println("Data Loaded Successfully");
					} else {
						System.out.println("Data has been not loaded");
					}

					break;
				case 2:
					Set<Coin> c = FileHandling.readDataFromFile();
					flag = databaseOperations.saveDataToDatabase(c);
					if (flag) {
						System.out.println("Data added successfully to the databse table");
					} else {
						System.out.println("Data is not added  to the databse table");
					}
					break;
				case 3:
					for (Coin coin : coins) {
						System.out.println(coin.toString());
					}
					break;
				case 4:
					dummyCoins = addNewCoinToTheCollection(coins, dummyCoins);

					break;
				case 5:
					flag = databaseOperations.saveDataToDatabase(dummyCoins);
					if (flag) {
						System.out.println("Current state of Data successfully added to the databse table");

					} else {
						System.out.println("Current state of Data not added to the databse table");
					}
					break;
				case 6:
					for (Coin coin : dummyCoins) {
						System.out.println(coin.toString());
					}
					break;
				case 7:
					while ((choice = createListMenuBar()) != 0) {
						switch (choice) {
						case 1:
							CreateList.countryList(coins);
							break;
						case 2:
							CreateList.yearOfMiningList(coins);
							break;
						case 3:
							CreateList.currentValueList(coins);
							break;
						}
					}
					;
				case 8:
					while ((choice = SearchingListMenuBar()) != 0) {
						switch (choice) {
						case 1:
							Searching.countryAndDenomination(coins);
							break;
						case 2:
							Searching.countryAndYearOfMinting(coins);
							break;
						case 3:
							Searching.countryAndDenominationAndYearOfMinting(coins);
							break;
						case 4:
							Searching.countryAndAcquiredDate(coins);
							break;
						}
					}
					;

					break;
					
//					default: throw new CustomException();
				}
			} catch (SQLException e) {

				System.out.println("\nDatabase Connection Problem\n");

			}catch (ParseException e) {

				System.out.println("\nInvalid Date format provide please provide valid format\n");

			} catch (CustomException e) {

				System.out.println("Invalid Input please Enter Valid Input");
				
				

			} catch (RuntimeException e) {

				System.out.println("\nDatabase Connection issue occured check credentials\n");
				
			} catch (ClassNotFoundException e) {
				System.out.println("\nData Not Found or Unable to get data\n");
			}

		} while ((choice = mainMenu()) != 0);

	}

	public static Integer createListMenuBar() {
		Integer a=0;
		
		System.out.println("1 : Country");
		System.out.println("2 : Year of minting");
		System.out.println("3 : Current Value");
		System.out.println("0 : Previous Menu");
		
		a=validateUserInput();
		if(a==0) {
			System.out.println("\nInvalid Input\n");
			main(null);
		}
		
		return a;
	}

	public static Integer SearchingListMenuBar(){
		Integer a=0;
		System.out.println("1 : Searching Based On: Country + Denomination");
		System.out.println("2 : Searching Based On: Country + Year of Minting");
		System.out.println("3 : Searching Based On: Country + Denomination + Year of Minting");
		System.out.println("4 : Searching Based On: Country + Acquired Date");
		System.out.println("0 : Previous Menu");
		
		a=validateUserInput();
		if(a==0) {
			System.out.println("\nInvalid Input\n");
			main(null);
		}
		
		return a;
	}
	
	public static  Integer validateUserInput() {

		Pattern p = Pattern.compile("\\d+");

		String input = scan.nextLine();

		Matcher m = p.matcher(input);

		if (m.matches()) {
			return Integer.parseInt(input);
		} else {
			return 0;
		}

	
	}
}