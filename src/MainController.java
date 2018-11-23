import java.sql.SQLOutput;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        DataModel data = new DataModel();

        boolean flag = true;
        while (flag){
            int choose;
            System.out.println("1. To add new account");
            System.out.println("2. To add new transaction");
            choose = input.nextInt();
            switch (choose){
                case 1:
                    Login_Name();
                    flag = false;
                    break;
                case 2:
                    addTransaction();
                    flag = false;
                    break;
                    default:
                        System.out.println("Enter appropriate integer to choose");
                        break;
            }
        }
    }

    // Add Login_Name to account
    public static void Login_Name(){
        Scanner input = new Scanner(System.in);
        DataModel data = new DataModel();

        System.out.println("Enter login name to create account: ");
        String login;
        login = input.nextLine();
        data.insertToAccount(login);
    }

    // Add Transactions to account
    public static void addTransaction(){
        Scanner input = new Scanner(System.in);
        DataModel data = new DataModel();

        System.out.println("Enter login: ");
        String login;
        login = input.nextLine();
        data.insertToBet_history(login);
    }
}
