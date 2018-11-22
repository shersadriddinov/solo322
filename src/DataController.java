import java.sql.*;
import java.lang.*;

public class DataController{
    public void connectToSQL(String login){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabet", "javaBet", "12345");
            String query = "insert into accounts(Login_Name)" + "values (?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, login);
            pre.execute();
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}