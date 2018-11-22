import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter login name to create account: ");
        String login;
        login = input.nextLine();
        DataController data = new DataController();
        data.connectToSQL(login);
    }
}
