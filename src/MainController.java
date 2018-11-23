import java.util.Scanner;

public class MainController {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        DataModel data = new DataModel();
        // Add Login_Name to account
        System.out.println("Enter login name to create account: ");
        String login;
        login = input.nextLine();
        data.insetToAccount(login);
    }
}
