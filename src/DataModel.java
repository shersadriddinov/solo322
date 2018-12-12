import java.sql.*;
import java.lang.*;
import java.util.LinkedList;

public class DataModel {
    Connection connection;
    Statement st;
    public String login;
    public double sum, odd;
    LinkedList<Double> total_strake = new LinkedList<>();
    LinkedList<Double> odds = new LinkedList<>();

    // Establishing connection to Database
    public DataModel(String login){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabet",
                    "Ulugbek", "1998166bek");
            st = connection.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
        this.login = login;
    }

    // Accounts table
    public void insertToAccount(double sum) {
        try {
            String query = "insert into accounts (Login_Name)" + "values (?)";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, login);
            pre.execute();
            int id = verify_login();
            query = "INSERT INTO transactions(account_id, Type_bet, Type_withdrawal, Sum, Cur_balance, Gen_income)" +
                    "values('" + id + "', '" + 0 + "', '" + 0 + "', '" + sum + "', '" + sum + "', '" + 0 + "')";
            st.executeUpdate(query);
            System.out.println("Successfully added");
            connection.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    // Transactions table
    public void insertToTransactions(int type_bet, int type_with, double sum) {
        try {
            double cur_balance;
            double gen_income;

            int id = verify_login();
            String query = "SELECT Cur_Balance, Gen_Income FROM transactions WHERE account_id = " + "'" + id + "' ORDER BY ID DESC LIMIT 1";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            cur_balance = rs.getDouble(1);
            gen_income = rs.getDouble(2);
            if (type_with == 1) {
                if (cur_balance < sum) {
                    System.out.println("No sufficient founds to proceed the step");
                    System.exit(0);
                }
                cur_balance -= sum;
            } else {
                cur_balance += sum;
            }
            if (type_bet == 1 && type_with == 1 || type_bet == 0 && type_with == 0) {
                gen_income -= sum;
            } else {
                gen_income += sum;
            }

            st.executeUpdate("INSERT INTO transactions(account_id, Type_bet, Type_withdrawal, Sum, Cur_balance, Gen_income)" + "values('" + id + "', '" + type_bet + "', '" + type_with + "', '" + sum + "', '" + cur_balance + "', '" + gen_income + "')");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    // Betting history
    public void insertToBetting_history(String bet, double total_strake, double odds, int status){
        try{
            insertToTransactions(1, 1, total_strake);
            double benefit = 0;
            int type_with;
            if (status == 1){
                type_with = 0;
                benefit = total_strake * odds;
            } else {
                type_with = 1;
            }

            int id = verify_login();

            insertToTransactions(1, type_with, benefit);
            st.executeUpdate("INSERT INTO bet_history(account_id, Bet, Total_Strake, Benefit, Odds, Status) " +
                    "values ('" + id + "', '" + bet + "', '" + total_strake + "', '"+ benefit + "', '" + odds + "', '" + status + "')");
            connection.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    // Verifier
    public int verify_login(){
        try {
            String query = "SELECT ID FROM accounts WHERE Login_Name = " + "'" + this.login + "'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            int id = rs.getInt(1);
            return id;
        } catch (Exception e){
            int id = 0;
            System.out.println(e);
            System.exit(0);
            return id;
        }
    }

    // get Size
    public void getSize(){
        try {
            int id = verify_login();
            String query = "SELECT MAX(Total_Strake), MAX(Odds) FROM bet_history WHERE account_id = " + "'" + id + "'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            sum = rs.getDouble(1);
            odd = rs.getDouble(2);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    // get Bet
    public void getBet(){
        try{
            int id = verify_login();
            String query = "SELECT * FROM bet_history WHERE account_id = " + "'" + id + "'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                total_strake.add(rs.getDouble(5));
                odds.add(rs.getDouble(7));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}