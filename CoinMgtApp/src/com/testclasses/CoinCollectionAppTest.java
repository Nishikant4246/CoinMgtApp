
package com.testclasses;

import rebit.pm.training.currencymgtapp.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CoinCollectionAppTest {
	DatabaseOperations databaseOperations;

    // Test if a new coin is added to the collection correctly.
    @Test
    public void testAddNewCoinToTheCollection() throws ParseException {
        // Prepare input data and simulate user input.
        Set<Coin> coins = new HashSet<>();
        Set<Coin> dummyCoins = new HashSet<>();
        CoinCollectionApp.scan = new Scanner("USA\nQuarter\n1995\n25\nUSD\n2023-10-14\n");
        Set<Coin> result = CoinCollectionApp.addNewCoinToTheCollection(coins, dummyCoins);
        assertEquals(1, result.size());
    }

    // Test if the main menu function works correctly.
    @Test
    public void testMainMenu() throws Exception {
        // Simulate user input.
        CoinCollectionApp.scan = new Scanner("1\n");
        int choice = CoinCollectionApp.mainMenu();
        assertEquals(1, choice);
    }

    // Test if the CreateList menu bar works correctly.
    @Test
    public void testCreateListMenuBar() {
        // Simulate user input.
        CoinCollectionApp.scan = new Scanner("2\n");
        int choice = CoinCollectionApp.createListMenuBar();
        assertEquals(2, choice);
    }

    // Test if the Searching menu bar works correctly.
    @Test
    public void testSearchingListMenuBar() {
        // Simulate user input.
        CoinCollectionApp.scan = new Scanner("3\n");
        int choice = CoinCollectionApp.SearchingListMenuBar();
        assertEquals(3, choice);
    }

    // Test if the getCoins method returns a non-empty set after a callback to the database.
    @Test
    public void test_getCoins_returns_non_empty_set() throws SQLException, ClassNotFoundException {
        databaseOperations = new DatabaseOperations();
        Set<Coin> coins = databaseOperations.getCoins();
        assertNotNull(coins);
        assertFalse(coins.isEmpty());
    }

    // Test if data is saved to the database successfully.
    @Test
    public void test_saveDataToDatabase_returns_true_when_data_is_saved_successfully() throws SQLException {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        Set<Coin> coins = new HashSet<>();
        coins.add(new Coin("United States", "1", 2023, 1, "USD", new java.sql.Date(System.currentTimeMillis())));
        boolean success = databaseOperations.saveDataToDatabase(coins);
        assertTrue(success);
    }
}
