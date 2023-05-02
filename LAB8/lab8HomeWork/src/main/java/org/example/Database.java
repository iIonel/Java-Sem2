package org.example;
import java.sql.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
public class Database {
    private static final HikariDataSource dataSource;
    private static final String URL = "jdbc:postgresql://localhost:5432/albums";
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";
    private static Connection connection;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/albums");
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        dataSource = new HikariDataSource(config);
    }
    public static Connection getConnection(){
        if (connection == null) {
            try {
                System.out.printf("Creating connection to %s...%n", POSTGRES_URL);
                Connection postgresConnection = DriverManager.getConnection(POSTGRES_URL, USER, PASSWORD);
                Statement statement = postgresConnection.createStatement();

                // Check if the "albums" database exists
                ResultSet resultSet = statement.executeQuery("SELECT 1 FROM pg_database WHERE datname='albums'");
                if (!resultSet.next()) {
                    // Create the "albums" database and grant privileges
                    statement.executeUpdate("CREATE DATABASE albums");
                    statement.executeUpdate("GRANT ALL PRIVILEGES ON DATABASE albums TO " + USER);
                }

                statement.close();
                postgresConnection.close();

                // Connect to the "albums" database
                System.out.printf("Creating connection to %s...%n", URL);
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
                createTables();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return connection;
    }
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void createTables() {
        try (Statement statement = connection.createStatement()) {
            // Create "artists" table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS artists (" +
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "country VARCHAR(100))");

            // Create "genres" table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS genres (" +
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL UNIQUE)");

            // Create "albums" table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS albums (" +
                    "id SERIAL PRIMARY KEY," +
                    "release_year INTEGER," +
                    "name VARCHAR(100) NOT NULL," +
                    "artist_id INTEGER REFERENCES artists(id)," +
                    "genre_id INTEGER REFERENCES genres(id))");
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }
    }

    public static void dropTables() {
        try (Statement statement = connection.createStatement()) {
            // Drop "albums" table
            statement.executeUpdate("DROP TABLE IF EXISTS albums");

            // Drop "artists" table
            statement.executeUpdate("DROP TABLE IF EXISTS artists");

            // Drop "genres" table
            statement.executeUpdate("DROP TABLE IF EXISTS genres");
        } catch (SQLException e) {
            System.err.println("Error dropping tables: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void rollback() {
        try {
            connection.rollback();
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }
}
