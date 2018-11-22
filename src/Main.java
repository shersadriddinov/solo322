import java.sql.*;
public class Main {
    public static void main(String[] args){
        try{
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javabet","javaBet","12345");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("show tables");
            con.close();
        }catch(Exception e){ System.out.println(e);}
        System.out.println("test");
    }
}
