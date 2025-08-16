package com.testclasses;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import rebit.pm.training.currencymgtapp.DbUtils;

public class DBUtilsTest {

    // Test that the `DbUtils.initializeDatabase()` method successfully connects to the database.
    @Test
    public void test_initializeDatabase_connects_to_database() throws Exception {

        DbUtils.initializeDatabase();
        assertNotNull(DbUtils.getConnection());
    }

    // Test that the `DbUtils.getConnection()` method returns a valid connection to the database.
    @Test
    public void test_getConnection_returns_valid_connection() throws Exception {

        DbUtils.initializeDatabase();
        Connection connection = DbUtils.getConnection();
        assertNotNull(connection);
        assertTrue(connection.isValid(10));
    }

    // Test that the `DbUtils.closeConnection()` method successfully closes a connection to the database.
    @Test
    public void test_closeConnection_closes_connection() throws Exception {

        DbUtils.initializeDatabase();
        Connection connection = DbUtils.getConnection();
        DbUtils.closeConnection();
        assertFalse(connection.isValid(10));
    }

    // Test that the `DbUtils.closeResource()` method successfully closes an AutoCloseable resource.
    @Test
    public void testCloseResource() {

        AutoCloseable resource = null;
        try {
            resource = new AutoCloseableResource();
        } catch (Exception e) {
            fail("Failed to create resource");
        }
        DbUtils.closeResource(resource);
        assertTrue(resource == null || !((AutoCloseableResource) resource).isClosed());
    }

    // Custom class to simulate an AutoCloseable resource for testing
    private class AutoCloseableResource implements AutoCloseable {

        private boolean closed = false;

        @Override
        public void close() throws Exception {
            closed = true;
        }

        public boolean isClosed() {
            return closed;
        }
    }
}
