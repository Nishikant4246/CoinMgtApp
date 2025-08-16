package rebit.pm.training.currencymgtapp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class DatabaseOperations {
	Set<Coin> coins;
	Connection connection;

	public DatabaseOperations() {
		super();
		coins = new HashSet<>();
	}

	public Set<Coin> getCoins() throws SQLException, ClassNotFoundException {
		loadAllDataFromDatabase();
		return coins;
	}

	public void setCoins(Set<Coin> coins) {

		this.coins = coins;
	}

	public void loadAllDataFromDatabase() throws SQLException, ClassNotFoundException {
		DbUtils.initializeDatabase();
		connection = DbUtils.getConnection();
		String query = "select *from coins";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
//			Integer id = resultSet.getInt(1);
			String country = resultSet.getString(2);
			String denomination = resultSet.getString(3);
			Integer yearOfMinting = resultSet.getInt(4);
			Integer currentValue = resultSet.getInt(5);
			String currency = resultSet.getString(6);
			Date acquiredDate = resultSet.getDate(7);
			Coin coin = new Coin(country, denomination, yearOfMinting, currentValue, currency, acquiredDate);
//			System.out.println(coin.toString());
			coins.add(coin);
//			System.out.println(
//					"Id :" + id + "country : " + country + ", denomination : " + denomination + ", yearOfMinting : "
//							+ yearOfMinting + ", currentValue : " + currentValue + ", acquiredDate : " + acquiredDate);
		}
	}

	public boolean saveDataToDatabase(Set<Coin> fileAddedCoins) throws SQLException {
		String insertQuery = "INSERT INTO coins (country, denomination, year_of_minting, current_value,currency, acquired_date) VALUES (?, ?, ?, ?,?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		for (Coin coin : fileAddedCoins) {
			preparedStatement.setString(1, coin.getCountry());
			preparedStatement.setString(2, coin.getDenomination());
			preparedStatement.setInt(3, coin.getYearOfMinting());
			preparedStatement.setInt(4, coin.getCurrentValue());
			preparedStatement.setString(5, coin.getCurrency());
			preparedStatement.setDate(6, coin.getAcquiredDate());
			preparedStatement.addBatch();
		}
		int[] insertCounts = preparedStatement.executeBatch();
		System.out.println("Number of Rows Affected are: " + insertCounts.length);
		if (insertCounts.length > 0) {
			System.out.println("Number of Rows Affected are: " + insertCounts.length);
			return true;
		}
		return false;
	}

}