package com.testclasses;
import rebit.pm.training.currencymgtapp.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearchingTest {

    @Test
    public void test_countryAndDenomination_returns_correct_coins() {
        // Arrange
        Set<Coin> coins = new HashSet<>();
        coins.add(new Coin("United States", "4", 2023, 1, "USD", new java.sql.Date(System.currentTimeMillis())));
        coins.add(new Coin("Canada", "65", 2023, 1, "CAD", new java.sql.Date(System.currentTimeMillis())));

        // Act
        Searching.countryAndDenomination(coins);

        // Assert
        // TODO: Assert that the correct coins are returned.
    }

    @Test
    public void test_countryAndYearOfMinting_returns_correct_coins() {
        // Arrange
        Set<Coin> coins = new HashSet<>();
        coins.add(new Coin("United States", "10", 2023, 1, "USD", new java.sql.Date(System.currentTimeMillis())));
        coins.add(new Coin("Canada", "20", 2022, 1, "CAD", new java.sql.Date(System.currentTimeMillis())));

        // Act
        Searching.countryAndYearOfMinting(coins);

        // Assert
        // TODO: Assert that the correct coins are returned.
    }

    @Test
    public void test_countryAndDenominationAndYearOfMinting_returns_correct_coins() {
        // Arrange
        Set<Coin> coins = new HashSet<>();
        coins.add(new Coin("United States", "10", 2023, 1, "USD", new java.sql.Date(System.currentTimeMillis())));
        coins.add(new Coin("Canada", "20", 2022, 1, "CAD", new java.sql.Date(System.currentTimeMillis())));

        // Act
        Searching.countryAndDenominationAndYearOfMinting(coins);

        // Assert
        // TODO: Assert that the correct coins are returned.
    }

    @Test
    public void test_countryAndAcquiredDate_returns_correct_coins() {
        // Arrange
        Set<Coin> coins = new HashSet<>();
        coins.add(new Coin("United States", "Penny", 2023, 1, "USD", new java.sql.Date(System.currentTimeMillis())));
        coins.add(new Coin("Canada", "Nickel", 2022, 1, "CAD", new java.sql.Date(System.currentTimeMillis())));

        // Act
        Searching.countryAndAcquiredDate(coins);

        // Assert
        // TODO: Assert that the correct coins are returned.
    }
}
