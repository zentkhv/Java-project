import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database.db";
        String query = "SELECT * FROM test";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String value = rs.getString("value");

                System.out.println("ID: " + id + ", Value: " + value);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
