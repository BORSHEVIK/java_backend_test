import java.sql.*;

/**
 * Created by УВД on 16.04.2017.
 */
public class JDBC {
    public static void main(String[] args) {
        String url="jdbc:mariadb://localhost:3306/tutorial";
        String username="root";
        String password="0182973Job";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url, username, password);
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM employees");
            while (resultSet.next()){
                System.out.println("Name: "+ resultSet.getString(2) + ", " + "Skill: " + resultSet.getString(3));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
