import java.sql.*;
import java.lang.*;

public class DataModel {

    // Accounts table
    public void insertToAccount(String login) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabet",
                    "javaBet", "12345");

            String query = "insert into accounts (Login_Name)" + "values (?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, login);
            pre.execute();

            connection.close();
            System.out.println("Successfully added");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    // bet_history table
    public void insertToBet_history(String login)
                                    /*boolean type_bet,
                                    boolean type_with,
                                    int sum,
                                    int cur_balance,
                                    int gen_income)*/ {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabet",
                    "javaBet", "12345");

            String query = "select ID from accounts" + "where Login_Name = " + login;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("Data base returned: ");
            int id = rs.getInt("1");
            System.out.println(id);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}