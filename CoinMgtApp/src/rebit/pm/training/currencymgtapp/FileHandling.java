package rebit.pm.training.currencymgtapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileHandling {

	public static Set<Coin> readDataFromFile() {
		String fileName = "./coin_data.csv";
		Set<Coin> newData = new HashSet<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			boolean isHeader = true;

			while ((line = reader.readLine()) != null) {

				if (isHeader) {

					isHeader = false;
					continue;
				}

				String[] parts = line.split(",");
				if (parts.length == 6) {

					Coin coin = new Coin();
					coin.setCountry(parts[0].trim());
					coin.setDenomination(parts[1].trim());
					coin.setYearOfMinting(Integer.parseInt(parts[2].trim()));
					coin.setCurrentValue(Integer.parseInt(parts[3].trim()));
					coin.setCurrency(parts[4].trim());
					coin.setAcquiredDate(java.sql.Date.valueOf(parts[5].trim()));
					newData.add(coin);
				}
			}
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
		return newData;
	}
}