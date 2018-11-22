import java.sql.*;
public class Main {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javabet", "javaBet", "12345");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Login_Name, Cur_Balance, Gen_Income from accounts");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
