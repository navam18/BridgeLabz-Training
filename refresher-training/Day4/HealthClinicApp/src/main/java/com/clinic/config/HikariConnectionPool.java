package com.clinic.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Single doorway to MySQL for the whole app. Every DAO calls
 * HikariConnectionPool.getConnection() instead of opening its own connection.
 *
 * Reads settings from src/main/resources/db.properties so credentials
 * aren't hard-coded in Java source.
 */
public final class HikariConnectionPool {

    private static final HikariDataSource dataSource;

    static {
        Properties props = loadProperties();

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(props.getProperty("db.url"));
        config.setUsername(props.getProperty("db.user"));
        config.setPassword(props.getProperty("db.password"));
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Reasonable pool defaults for a small console app
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setConnectionTimeout(10_000);
        config.setIdleTimeout(60_000);
        config.setPoolName("HealthClinicPool");

        dataSource = new HikariDataSource(config);
    }

    private HikariConnectionPool() {
        // utility class, no instances
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream in = HikariConnectionPool.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {
            if (in == null) {
                throw new RuntimeException("db.properties not found on classpath (expected in src/main/resources)");
            }
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load db.properties", e);
        }
        return props;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void shutdown() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }
}
