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

    // Transactions table
    public void insertToTransactions(String login, int type_bet, int type_with, double sum) {
        try {
            double cur_balance;
            double gen_income;
            Statement st = connection.createStatement();

            String query = "SELECT ID FROM accounts WHERE Login_Name = " + "'" + login + "'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            int id = rs.getInt(1);

            query = "SELECT Cur_Balance, Gen_Income FROM transactions WHERE account_id = " + "'" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            cur_balance = rs.getDouble("Cur_Balance");
            gen_income = rs.getDouble("Gen_Income");
            if (type_with == 1){
                cur_balance -= sum;
            } else {
                cur_balance += sum;
            }
            if (type_bet == 1 && type_with == 1 || type_bet == 0 && type_with == 0){
                gen_income -= sum;
            } else {
                gen_income += sum;
            }

            st.executeUpdate("INSERT INTO transactions(account_id, Type_bet, Type_withdrawal, Sum, Cur_balance, Gen_income)" +
                    "values('" + id + "', '" + type_bet + "', '" + type_with + "', '" + sum + "', '" + cur_balance + "', '" + gen_income + "')");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    // Betting history
    public void insertToBettig_history(String login, String bet, double total_strake, double odds, int status){
        double benefit;
        if (status == 1){
            benefit = total_strake * odds;
        } else {
            benefit = 0;
        }
    }
}