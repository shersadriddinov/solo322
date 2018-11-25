import java.sql.*;
import java.lang.*;

public class DataModel {
    Connection connection;
    // Establishing connection to Database
    public DataModel(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabet",
                    "javaBet", "12345");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    // Accounts table
    public void insertToAccount(String login) {
        try {
            String query = "insert into accounts (Login_Name)" + "values (?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, login);
            pre.execute();
            System.out.println("Successfully added");
            connection.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    // bet_history table
    public void insertToBet_history(String login,
                                    int type_bet,
                                    int type_with,
                                    int sum,
                                    int cur_balance,
                                    int gen_income) {
        try {
            int id;
            Statement st = connection.createStatement();

            st.executeUpdate("INSERT INTO accounts(Login_Name)" + "values('" + login + "')");

            String query = "SELECT ID FROM accounts WHERE Login_Name = " + "'" + login + "'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt( 1);
            st.executeUpdate("INSERT INTO transactions(account_id, Type_bet, Type_withdrawal, Sum, Cur_balance, Gen_income)" +
                    "values('" + id + "', '" + type_bet + "', '" + type_with + "', '" + sum + "', '" + cur_balance + "', '" + gen_income + "')");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}