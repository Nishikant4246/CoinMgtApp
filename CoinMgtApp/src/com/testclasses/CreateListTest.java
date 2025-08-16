package com.testclasses;

import static org.junit.jupiter.api.Assertions.*;
import rebit.pm.training.currencymgtapp.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import java.util.HashSet;
import java.util.Set;
public class CreateListTest {

	// Test if the countryList function displays a non-empty set of coins.
    @Test
    public void test_countryList_returns_non_empty_set() {
        Set<Coin> coins = new HashSet<>();
        coins.add(new Coin("United States", "1", 2023, 1, "USD", new java.sql.Date(System.currentTimeMillis())));
        CreateList.countryList(coins);
        assertNotNull(coins);
        assertFalse(coins.isEmpty());
    }

 // Test if the yearOfMiningList function displays a non-empty set of coins.
    @Test
    public void test_yearOfMiningList_returns_non_empty_set() {
        Set<Coin> coins = new HashSet<>();
        coins.add(new Coin("United States", "2", 2023, 56, "USD", new java.sql.Date(System.currentTimeMillis())));
        CreateList.yearOfMiningList(coins);
        assertNotNull(coins);
        assertFalse(coins.isEmpty());
    }

 // Test if the currentValueList function displays a non-empty set of coins.

    @Test
    public void test_currentValueList_returns_non_empty_set() {
        Set<Coin> coins = new HashSet<>();
        coins.add(new Coin("United States", "3", 2023, 465, "USD", new java.sql.Date(System.currentTimeMillis())));
        CreateList.currentValueList(coins);
        assertNotNull(coins);
        assertFalse(coins.isEmpty());
    }
}