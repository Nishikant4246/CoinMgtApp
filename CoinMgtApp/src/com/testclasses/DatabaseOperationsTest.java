package com.testclasses;
import rebit.pm.training.currencymgtapp.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class DatabaseOperationsTest {
	DatabaseOperations databaseOperations;
	
	    // Initialize the `databaseOperations` variable before each test method is executed.
	    @Before
	    public void setUp() {
	        databaseOperations = new DatabaseOperations();
	    }

	    // Test that the `DatabaseOperations.getCoins()` method returns a non-empty set of coins.
	    @Test
	    public void test_getCoins_returns_non_empty_set() throws SQLException, ClassNotFoundException {
	        Set<Coin> coins = databaseOperations.getCoins();
	        assertNotNull(coins);
	        assertFalse(coins.isEmpty());
	    }

	    // Test that the `DatabaseOperations.saveDataToDatabase()` method returns `true` when the data is saved to the database successfully.
	    @Test
	    public void test_saveDataToDatabase_returns_true_when_data_is_saved_successfully() throws SQLException {
	        Set<Coin> coins = new HashSet<>();
	        coins.add(new Coin("United States", "5", 2023, 1, "USD", java.sql.Date.valueOf("2021-01-01")));
	        boolean success = databaseOperations.saveDataToDatabase(coins);
	        assertTrue(success);
	    }
	}

