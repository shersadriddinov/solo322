import java.sql.*;
import java.lang.*;

public class DataModel{
    public void insetToAccount(String login){
        String query = "insert into accounts (Login_Name)" + "values (?)";
        connectToSQL(query, login);
    }
    public void connectToSQL(String query, String login){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabet", "javaBet", "12345");
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, login);
            pre.execute();
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}