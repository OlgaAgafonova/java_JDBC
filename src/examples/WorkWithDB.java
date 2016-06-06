package examples;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithDB {
    private static final String URL_MySQL = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false&serverTimezone=UTC";
    private static final String DRIVER_MySQL = "com.mysql.cj.jdbc.Driver";
    private static final String URL_PostgreSQL = "jdbc:postgresql://hostname:port/dbname";
    private static final String DRIVER_PostgreSQL = "org.postgresql.Driver";
    private static final String URL_Oracle = "jdbc:oracle:thin:@localhost:1521:mkyong";
    private static final String DRIVER_Oracle = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_LOGIN = "root";
    private static final String DB_PASSWORD = "root";

    private static final String DB_DRIVER = DRIVER_MySQL;
    private static final String DB_URL = URL_MySQL;
    private static Connection connection;
    private static boolean isConnected = false;


    private static final String insertSQL = "INSERT INTO USERS (NAME, MAIL) VALUES (?,?)";
    private static final String selectAllSQL = "SELECT * FROM USERS";

    private WorkWithDB() {
    }

    public static void connect() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found");
            isConnected = false;
            return;
        }

        try {
            connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("Unable to connect to database");
            isConnected = false;
            return;
        }
        System.out.println("Connected to database");
        isConnected = true;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: disconnect");
        }
        System.out.println("Disconnected to database");
        isConnected = false;
    }

    public static boolean isConnected() {
        return isConnected;
    }

    public static boolean insert(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Error: insert");
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAllSQL);
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("mail"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Error: selectAll");
        }
        return users;
    }

}
