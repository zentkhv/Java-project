package src.db_tester;
import java.sql.*;

public class Main {
        public static void main(String[] args) {
            String url = "jdbc:sqlite:./database.db"; // Укажите путь к вашей базе данных SQLite
            String query = "SELECT * FROM test";

            try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                System.out.println(rs.getClass());

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int value = rs.getInt("value");
                    System.out.println(rs.getRow() + ") ID: " + id + ", Value: " + value);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
