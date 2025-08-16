// This class contains JUnit tests for the Coin class.
package com.testclasses;

// Importing necessary classes.
import rebit.pm.training.currencymgtapp.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.Date;

public class CoinTest {

    // Testing if two Coin objects with the same attributes are considered equal.
    @Test
    public void testEquals() {
        // Creating two Coin objects with identical attributes.
        Coin coin1 = new Coin("USA", "Quarter", 1995, 25, "USD", Date.valueOf("2021-01-01"));
        Coin coin2 = new Coin("USA", "Quarter", 1995, 25, "USD", Date.valueOf("2021-01-01"));
        assertEquals(coin1, coin2); // Asserting that the objects are considered equal.
    }

    // Testing if two Coin objects with different attributes are not considered equal.
    @Test
    public void testNotEquals() {
        // Creating two Coin objects with different attributes.
        Coin coin1 = new Coin("USA", "Quarter", 1995, 25, "USD", Date.valueOf("2021-01-01"));
        Coin coin2 = new Coin("USA", "Dime", 1995, 10, "USD", Date.valueOf("2021-01-01"));
        assertNotEquals(coin1, coin2); // Asserting that the objects are not considered equal.
    }

    // Testing the toString() method of the Coin class.
    @Test
    public void testToString() {
        // Creating a Coin object.
        Coin coin = new Coin("USA", "Quarter", 1995, 25, "USD", Date.valueOf("2021-01-01"));
        // Creating the expected string representation of the Coin object.
        String expectedString = "Country: USA            | Denomination: Quarter   | Year of Minting: 1995 | Current Value: 25    | Currency: USD            | Acquired Date: 2021-01-01|";
        assertEquals(expectedString, coin.toString()); // Asserting that the toString() method returns the expected string.
    }

    // Testing the hashCode() method of the Coin class.
    @Test
    public void testHashCode() {
        // Creating two Coin objects with identical attributes.
        Coin coin1 = new Coin("USA", "Quarter", 1995, 25, "USD", Date.valueOf("2021-01-01"));
        Coin coin2 = new Coin("USA", "Quarter", 1995, 25, "USD", Date.valueOf("2021-01-01"));
        assertEquals(coin1.hashCode(), coin2.hashCode()); // Asserting that the hash codes are equal.
    }

    // Testing the getters and setters of the Coin class.
    @Test
    public void testGettersAndSetters() {
        Coin coin = new Coin(); // Creating a Coin object.

        // Setting attributes using setters.
        coin.setId(1);
        coin.setCountry("USA");
        coin.setDenomination("Quarter");
        coin.setYearOfMinting(1995);
        coin.setCurrentValue(25);
        coin.setCurrency("USD");
        coin.setAcquiredDate(Date.valueOf("2021-01-01"));

        // Getting attributes using getters and asserting their values.
        assertEquals(Integer.valueOf(1), coin.getId());
        assertEquals("USA", coin.getCountry());
        assertEquals("Quarter", coin.getDenomination());
        assertEquals(Integer.valueOf(1995), coin.getYearOfMinting());
        assertEquals(Integer.valueOf(25), coin.getCurrentValue());
        assertEquals("USD", coin.getCurrency());
        assertEquals(Date.valueOf("2021-01-01"), coin.getAcquiredDate());
    }
}
